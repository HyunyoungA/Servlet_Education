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
	<c:set var="family" value="신형만, 봉미선, 신짱구, 신짱아"/>
	<ul>
		<c:forEach var="f" items="${ family }">
			<li>${ f }</li>
		</c:forEach>
	</ul>
	
	<ul>
		<c:forTokens var="f" items="${ family }" delims=", ">
			<li>${ f }</li>
		</c:forTokens>
	</ul>
	
	<c:set var="family2" value="신형만,봉미선/신짱구-신짱아 고길동,둘리/도우너.희동이-또치 마이콜"/>
	<ul>
		<c:forEach var="f" items="${ family2 }">
			<li>${ f }</li>
		</c:forEach>
	</ul>
	
	<ul>
		<c:forTokens var="f" items="${ family2 }" delims=", /-.">
			<li>${ f }</li>
		</c:forTokens>
	</ul>
	
	<!-- split같은 delims=", " 잘라준다. > -->
</body>
</html>