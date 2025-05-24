<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pageNav" tagdir="/WEB-INF/tags" %>
<div class="card">
  <div class="card-header">
  	<span class="btn btn-primary float-right" id="replyWriteBtn">등록</span>
  	<h3>댓글 리스트</h3>
  </div>
  <div class="card-body">
  	<c:if test="${ empty replyList }">
  		데이터가 존재하지 않습니다.
  	</c:if>
  	<c:if test="${ !empty replyList }">
  	<!-- 데이터가 있는 만큼 반복 처리 시작 -->
  		<c:forEach items="${replyList }" var="replyVO">
		  <div class="card replyDataRow" data-rno="${replyVO.rno }"
		   style="margin: 5px 0;">
			  <div class="card-header">
			  	<span class="float-right">${replyVO.writeDate }</span>

			  	<b class="replyWriter">${replyVO.writer }</b>
			  </div>
			  <div class="card-body">
			  	<pre class="replyContent">${replyVO.content }</pre>
			  </div>
			  <div class="card-footer">
			  	<button class="btn btn-success replyUpdateBtn">수정</button>
			  	<button class="btn btn-danger replyDeleteBtn">삭제</button>
			  </div>
			</div>
		</c:forEach>
  	<!-- 데이터가 있는 만큼 반복 처리 끝 -->
  	</c:if>
  </div>
  <div class="card-footer">
  	<pageNav:replayPageNav 
  		listURI="view.do" pageObject="${replyPageObject }" query="&inc=0"/>
  </div>
</div>
