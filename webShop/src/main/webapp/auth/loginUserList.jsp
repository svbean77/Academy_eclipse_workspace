<%@page import="java.util.List"%>
<%@page import="com.shinhan.vo.AdminVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 상태인 사용자 리스트</h1>
<%
// 지금 JSP는 다 안배웠으니 일단 자바로 해보자~
Object obj = application.getAttribute("userList");
if(obj == null) {
	return;
}
List<AdminVO> userList = (List<AdminVO>) obj;
for(AdminVO vo: userList) {
	out.print("<h2>" + vo + "</h2>");
}
%>
</body>
</html>