package com.caocao.server.control.mobile;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.caocao.core.model.Bank;
import com.caocao.core.model.Car;
import com.caocao.core.model.Custumer;
import com.caocao.core.model.Driver;
import com.caocao.core.model.Order;
import com.caocao.server.control.User;
import com.caocao.server.dto.MobileHttpDto;
import com.caocao.server.dto.OrderBeanDto;

@Controller
@RequestMapping("driver")
public class DriverController {
	/**
	 *获取已结单列表
	 * @param mobile
	 * @param token
	 * @return
	 */
    @RequestMapping(value="/acquireOrderHistory", method = {RequestMethod.GET})
    @ResponseBody
    public MobileHttpDto acquireOrderHistory(@RequestParam String token,@RequestParam int userid,int pageNum,int pageSize)
    {
    	List<Order> lstOrder=new ArrayList<Order>();
    	MobileHttpDto dto=new MobileHttpDto();
    	dto.setBody(lstOrder);
        return dto;
    }
    
	/**
	 * 司机登录-获取验证码
	 * @param mobile
	 * @param token
	 * @return
	 */
    @RequestMapping(value="/acquireCode", method = {RequestMethod.GET})
    @ResponseBody
    public MobileHttpDto acquireCode(@RequestParam String mobile,@RequestParam String token)
    {
    	/**
    	 * 调用短信接口将验证码发送给司机，返回给乘客端短信已发送。。。
    	 */
    	MobileHttpDto dto=new MobileHttpDto();
        return dto;
    }
    
	/**
	 * 登录-验证user与code是否一致
	 * @param mobile
	 * @param token
	 * @return
	 */
    @RequestMapping(value="/verifyAuthor", method = {RequestMethod.GET})
    @ResponseBody
    public MobileHttpDto verifyAuthor(@RequestParam String mobile,@RequestParam String verifyCode,@RequestParam String token)
    {

    	MobileHttpDto dto=new MobileHttpDto();
    	dto.setBody(new Driver());
        return dto;  	
    }
    
	/**
	 * 请求可选车辆
	 * @param mobile
	 * @param token
	 * @return
	 */
    @RequestMapping(value="/acquireCar", method = {RequestMethod.GET})
    @ResponseBody
    public MobileHttpDto acquireCar(@RequestParam String token,@RequestParam int driverid,HttpServletRequest request)
    {
    	MobileHttpDto dto=new MobileHttpDto();
    	List<Car> lstCar=new ArrayList<Car>();
    	dto.setBody(lstCar);
        return dto;
    }
    
	/**
	 * 选择一辆车辆
	 * @param mobile
	 * @param token
	 * @return
	 */
    @RequestMapping(value="/decideCar", method = {RequestMethod.GET})
    @ResponseBody
    public MobileHttpDto decideCar(@RequestParam String token,@RequestParam int driverid,@RequestParam int carid)
    {
    	
    	MobileHttpDto dto=new MobileHttpDto();
    	//dto.setStatus();
        return dto;   	
    }
    
	/**
	 * 到达目的地结单
	 * @param mobile
	 * @param token
	 * @return
	 */
    @RequestMapping(value="/checkOut", method = {RequestMethod.POST})
    @ResponseBody
    public MobileHttpDto queryPayBank(@Valid OrderBeanDto order,BindingResult result,HttpServletRequest req)
    {
    	
    	MobileHttpDto dto=new MobileHttpDto();
    	//dto.setStatus();
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
    public MobileHttpDto cancleDelegation(@RequestParam int token,@RequestParam int userid,@RequestParam int orderId,@RequestParam String resion,@RequestParam String remark,HttpServletRequest request)
    {

    	MobileHttpDto dto=new MobileHttpDto();
        return dto; 
    }
    
/*	*//**
	 * 给司机打分
	 * @param mobile
	 * @param token
	 * @return
	 *//*
    @RequestMapping(value="/gradeDriver", method = {RequestMethod.GET})
    @ResponseBody
    public MobileHttpDto cancleDelegation(@RequestParam int token,@RequestParam int userid,@RequestParam int grade)
    {

    	MobileHttpDto dto=new MobileHttpDto();
        return dto; 
    }*/
}
