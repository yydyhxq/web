package com.caocao.server.control.mobile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.caocao.core.model.Bank;
import com.caocao.core.model.Coupon;
import com.caocao.core.model.Custumer;
import com.caocao.core.model.Journey;
import com.caocao.core.model.MyWallet;
import com.caocao.core.model.Order;
import com.caocao.core.service.impl.BankServiceImpl;
import com.caocao.core.service.impl.CouponServerImpl;
import com.caocao.core.service.impl.CustumerServiceImpl;
import com.caocao.core.service.impl.OrderServiceImpl;
import com.caocao.service.integration.sms.MessageFactory;
import com.caocao.util.CalculateCost;
import com.caocao.util.MobileCode;
import com.caocao.util.StringUtils;
import com.caocao.util.TimeUtil;
import com.caocao.server.constant.OrderState;
import com.caocao.server.constant.OrderType;
import com.caocao.server.constant.PayMethod;
import com.caocao.server.constant.ResultCode;
import com.caocao.server.constant.ResultState;
import com.caocao.server.constant.SysConstant;
import com.caocao.server.dto.MobileHttpDto;
import com.caocao.server.dto.MobileHttpDto.Error;
import com.caocao.server.dto.PriceEstimateDto;
import com.caocao.server.extend.SmsTemplate;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Controller
@RequestMapping("customer")
public class CustomerController {
	private static final Logger logger = LoggerFactory
			.getLogger(CustomerController.class);
	@Resource
	private CustumerServiceImpl custumerService;
	@Resource
	private BankServiceImpl bankService;
	@Resource
	private OrderServiceImpl orderService;
	@Resource
	private CouponServerImpl couponServer;
	/*
	 * @Resource private AndroidPushtoSingle androidPushtoSingle;
	 * 
	 * @Resource private IosPushtoSingle iosPushtoSingle;
	 */
	/*
	 * @Resource private YunTu yunTu;
	 */
	@Resource(name = "messageFactory")
	private MessageFactory messageFactory;
	@Value("${car.fare}")
	private String taxStrartPrice;
	@Value("${car.timecost}")
	private String taxPerTimePrice;
	@Value("${car.perdistance}")
	private String taxPerDistancePrice;
	@Value("${car.speed}")
	private String carSpeed;

	/**
	 * 获取手机验证码(需调用短信接口)-登录/注册
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/acquireCode", method = { RequestMethod.GET })
	@ResponseBody
	public MobileHttpDto acquireCode(@RequestParam String mobile,
			@RequestParam(required = false) Double version,
			@RequestParam(required = false) String token, HttpSession session)
			throws Exception {
		String code = MobileCode.createRandom(true, 6);
		// 发送短信
		boolean result = messageFactory.sendSMS(SmsTemplate.driverNotify(code),
				mobile, null);
		MobileHttpDto dto = new MobileHttpDto();
		if (result == true) {
			dto.setStatus(ResultState.SUCCESS);
			session.setMaxInactiveInterval(60 * 1);
			session.setAttribute(mobile, code);
		} else {
			dto.setStatus(ResultState.FAIL);
		}
		return dto;
	}

	/**
	 * 登录
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/login", method = { RequestMethod.GET })
	@ResponseBody
	public MobileHttpDto verifyAuthor(@RequestParam String mobile,
			@RequestParam String verifyCode,
			@RequestParam(required = false) Double version,
			@RequestParam(required = false) String token, HttpSession session)
			throws Exception {

		MobileHttpDto dto = new MobileHttpDto();
		String mobileCode = String.valueOf(session.getAttribute(mobile));
		System.out.println("mobileCode:" + mobileCode);
		if (StringUtils.isEmpty(mobileCode)
				|| !verifyCode.equalsIgnoreCase(mobileCode)) {
			dto.setStatus(ResultState.FAIL);

			dto.setError(new Error(
					ResultCode.MOBLECODE_VALIDATE_FAIL.getCode(),
					ResultCode.MOBLECODE_VALIDATE_FAIL.getMessage()));
			return dto;
		}
		/**
		 * 检查改MOBILE是否存在
		 */
		Custumer custumer = custumerService.verifyCustumer(mobile);
		if (null == custumer) {
			dto.setStatus(ResultState.FAIL);
			dto.setError(new Error(ResultCode.LOGIN_VALIDATE_FAIL.getCode(),
					ResultCode.LOGIN_VALIDATE_FAIL.getMessage()));
			return dto;
		}

		dto.setStatus(ResultState.SUCCESS);
		dto.setBody(custumer);
		return dto;
	}

	/**
	 * 注册-第一步验证手机，并保存用户电话
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/register", method = { RequestMethod.GET })
	@ResponseBody
	public MobileHttpDto register(@RequestParam String mobile,
			@RequestParam String verifyCode,
			@RequestParam(required = false) Double version,
			@RequestParam(required = false) String token, HttpSession session)
			throws Exception {
		/**
		 * 检测一下数据库中是否存在该记录,追加版本号.或设置联合主键
		 */
		MobileHttpDto dto = new MobileHttpDto();
		String mobileCode = String.valueOf(session.getAttribute(mobile));
		System.out.println("mobileCode:" + mobileCode);
		if (!verifyCode.equalsIgnoreCase(mobileCode)) {
			dto.setStatus(ResultState.FAIL);

			dto.setError(new Error(
					ResultCode.MOBLECODE_VALIDATE_FAIL.getCode(),
					ResultCode.MOBLECODE_VALIDATE_FAIL.getMessage()));
			return dto;
		}
		Custumer custumer = new Custumer();
		custumer.setPhone(mobile);
		custumer.setInviteCode(MobileCode.createRandom(false, 6));
		int rst = custumerService.registerUser(custumer);
		// 判断该手机号用户是否存在
		if (rst == 0) {
			dto.setStatus(ResultState.FAIL);
			dto.setError(new Error(ResultCode.MOBLE_EXISTS.getCode(),
					ResultCode.MOBLE_EXISTS.getMessage()));
		} else {
			dto.setStatus(ResultState.SUCCESS);
			dto.setBody(custumer.getId());
		}
		return dto;
	}

	/**
	 * 编辑用户信息 返回从数据库中查询出来的USERID
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/editUser", method = { RequestMethod.POST })
	@ResponseBody
	public MobileHttpDto editUser(
			@RequestParam(required = false) Double version,
			@RequestParam(required = false) String token,
			@RequestParam int userid,
			@RequestParam String name,
			@RequestParam int sex,
			@RequestParam(required = false) String email,
			@RequestParam(required = false) String companyName,
			@RequestParam(value = "picture", required = false) MultipartFile picture,
			HttpServletRequest request) throws Exception {
		/**
		 * 文件上传(如果有变化则修改，否则不传)
		 */
		MobileHttpDto dto = new MobileHttpDto();
		try {
			Custumer custumer = custumerService.acquireById(userid);
			custumer.setName(name);
			custumer.setSex(sex);
			if (StringUtils.isNotEmpty(email)) {
				custumer.setEmail(email);
			}
			if (StringUtils.isNotEmpty(companyName)) {
				custumer.setCompany(companyName);
			}

			custumer.setType(SysConstant.PERSIONCUSTOMER);

			if (!picture.isEmpty()) {
				ServletContext sc = request.getSession().getServletContext();
				String dir = sc.getRealPath("/upload"); // 设定文件保存的目录
				String filename = picture.getOriginalFilename(); // 得到上传时的文件名
				System.out.println("图片大小:" + picture.getBytes().length);
				String newFileName = userid
						+ TimeUtil.getTimeStap()
						+ filename.substring(filename.indexOf('.'),
								filename.length());
				try {
					FileUtils.writeByteArrayToFile(new File(dir, newFileName),
							picture.getBytes());
				} catch (IOException e) {
					logger.error("图像上传出错", e);
					// TODO Auto-generated catch block

				}
				// 设置图片所在路径
				custumer.setPhoto("/upload/" + newFileName);

			}
			custumerService.updateCustumer(custumer);
			dto.setStatus(ResultState.SUCCESS);
		} catch (Exception e) {
			dto.setStatus(ResultState.FAIL);
		}

		return dto;
	}

	/**
	 * 仅用于添加银行卡(司机/乘客公用)
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/addPayBank", method = { RequestMethod.POST })
	@ResponseBody
	public MobileHttpDto addPayBank(@RequestParam int year,
			@RequestParam String payNumber, @RequestParam int month,
			@RequestParam int accountType,
			@RequestParam(required = false) Double version,
			@RequestParam(required = false) String token,
			@RequestParam int securityCode, @RequestParam int userid)
			throws Exception {
		Bank bank = new Bank();
		bank.setAccountType(accountType);// 乘客or司机
		bank.setAgentId(userid); // 乘客or司机
		bank.setPayMethod(PayMethod.credit); // 银行卡还是支付宝 1:银行卡;2:支付宝
		bank.setNumber(payNumber);
		bank.setYear(year);
		bank.setMonth(month);
		bank.setSecurityCode(securityCode);
		bankService.insertSelective(bank);
		MobileHttpDto dto = new MobileHttpDto();
		dto.setStatus(ResultState.SUCCESS);
		return dto;
	}

	/**
	 * 绑定银行卡
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/bindPayMethod", method = { RequestMethod.GET })
	@ResponseBody
	public MobileHttpDto addPayBank(@RequestParam int bankId,
			@RequestParam(required = false) Double version,
			@RequestParam(required = false) String token,
			@RequestParam int userid) throws Exception {
		bankService.updateBindCard(bankId, SysConstant.isDefault, userid,
				SysConstant.noDefault);
		MobileHttpDto dto = new MobileHttpDto();
		dto.setStatus(ResultState.SUCCESS);
		dto.setBody(bankId);
		return dto;
	}

	/**
	 * 仅用于添加支付宝(司机/乘客公用)
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/addAlipay", method = { RequestMethod.POST })
	@ResponseBody
	public MobileHttpDto addAlipay(@RequestParam String payNumber,
			@RequestParam int accountType,
			@RequestParam(required = false) Double version,
			@RequestParam(required = false) String token,
			@RequestParam int userid) throws Exception {
		Bank bank = new Bank();
		bank.setAccountType(accountType);// 乘客or司机
		bank.setAgentId(userid);// 乘客or司机
		bank.setPayMethod(PayMethod.alipay); // 银行卡还是支付宝 1:银行卡;2:支付宝
		bank.setNumber(payNumber);
		bankService.insertSelective(bank);
		MobileHttpDto dto = new MobileHttpDto();
		dto.setStatus(ResultState.SUCCESS);
		return dto;
	}

	/**
	 * 获取支付方式
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/queryPayMethod", method = { RequestMethod.GET })
	@ResponseBody
	public MobileHttpDto queryPayBank(@RequestParam int userid,
			@RequestParam(required = false) Double version,
			@RequestParam(required = false) String token,
			HttpServletResponse response) throws Exception {
		// System.out.println(yunTu.searchAround("50.4532,40.3497",
		// "1000").getCount());
		List<Bank> lstBank = bankService.acquireBankByUserId(userid);
		MobileHttpDto dto = new MobileHttpDto();
		dto.setStatus(ResultState.SUCCESS);
		dto.setBody(lstBank);
		return dto;
	}

	/**
	 * 获取优惠码
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/queryFavorableCode", method = { RequestMethod.GET })
	@ResponseBody
	public MobileHttpDto queryPayBank(@RequestParam int userid,
			@RequestParam(required = false) Double version,
			@RequestParam(required = false) String token) throws Exception {
		// System.out.println(yunTu.searchAround("50.4532,40.3497",
		// "1000").getCount());
		Custumer customer = custumerService.acquireById(userid);
		MobileHttpDto dto = new MobileHttpDto();
		dto.setStatus(ResultState.SUCCESS);
		dto.setBody(customer.getInviteCode());
		return dto;
	}

	/**
	 * 发起打车请求--实时打车
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/callTimely", method = { RequestMethod.POST })
	@ResponseBody
	public MobileHttpDto callDelegation(
			@RequestParam(required = false) Double version,
			@RequestParam(required = false) String token,
			@RequestParam(required = false) String address,
			@RequestParam(required = false) String cityName,
			@RequestParam int userid, @RequestParam double lg,
			@RequestParam double lt, @RequestParam int owner,
			@RequestParam String pushId, HttpServletRequest request)
			throws Exception {
		/**
		 * 需要将订单信息推送给司机，(并执行一个异步调用，司机抢单成功后调用个推发给客户端)修改成派单
		 */
		Order order = new Order();
		order.setCustomerId(userid);
		order.setStartLocation(address);
		order.setCostCity(cityName);
		order.setStartLg(lg);
		order.setStartLt(lt);
		order.setOwner(owner); // 个人还是出差
		order.setPushId(pushId);
		order.setOrderType(OrderType.REALTIME);
		order.setOrderCreatetime(new Date());
		orderService.insertSelective(order);
		/**
		 * 执行派单等
		 */
		MobileHttpDto dto = new MobileHttpDto();
		dto.setStatus(ResultState.SUCCESS);
		dto.setBody(order.getId());
		return dto;
	}

	/**
	 * 取消订单-乘客
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/cancleDelegation", method = { RequestMethod.POST })
	@ResponseBody
	public MobileHttpDto cancleDelegation(
			@RequestParam(required = false) Double version,
			@RequestParam(required = false) String token,
			@RequestParam int userid, @RequestParam int resion,
			@RequestParam int orderId, @RequestParam String remark,
			HttpServletRequest request) throws Exception {
		Order order = orderService.acquireOrder(orderId);
		order.setOrderStatus(OrderState.REVOCATION);
		order.setRevokeType(SysConstant.CUSTOMER);
		order.setRemark(remark);
		// 将撤销类型改成VARCHAR
		order.setRevokeCause(ResultCode.acquireMsg(resion));
		orderService.updateOrder(order);
		MobileHttpDto dto = new MobileHttpDto();
		dto.setStatus(ResultState.SUCCESS);
		return dto;
	}

	/**
	 * 乘客给司机打分
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/gradeDriver", method = { RequestMethod.GET })
	@ResponseBody
	public MobileHttpDto cancleDelegation(
			@RequestParam(required = false) Double version,
			@RequestParam(required = false) String token,
			@RequestParam int orderId, @RequestParam int grade)
			throws Exception {
		Order order = orderService.acquireOrder(orderId);
		order.setCustomerEvaluate(grade);
		MobileHttpDto dto = new MobileHttpDto();
		dto.setStatus(ResultState.SUCCESS);
		return dto;
	}

	/**
	 * 价格预估
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/estimatePrice", method = { RequestMethod.GET })
	@ResponseBody
	public MobileHttpDto estimatePrice(
			@RequestParam(required = false) Double version,
			@RequestParam(required = false) String token,
			@RequestParam float minMileage, @RequestParam float maxMileage)
			throws Exception {
		/**
		 * 价格计费(采用BigDecimal进行价格运算精度高)
		 */
		float minMileageTime = minMileage / Float.parseFloat((carSpeed)); // 耗时
		float maxMileageTime = maxMileage / Float.parseFloat((carSpeed));
		MobileHttpDto dto = new MobileHttpDto();
		dto.setStatus(ResultState.SUCCESS);
		double minPrice = CalculateCost.acquireCost(minMileageTime, minMileage,
				Double.parseDouble(taxStrartPrice),
				Double.parseDouble(taxPerTimePrice),
				Double.parseDouble(taxPerDistancePrice));
		double maxPrice = CalculateCost.acquireCost(maxMileageTime, maxMileage,
				Double.parseDouble(taxStrartPrice),
				Double.parseDouble(taxPerTimePrice),
				Double.parseDouble(taxPerDistancePrice));
		PriceEstimateDto price = new PriceEstimateDto(minPrice, maxPrice);
		dto.setBody(price);
		return dto;
	}

	/**
	 * 乘客获取历史订单(含实时和预约/个人和出差)
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/acquireHistoryOrder", method = { RequestMethod.GET })
	@ResponseBody
	public MobileHttpDto acquireHistoryOrder(
			@RequestParam(required = false) Double version,
			@RequestParam(required = false) String token,
			@RequestParam int userid, @RequestParam int pageNum,
			@RequestParam int pageSize) throws Exception {
		MobileHttpDto dto = new MobileHttpDto();
		// System.out.println(iosPushtoSingle.apnpush("8ec3bba7de23cda5e8a2726c081be79204faede67529e617b625c984d61cf5c1","42345"));
		try {
			PageList<Order> order = orderService.acquireHistoryOrder(pageNum,
					pageSize, userid);
			dto.setStatus(ResultState.SUCCESS);
			dto.setBody(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			dto.setStatus(ResultState.FAIL);
			logger.error(e.getMessage());
		}

		return dto;
	}

	/**
	 * 设置个推编号
	 */
	@RequestMapping(value = "/setPushId", method = { RequestMethod.GET })
	@ResponseBody
	public MobileHttpDto acquireJourney(
			@RequestParam(required = false) Double version,
			@RequestParam(required = false) String token,
			@RequestParam int userid, @RequestParam String pushid)
			throws Exception {
		MobileHttpDto dto = new MobileHttpDto();
		Custumer custumer = new Custumer();
		custumer.setId(userid);
		custumer.setPushId(pushid);
		custumerService.updateCustumer(custumer);
		return dto;
	}

	/**
	 * 获取乘客个人行程
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/acquireJourney", method = { RequestMethod.GET })
	@ResponseBody
	public MobileHttpDto acquireJourney(
			@RequestParam(required = false) Double version,
			@RequestParam(required = false) String token,
			@RequestParam int userId, @RequestParam int pageNum,
			@RequestParam int pageSize) throws Exception {
		MobileHttpDto dto = new MobileHttpDto();

		try {
			PageList<Journey> journey = custumerService.acquireJourney(userId,
					pageNum, pageSize);
			dto.setStatus(ResultState.SUCCESS);
			dto.setBody(journey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			dto.setStatus(ResultState.FAIL);
			logger.error(e.getMessage());
		}

		return dto;
	}

	/**
	 * 获取乘客钱包
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/acquireWallet", method = { RequestMethod.GET })
	@ResponseBody
	public MobileHttpDto acquireWallet(
			@RequestParam(required = false) Double version,
			@RequestParam(required = false) String token,
			@RequestParam int userId) throws Exception {
		MobileHttpDto dto = new MobileHttpDto();

		MyWallet bean = custumerService.acquireMyWallet(userId,
				SysConstant.isDefault);
		dto.setStatus(ResultState.SUCCESS);
		dto.setBody(bean);
		return dto;
	}

	/**
	 * 获取打车卷列表
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/acquireMyCoupon", method = { RequestMethod.GET })
	@ResponseBody
	public MobileHttpDto acquireMyCoupon(
			@RequestParam(required = false) Double version,
			@RequestParam(required = false) String token,
			@RequestParam int userId) throws Exception {
		MobileHttpDto dto = new MobileHttpDto();
		List<Coupon> bean = couponServer.acquireMyCoupon(userId);
		dto.setStatus(ResultState.SUCCESS);
		dto.setBody(bean);
		return dto;
	}
	
	/**
	 * 输入优惠码
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/enterInviteCode", method = { RequestMethod.GET })
	@ResponseBody
	public MobileHttpDto enterInviteCode(
			@RequestParam(required = false) Double version,
			@RequestParam(required = false) String token,
			@RequestParam int userId,@RequestParam String inviteCode) throws Exception {
		MobileHttpDto dto = new MobileHttpDto();
		List<Coupon> bean = couponServer.acquireMyCoupon(userId);
		dto.setStatus(ResultState.SUCCESS);
		dto.setBody(bean);
		return dto;
	}
}
