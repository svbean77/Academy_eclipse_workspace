<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>forward!!!!</h1>
<jsp:useBean id="vo1" class="com.shinhan.vo.AdminVO" scope="request"></jsp:useBean>
<p><jsp:getProperty property="email" name="vo1"/></p>
<jsp:useBean id="vo2" class="com.shinhan.vo.AdminVO" scope="page"></jsp:useBean>
<p><jsp:getProperty property="email" name="vo2"/></p>
</body>
</html>