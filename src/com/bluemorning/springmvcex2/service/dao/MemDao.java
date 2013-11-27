/*
 * @(#) MemDao.java 2012. 4. 6.
 * 
 * Copyright(c) 2012 Lee Chang-Yeol.
 * 
 * NOTICE:
 * This source code that is confidential and proprietary to Lee Chang-Yeol.
 * No part of this source code may be reproduced in any form 
 * whatsoever without prior approval by Lee Chang-Yeol.
 */

package com.bluemorning.springmvcex2.service.dao;

import org.springframework.stereotype.Repository;

import com.bluemorning.springmvcex2.service.dao.core.BaseDao;
import com.bluemorning.springmvcex2.service.vo.MemberVO;

/**
 * <PRE>
 * 1. FileName : MemDao.java
 * 2. Package  : com.bluemorning.springmvcex2.service.dao
 * 3. Comment  : 
 * 4. Programmer   : BlueMorning
 * 5. Date   : 2012. 4. 6. 오후 2:33:04
 * </PRE>
 */
@Repository
public class MemDao extends BaseDao{
	
	/**
	 * select member.
	 * @param serviceId
	 * @return
	 */
	public MemberVO selectMemberInfo(MemberVO memberVO) {
		return (MemberVO) select("member.selectMemberInfo", memberVO);
	}
	
	/**
	 * insert member
	 * @param memberVO
	 * @return
	 */
	public int insertMember(MemberVO memberVO){
		return insert("member.insertMember", memberVO);
	}
	
	/**
	 * update member
	 * @param memberVO
	 * @return
	 */
	public int updateMember(MemberVO memberVO){
		return update("member.updateMember", memberVO);
	}
	
	/**
	 * delete member
	 * @param memberVO
	 * @return
	 */
	public boolean deleteMember(MemberVO memberVO){
		return delete("member.deleteMember", memberVO) > 0;

	}
}
