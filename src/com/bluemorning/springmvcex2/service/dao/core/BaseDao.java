package com.bluemorning.springmvcex2.service.dao.core;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class BaseDao {

	@Autowired
	private SqlSession sqlSession;

	protected List<?> selectList(String statementName, Object parameterObject) {
		return sqlSession.selectList(statementName, parameterObject);
	}
	
	protected Object select(String statementName, Object parameterObject) {
		return sqlSession.selectOne(statementName, parameterObject);
	}

	protected Object select(String statementName) {
		return sqlSession.selectOne(statementName);
	}

	protected List<?> selectList(String statementName) {
		return sqlSession.selectList(statementName);
	}
	
	protected int insert(String statementName, Object parameterObject) {
		return sqlSession.insert(statementName, parameterObject);
	}

	protected int insert(String statementName) {
		return sqlSession.insert(statementName);
	}
//	protected Object insert(String statementName, Object parameterObject) {
//		return sqlSession.insert(statementName, parameterObject);
//	}
//	
//	protected Object insert(String statementName) {
//		return sqlSession.insert(statementName);
//	}

	protected int update(String statementName, Object parameterObject) {
		return sqlSession.update(statementName, parameterObject);
	}

	protected int update(String statementName) {
		return sqlSession.update(statementName);
	}

	protected int delete(String statementName, Object parameterObject) {
		return sqlSession.delete(statementName, parameterObject);
	}

	protected int delete(String statementName) {
		return sqlSession.delete(statementName);
	}


}
