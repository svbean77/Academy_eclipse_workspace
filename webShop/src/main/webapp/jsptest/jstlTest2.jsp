<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL 연습 2</h1>
	<h2>scope를 알고 싶다! score: ${score}</h2> <!-- X -->
	<p>page: ${val1}</p> <!-- X -->
	<p>request: ${val2}</p> <!-- X -->
	<p>session: ${val3}</p> <!-- O -->
	<p>application: ${val4}</p> <!-- O -->
</body>
</html>