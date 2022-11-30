<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align: center;">
	<h3>신간 소개</h3>
		도서 명 : 점심은 무엇을 먹는 게 좋을까?<br>
		저자 명 : 박춘희<br>
		페이지 수 : 100페이지<br>
		가격 : 15,000원<br>
		
		<hr>
		
		<%@ include file="01_1_bookCopyRight.jsp" %>
		
		<hr>
		
		<jsp:include page="01_1_bookCopyRight.jsp"></jsp:include>
	</div>
</body>
</html>