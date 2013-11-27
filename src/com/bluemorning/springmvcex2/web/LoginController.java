/*
 * @(#) LoginController.java 2012. 4. 6.
 * 
 * Copyright(c) 2012 Lee Chang-Yeol.
 * 
 * NOTICE:
 * This source code that is confidential and proprietary to Lee Chang-Yeol.
 * No part of this source code may be reproduced in any form 
 * whatsoever without prior approval by Lee Chang-Yeol.
 */

package com.bluemorning.springmvcex2.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bluemorning.springmvcex2.service.mgr.MemMgr;
import com.bluemorning.springmvcex2.service.vo.MemberVO;
import com.bluemorning.springmvcex2.web.beans.MemberBeans;
import com.bluemorning.springmvcex2.web.core.BaseController;

/**
 * <PRE>
 * 1. FileName : LoginController.java
 * 2. Package  : com.bluemorning.springmvcex2.web
 * 3. Comment  : 
 * 4. Programmer   : BlueMorning
 * 5. Date   : 2012. 4. 6. 오후 10:58:36
 * </PRE>
 */
@Controller
public class LoginController extends BaseController {
	@Autowired
	private MemMgr memMgr;
	
	/**
	 * Move to login form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/loginFrm")
	public String goLoginFrm(HttpServletRequest request) throws Exception {
		infoLog("세션 종료");
		HttpSession ses = request.getSession();
		ses.invalidate();
		infoLog("로그인페이지로 이동");
		return "loginFrm";
	}
	
	/**
	 * login
	 * @param command
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/loginProc", method = RequestMethod.POST)
	public String loginProc(MemberBeans command, HttpServletRequest request
			,ModelMap model) throws Exception {
		MemberVO memberVO = new MemberVO();
		HttpSession ses = request.getSession();
		
		try {
			infoLog("로그인페이지...");
			if (!command.validation()) {
				infoLog("유효성 검사 실패!!!");
				return "redirect:loginFrm.do";
			}
			BeanUtils.copyProperties(memberVO, command);
			
			//로그인 로직 수행
			infoLog("로그인 중...");
			memberVO = memMgr.selectMemberInfo(memberVO);
			if (memberVO == null) {
				infoLog("존재하지 않는사용자");
				return alert("아이디/비번이 잘못되었거나 존재하지 않는 사용자입니다.", "loginFrm.do", model);
			}
			ses.setAttribute("MEM_ID", memberVO.getMemId());
			ses.setAttribute("MEM_PWD", memberVO.getMemPwd());
			ses.setAttribute("MEM_NAME", memberVO.getMemName());
			
			infoLog("로그인 완료...");
			return "redirect:mem/memInfo.do";
		} catch (Exception e) {
			errorLog("Login Error!", e);
			throw e;
		}
	}
}
