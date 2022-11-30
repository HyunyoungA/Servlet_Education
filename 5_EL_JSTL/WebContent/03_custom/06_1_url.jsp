<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="06_2_urlEnd.jsp?pname=귀걸이&pcount=2&option=알러지X&option=큐빅추가">쿼리스트링</a>
	
	<br>
	<!--연결할 url을 value에 담고 담은 url을 변수 u에 담아 밑에 a태그에서 가져와 사용 -->
	<c:url value="06_2_urlEnd.jsp" var="u">
		<c:param name="pname" value="귀걸이"/>
		<c:param name="pcount"value="2"/>
		<c:param name="option" value="알러지X"/>
		<c:param name="option" value="큐빅추가"/>
	</c:url>
	<a href="${ u }">jstl:url</a>
</body>
</html>