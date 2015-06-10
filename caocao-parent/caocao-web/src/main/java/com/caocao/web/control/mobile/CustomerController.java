package com.caocao.web.control.mobile;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.caocao.core.model.Bank;
import com.caocao.core.model.Custumer;
import com.caocao.core.service.impl.CustumerServiceImpl;
import com.caocao.util.MobileCode;
import com.caocao.web.constant.ResultCode;
import com.caocao.web.constant.ResultState;
import com.caocao.web.dto.MobileHttpDto;
import com.caocao.web.dto.MobileHttpDto.Error;

@Controller
@RequestMapping("customer")
public class CustomerController {
	@Resource
	private CustumerServiceImpl custumerService; 
	/**
	 *获取手机验证码(需调用短信接口)-登录/注册
	 * @param mobile
	 * @param token
	 * @return
	 */
    @RequestMapping(value="/acquireCode", method = {RequestMethod.GET})
    @ResponseBody
    public MobileHttpDto acquireCode(@RequestParam String mobile,@RequestParam String token,HttpSession session)
    {
    	String code=MobileCode.createRandom(true,6);
    	session.setAttribute("mobileCode", code);
    	System.out.println("当前的验证码为:"+code);
    	/**
    	 * 此处为发送短信逻辑
    	 */
    	MobileHttpDto dto=new MobileHttpDto();
    	dto.setStatus(ResultState.SUCCESS);
        return dto;
    }
    
	/**
	 * 登录
	 * @param mobile
	 * @param token
	 * @return
	 */
    @RequestMapping(value="/login", method = {RequestMethod.GET})
    @ResponseBody
    public MobileHttpDto verifyAuthor(@RequestParam int mobile,@RequestParam String verifyCode,@RequestParam String token,HttpSession session)
    {

    	MobileHttpDto dto=new MobileHttpDto();
    	String mobileCode=String.valueOf(session.getAttribute("mobileCode"));
    	if(!verifyCode.equalsIgnoreCase(mobileCode))
    			{
    		dto.setStatus(ResultState.FAIL);
    		
    		dto.setError(new Error(ResultCode.MOBLECODE_VALIDATE_FAIL.getCode(),ResultCode.MOBLECODE_VALIDATE_FAIL.getMessage()));
    		return dto;
    			}
    	/**
    	 * 检查改MOBILE是否存在
    	 */
    	Custumer custumer=custumerService.verifyCustumer(mobile);
        if(null==custumer)
        {
        	dto.setStatus(ResultState.FAIL);
        	dto.setError(new Error(ResultCode.LOGIN_VALIDATE_FAIL.getCode(),ResultCode.LOGIN_VALIDATE_FAIL.getMessage()));
    		return dto;
        }
    	
    	dto.setStatus(ResultState.SUCCESS);
    	dto.setBody("登录成功");
        return dto;    	
    }
    
    /**
	 * 注册-第一步验证手机，并保存用户电话
	 * @param mobile
	 * @param token
	 * @return
	 */
    @RequestMapping(value="/register", method = {RequestMethod.GET})
    @ResponseBody
    public MobileHttpDto register(@RequestParam int mobile,@RequestParam String verifyCode,@RequestParam String token,HttpSession session)
    {

    	MobileHttpDto dto=new MobileHttpDto();
    	String mobileCode=String.valueOf(session.getAttribute("mobileCode"));
    	if(!verifyCode.equalsIgnoreCase(mobileCode))
    			{
    		dto.setStatus(ResultState.FAIL);
    		
    		dto.setError(new Error(ResultCode.MOBLECODE_VALIDATE_FAIL.getCode(),ResultCode.MOBLECODE_VALIDATE_FAIL.getMessage()));
    		return dto;
    			}
    	Custumer custumer=new Custumer();
    	custumer.setPhone(mobile);
    	custumerService.registerUser(custumer);    	
    	dto.setStatus(ResultState.SUCCESS);
    	dto.setBody(custumer.getId());
        return dto;    	
    }
    
	/**
	 * 编辑用户信息
	 * 返回从数据库中查询出来的USERID
	 * @param mobile
	 * @param token
	 * @return
	 */
    @RequestMapping(value="/editUser", method = {RequestMethod.POST})
    @ResponseBody
    public MobileHttpDto editUser(@RequestParam String token,@RequestParam int userid,@RequestParam String name,@RequestParam String firstname,@RequestParam(value = "picture", required = false) MultipartFile picture, HttpServletRequest request)
    {
    /**
     * 文件上传
     */ 
    	MobileHttpDto dto=new MobileHttpDto();
    	try{
    	Custumer custumer=custumerService.acquireById(userid);
    	custumer.setFirstName(name);
    
    	    if(!picture.isEmpty()){
    		         ServletContext sc = request.getSession().getServletContext();
    		        String dir = sc.getRealPath("/upload");    //设定文件保存的目录    		        
    		        String filename = picture.getOriginalFilename();    //得到上传时的文件名
    		         try {
						FileUtils.writeByteArrayToFile(new File(dir,filename), picture.getBytes());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						
					}
    		     	custumer.setPhoto("/upload/"+filename);
    		         //设置图片所在路径
    		         
    		
    		     }  
    	    custumerService.updateCustumer(custumer);
    	    dto.setStatus(ResultState.SUCCESS);
    	}catch(Exception e)
    	{
    		
    	}
    	
        return dto;
    }
    
	/**
	 * 添加银行卡
	 * @param mobile
	 * @param token
	 * @return
	 */
    @RequestMapping(value="/addPayBank", method = {RequestMethod.POST})
    @ResponseBody
    public MobileHttpDto addPayBank(@RequestParam String bankType,@RequestParam String bankNumber,@RequestParam String mobile,@RequestParam String token,@RequestParam int userid)
    {
    	
    	MobileHttpDto dto=new MobileHttpDto();
        return dto;   	
    }
    
	/**
	 * 获取支付方式
	 * @param mobile
	 * @param token
	 * @return
	 */
    @RequestMapping(value="/queryPayBank", method = {RequestMethod.GET})
    @ResponseBody
    public MobileHttpDto queryPayBank(@RequestParam int userid,@RequestParam String token)
    {
    	MobileHttpDto dto=new MobileHttpDto();
    	dto.setBody(new Bank());
        return dto;   	
    }
    
	/**
	 * 发起打车请求
	 * @param mobile
	 * @param token
	 * @return
	 */
    @RequestMapping(value="/callDelegation", method = {RequestMethod.POST})
    @ResponseBody
    public MobileHttpDto callDelegation(@RequestParam String token,@RequestParam int userid,@RequestParam double lg,@RequestParam double lt,HttpServletRequest request)
    {
    	/**
    	 * 需要将订单信息推送给司机，并执行一个异步调用，司机抢单成功后调用个推发给客户端
    	 */
    	MobileHttpDto dto=new MobileHttpDto();
        return dto; 
    }
    
	/**
	 * 取消订单
	 * @param mobile
	 * @param token
	 * @return
	 */
    @RequestMapping(value="/cancleDelegation", method = {RequestMethod.POST})
    @ResponseBody
    public MobileHttpDto cancleDelegation(@RequestParam String token,@RequestParam int userid,@RequestParam String resion,@RequestParam String remark,HttpServletRequest request)
    {

    	MobileHttpDto dto=new MobileHttpDto();
        return dto; 
    }
    
	/**
	 * 给司机打分
	 * @param mobile
	 * @param token
	 * @return
	 */
    @RequestMapping(value="/gradeDriver", method = {RequestMethod.GET})
    @ResponseBody
    public MobileHttpDto cancleDelegation(@RequestParam String token,@RequestParam int userid,@RequestParam int grade)
    {

    	MobileHttpDto dto=new MobileHttpDto();
        return dto; 
    }
    
	/**
	 * 价格预估
	 * @param mobile
	 * @param token
	 * @return
	 */
    @RequestMapping(value="/estimate", method = {RequestMethod.GET})
    @ResponseBody
    public MobileHttpDto estimate(@RequestParam String token,@RequestParam int userid,@RequestParam float mileage)
    {

    	MobileHttpDto dto=new MobileHttpDto();
    	dto.setBody(new Float(11.5f));
        return dto; 
    }
}
