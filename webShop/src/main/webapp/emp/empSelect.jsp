<%@page import="com.shinhan.vo.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// object이기 때문에 받을 때 형변환 필요
// 이제 getAttribute를 해야하기 때문에 무조건 servlet을 먼저 실행해야 함~
List<EmpVO> emplist = (List<EmpVO>) request.getAttribute("empAll"); // 지금은 안배워서 자바를 쓰지만 나중에는 이것도 지울거야!
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
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
		location.href = "empDelete.do?empid=" + $(this).attr("data-del");
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
		<h1>직원목록</h1>
		<div>현재 로그인중: '${loginUser.manager_name}'님</div>
		<hr>
		<button onclick="location.href='empinsert.do'" type="button" class="btn btn-outline-success">직원등록(버튼, 상대)</button>
		<a type="button" class="btn btn-outline-success" href="<%=request.getContextPath() %>/emp/empinsert.do">직원등록(a태그, 절대)</a>
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
		<hr>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>직원번호</th>
					<th>이름</th>
					<th>성</th>
					<th>이메일</th>
					<th>전화번호</th>
					<th>입사일</th>
					<th>직책</th>
					<th>급여</th>
					<th>커미션</th>
					<th>매니저</th>
					<th>부서</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
				for (EmpVO emp : emplist) {
				%>
				<tr>
					<td><a href="empdetail.do?empid=<%=emp.getEmployee_id()%>"><%=emp.getEmployee_id()%></a></td>
					<td><a href="empdetail.do?empid=<%=emp.getEmployee_id()%>"><%=emp.getFirst_name()%></a></td>
					<td><%=emp.getLast_name()%></td>
					<td><%=emp.getEmail()%></td>
					<td><%=emp.getPhone_number()%></td>
					<td><%=emp.getHire_date()%></td>
					<td><%=emp.getJob_id()%></td>
					<td><%=emp.getSalary()%></td>
					<td><%=emp.getCommission_pct()%></td>
					<td><%=emp.getManager_id()%></td>
					<td><%=emp.getDepartment_id()%></td>
					<!-- 삭제할 방법이 일단 두 가지가 있음! 속성으로 empid 보내주기 or inline으로 함수에 아이디 보내주기 -->
					<td><button class="btnDel" data-del="<%=emp.getEmployee_id()%>">삭제(속성)</button></td>
					<td><button class="btnDel2" data-del="<%=emp.getEmployee_id()%>">삭제(화살표)</button></td>
					<%-- <td><button class="btnDel2" onclick="call(<%=emp.getEmployee_id()%>)">삭제(inline)</button></td> --%>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>