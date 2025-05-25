<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pageNav" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메시지 보기</title>
</head>
<body>
<div class="container">
	<c:if test="${param.accept==1}">
		<h3>받은메세지 보기</h3>
			<div class="card">
				<div class="card-header">
					<div class="media border p-3">
						<img src="${vo.senderPhoto }" class="mr-3 mt-3 rounded-circle" style="width: 60px;">
						<div class="media-body">
								${vo.senderName }<small><i>(${vo.senderId })</i></small>
							<p>보낸날짜 : ${vo.sendDate } / 받은날짜 : ${(empty vo.acceptDate)?"읽지 않음":vo.acceptDate}</p>
						</div>
            <!--end of media-body-->
					</div>
          <!--end of media border p-3-->
				</div>
        <!--end of card-header-->

				<div class="card-body">
          <pre>${vo.content }</pre>
        </div>

        <div class="card-footer">
          <a href="/message/writeForm.do" class="btn btn-primary">답장</a>
          <a href="/message/delete.do" class="btn btn-danger">삭제</a>
          <a href="/message/list.do?${pageObject.pageQuery }&mode=${param.mode}" class="btn btn-success">리스트</a>
        </div>
          <!--end of card-footer-->
			</div>
      <!--end of card-->
		</c:if>
		
		
		<c:if test="${param.accept!=1}">
		<h3>받은메세지 보기</h3>
			<div class="card">
				<div class="card-header">
					<div class="media border p-3">
						<img src="${vo.accepterPhoto }" class="mr-3 mt-3 rounded-circle" style="width: 60px;">
						<div class="media-body">
								${vo.accepterName }<small><i>(${vo.accepterId })</i></small>
							<p>받은날짜 :  ${(empty vo.acceptDate)?"읽지 않음":vo.acceptDate} / 보낸날짜 : ${vo.sendDate }</p>
						</div>
            <!--end of media-body-->
					</div>
          <!--end of card-header-->
				</div>

        <!--end of media border p-3-->
				<div class="card-body">
          <pre>${vo.content }</pre>
        </div>

				<div class="card-footer">
  				<c:if test="${empty vo.accepteDate }">
  				<!-- 메시지를 상배당이읽지 않은 경우에만 삭제가 된다 -->
  					<a href="/message/delete.do" class="btn btn-danger">삭제</a>
  				</c:if>
				  <a href="/message/list.do?${pageObject.pageQuery }&mode=${param.mode}" class="btn btn-success">리스트</a>
				</div>
        <!--end of card-footer-->
			</div>
      <!--end of card-->
		</c:if>
	</div>
  <!--end of container-->
</body>
</html>
