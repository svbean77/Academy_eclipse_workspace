<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.vo.AdminVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL(Expression Language) 연습!</h1>
<!-- Action Tag: jsp:로 시작하는 태그(JSP가 기본적으로 제공하는 태그!) -->
<!-- scope: page, request, session, application 4개의 범위가 존재 -->
<!-- EL이 내장하는 객체의 scope: pageScope, requestScope, sessionScope, applicationScope -->
<jsp:useBean id="vo1" class="com.shinhan.vo.AdminVO" scope="request"></jsp:useBean> <!-- scope이 request -> 이 페이지에서 다른 페이지로 요청이 넘어가도 사용 가능! -->
<jsp:setProperty property="email" name="vo1" value="vo1user@mail"/>
<jsp:useBean id="vo2" class="com.shinhan.vo.AdminVO" scope="page"></jsp:useBean>
<jsp:setProperty property="email" name="vo1" value="vo2user@mail"/>
<%-- <jsp:forward page="forwardTest.jsp"></jsp:forward> --%>

<jsp:useBean id="alist" class="java.util.ArrayList"></jsp:useBean>

<pre style="line-height:1.5;">
기본 연산
1. 숫자, 연산자 사용: 100 + 200 = ${100 + 200}
2. 문자 사용: \${"hello"} = ${"hello"} (-> 문자 + 숫자, 문자 + 문자는 불가능! 따로 함수를 사용해야 함!)
3-1. empty(문자열): \${empty "hello"} = ${empty "hello"}, \${empty ""} = ${empty ""}
3-2. empty(객체): \${empty vo1} = ${empty vo1}, \${empty alist} = ${empty alist}
3-3. empty(null): \${empty null} = ${empty null}
4. 비교: \${100 > 200} = ${100 > 200}
5. 숫자+문자: \${"100" + 10} = ${"100" + 10} (-> 숫자형 문자는 자동 형 변환 되어 숫자+숫자가 됨! 그냥 +로 사용하려면 숫자형 문자만 가능!)
6. 같다(eq): \${"Hello" == "Hello"} = ${"Hello" == "Hello"}, \${"Hello" eq "Hello"} = ${"Hello" eq "Hello"}
7. 나머지: \${100 % 3} = ${100 % 3}, \${100 mod 3} = ${100 mod 3}
8. 논리: \${(100 == 100) && (200 == 400)} = ${(100 == 100) && (200 == 400)}. \${(100 == 100) && (200 != 400)} = ${(100 == 100) && (200 != 400)}, \${(100 == 100) && !(200 == 400)} = ${(100 == 100) && !(200 == 400)}

내장 객체
<%String p1 = request.getParameter("param1");%>
9-1. param(EL): \${param.param1} = ${param.param1} (주소창에 ?param1=값을 넣어줘야 함!)
9-2. param(JAVA): <\%=p1 %> = <%=p1 %> (이 JAVA 코드로 작성하는 방법은 쓰지 말자! 자바 코드가 최대한 없는 것이 좋아!)
10-1. application, session, request 영역에 저장 (JAVA에서 실행)
<%
application.setAttribute("score1", 100);
session.setAttribute("score2", 200);
request.setAttribute("score3", 300);
%>
10-2. application, session, request 영역에서 읽기: \${score1} = ${score1}, \${score2} = ${score2}, \${score3} = ${score3} 
	(어디서든 가져옴, 정확히 어디서 가져오는지는 몰라, 이름이 겹치면 가까운 영역(request>session>application)이 보임!
11-1. application, session, request 영역에 저장 (JAVA에서 실행), 같은 이름!
<%
application.setAttribute("test", "application");
session.setAttribute("test", "session");
request.setAttribute("test", "request");
%>
11-2. application, session, request 영역에서 읽기: \${test} = ${test} (가장 가까운 영역이 읽힘!)
	\${applicationScope.test} = ${applicationScope.test}, \${sessionScope.test} = ${sessionScope.test}, \${requestScope.test} = ${requestScope.test}, \${pageScope.test} = ${pageScope.test} (없으니까 비어있음)
12-1. pageContext(JAVA)(Expression 문법): <\%=request.getContextPath()%> = <%=request.getContextPath() %>
12-2. pageContext(EL): \${pageContext.request.contextPath} = ${pageContext.request.contextPath}
<%
AdminVO adminVO = new AdminVO("aa@email.com", "영희", "1234");
request.setAttribute("admin", adminVO);
%> 
13. 객체의 속성 사용: \${admin} = ${admin} (JAVA의 request.getAttribute("admin");과 같은 표현!)
	\${admin.email} = ${admin.email}, \${admin.manager_name} = ${admin.manager_name}, \${admin.pass} = ${admin.pass} (JAVA의 request.getAttribute("admin").getXxx()와 같은 표현!)
<%
// 14. Collection을 위한 array
// 15. HaspMap을 위한 map
// 이 부분은 servlet으로 처리! EL 공부가 목적이기 때문에 여기서 만드는 것일 뿐!
List<AdminVO> adminList = new ArrayList<>();
adminList.add(new AdminVO("aa@email", "김철수", "1234"));
adminList.add(new AdminVO("bb@email", "김영희", "1234"));
request.setAttribute("adminList", adminList);

HashMap<String, Object> map1 = new HashMap<>();
map1.put("키위", 5);
map1.put("딸기", 15);
map1.put("peach", 25);
map1.put("admins", adminList);
request.setAttribute("fruits", map1);
%>
14. Collection: \${adminList[0]} = ${adminList[0]}, \${adminList[1]} = ${adminList[1]}
15. HashMap: \${fruits["키위"]} = ${fruits["키위"]}, \${fruits["딸기"]} = ${fruits["딸기"]}, \${fruits.peach} = ${fruits.peach} (한글은 dot 연산자 불가능.. 대괄호로 적어야 함!)
	\${fruits.admins} = ${fruits.admins} (모든 리스트에 접근)
	\${fruits.admins[0]} = ${fruits.admins[0]}, \${fruits.admins[0].email} = ${fruits.admins[0].email} (특정 리스트에 접근) 
</pre>
</body>
</html>