<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>장바구니 담기</h1>
	<p>로그인 정보: ${loginUser.manager_name}</p>
	<div>
		<form action="addCart.do" method="post">
			<input type="radio" name="product" value="김밥" checked> 김밥 
			<input type="radio" name="product" value="햄버거"> 
			햄버거 <input type="radio" name="product" value="콜라"> 콜라 
			<br> <input type="number" name="count" value="1">개<br>				
			<hr> 
			<input type="submit" value="장바구니에 담기">
			<input type="button" value="장바구니 보기" onclick="location.href='cartview.do';">
			<input type="button" value="장바구니 비우기" onclick="location.href='cartremove.do';">
		</form>
	</div>
	
	
</body>
</html>