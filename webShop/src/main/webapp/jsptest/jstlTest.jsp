<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL 연습</h1>
<c:set var="score" value="99"></c:set>
<c:set var="s" value="${param.score2}"></c:set> <!-- parameter의 이름(주소창 입력)이 score2이고 변수 이름은 s로 쓰겠다 -->
<h1>점수1는 ${score}점</h1>
<h1>점수2는 ${s}점</h1>
<c:forEach begin="1" end="10" step="1" var="su"> <!-- JSTL -->
	<p>${su}</p> <!-- EL -->
</c:forEach>


<hr>
<h2>scope를 알고 싶다! score: ${score}</h2>
<c:set var="val1" value="1 page" scope="page"/>
<c:set var="val2" value="2 request" scope="request"/>
<c:set var="val3" value="3 session" scope="session"/>
<c:set var="val4" value="4 application" scope="application"/>
<p>page: ${val1}</p>
<p>request: ${val2}</p>
<p>session: ${val3}</p>
<p>application: ${val4}</p>

<jsp:include page="../common/header.jsp"></jsp:include>
<h2>header.jsp에서 저장한 contextPath: ${path}</h2> <!-- header.jsp에 있는 변수 path 사용 -> header.jsp가 한 번 실행이 돼야 변수 사용 가능! -->

<hr>

</body>
</html>