package com.caocao.web.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("test")
public class TestController {
  
  @RequestMapping(value="/abc", method = {RequestMethod.POST})
  @ResponseBody
	public String showTime(@Valid User user,BindingResult result,HttpServletRequest req,HttpServletResponse rep)
	{
	
	//  System.out.println("JUNIT:"+user.getUsername()+"  "+result.getFieldError().getField());//.hasErrors());
		return "英国人";
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
