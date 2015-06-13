package com.caocao.web.control.mobile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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
import com.caocao.core.model.Custumer;
import com.caocao.core.model.Order;
import com.caocao.core.service.impl.BankServiceImpl;
import com.caocao.core.service.impl.CustumerServiceImpl;
import com.caocao.core.service.impl.OrderServiceImpl;
import com.caocao.service.integration.sms.MessageFactory;
import com.caocao.util.CalculateCost;
import com.caocao.util.MobileCode;
import com.caocao.util.StringUtils;
import com.caocao.web.constant.OrderState;
import com.caocao.web.constant.OrderType;
import com.caocao.web.constant.ResultCode;
import com.caocao.web.constant.ResultState;
import com.caocao.web.constant.SysConstant;
import com.caocao.web.dto.MobileHttpDto;
import com.caocao.web.dto.MobileHttpDto.Error;
import com.caocao.web.dto.PriceEstimateDto;
import com.caocao.web.extend.SmsTemplate;
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
/*	@Resource
	private AndroidPushtoSingle androidPushtoSingle;
	@Resource
	private IosPushtoSingle iosPushtoSingle;*/
	@Resource(name="messageFactory")
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
	 */
	@RequestMapping(value = "/acquireCode", method = { RequestMethod.GET })
	@ResponseBody
	public MobileHttpDto acquireCode(@RequestParam String mobile,
			@RequestParam String token, HttpSession session) {
		System.out.println("进入");
		String code = MobileCode.createRandom(true, 6);
		session.setAttribute("mobileCode", code);
		session.setMaxInactiveInterval(60*5);
	   //发送短信
	   messageFactory.sendSMS(SmsTemplate.mobileValidateCode(code), mobile,null);

		MobileHttpDto dto = new MobileHttpDto();
		dto.setStatus(ResultState.SUCCESS);
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
	public MobileHttpDto verifyAuthor(@RequestParam int mobile,
			@RequestParam String verifyCode, @RequestParam String token,
			HttpSession session) {

		MobileHttpDto dto = new MobileHttpDto();
		String mobileCode = String.valueOf(session.getAttribute("mobileCode"));
		if (!verifyCode.equalsIgnoreCase(mobileCode)||StringUtils.isNotEmpty(mobileCode)) {
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
		dto.setBody("登录成功");
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
	public MobileHttpDto register(@RequestParam int mobile,
			@RequestParam String verifyCode, @RequestParam String token,
			HttpSession session) {

		MobileHttpDto dto = new MobileHttpDto();
		String mobileCode = String.valueOf(session.getAttribute("mobileCode"));
		if (!verifyCode.equalsIgnoreCase(mobileCode)) {
			dto.setStatus(ResultState.FAIL);

			dto.setError(new Error(
					ResultCode.MOBLECODE_VALIDATE_FAIL.getCode(),
					ResultCode.MOBLECODE_VALIDATE_FAIL.getMessage()));
			return dto;
		}
		Custumer custumer = new Custumer();
		custumer.setPhone(mobile);
		custumerService.registerUser(custumer);
		dto.setStatus(ResultState.SUCCESS);
		dto.setBody(custumer.getId());
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
			@RequestParam String token,
			@RequestParam int userid,
			@RequestParam String name,
			@RequestParam String firstname,
			@RequestParam(value = "picture", required = false) MultipartFile picture,
			HttpServletRequest request) {
		/**
		 * 文件上传
		 */
		MobileHttpDto dto = new MobileHttpDto();
		try {
			Custumer custumer = custumerService.acquireById(userid);
			custumer.setFirstName(name);

			if (!picture.isEmpty()) {
				ServletContext sc = request.getSession().getServletContext();
				String dir = sc.getRealPath("/upload"); // 设定文件保存的目录
				String filename = picture.getOriginalFilename(); // 得到上传时的文件名
				try {
					FileUtils.writeByteArrayToFile(new File(dir, filename),
							picture.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block

				}
				custumer.setPhoto("/upload/" + filename);
				// 设置图片所在路径

			}
			custumerService.updateCustumer(custumer);
			dto.setStatus(ResultState.SUCCESS);
		} catch (Exception e) {
			dto.setStatus(ResultState.FAIL);
		}

		return dto;
	}

	/**
	 * 添加银行卡(司机/乘客公用)
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/addPayBank", method = { RequestMethod.POST })
	@ResponseBody
	public MobileHttpDto addPayBank(@RequestParam String bankName,
			@RequestParam int accountType, @RequestParam String payNumber,
			@RequestParam int payMethod, @RequestParam String token,
			@RequestParam int userid) {
		Bank bank = new Bank();
		bank.setAccountType(accountType);
		// bank.setBankName();//需要增加此字段
		bank.setAgentId(userid + ""); // 字段需改成int类型
		bank.setPayMethod(payMethod); // 银行卡还是支付宝
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
	@RequestMapping(value = "/queryPayBank", method = { RequestMethod.GET })
	@ResponseBody
	public MobileHttpDto queryPayBank(@RequestParam int userid,
			@RequestParam String token) {
		List<Bank> lstBank = bankService.acquireBankByUserId(userid);
		MobileHttpDto dto = new MobileHttpDto();
		dto.setStatus(ResultState.SUCCESS);
		dto.setBody(lstBank);
		return dto;
	}

	/**
	 * 发起打车请求--实时打车
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/callDelegation", method = { RequestMethod.POST })
	@ResponseBody
	public MobileHttpDto callDelegation(@RequestParam String token,
			@RequestParam String address, @RequestParam String geohash,
			@RequestParam String cityName, @RequestParam int userid,
			@RequestParam double lg, @RequestParam double lt,
			HttpServletRequest request) {
		/**
		 * 需要将订单信息推送给司机，(并执行一个异步调用，司机抢单成功后调用个推发给客户端)修改成派单
		 */
		Order order = new Order();
		order.setCustomerId(String.valueOf(userid));
		order.setStartLocation(address);
		order.setCostCity(cityName);
		order.setStartLg(lg);
		order.setStartLt(lt);
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
	public MobileHttpDto cancleDelegation(@RequestParam String token,
			@RequestParam int userid, @RequestParam int resion,
			@RequestParam int orderId, @RequestParam String remark,
			HttpServletRequest request) {
		Order order = orderService.acquireOrder(orderId);
		order.setOrderStatus(OrderState.REVOCATION);
		order.setRevokeType(SysConstant.CUSTOMER);
		order.setRemark(remark);
		// 将撤销类型改成VARCHAR
		// order.setRevokeCause(ResultCode.acquireMsg(resion));
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
	public MobileHttpDto cancleDelegation(@RequestParam String token,
			@RequestParam int orderId, @RequestParam int grade) {
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
	public MobileHttpDto estimatePrice(@RequestParam String token,
			@RequestParam float minMileage, @RequestParam float maxMileage) {
		/**
		 * 价格计费(采用BigDecimal进行价格运算精度高)
		 */
		float minMileageTime=minMileage/Float.parseFloat((carSpeed)); //耗时
		float maxMileageTime=maxMileage/Float.parseFloat((carSpeed));
		MobileHttpDto dto = new MobileHttpDto();
		dto.setStatus(ResultState.SUCCESS);
		double minPrice=CalculateCost.acquireCost(minMileageTime,minMileage,Double.parseDouble(taxStrartPrice), Double.parseDouble(taxPerTimePrice), Double.parseDouble(taxPerDistancePrice));
		double maxPrice=CalculateCost.acquireCost(maxMileageTime, maxMileage,Double.parseDouble(taxStrartPrice), Double.parseDouble(taxPerTimePrice), Double.parseDouble(taxPerDistancePrice));		
		PriceEstimateDto price = new PriceEstimateDto(minPrice,maxPrice);
		dto.setBody(price);
		return dto;
	}

	/**
	 * 乘客获取历史订单
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/acquireHistoryOrder", method = { RequestMethod.GET })
	@ResponseBody
	public MobileHttpDto acquireHistoryOrder(@RequestParam String token,
			@RequestParam int userid, @RequestParam int pageNum,
			@RequestParam int pageSize) {
		MobileHttpDto dto = new MobileHttpDto();
//		System.out.println(iosPushtoSingle.apnpush("8ec3bba7de23cda5e8a2726c081be79204faede67529e617b625c984d61cf5c1","42345"));
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
}
