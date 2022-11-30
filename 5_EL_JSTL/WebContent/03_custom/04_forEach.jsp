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
	<!-- 1부터 6까지 반복, 반복 변수 i -->
	<c:forEach begin="1" end="6" var="i">
		<h${ i }>반복문 ${ i }<h${ i }>
	</c:forEach>
	<!-- 1부터 6까지 반복, 2단계씩뛰기 -->
	<c:forEach begin="1" end="6" var="i" step="2">
		<h${ i }>반복문 ${ i }<h${ i }>
	</c:forEach>
	<!-- 6부터 1까지 반복 -->
	<c:forEach begin="1" end="6" var="i">
		<h${ 7-i }>반복문 ${ 7-i }<h${ 7-i }>
	</c:forEach>
	
	<hr><hr>
	
	<%
		String[] nameArr = {"신형만", "봉미선", "신짱구", "신짱아"};
		request.setAttribute("family", nameArr);
	%>
	<ol>
		<c:forEach items="${ family }" var="f">
			<li>${ f }</li>
		</c:forEach>
	</ol>
	
	<hr>
	<!-- 알파벳 변수에 배열넣기 -->
	<c:set var="alphabet">
		A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z
	</c:set>
	<!-- 알파벳을 아이템즈에 담은 후 변수 a로 설정해서 출력한다 -->
	<c:forEach items="${ alphabet }" var="a" varStatus="vs">
<%-- 		<% if vs. %3 = =0 %> --%>
		${ a }<br>
		vs.first : ${ vs.first }<br>
		vs.last : ${ vs.last }<br>
		vs.index : ${ vs.index }<br>
		vs.count : ${ vs.count }<br>
		vs.current : ${ vs.current }<br>
	</c:forEach>
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>