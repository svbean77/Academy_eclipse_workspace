<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
	<c:forEach items="${adminsPicture}" var="admin">
		<li><img src="${path}/uploads/${admin.pic}" width="150"></li>
	</c:forEach>
</ul>