package com.caocao.web.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.caocao.web.dto.MobileHttpDto.Error;
import com.caocao.core.model.AdminExample;
import com.caocao.core.model.AdminExample.Criteria;
import com.caocao.core.service.impl.AdminServiceImpl;
import com.caocao.web.dto.MobileHttpDto;
@Controller
@RequestMapping("test")
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	@Resource
	private AdminServiceImpl adminService;
    @RequestMapping(value="/abc", method = {RequestMethod.GET})
    @ResponseBody
	public String showTime(@Valid User user,BindingResult result,HttpServletRequest req,HttpServletResponse rep)
	{
	logger.error("出错");
	//  System.out.println("JUNIT:"+user.getUsername()+"  "+result.getFieldError().getField());//.hasErrors());
	  AdminExample e=new AdminExample();
	  Criteria c=e.createCriteria();
	  c.andUsernameLike("%abc%");
	  c.andIdEqualTo(1);
	 System.out.println("number:"+adminService.countByExample(e));
		return "英国人";
	}
    
    @RequestMapping(value="/acquireCode", method = {RequestMethod.GET})
    @ResponseBody
    public MobileHttpDto acquireCode(@RequestParam String mobile,@RequestParam String token)
    {
    	MobileHttpDto m=new MobileHttpDto();
		m.setBody(mobile);
		m.setStatus(1);
		Error error = new Error(11, token);
		m.setError(error);
        return m;    	
    }   
  
/*  @InitBinder
  public void initBinder(WebDataBinder binder)
  {
	  SimpleMappingExceptionResolver
	  binder.addValidators(validators);
	  binder.getConversionService();
	  binder.validate();
	  binder.registerCustomEditor(Date.class, propertyEditor);
  }*/    

}
