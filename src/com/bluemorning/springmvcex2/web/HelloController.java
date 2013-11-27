/*
 * @(#) IndexController.java 2012. 3. 9.
 * 
 * Copyright(c) 2012 Lee Chang-Yeol.
 * 
 * NOTICE:
 * This source code that is confidential and proprietary to Lee Chang-Yeol.
 * No part of this source code may be reproduced in any form 
 * whatsoever without prior approval by Lee Chang-Yeol.
 */

package com.bluemorning.springmvcex2.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bluemorning.springmvcex2.service.mgr.HelloMgr;

/**
 * <PRE>
 * 1. FileName : IndexController.java
 * 2. Package  : com.bluemorning.springmvcex2.web.beans
 * 3. Comment  : 
 * 4. Programmer   : BlueMorning
 * 5. Date   : 2012. 3. 9. 오후 4:05:43
 * </PRE>
 */
@Controller
public class HelloController {
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private HelloMgr helloMgr;
	
	@RequestMapping(value="/hello.do")
	public void helloController() throws Exception{
		logger.info("this is HelloController.");
		helloMgr.testHello();
		//throw new Exception();
	}
}
