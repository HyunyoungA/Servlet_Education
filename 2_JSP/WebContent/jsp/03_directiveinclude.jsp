<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	오늘 날씨가 정말 좋네요!<br>
	오늘 날짜는 <%@ include file="today.jsp" %> 입니다.
	<%
		//String today= "최고의 날씨";//include file로 코드를 통채로 가져와서 삽입했기때문에 변수명이 겹치면 안된다.
	%>
</body>
</html>