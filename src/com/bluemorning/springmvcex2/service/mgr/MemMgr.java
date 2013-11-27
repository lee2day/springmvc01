package com.bluemorning.springmvcex2.service.mgr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluemorning.springmvcex2.service.vo.MemberVO;
import com.bluemorning.springmvcex2.service.dao.MemDao;
import com.bluemorning.springmvcex2.service.mgr.core.BaseMgr;

@Service
public class MemMgr extends BaseMgr {
	@Autowired
	private MemDao memDao;
	
	/**
	 * select member
	 * @param nsgmUserVO
	 * @return
	 */
	public MemberVO selectMemberInfo(MemberVO memberVO) {
		return memDao.selectMemberInfo(memberVO);
	}
	
	/**
	 * insert member
	 * @param memberVO
	 * @return
	 */
	public int insertMember(MemberVO memberVO){
		return memDao.insertMember(memberVO);
	}
	
	/**
	 * update member
	 * @param memberVO
	 * @return
	 */
	public int updateMember(MemberVO memberVO){
		return memDao.updateMember(memberVO);
	}
	
	/**
	 * delete member
	 * @param memberVO
	 * @return
	 */
	public boolean deleteMember(MemberVO memberVO){
		return memDao.deleteMember(memberVO);
	}
}
