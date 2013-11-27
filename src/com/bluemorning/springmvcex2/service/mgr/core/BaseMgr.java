package com.bluemorning.springmvcex2.service.mgr.core;

import org.apache.log4j.Logger;

public abstract class BaseMgr {

	private Logger logger = Logger.getLogger(getClass());

	protected void debugLog(String debugMsg){
		if(logger.isDebugEnabled()){
			logger.debug(debugMsg);
		}
	}

	protected void infoLog(String infoMsg){
		if(logger.isInfoEnabled()){
			logger.info(infoMsg);
		}
	}

	protected void warnLog(String warnMsg) {
		logger.warn(warnMsg);
	}

	protected void errorLog(String errMsg){
		logger.error(errMsg);
	}

	protected void errorLog(String errMsg, Throwable e){
		logger.error(errMsg, e);
	}

	protected void fatalLog(String fatalMsg) {
		logger.fatal(fatalMsg);
	}
}
