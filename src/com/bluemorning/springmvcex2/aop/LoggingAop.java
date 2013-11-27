package com.bluemorning.springmvcex2.aop;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;
import org.springframework.web.util.WebUtils;

public class LoggingAop {

	private static final Logger logger = Logger.getLogger(LoggingAop.class);

	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String className = proceedingJoinPoint.getTarget().getClass().getSimpleName();
		String methodName = proceedingJoinPoint.getSignature().getName();
		Object[] params = proceedingJoinPoint.getArgs();
		String values = "";

		try {
			if (className.indexOf("LogHandlerInterceptor") >= 0) {
				HttpServletRequest request = (HttpServletRequest) params[0];
				String path = request.getServletPath();
				String addr = request.getRemoteAddr();
				int port = request.getRemotePort();
				Map<?, ?> map = WebUtils.getParametersStartingWith(request, null);
				if (logger.isDebugEnabled()) {
					logger.debug("####################################################################");
					logger.debug("## REQUEST = http://" + addr + ":" + port + " ACTION = " + path + map);
					logger.debug("####################################################################");
				}
				return proceedingJoinPoint.proceed();
			}
		} catch (Exception e) {
			logger.fatal("Exception", e);
		}

		if (params != null)
			for (int i = 0; i < params.length; i++) {
				values += params[i] + ",";
			}

		if (values != null && values.length() > 0)
			values = values.substring(0, values.length() - 1);

		StopWatch watch = new StopWatch();
		if (logger.isDebugEnabled()) {
			logger.debug("#IN #[" + className + "." + methodName + "] [" + values + "]");
		}
		Object object = null;
		try {
			watch.start();
			object = proceedingJoinPoint.proceed();

		} catch (Exception e) {
			logger.fatal("Exception", e);
		} finally {
			watch.stop();
			if (logger.isDebugEnabled()) {
				logger.debug("#OUT#[" + className + "." + methodName + "] [" + (object==null?"":object.toString()) + "] " + "("+ watch.getTotalTimeMillis()+"ms)");
			}
		}

		return object;
	}
}
