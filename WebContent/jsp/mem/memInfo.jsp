<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Member Info</title>
</head>
<body>
	<p>회원님의 정보입니다.</p>
	<div>ID : ${MEM_ID }</div>
	<div>PASSWORD : ${MEM_PWD }</div>
	<div>NAME : ${MEM_NAME }</div>
	<div>
		<a href="${pageContext.request.contextPath}/loginFrm.do">로그아웃</a>
		<a href="${pageContext.request.contextPath}/mem/goUpdateMemInfoFrm.do">정보수정</a>
	</div>
</body>
</html>