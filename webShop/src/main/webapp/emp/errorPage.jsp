<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류..</title>
</head>
<body>
<h1>오류 정보</h1>
<p><%=exception %></p>
<p><%=exception.getMessage() %></p>
<p><%exception.printStackTrace(); // 이 에러는 콘솔창에 뜸 %></p>
</body>
</html>