<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<ul>
	<c:forEach begin="0" end="4" step="1" var="idx"> <!-- forEach의 end는 포함이구나 -->
		<li>${jobList[idx].job_id} - ${jobList[idx].job_title}</li>
	</c:forEach>
</ul>