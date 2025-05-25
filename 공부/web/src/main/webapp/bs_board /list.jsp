<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 게시판 리스트</title>
<!-- 1. Bootstrap 4 + jquery 3.7 라이브러리 등록 CDN -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- 아이콘 라이브러리 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style type="text/css">
.dataRow:hover {
	background: #ddd;
	cursor: pointer;
}
</style>

<script type="text/javascript">
	$(function() {

		// 2. jquery 확인
		console.log("jquery loading..... --------------- ");

	});
</script>
</head>
<body>
	<!-- 3. body 부분의 소스를 채운다. w3schools.com 사이 소스 참소. -->
	<div class="container">
		<h2 class="text-success">
			<i class="fa fa-list" ></i> <a class="navbar-brand" href="#">일반 게시판 리스트
		</h2>
		<form action="list.jsp>">
			<div class="row">
				<div class="col-md-8">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<select name="key" id="key" class="form-control">
								<option value="t">제목</option>
								<option value="c">내용</option>
								<option value="s">작성자</option>
								<option value="tc">제목/내용</option>
								<option value="tw">제목/작성자</option>
								<option value="cw">내용/작성자</option>
								<option value="tcw">모두</option>
							</select>
						</div>
						<input type="text" class="form-control" placeholder="검색" id="word" name="word">
						<div class="input-group-append">
							<button class="btn btn-outline-primary">검색</button>
						</div>
					</div>
				</div>
				<!-- col-md-8의 끝 : 검색 -->
				<div class="col-md-4">
				<!-- 너비를 조정하기 위한 div 추가 -->
				<!-- float-rigth:  오른쪽으로 정렬 -->
				 <div style="width: 200px;"class="float-right">
					<div class="input-group mb-3 ">
						<div class="input-group-prepend">
							<span class="input-group-text">Row/page</span>
						</div>
						<select id="parPageNum" name="parpageNum" class="form-control">
							<option>10</option>
							<option>15</option>
							<option>20</option>
							<option>25</option>
						</select>
					</div>
				 </div>
				</div>
				<!-- col-md-4의 끝 : 검색 -->
			</div>
		</form>
		<table class="table">
			<!-- tr : table row - 테이블 한줄 -->
			<!-- 게시판 데이터의 제목 -->
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<!-- 실제적인 데이터 표시 : 데이터가 있는 만큼 줄(tr)이 생긴다. -->
			<!-- JS로 글보기로 페이지 이동
			onclick : click 이벤트 핸들러 속성 -->
			<tr onclick="location='view.jsp';" class="dataRow">
				<!-- td : table data - 테이블 데이터 텍스트 -->
				<td>2</td>
				<td>저도유</td>
				<td>에옹</td>
				<td>2024.06.12</td>
				<td>12</td>
			</tr>
			<tr onclick="location='view.jsp';" class="dataRow">
				<td>1</td>
				<td>배고파요</td>
				<td>이이섭</td>
				<td>2024.06.12</td>
				<td>13</td>
			</tr>
			<tr>
				<td colspan="5">
					<!-- a tag : 데이터를 클릭하면 href의 정보를 가져와서 페이지 이동시킨다. --> <a href="writeForm.jsp" class="btn btn-primary">등록</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
