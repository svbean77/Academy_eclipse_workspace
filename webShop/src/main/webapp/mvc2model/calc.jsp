<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>계산기</h1>
<form method="post" action="calc">
	<input type="number" name="su1" value="${su1}">
	<select name="op">
		<option ${op == "+" ? "selected" : ""}>+</option>
		<option ${op == "-" ? "selected" : ""}>-</option>
		<option ${op == "*" ? "selected" : ""}>*</option>
		<option ${op == "/" ? "selected" : ""}>/</option>
	</select>
	<input type="number" name="su2" value="${su2}">
	<button>=</button>
	<input type="number" value="${result}">
</form>
</body>
</html>