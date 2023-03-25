<%@page import="com.shinhan.model.EmpService"%>
<%@page import="com.shinhan.dbutil.DateUtil"%>
<%@page import="com.shinhan.vo.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String empid = request.getParameter("employee_id");
String fname = request.getParameter("first_name");
String lname = request.getParameter("last_name");
String email = request.getParameter("email");
String phone = request.getParameter("phone_number");
String hdate = request.getParameter("hire_date");
String job_id = request.getParameter("job_id");
String salary = request.getParameter("salary");
String comm = request.getParameter("commission_pct");
String mid = request.getParameter("manager_id");
String deptid = request.getParameter("department_id");

EmpVO emp = new EmpVO();
emp.setCommission_pct(Double.parseDouble(comm));
emp.setDepartment_id(Integer.parseInt(deptid));
emp.setEmail(email);
emp.setEmployee_id(Integer.parseInt(empid));
emp.setFirst_name(fname);
emp.setHire_date(DateUtil.convertToDate(hdate));
emp.setJob_id(job_id);
emp.setLast_name(lname);
emp.setManager_id(Integer.parseInt(mid));
emp.setPhone_number(phone);
emp.setSalary(Double.parseDouble(salary));

System.out.println(emp);

EmpService service = new EmpService();
service.empInsert(emp);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB에 직원 저장...</title>
<style>
	p {
		border: 1px solid green;
	}
</style>
</head>
<body>
	<h1>신규직원을 DB에 저장합니다.</h1>
	<p><%=emp %></p>
	<p>직원번호: <%=empid%></p>
	<p>이름: <%=fname%></p>
	<p>성: <%=lname%></p>
	<p>이메일: <%=email%></p>
	<p>전화번호: <%=phone%></p>
	<p>입사일: <%=hdate%></p>
	<p>직책: <%=job_id%></p>
	<p>급여: <%=salary%></p>
	<p>커미션: <%=comm%></p>
	<p>매니저: <%=mid%></p>
	<p>부서: <%=deptid%></p>
</body>
</html>