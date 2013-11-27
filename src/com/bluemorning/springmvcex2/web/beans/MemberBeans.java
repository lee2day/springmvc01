/*
 * @(#) MemberBeans.java 2012. 3. 24.
 * 
 * Copyright(c) 2012 Lee Chang-Yeol.
 * 
 * NOTICE:
 * This source code that is confidential and proprietary to Lee Chang-Yeol.
 * No part of this source code may be reproduced in any form 
 * whatsoever without prior approval by Lee Chang-Yeol.
 */

package com.bluemorning.springmvcex2.web.beans;

import com.bluemorning.springmvcex2.util.StringUtil;
import com.bluemorning.springmvcex2.web.beans.core.BaseBeans;

/**
 * <PRE>
 * 1. FileName : MemberBeans.java
 * 2. Package  : com.bluemorning.springmvcex.web.beans
 * 3. Comment  : 
 * 4. Programmer   : BlueMorning
 * 5. Date   : 2012. 3. 24. 오전 9:06:14
 * </PRE>
 */
public class MemberBeans extends BaseBeans {
	
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

	/**
	 * @return the regDate
	 */
	public String getRegDate() {
		return regDate;
	}

	/**
	 * @param regDate the regDate to set
	 */
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
		return "MemberBeans [memId=" + memId + ", memPwd=" + memPwd
				+ ", memNewPwd=" + memNewPwd + ", memName=" + memName
				+ ", regDate=" + regDate + "]";
	}

	/* (non-Javadoc)
	 * @see com.bluemorning.springmvcex.web.beans.core.BaseBeans#validation()
	 */
	@Override
	public boolean validation() {
		if (StringUtil.isNullOrEmpty(memId)) {
			infoLog("memId is null or Empty!");
			return false;
		}
		if (StringUtil.isNullOrEmpty(memPwd)) {
			infoLog("memPwd is null or Empty!");
			return false;
		}
		return true;
	}
	
	/**
	 * validation for insert member
	 * @return
	 */
	public boolean validationForInsertMember() {
		if (!validation()) {
			return false;
		}
		if (StringUtil.isNullOrEmpty(memName)) {
			infoLog("memName is null or Empty!");
			return false;
		}
		return true;
	}

}
