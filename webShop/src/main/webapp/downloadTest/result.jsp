<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>       

<html>
<head>
<meta charset="UTF-8">
<c:set var="file1" value="${param.param1}"  />    
<c:set var="file2" value="${param.param2}"  />
 
<title>이미지 파일 출력하기</title>
</head>
<body>

파라미터 1 :<c:out value="${file1}"  /><br>
파라미터 2 :<c:out value="${file2}"  /><br>

<h3>이미지를 클릭해도 다운로드 됩니다!</h3>
<c:if test="${not empty file1 }">
<a href="${path}/download.do?fileName=${file1}" >
	<img src="${path}/uploads/${file1}"  width=300 height=300 />
</a>
<hr>
</c:if>
<br>
<c:if test="${not empty file2 }">
<a href="${path}/download.do?fileName=${file2}">
	<img src="${path}/uploads/${file2}"  width=300 height=300 />
</a>
<br>
</c:if>
<a href="${path}/download.do?fileName=${file1}" >파일 내려받기1</a><br> 
<a href="${path}/download.do?fileName=${file2}" >파일 내려받기2</a><br>
</body>
</html>
