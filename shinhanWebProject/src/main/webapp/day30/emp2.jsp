<%@page import="com.shinhan.vo.EmpVO"%>
<%@page import="com.shinhan.model.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String sid = request.getParameter("empid");
int empid = 0;

if(sid != null) {
	empid = Integer.parseInt(sid);
}

EmpService service = new EmpService();
EmpVO emp = service.selectById(empid);
%>
{
	"first_name": "<%=emp.getFirst_name() %>",
	"salary": "<%=emp.getSalary() %>"
}