<%-- <%@page import="com.shinhan.vo.AdminVO"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JavaBean 이용하기!</h1>
<%-- 
<%
// 액션 태그를 몰랐다면 자바로 이렇게 써야 함!
String a = request.getParameter("email");
String b = request.getParameter("manager_name");
String c = request.getParameter("pass");
// AdminVO admin = new AdminVO(a, b, c);
admin.setEmail(a);
admin.setManager_name(b);
admin.setPass(c);
%>
<h2><%=admin %></h2>
 --%>
<jsp:useBean id="admin" class="com.shinhan.vo.AdminVO"></jsp:useBean> <!-- admin이라는 객체를 생성한 것! -->
<jsp:setProperty property="email" name="admin"/> <!-- property: setEmail을 찾는 것! 변수 이름! -->
<jsp:setProperty property="manager_name" name="admin"/>
<jsp:setProperty property="pass" name="admin" param="pass"/> <!-- input의 name과 vo의 변수명이 같으면 param을 주지 않아도 들어감! -->
<p>email: <jsp:getProperty property="email" name="admin"/></p>
<p>manager: <jsp:getProperty property="manager_name" name="admin"/></p>
<p>pass: <jsp:getProperty property="pass" name="admin"/></p>
<hr>

<!-- 더 간편한 방법: name과 변수명이 같으면 모두 설정 가능! -->
<jsp:useBean id="admin2" class="com.shinhan.vo.AdminVO"></jsp:useBean>
<jsp:setProperty property="*" name="admin2"/>
<p>email: <jsp:getProperty property="email" name="admin2"/></p>
<p>manager: <jsp:getProperty property="manager_name" name="admin2"/></p>
<p>pass: <jsp:getProperty property="pass" name="admin2"/></p>
</body>
</html>