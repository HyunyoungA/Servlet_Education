<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>에러 처리 페이지입니다 !</h1>
	<%= exception %>
	<%= exception.getClass().getName() %><br>
	<%= exception.getMessage() %><%--보내는 메세지가 없어서 NullPointerExceptionnull --%>
</body>
</html>