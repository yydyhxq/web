package com.caocao.server.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

	/**
	 * 可以根据ex是否为null判断是否发生了异常，进行日志记录.
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		// System.out.println("exeuce");
		super.afterCompletion(request, response, handler, ex);
	}

	/**
	 * bean处理后，有机会修改ModelAndView.
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		// System.out.println("after interceptor");
		super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * bean处理前，可以进行编码、安全控制等处理.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * StringBuffer buffer=new StringBuffer();
		 * System.out.println(request.getQueryString()); Map<String, String>
		 * m=request.getParameterMap();
		 * 
		 * for(Map.Entry<String, String> entry:m.entrySet()){
		 * System.out.println(
		 * entry.getKey()+"--->"+entry.getValue().toString()); } Set<String>
		 * xt=m.keySet(); Iterator<String> it=xt.iterator(); while(it.hasNext())
		 * { String key=String.valueOf(it.next());
		 * buffer.append(key.toString()+":");
		 * buffer.append(m.get(it.next()).toString()); }
		 */
		System.out.println("正在执行:  " + request.getRequestURL().toString()
				+ "参数列表:" + request.getQueryString());

		return super.preHandle(request, response, handler);
	}

}
