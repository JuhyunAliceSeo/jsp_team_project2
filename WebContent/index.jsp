<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomeShopping</title>
<style>
        section>h1 {
            text-align: center;
            max-width: 800px;
            margin: 0 auto;
        }
    </style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
</head>
<body class="d-flex vw-100 vh-100 flex-column justify-content-between">
	<header>
		<!-- 네비게이션 바 -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="index.jsp">쇼핑몰 회원관리 ver1.0</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="regMember.jsp">회원등록</a></li>
						<li class="nav-item"><a class="nav-link" href="listViewMember.do">회원목록조회/수정</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="salesView.do">회원매출조회</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="index.jsp">홈으로</a></li>
					</ul>
					<form class="d-flex">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-light" type="submit">Search</button>
					</form>
				</div>
			</div>
		</nav>
	</header>
		
	<body>

      <section>
      <h1>쇼핑몰 회원관리 프로그램</h1><br><br>
		쇼핑몰 회원정보와 회원매출정보 데이터베이스를 구축하고 회원관리 프로그램을 작성하는 프로그램이다.<br>
		프로그램 작성 순서<br>
		1.회원정보 테이블을 생성한다.<br>
		2.매출정보 테이블을 생성한다.<br>
		3.회원정보, 매출정보 테이블에 제시된 문제지의 참조데이터를 추가 생성한다.<br>
		4.회원정보 입력 화면프로그램을 작성한다.<br>
		5.회원정보 조회 프로그램을 작성한다.<br>
		6.회원매출정보 조회 프로그램을 작성한다.<br>
      </section>
      
      <footer class="align-bottom p-4" >
            <p>ⓒ AliceSeo 2023</p>
    </footer>
</body>
</html>

