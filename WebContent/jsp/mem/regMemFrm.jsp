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
	$(function() {
		$('#regBtn').click(function() {
			regMemProc();
		});
	});

	function regMemProc() {
		// TEST CODE
// 		$('#memId').attr("value", "bluemorning3");
// 		$('#memPwd').attr("value", "1111");
// 		$('#memName').attr("value", "이창열");

		if (!chkNullOrEmpty("아이디", $('#memId'))){return false;};
		if (!chkNullOrEmpty("패스워드", $('#memPwd'))){return false;};
		if (!chkNullOrEmpty("이름", $('#memName'))){return false;};
		
		$('#regFrm').attr("action",	"${pageContext.request.contextPath}/mem/insertMemberProc.do");
		$('#regFrm').submit();
	}

	
</script>

</head>
<body>
	<div align="center">
		<p>가입</p>
		<form id="regFrm" name="regFrm" method="post">
			<table>
				<tr>
					<td height="25">아이디</td>
					<td height="25"><input type="text" name="memId" id="memId" /></td>
				</tr>
				<tr>
					<td height="25">패스워드</td>
					<td height="25"><input type="password" id="memPwd" name="memPwd" /></td>
				</tr>
				<tr>
					<td height="25">이름</td>
					<td height="25"><input type="text" id="memName" name="memName" /></td>
				</tr>
			</table>
			<p>
				<input type="button" value="가입신청" id="regBtn" />
			</p>
		</form>
	</div>
</body>
</html>