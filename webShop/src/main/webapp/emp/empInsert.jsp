<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
// errorPage="errorPage.jsp"위의 page에 이거 추가하면 내가 만든 에러 페이지로 이동, 이거 배면 web.xml에서 매핑한 페이지로 이동
// 나는 자바의 주석
// 자바 코드 작성 -> service의 코드에 삽입된다.
String subject = "JSP코드";

// int age = Integer.parseInt(request.getParameter("age"));
%>
<%!
// 자바 코드 작성, 선언부! -> 서블릿 클래스 멤버로 변환
int score = 100;
public int add(int a, int b) {
	return a + b;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 정보 등록</title>
<%@ include file="../common/commonfiles.jsp" %>
</head>
<body>
	<div>
	<%@ include file="../common/header.jsp" %>
		<hr>
		<h1>직원정보 입력</h1>
		<%-- 나는 JSP의 주석 --%>
		<!-- 나는 HTML의 주석 -->
		<!-- service의 out.write에 들어간다. -->
		subject: <%=subject %> <br>
		score: <%=score %> <br>
		add(100, 200): <%=add(100, 200) %>  <br>
		
		<%-- age: <%=age %> --%>
		
		<hr>
		
		<form action="<%=request.getContextPath() %>/emp/empinsert.do" class="mb-3" method="post"> 
		<!-- 
		직원등록 페이지로 이동하는 데 이미 get 방식을 사용함 (index.jsp)
		따라서 하는 역할이 다르기 때문에 방법을 다르게 servlet에게 가는 방법은 post로 변경! 
		-->
			<table>
				<tr class="form-floating">
					<td><label for="employee_id">직원번호</label></td>
					<td><input id="employee_id" type="number" name="employee_id" placeholder="직원 번호는 시퀀스가 알아서~" value="999" readonly></td>
				</tr>
				<tr>
					<td>firstName</td>
					<td><input type="text" name="first_name" maxlength="20"></td>
				</tr>
				<tr>
					<td>LastName</td>
					<td><input type="text" name="last_name" required="required"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" required="required"></td>
				</tr>
				<tr>
					<td>phone</td>
					<td><input type="tel" name="phone_number"
						value="010-7896-8963" pattern="010-[0-9]{4}-[0-9]{4}"></td>
				</tr>
				<tr>
					<td>salary</td>
					<td><input type="number" name="salary"></td>
				</tr>
				<tr>
					<td>부서</td>
					<td><input type="number" name="department_id" value="60"></td>
				</tr>
				<tr>
					<td>메니져</td>
					<td><input type="number" name="manager_id" value="100"></td>
				</tr>
				<tr>
					<td>커미션</td>
					<td><input type="text" name="commission_pct" value="0.2"></td>
				</tr>
				<tr>
					<td>입사일</td>
					<td><input type="date" name="hire_date" value="2021-01-10"
						required="required"></td>
				</tr>
				<tr>
					<td>직급</td>
					<td><input type="text" name="job_id" required="required"
						value="IT_PROG"></td>
				</tr>
				<tr style="text-align: center;">
					<td colspan="2"><input type="submit" value="직원등록"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>