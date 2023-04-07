<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%--<meta http-equiv="refresh" content="3;auth/login.jsp"> --> <!-- servlet의 response.setHeader("refresh", "3;login.jsp");와 같은 의미! --%>
<title>Insert title here</title>
</head>
<body>
<h1>JSP/Servlet Project</h1>
<%-- application, session, request 영역 연습! el 문법으로 읽어오자 ${} --%>
<p>application: ${mydata1}</p>
<p>session: ${mydata2}</p>
<p>request: ${mydata3}</p>
<p>변수명이 같으면 누구의 값이 올까?!: ${myname}</p> <%-- 가장 가까운 session이 옴! (index는 request를 전달받지 못했어.. 따라서 app, session 중 범위가 좁은 session! --%>
<p>나는 확실한 값이 필요해.. application: ${applicationScope.myname}</p>
<p>나는 확실한 값이 필요해.. session: ${sessionScope.myname}</p>
<p>나는 확실한 값이 필요해.. request: ${requestScope.myname}</p>

<hr>
<p>web.xml에 들어있는 내용(어디서든 읽을 수 있어!): <%=application.getInitParameter("DB_userid")%></p>

<hr>
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
<a href="auth/loginCheck.do">로그인하기(상대경로)</a> <!-- 상대경로는 ./이 생략된 것! (현재 위치) -->
<a href="<%=request.getContextPath() %>/auth/loginCheck.do">로그인하기(절대경로)</a> <!-- 절대경로에서 위치는 포트번호까지! 따라서 context path를 적어야 함! -->
<hr>
<a href="<%=request.getContextPath()%>/emp/emplist.do">직원조회</a>
<a href="<%=request.getContextPath()%>/emp/empinsert.do">직원등록</a>
</body>
</html>