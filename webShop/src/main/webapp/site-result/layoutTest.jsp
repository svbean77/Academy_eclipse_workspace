<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/commonfiles.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dream Jeju</title>
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
<script>
	function call () {
		$.ajax({
			// 화면 이동 없이 불러온 데이터를 원하는 위치(공지사항)에 넣었다!!!! 쉬운 방법임
			url: "jobsAjax.do",
			method: "get",
			success: function (responseData) {
				console.log(responseData);
				
				// 방법 1. JSP 새로 만들어서 찍기
				// $("#here").html(responseData);
				
				// 방법 2. JSON으로 만든 데이터 가져와 파싱해 사용
				// responseData: '{"jobList": [{}, {}, {}]}'
				var datas = JSON.parse(responseData); // 파싱 결과: {"jobList": [{}, {}, {}]} (문자열 to obj)
				var arr = datas.jobList;
				var output = '<ul>';
				$.each(arr, function (idx, item) {
					<%-- output += "<li>" + item["job_id"] + "</li>"; --%> 
					
					output+=`<li>${"${item['job_id']}"}</li>`; <%-- ${}를 사용할 때 값이기 때문에 한 번 더 ""로 감싸야 함 얘는 --%> 
				});
				output += "</ul>";
				$("#here").html(output);
				
			}, 
			error: function (message) {
				console.log(message);
			}
		});
	}
	
	function call2 () {
		$.ajax({
			url: "pictureAjax.do",
			method: "get",
			success: function (result) {
				// 방법 1. JSP 만들기
				 <%-- $("#gallery").html(result);  --%>
				
				// 방법 2. JSON 만들기
				var datas = JSON.parse(result);
				var arr = datas.adminsPicture;
				console.log(arr);
				
				var output = "<ul>";
				
				$.each(arr, function (idx, item) {
					var url = "${path}/uploads/" + item["picture"];
					output += "<li><img src='" + url + "' width='150'></li>";
					output += "<li><img src='${path}/uploads/" + item.picture + "' width='150'></li>"
					$("#quick-icon" + (idx + 1)).css("background-image", "url('"+ url + "')").css("background-size", "100%");
					$("#quick-icon" + (idx + 1) + " + p").html(item["name"]);
				});
				
				output += "</ul>"
				$("#gallery").html(output);
				
			},
			error: function (message) {
				alert(message);
			}
		});
	}
</script>
</head>
<body>
	<div id="container">
	<img src="${path}/uploads/fox1.jpg" width="150">
		<header>
			<div id="logo">
				<a href="index.html">
					<h1>Dream Jeju</h1>
				</a>
			</div>
			<nav>
				<ul id="topMenu">
					<li><a href="#">단체 여행 <span>▼</span></a>
						<ul>
							<li><a href="#">회사 연수</a></li>
							<li><a href="#">수학 여행</a></li>
						</ul></li>
					<li><a href="#">맞춤 여행 <span>▼</span></a>
						<ul>
							<li><a href="#">4.3 평화 기행</a></li>
							<li><a href="#">곶자왈 체험</a></li>
							<li><a href="#">힐링 워크샵</a></li>
						</ul></li>
					<li><a href="javascript:call2()">갤러리</a></li>
					<li><a href="javascript:call()">문의하기</a></li>
					<!-- js에서 call을 수행할거야!라는 의미 -->
				</ul>
			</nav>
		</header>
		<div id="slideShow">
			<div id="slides">
				<img src="images/photo-1.jpg" alt=""> 
				<img src="images/photo-2.jpg" alt=""> 
				<img src="images/photo-3.jpg" alt="">
				<button id="prev">&lang;</button>
				<button id="next">&rang;</button>
			</div>
		</div>
		<div id="contents">
			<div id="tabMenu">
				<input type="radio" id="tab1" name="tabs" checked> 
				<label for="tab1">공지사항</label> 
				<input type="radio" id="tab2" name="tabs">
				<label for="tab2">갤러리</label>
				<div id="notice" class="tabContent">
					<h2>공지사항 내용입니다.</h2>
					<div id="here">
						<ul>
							<li>사무실을 이전했습니다</li>
							<li>[참가 모집] 카약 체험에 초대합니다.</li>
							<li>[참가 모집] 여름 방학 기간, 오름 체험단을 모집합니다.</li>
							<li>겨울, 추천 여행지</li>
							<li>가을, 추천 여행지</li>
						</ul>
					</div>
				</div>
				<div id="gallery" class="tabContent">
					<h2>갤러리 내용입니다.</h2>
					<ul>
						<li><img src="images/img-1.jpg"></li>
						<li><img src="images/img-2.jpg"></li>
						<li><img src="images/img-3.jpg"></li>
						<li><img src="images/img-1.jpg"></li>
						<li><img src="images/img-2.jpg"></li>
						<li><img src="images/img-3.jpg"></li>
					</ul>
				</div>
			</div>
			<div id="links">
				<ul>
					<li><a href="#"> <span id="quick-icon1"></span>
							<p>평화기행</p>
					</a></li>
					<li><a href="#"> <span id="quick-icon2"></span>
							<p>힐링 워크샵</p>
					</a></li>
					<li><a href="#"> <span id="quick-icon3"></span>
							<p>문의하기</p>
					</a></li>
				</ul>
			</div>
		</div>
		<footer>
			<div id="bottomMenu">
				<ul>
					<li><a href="#">회사 소개</a></li>
					<li><a href="#">개인정보처리방침</a></li>
					<li><a href="#">여행약관</a></li>
					<li><a href="#">사이트맵</a></li>
				</ul>
				<div id="sns">
					<ul>
						<li><a href="#"><img src="images/sns-1.png"></a></li>
						<li><a href="#"><img src="images/sns-2.png"></a></li>
						<li><a href="#"><img src="images/sns-3.png"></a></li>
					</ul>
				</div>
			</div>
			<div id="company">
				<p>제주특별자치도 ***동 ***로 *** (대표전화) 123-456-7890</p>
			</div>
		</footer>
	</div>

	<script src="js/slideshow.js"></script>

</body>
</html>