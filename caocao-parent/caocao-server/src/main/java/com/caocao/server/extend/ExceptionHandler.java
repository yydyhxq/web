package com.caocao.server.extend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionHandler implements HandlerExceptionResolver {
	private static final Logger logger = LoggerFactory
			.getLogger(ExceptionHandler.class);
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {		
		// TODO Auto-generated method stub
        if (ex instanceof UserDefinedException) {  
            //doSomething...
        	logger.error("执行请求{}发生错误",request.getRequestURL(),ex);
        	return new ModelAndView("error/UserDefineError");
    		}
        return new ModelAndView("error/UserDefineError");
	}

}
