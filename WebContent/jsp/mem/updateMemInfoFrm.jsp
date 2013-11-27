<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Update Member Info</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/common.js"></script>
<script type="text/javascript">
	$(function() {
		$('#updateBtn').click(function() {
			updateMemProc();
		});
		$('#deleteBtn').click(function() {
			deleteMemProc();
		});
		$('#logoutBtn').click(function() {
			location.replace("${pageContext.request.contextPath}/loginFrm.do");
		});
	});

	function updateMemProc() {
		// TEST CODE
		//$('#memId').attr("value", "bluemorning3");
		//$('#memPwd').attr("value", "1111");
		//$('#memName').attr("value", "이창열");

		if (!chkNullOrEmpty("아이디", $('#memId'))){return false;};
		if (!chkNullOrEmpty("패스워드", $('#memPwd'))){return false;};
		if (!chkNullOrEmpty("이름", $('#memName'))){return false;};
		
		$('#updateFrm').attr("action",	"${pageContext.request.contextPath}/mem/updateMemberProc.do");
		$('#updateFrm').submit();
	}
	
	function deleteMemProc(){
		if (!chkNullOrEmpty("아이디", $('#memId'))){return false;};
		if (!chkNullOrEmpty("패스워드", $('#memPwd'))){return false;};
		$('#updateFrm').attr("action",	"${pageContext.request.contextPath}/mem/deleteMemProc.do");
		$('#updateFrm').submit();
	}

	
</script>

</head>
<body>
	<div align="center">
		<p>정보변경</p>
		<form id="updateFrm" name="updateFrm" method="post">
			<table>
				<tr>
					<td height="25">아이디</td>
					<td height="25"><input type="text" id="memId" name="memId" value="${memberVO.memId}" readonly="readonly" /></td>
				</tr>
				<tr>
					<td height="25">패스워드</td>
					<td height="25"><input type="password" id="memPwd" name="memPwd" value="${memberVO.memPwd}"/></td>
				</tr>
				<tr>
					<td height="25">변경패스워드</td>
					<td height="25"><input type="password" id="memNewPwd" name="memNewPwd" /></td>
				</tr>
				<tr>
					<td height="25">이름</td>
					<td height="25"><input type="text" id="memName" name="memName" value="${memberVO.memName}" /></td>
				</tr>
			</table>
			<p>
				<input type="button" value="정보변경" id="updateBtn" />
				<input type="button" value="탈퇴" id="deleteBtn" />
				<input type="button" value="로그아웃" id="logoutBtn" />
			</p>
		</form>
	</div>
</body>
</html>