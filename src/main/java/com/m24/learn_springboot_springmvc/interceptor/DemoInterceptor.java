package com.m24.learn_springboot_springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DemoInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler,	ModelAndView modelAndView) throws Exception {
		long startTime = (Long) request.getAttribute("startTime");
		request.removeAttribute("startTime");
		long endTime = System.currentTimeMillis();
		System.out.println("use time: " + (endTime - startTime));
		request.setAttribute("handlingTime", endTime-startTime);
	}
}
