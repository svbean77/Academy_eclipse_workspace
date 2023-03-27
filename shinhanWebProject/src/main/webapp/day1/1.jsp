<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- HTML과의 차이점은 이 위의 두 줄! < % % > 내부에 작성하면 JAVA! -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
String myName = "이름 is JAVA";
%>
</head>
<body>
	<h1>
		JSP 파일이다!
		<%=myName%></h1>
</body>
</html>