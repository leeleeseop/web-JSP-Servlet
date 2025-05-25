<!-- 2024 07 16 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문/답변 보기</title>
</head>
<body>
<div class= container>
	<h3>질문/답변 보기</h3>
	<div class="card">
		<div class="card-header">
			<span class="float-rigth">${vo.name }</span>
			${vo.title }
		</div>
		
		<div class="card-body">${vo.content }</div>
		
		<div class="card-footer">
			<span class="float-rigth">${vo.writeDate }</span>
			${vo.name }
		</div>
	</div>

  <!-- 자기가 답변할 수 없다 -->
  <c:if test="${!empty login && vo.id != login.id && vo.levNo <3 }"> 
    <a href="answerForm.do?no=${vo.no }&perPageNum=${param.perPageNum}" class="btn btn-primary">답변하기</a>
	</c:if>
	  <a href="list.do?${pageObject.pageQuery }" class="btn btn-success">리스트</a>
</div>
</body>
</html>
