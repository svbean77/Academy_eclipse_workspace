<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String jid = request.getParameter("job_id");
String title = request.getParameter("job_title");
String maxSal = request.getParameter("max_salary");
String minSal = request.getParameter("min_salary");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Job을 등록해보자</h1>
<p>job id: <%=jid %></p>
<p>job title: <%=title %></p>
<p>max salary: <%=maxSal %></p>
<p>min salary: <%=minSal %></p>
</body>
</html>