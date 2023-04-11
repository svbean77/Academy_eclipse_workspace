<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>현재 로그인중: '${loginUser.manager_name}'님</div>
		<div>(EL문법) 세션에서 로그인 사용자 읽기: '${sessionScope.loginUser}'님</div>
		<div>(ScriptLet)script방법 로그인 사용자 읽기: '<%=session.getAttribute("loginUser") %>'님</div>
		<button id="btnLogout">로그아웃</button>
		<img src="../images/fantasy.jpg" width="200">
</body>
</html>