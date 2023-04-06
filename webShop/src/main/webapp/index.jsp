<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta http-equiv="refresh" content="3;auth/login.jsp"> --> <!-- servlet의 response.setHeader("refresh", "3;login.jsp");와 같은 의미! -->
<title>Insert title here</title>
</head>
<body>
<h1>JSP/Servlet Project</h1>
<ul>
	<li><a href="first">첫번째 서블릿 요청1 (a태그: get)</a></li>
	<li>
		<form action="first" method="get">
			<input type="submit" value="첫번째 서블릿 요청2 (form: get)">
		</form>
	</li>
	<li>
		<form action="first" method="post">
			<input type="submit" value="첫번째 서블릿 요청3 (form: post)">
		</form>
	</li>
	<li>
		<form action="param">
			<input type="text" name="userid"><br>
			<input type="number" name="salary"><br>
			남자: <input type="radio" name="gender" value="Male">
			여자: <input type="radio" name="gender" value="Female"><br>
			hobby: 
			게임<input type="checkbox" name="hobby" value="게임">
			독서<input type="checkbox" name="hobby" value="독서">
			족구<input type="checkbox" name="hobby" value="족구">
			농구<input type="checkbox" name="hobby" value="농구"><br>
			<input type="submit" value="전송">
		</form>
	</li>
</ul>
<a href="auth/login.jsp">로그인하기(상대경로)</a> <!-- 상대경로는 ./이 생략된 것! (현재 위치) -->
<a href="<%=request.getContextPath() %>/auth/login.jsp">로그인하기(절대경로)</a> <!-- 절대경로에서 위치는 포트번호까지! 따라서 context path를 적어야 함! -->
<hr>
<a href="<%=request.getContextPath()%>/emp/emplist.do">직원조회</a>
<a href="<%=request.getContextPath()%>/emp/empinsert.do">직원등록</a>
</body>
</html>