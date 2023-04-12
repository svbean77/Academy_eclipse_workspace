<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>첫 번째 페이지!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!</h1>
<%-- <jsp:forward page="b.jsp"></jsp:forward> <!-- 액션태그: 포워딩 -> 주소는 a인데 보이는 페이지는 b --> --%>
<jsp:include page="b.jsp"></jsp:include> <!-- 액션태그: 인클루드 -> 주소는 a이고 b도 갔다 옴 -->
<%-- 
<%
// 액션 태그를 모른다면 자바로 어떻게 써야 해?
RequestDispatcher rd = request.getRequestDispatcher("b.jsp");
//forward
//rd.forward(request, response);
//include
rd.include(request, response); // 두 번째 페이지가 먼저 해석 됨
%>
 --%>
</body>
</html>