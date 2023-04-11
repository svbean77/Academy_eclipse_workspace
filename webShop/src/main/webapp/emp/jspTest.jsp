<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
// 나는 선언문 -> 멤버 변수, 멤버 메소드로 생성: class에 독립적으로 만들어짐 (클래스 멤버)
// -> 해당 객체를 사용하는 모든 클래스가 공유하는 변수
String myName = "홍길동: 공유 변수";
public int sum(int a, int b) {
	return a + b;
}
%>

<%
// 나는 스크립트릿 -> _jspService 메소드 내부로 들어감
int age = 20;
%>

<%-- 
JSP 주석
JSP -> .java로 바뀌면 주석이 있을까? -> 없음!!!!!
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP의 ScriptLet 연습</h1>
<p>멤버 변수 myName: <%=myName %></p>
<p>서비스 내부 변수 age: <%=age %></p> <!-- HTML 내용도 service 내부에 존재! 따라서 age를 호출할 수 있음! -->
<p>멤버 메소드 sum: <%=sum(10, 20) %></p>
<hr>

<%
// 아주 끔찍한 스크립트릿 문법.. 이렇게 제발 쓰지 말자..
for(int i = 1; i <= 10; i++) {%>
	<p><%=i %></p>
<%}
%>
<hr>
<%
// 그나~~~~마 나은 방법: 완전 다 자바로 써버리기 + 내장 객체 사용
// 그래도 이 방법으로는 쓰지는 말자..
for(int i = 1; i <= 10; i++) {
	out.print("<p>" + i + "</p>");
}
%>
</body>
</html>