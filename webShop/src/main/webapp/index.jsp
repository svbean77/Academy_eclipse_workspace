<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
</body>
</html>