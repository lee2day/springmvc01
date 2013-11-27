/**
 * 인크로스(주) | http://in-cross.co.kr
 * Copyright (c)2007-2010, Incross Co., Ltd.
 * All rights reserved.
 */
package com.bluemorning.springmvcex2.web.beans.core;

import org.apache.log4j.Logger;

/**
 * BaseBeans
 * @author jsmarch
 * @created 2010. 5. 28.
 */
public abstract class BaseBeans {

	/** Logger */
	private Logger logger = Logger.getLogger(getClass()); 

	/**
	 * <pre>
	 * validation
	 * 해당 Beans 의 유효성 검사 결과를 반환한다.
	 * <pre>
	 * @return boolean
	 */
	public abstract boolean validation();

	/**
	 * <pre>
	 * debugLog
	 * DEBUG level log 출력
	 * </pre>
	 * @param logMsg
	 */
	public void debugLog(String logMsg){
		if(logger.isDebugEnabled()){
			logger.debug(logMsg);
		}
	}

	/**
	 * <pre>
	 * infoLog
	 * INFO level log 출력 
	 * <pre>
	 * @param logMsg
	 */
	public void infoLog(String logMsg){
		if(logger.isInfoEnabled()){
			logger.info(logMsg);
		}
	}

	/**
	 * <pre>
	 * warnLog
	 * WARN level log 출력
	 * <pre>
	 * @param logMsg
	 */
	public void warnLog(String logMsg){
		logger.warn(logMsg);
	}

	/**
	 * <pre>
	 * errorLog
	 * ERROR level log 출력
	 * <pre>
	 * @param logMsg
	 */
	public void errorLog(String logMsg){
		logger.error(logMsg);
	}

	/**
	 * <pre>
	 * errorLog
	 * ERROR level log 출력
	 * <pre>
	 * @param logMsg
	 * @param tw
	 */
	public void errorLog(String logMsg, Throwable tw){
		logger.error(logMsg, tw);
	}
}
