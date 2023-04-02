<%@page import="java.util.List"%>
<%@page import="com.shinhan.vo.EmpVO"%>
<%@page import="com.shinhan.model.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
EmpService eService = new EmpService();
List<EmpVO> emplist = eService.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- day25? bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- day28 jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script>
	$(function () {
		// 선생님
		$("thead tr th").click(function(e){
			var trNum = $(this).closest("th").prevAll().length; // 내가 클릭한 게 전체 th 중 몇 번째 th인가
			//$(this).find(" ~ th").css("background-color", "white");
			//$(this).css("background-color", "orange");
			var a = $("tbody tr").each(function(index, item){ // tr을 배열로 둠
				var col = $(item).find("td:nth-child(" + (trNum+1) + ")");
				console.log(col);
				$(item).find("td").css("background-color", "white");
				$(col).css("background-color", "orange");
			});
			console.log(a);
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
				var sal = parseInt($(item).html()) + 1;
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
		
		// 나
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
<title>Insert title here</title>
<style>
/* 
내가 만들어본 스타일! 부트스트랩 사용으로 잠시 안녕~
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);

* {
	font-family: 'Jeju Gothic', sans-serif;
	margin: 0px;
	padding: 0px;
}

#container {
	width: 1100px;
	margin: 20px auto;
	text-align: center;
}

table {
	margin: 5px auto;
}

tr, td {
	padding: 5px;
}

thead tr {
	background-color: rgb(221, 250, 182);
}

th {
	padding: 5px 5px;
}

tbody tr:nth-child(even) {
	background-color: rgba(221, 250, 182, 0.5);
}

h1 {
	margin: 20px 0px;
} 
*/
</style>
</head>
<body>
	<div id="container" class="container mt-3">
		<h1>직원목록</h1>
		<!-- day24 -->
		<button onclick="location.href='emp_insert.html'" type="button" class="btn btn-outline-success">직원등록(버튼)</button>
		<a type="button" class="btn btn-outline-success" href="emp_insert.html">직원등록(a태그)</a>
		<!-- day28 jQuery -->
		<button id="btn1">이름에 S 들어가는 직원</button>
		<button id="btn2">짝수번째 직원</button>
		<button id="btn3">급여가 5000 이상인 직원</button>
		<button id="btn4">직원번호 홀수인 직원</button>
		<button id="btn5">q</button>
		
		<select id="select">
			<option selected>AD_PRES</option>
			<option>IT_PROG</option>
			<option>AD_VP</option>
			<option>FI_MGR</option>
		</select>
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
				</tr>
			</thead>
			<tbody>
				<!-- 여러 직원의 정보를 출력하기 위해 for문을 돌아야 함! 해석은 WAS가 해준다~~ -->
				<%
				for (EmpVO emp : emplist) {
				%>
				<tr>
					<td id="emp_id"><%=emp.getEmployee_id()%></td>
					<td><%=emp.getFirst_name()%></td>
					<td><%=emp.getLast_name()%></td>
					<td><%=emp.getEmail()%></td>
					<td><%=emp.getPhone_number()%></td>
					<td><%=emp.getHire_date()%></td>
					<td><%=emp.getJob_id()%></td>
					<td><%=emp.getSalary()%></td>
					<td><%=emp.getCommission_pct()%></td>
					<td><%=emp.getManager_id()%></td>
					<td><%=emp.getDepartment_id()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>