<%@page import="java.util.List"%>
<%@page import="com.shinhan.vo.EmpVO"%>
<%@page import="com.shinhan.model.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
EmpService eService = new EmpService();
List<EmpVO> emplist = eService.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<style>
/* 
내가 만들어본 스타일! 부트스트랩 사용으로 잠시 안녕~
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);

* {
	font-family: 'Jeju Gothic', sans-serif;
	margin: 0px;
	padding: 0px;
}

#container {
	width: 1100px;
	margin: 20px auto;
	text-align: center;
}

table {
	margin: 5px auto;
}

tr, td {
	padding: 5px;
}

thead tr {
	background-color: rgb(221, 250, 182);
}

th {
	padding: 5px 5px;
}

tbody tr:nth-child(even) {
	background-color: rgba(221, 250, 182, 0.5);
}

h1 {
	margin: 20px 0px;
} 
*/
</style>
</head>
<body>
	<div id="container" class="container mt-3">
		<h1>직원목록</h1>
		<button onclick="location.href='emp_insert.html'" type="button" class="btn btn-outline-success">직원등록(버튼)</button>
		<a type="button" class="btn btn-outline-success" href="emp_insert.html">직원등록(a태그)</a>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>직원번호</th>
					<th>이름</th>
					<th>성</th>
					<th>이메일</th>
					<th>전화번호</th>
					<th>입사일</th>
					<th>직책</th>
					<th>급여</th>
					<th>커미션</th>
					<th>매니저</th>
					<th>부서</th>
				</tr>
			</thead>
			<tbody>
				<!-- 여러 직원의 정보를 출력하기 위해 for문을 돌아야 함! 해석은 WAS가 해준다~~ -->
				<%
				for (EmpVO emp : emplist) {
				%>
				<tr>
					<td><%=emp.getEmployee_id()%></td>
					<td><%=emp.getFirst_name()%></td>
					<td><%=emp.getLast_name()%></td>
					<td><%=emp.getEmail()%></td>
					<td><%=emp.getPhone_number()%></td>
					<td><%=emp.getHire_date()%></td>
					<td><%=emp.getJob_id()%></td>
					<td><%=emp.getSalary()%></td>
					<td><%=emp.getCommission_pct()%></td>
					<td><%=emp.getManager_id()%></td>
					<td><%=emp.getDepartment_id()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>