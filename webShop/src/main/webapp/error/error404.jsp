<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- 404는 에러가 아님: exception에 들어오는 값이 없기 때문에 isErrorPage가 없어도 됨 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404Error</title>
</head>
<body>
<h1>요청하신 주소는 존재하지 않습니다.</h1>
<h2 id="here"></h2>

<script>
	here.innerHTML = "요청 주소: " + location.href;
</script>
</body>
</html>