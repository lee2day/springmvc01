package com.bluemorning.springmvcex2.web.intercepteor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Service
public class NoCacheHeaderInterceptor extends HandlerInterceptorAdapter {

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		response.setHeader("Cache-Control", "no-store"); // HTTP 1.0
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		if (request.getProtocol().equals("HTTP/1.1"))
			response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
	}
}
