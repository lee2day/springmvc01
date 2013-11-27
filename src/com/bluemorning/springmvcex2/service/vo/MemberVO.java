/*
 * @(#) MemberVO.java 2012. 3. 24.
 * 
 * Copyright(c) 2012 Lee Chang-Yeol.
 * 
 * NOTICE:
 * This source code that is confidential and proprietary to Lee Chang-Yeol.
 * No part of this source code may be reproduced in any form 
 * whatsoever without prior approval by Lee Chang-Yeol.
 */

package com.bluemorning.springmvcex2.service.vo;

/**
 * <PRE>
 * 1. FileName : MemberVO.java
 * 2. Package  : com.bluemorning.springmvcex.service.vo
 * 3. Comment  : 
 * 4. Programmer   : BlueMorning
 * 5. Date   : 2012. 3. 24. 오전 9:11:34
 * </PRE>
 */
public class MemberVO {
	
	private String memId;
	private String memPwd;
	private String memNewPwd;
	private String memName;
	private String regDate;
	
	/**
	 * @return the memId
	 */
	public String getMemId() {
		return memId;
	}

	/**
	 * @param memId the memId to set
	 */
	public void setMemId(String memId) {
		this.memId = memId;
	}

	/**
	 * @return the memPwd
	 */
	public String getMemPwd() {
		return memPwd;
	}

	/**
	 * @param memPwd the memPwd to set
	 */
	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	/**
	 * @return the memName
	 */
	public String getMemName() {
		return memName;
	}

	/**
	 * @param memName the memName to set
	 */
	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getMemNewPwd() {
		return memNewPwd;
	}

	public void setMemNewPwd(String memNewPwd) {
		this.memNewPwd = memNewPwd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPwd=" + memPwd
				+ ", memNewPwd=" + memNewPwd + ", memName=" + memName
				+ ", regDate=" + regDate + "]";
	}

}
