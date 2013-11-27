<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Login</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/common.js"></script>
<script type="text/javascript">
	$(function(){
		$('#loginBtn').click(function(){
			loginProc();
		});
		$('#goRegMemFrmBtn').click(function(){
			location.replace("${pageContext.request.contextPath}/mem/regMemFrm.do");
		});
	});
	
	function loginProc(){
		// TEST CODE
// 		$('#memId').attr("value", "bluemorning");
// 		$('#memPwd').attr("value", "1212");
		
		if (isEmptyOrNull($('#memId').val())) {
			valFalseProc("아이디", $('#memId'));
			return false;
		}
		if (isEmptyOrNull($('#memPwd').val())) {
			valFalseProc("패스워드", $('#memPwd'));
			return false;
		}
		
		$('#loginFrm').attr("action", "${pageContext.request.contextPath}/loginProc.do");
		$('#loginFrm').submit();
	}
	
</script>

</head>
<body>
<div align="center">
<p>로그인 페이지 입니당...</p>
<form id="loginFrm" name="loginFrm" method="post">
<table>
	<tr>
		<td height="25" >아이디</td>
		<td height="25">
			<input type="text" name="memId" id="memId" />
		</td>
	</tr>
	<tr>
		<td height="25" >패스워드</td>
		<td height="25" >
			<input type="password" id="memPwd" name="memPwd"/>
		</td>
	</tr>
</table>
<p>
	<input type="button" value="로그인" id="loginBtn" />
	<input type="button" value="가입" id="goRegMemFrmBtn" />
</p>
</form>
</div>
</body>
</html>