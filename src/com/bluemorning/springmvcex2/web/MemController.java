/*
 * @(#) MemController.java 2012. 4. 6.
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

import com.bluemorning.springmvcex2.service.mgr.MemMgr;
import com.bluemorning.springmvcex2.service.vo.MemberVO;
import com.bluemorning.springmvcex2.util.StringUtil;
import com.bluemorning.springmvcex2.web.beans.MemberBeans;
import com.bluemorning.springmvcex2.web.core.BaseController;

/**
 * <PRE>
 * 1. FileName : MemController.java
 * 2. Package  : com.bluemorning.springmvcex2.web
 * 3. Comment  : 
 * 4. Programmer   : BlueMorning
 * 5. Date   : 2012. 4. 6. 오후 2:01:12
 * </PRE>
 */
@Controller
public class MemController extends BaseController {
	
	@Autowired
	private MemMgr memMgr;
	
	/**
	 * member info page after login
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/mem/memInfo")
	public void memInfo() throws Exception {
		infoLog("멤버 정보페이지로 이동.");
	}
	
	/**
	 * member info page after login
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/mem/regMemFrm")
	public void regMemFrm() throws Exception {
		infoLog("가입 페이지로 이동.");
	}
	
	/**
	 * insert member
	 * @param model
	 * @param command
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/mem/insertMemberProc")
	public String insertMemberProc(ModelMap model, MemberBeans command, HttpServletRequest request) throws Exception{
		MemberVO memberVO = new MemberVO();
		HttpSession ses = request.getSession();
		
		try {
			infoLog("가입프로세스...");
			if (!command.validationForInsertMember()) {
				infoLog("유효성 검사 실패!!!");
				return alert("유효성 검사 실패!!!", "regMemFrm.do", model);
			}
			BeanUtils.copyProperties(memberVO, command);
			
			if (memMgr.insertMember(memberVO) < 1) {
				infoLog("가입실패!");
				return alert("가입 실패!", "regMemFrm.do", model);
			}
			ses.setAttribute("MEM_ID", memberVO.getMemId());
			ses.setAttribute("MEM_PWD", memberVO.getMemPwd());
			ses.setAttribute("MEM_NAME", memberVO.getMemName());
			
			infoLog("가입 완료...");
			return "redirect:memInfo.do";
		} catch (Exception e) {
			errorLog("INSERT MEMBER ERROR!", e);
			throw e;
		}
	}
	
	@RequestMapping(value="/mem/goUpdateMemInfoFrm")
	public String goUpdateMemInfoFrm(HttpServletRequest request, ModelMap model) throws Exception{
		MemberVO memberVO = new MemberVO();
		HttpSession ses = request.getSession();
		try {
			infoLog("회원정보 수정...");
			memberVO.setMemId((String)ses.getAttribute("MEM_ID"));
			memberVO.setMemPwd((String)ses.getAttribute("MEM_PWD"));
			infoLog(memberVO.toString());
			memberVO = memMgr.selectMemberInfo(memberVO);
			model.addAttribute("memberVO", memberVO);
			return "/mem/updateMemInfoFrm";
		} catch (Exception e) {
			errorLog("GO UPDATE MEMBER FROM ERROR!", e);
			throw e;
		}
	}
	
	/**
	 * 회원정보 수정
	 * @param model
	 * @param command
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/mem/updateMemberProc")
	public String updateMemberProc(ModelMap model, MemberBeans command, HttpServletRequest request) throws Exception{
		MemberVO memberVO = new MemberVO();
		HttpSession ses = request.getSession();
		
		try {
			infoLog("회원정보수정...");
			if (!command.validationForInsertMember()) {
				infoLog("유효성 검사 실패!!!");
				return alert("유효성 검사 실패!!!", "goUpdateMemInfoFrm.do", model);
			}
			BeanUtils.copyProperties(memberVO, command);
			
			if (memMgr.updateMember(memberVO) < 1) {
				infoLog("변경실패!");
				return alert("변경실패!", "goUpdateMemInfoFrm.do", model);
			}
			if (!StringUtil.isNullOrEmpty(memberVO.getMemNewPwd())) {
				memberVO.setMemPwd(memberVO.getMemNewPwd());
			}
			memberVO = memMgr.selectMemberInfo(memberVO);
			ses.setAttribute("MEM_ID", memberVO.getMemId());
			ses.setAttribute("MEM_PWD", memberVO.getMemPwd());
			ses.setAttribute("MEM_NAME", memberVO.getMemName());
			
			infoLog("수정 완료...");
			return "redirect:memInfo.do";
		} catch (Exception e) {
			errorLog("UPDATE MEMBER ERROR!", e);
			throw e;
		}
	}
	
	
	@RequestMapping(value="/mem/deleteMemProc")
	public String deleteMemProc(ModelMap model, MemberBeans command) throws Exception{
		MemberVO memberVO = new MemberVO();
		try {
			infoLog("회원삭제...");
			if (!command.validation()) {
				infoLog("유효성 검사 실패!!!");
				return alert("유효성 검사 실패!!!", "goUpdateMemInfoFrm.do", model);
			}
			BeanUtils.copyProperties(memberVO, command);
			if (!memMgr.deleteMember(memberVO)) {
				infoLog("회원정보 삭제 실패!");
				return alert("회원정보 삭제 실패!", "goUpdateMemInfoFrm.do", model);
			}
			infoLog("회원삭제 완료...");
			return "redirect:../loginFrm.jsp.do";
		} catch (Exception e) {
			errorLog("UPDATE MEMBER ERROR!", e);
			throw e;
		}
	}
	
}
