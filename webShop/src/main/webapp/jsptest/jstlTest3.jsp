<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL 연습~~!!</h1>
<p>scope</p>
<p>내 이름: ${myName}</p>
<p>앱 이름: ${applicationScope.myName}</p>
<p>세션 이름: ${sessionScope.myName}</p>
<p>리퀘 이름: ${requestScope.myName}</p>
<hr>

<p>forEach</p>
<ul>
	<c:set var="sum" value="0"/> <!-- loop에서 변수를 사용하고 싶다면 미리 선언! -->
	<!-- request.setAttribute("count", 0)과 같은 의미! -->
	<c:forEach items="${admins}" var="admin" varStatus="status">
		<c:set var="sum" value="${sum+100}"/>
		<li style="color:${status.first? 'red' : status.last? 'blue' : 'gray'}">first? [${status.first}], last? [${status.last}]</li>
		<li>${sum}점: ${admin}</li>
		<li>
			<ul>
				<li>varStatus 내장: index - ${status.index}, count - ${status.count}</li>
				<li>${admin.email}</li>
				<li>${admin.manager_name}</li>
				<li>${admin.pass}</li>
			</ul>
		</li>
	</c:forEach>
</ul>
<hr>

<p>if</p>
<c:if test="${score >= 90}">
	<p>합격!</p>
</c:if>
<c:if test="${score < 90}">
	<p>불합격..</p>
</c:if>
<hr>

<p>choose</p>
<c:choose>
	<c:when test="${score >= 90}"><p>A학점</p></c:when>
	<c:when test="${score >= 80}"><p>B학점</p></c:when>
	<c:when test="${score >= 70}"><p>C학점</p></c:when>
	<c:otherwise>F학점</c:otherwise>
</c:choose>

<hr>
<p>out</p>
<c:out value="점심 뭐 먹지~~~~"></c:out> <!-- 특수문자를 그대로 사용할 때 좋음 -->
<hr>

<h1>포매팅 라이브러리~</h1>
<c:set value="10000000000000000" var="price"/>
<p>1-1. price - \${price}: ${price }</p>
<p>1-2. price - fmt:formatNumber value="\${price }" groupingUsed="true" type="currency" /fmt:formatNumber: <fmt:formatNumber value="${price }" groupingUsed="true" type="currency"></fmt:formatNumber></p>
<p>2-1. today - fmt:formatDate value="\${today}" pattern="yyyy-MM-dd hh:mm:ss": <fmt:formatDate value="${today}" pattern="yyyy-MM-dd hh:mm:ss"/></p>
<p>2-2. today - fmt:formatDate value="\${today}" dateStyle="full": <fmt:formatDate value="${today}" dateStyle="full"/></p>
<p>2-3. today - fmt:formatDate value="\${today}" dateStyle="full" timeStyle="full": <fmt:formatDate value="${today}" dateStyle="full" timeStyle="full"/></p>
<hr>

<h1>문자열 함수~</h1>
<p>\${myName }: ${myName }</p>
<p>\${fn:substring(myName, 0, 4)}: ${fn:substring(myName, 0, 4)}</p>
<p>\${fn:length(myName)}: ${fn:length(myName)}</p>
</body>
</html>