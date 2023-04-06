<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css" type="text/css">
<script src='https://kit.fontawesome.com/a076d05399.js' ></script>
</head>
<body>
	<h2>Weekly Coding Challenge #1: Sign in/up Form</h2>
	<div class="container" id="container">
		<div class="form-container sign-up-container">
			<form action="<%=request.getContextPath()%>/auth/signup.do" method="post">
				<h1>Create Account</h1>
				<div class="social-container">
					<a href="#" class="social"><i class="fab fa-facebook-f"></i></a> <a
						href="#" class="social"><i class="fab fa-google-plus-g"></i></a> <a
						href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
				</div>
				<span>or use your email for registration</span> 
				<input type="text" name="manager_name" placeholder="Name" /> 
				<input type="email" name="email" placeholder="Email" />
				<input type="password" name="pass" placeholder="Password" />
				<button>Sign Up</button>
			</form>
		</div>
		<div class="form-container sign-in-container">
		<!-- 
		내 위치는 http://localhost:포트번호 까지임!
		따라서 절대 경로로 작성하고 싶다면 action="/webShop/경로"로 context path부터 작성해야 함!
		context path를 얻는 방법: < %=request.getContextPath()%> -> 이 결과는 /webShop임! 따라서 절대경로 작성 시 슬래시를 추가하지 않음!
		 -->
			<form action="<%=request.getContextPath()%>/auth/loginCheck.do" method="get" enctype="application/x-www-form-urlencoded"> <!-- 정의한 주소를 호출 -->
				<h1>Sign in</h1>
				<div class="social-container">
					<a href="#" class="social"><i class="fab fa-facebook-f"></i></a> <a
						href="#" class="social"><i class="fab fa-google-plus-g"></i></a> <a
						href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
				</div>
				<span>or use your account</span> 
				<input type="email" name="email" placeholder="Email" /> 
				<input type="password" name="pass" placeholder="Password" /> 
				<a href="#">Forgot your password?</a>
				<button>Sign In</button>
				<!-- <input type="submit" value="Sign In"> -->
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>Welcome Back!</h1>
					<p>To keep connected with us please login with your personal info</p>
					<button class="ghost" id="signIn">Sign In</button>
				</div>
				<div class="overlay-panel overlay-right">
					<h1>Hello, Friend!</h1>
					<p>Enter your personal details and start journey with us</p>
					<button class="ghost" id="signUp">Sign Up</button>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath() %>/js/login.js"></script> <!-- 로드가 끝난 후 실행해야 하기 때문에 위치는 body 내부로! -->
</body>
</html>