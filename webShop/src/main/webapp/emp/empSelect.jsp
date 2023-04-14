<%-- <%@page import="com.shinhan.vo.EmpVO"%> --%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
// <%@page 페이지 지시자 % >
// object이기 때문에 받을 때 형변환 필요
// 이제 getAttribute를 해야하기 때문에 무조건 servlet을 먼저 실행해야 함~
// List<EmpVO> emplist = (List<EmpVO>) request.getAttribute("empAll"); // 지금은 안배워서 자바를 쓰지만 나중에는 이것도 지울거야! -> JSTL 사용
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/commonfiles.jsp" %>
<!-- include는 컴파일 시(컴파일 시 저 파일과 내 파일을 합쳐야 하니까), path 변수는 실행 시 생성 -> 컴파일 시에는 변수가 존재하지 않기 때문에 path 변수 사용 불가능! -->
<%-- <jsp:include page="${path}/common/commonfiles.jsp"></jsp:include> 따로 컴파일해서 들어가기 때문에 path 변수를 사용할 수 없음!
이거를 HTML 주석 처리하면 JSP는 실행되기 때문에 에러 발생! 주석 처리할 때 웬만하면 Ctrl + Shift + /로 자동 주석처리 하자~
--%>
<script>
$(function () {
	$("thead tr th").click(function(e){
		var trNum = $(this).closest("th").prevAll().length; 
		var a = $("tbody tr").each(function(index, item){ 
			var col = $(item).find("td:nth-child(" + (trNum+1) + ")");
			console.log(col);
			$(item).find("td").css("background-color", "white");
			$(col).css("background-color", "orange");
		});
	});
	$("#btn1").click(function () {
		$("tr > td:nth-child(2):contains('S')").css("color", "red");
	});
	$("#btn2").click(function () {
		$("tbody tr:even").css("background", "pink");
		$("tbody tr:odd").css("background", "white");
	});
	$("#btn3").click(function() {
		var selector = "tr > td:nth-child(8)";
		
		$(selector).each(function(idx, item){
			var sal = parseInt($(item).html());
			if(sal >= 5000) {
				$(item).css("background-color", "lightblue");
			}
		}); 
	});
	$("#btn4").click(function(){
		var arr = $("tr>td:nth-child(1)");
			$.each(arr, function(index, item){
			console.log($(item).text());
			if(parseInt($(item).text())%2==1){
			$(item).parent().css("background-color", "lightgreen");
			}
		});
	});
	$("#select").change(function () {
		var jobid = $(this).val();
		
		$("tr td").css("color", "black");
		$("tr td:contains('" + jobid + "')").css("color", "red");
	});
	var str = "";
	var arr = ["IT_PROG", "PU_CLERK", "AD_VP", "FI_ACCOUNT", "FI_MGR", "ST_MAN"];
	$.each(arr, function (idx, item) {
		str += "<option>" + item + "</option>";
	});
	$("#jobs").html(str);

	$("#select").change(function () {
		var selector = "tr > td:nth-child(7)";
		
		$(selector).each(function (idx, item) {
			var sel = $("#select").val();
			if(sel == $(item).text()) {
				$(item).css("background-color", "pink");
			}		
			else {
				$(item).css("background-color", "white");
			}
		});
	});
	
	
});
</script>
<script>
$(function () {
	$(".btnDel").on("click", function () {
		location.href = "${path}/emp/empDelete.do?empid=" + $(this).attr("data-del");
	});
	$(".btnDel2").on("click", () => {
		var str = $(this).attr("data-del")
		str += " -- 화살표는 this가 없음!"
		alert(str);
	});
	
	
	function call () {}
});

</script>
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<div id="container" class="container mt-3">
		<!-- include 디렉티브는 소스 파일을 합친 후 컴파일함! header에서 선언된 변수를 여기서 사용 가능! -->
		<%-- <%@ include file="../common/header.jsp" %> <!-- include 지시자: 합쳐서 컴파일!!!! -->
		<h2><%=company %></h2> <!-- include 파일을 합쳐서 컴파일 하기 때문에 header에서 사용한 변수를 그대로 사용할 수 있다! --> --%>
		<jsp:include page="../common/header.jsp"></jsp:include> <!-- include 액션 태그: 컴파일 후 합치기!!!!! -->
		<h1>직원목록</h1>
		<hr>
		<button onclick="location.href='empinsert.do'" type="button" class="btn btn-outline-success">직원등록(버튼, 상대)</button>
		<a type="button" class="btn btn-outline-success" href="${path}/emp/empinsert.do">직원등록(a태그, 절대)</a>
		<button id="btn1">이름에 S 들어가는 직원</button>
		<button id="btn2">짝수번째 직원</button>
		<button id="btn3">급여가 5000 이상인 직원</button>
		<button id="btn4">직원번호 홀수인 직원</button>
		
		<select id="select">
			<option>AD_PRES</option>
			<option>IT_PROG</option>
			<option>AD_VP</option>
			<option>FI_MGR</option>
			<option>ST_MAN</option>
			<option>PU_CLERK</option>
		</select>
		
		<select id="jobs">
		</select>
		<!-- day037 파일 다운로드 -->
		 <form method="post"  action="${path }/downloadTest/result.jsp" >
		 	<input type=hidden  name="param1" value="fox1.jpg" /> <br>
		 	<input type=hidden  name="param2" value="fantasy.jpg" /> <br>
 	  		<input type ="submit" value="day037 이미지 다운로드">	 
		 </form> 
		 <!-- day037 모달 -->
		 <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">직원등록(modal)</button>
		 <%@ include file="empInsertModal.jsp" %>
		<hr>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>순서</th>
					<th>직원번호</th>
					<th>이름</th>
					<th>성</th>
					<th>이메일</th>
					<th>sub이메일</th>
					<th>이메일 @앞 아이디</th>
					<th>전화번호</th>
					<th>입사일</th>
					<th>직책</th>
					<th>급여</th>
					<th>누적급여</th>
					<th>커미션</th>
					<th>매니저</th>
					<th>부서</th>
					<th>삭제</th>
					<th>X</th>
				</tr>
			</thead>
			<tbody>
			<c:set var="totalSalary" value="0"/>
			<c:forEach items="${empAll}" var="emp" varStatus="status">
			<c:set var="totalSalary" value="${totalSalary + emp.salary}"/>
				<%-- <tr style="background-color:${status.first ? 'LavenderBlush' : status.last ? 'LemonChiffon' : 'LightGray'}"> 내 풀이: 3항 두 번--%>
				<tr style="background-color:${status.first || status.last ? 'LemonChiffon' : 'LightGray'}"> <!-- 선생님 풀이 -->
					<td>${status.count}</td>
					<td><a href="${path}/emp/empdetail.do?empid=${emp.employee_id}">${emp.employee_id }</a></td>
					<td><a href="${path}/emp/empdetail.do?empid=${emp.employee_id}">${emp.first_name}</a></td>
					<td style="color:${fn:length(emp.last_name) > 5 ? 'red' : 'blue'}">${emp.last_name}</td>
					<td>${emp.email}</td>
					<td>${fn:substring(emp.email, 0, 3)}</td>
					<%-- 
					<c:set value="${fn:indexOf(emp.email, '@') }" var="idx"/>
					<td>${idx == -1 ? emp.email : fn:substring(emp.email, 0, idx)}</td> 
					내 방법--%>
					<td>${fn:substring(emp.email, 0, fn:indexOf(emp.email, "@"))}</td> <!-- 유진언니 방법 -->
					<td>${emp.phone_number}</td>
					<td><fmt:formatDate value="${emp.hire_date}" pattern="yyyy/MM/dd"/></td>
					<td>${emp.job_id}</td>
					<td><fmt:formatNumber value="${emp.salary}" groupingUsed="true"></fmt:formatNumber></td>
					<td>${totalSalary}</td>
					<td>${emp.commission_pct}: <fmt:formatNumber value="${emp.commission_pct}" type="percent"></fmt:formatNumber></td>
					<td>${emp.manager_id}</td>
					<td>${emp.department_id}</td>
					<!-- 삭제할 방법이 일단 두 가지가 있음! 속성으로 empid 보내주기 or inline으로 함수에 아이디 보내주기 -->
					<td><button class="btnDel" data-del="${emp.employee_id}">삭제(속성)</button></td>
					<td><button class="btnDel2" data-del="${emp.employee_id}">삭제(화살표)</button></td>
					<%-- <td><button class="btnDel2" onclick="call(<%=emp.getEmployee_id()%>)">삭제(inline)</button></td> --%>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>