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
	<h1>jst1 core라이브러리</h1>
	<p>
		사용할 태그 라이브러리 선언: taglib지시자 사용<br>
		prefix : 앞첨자, 다른 태그와 구분할 수 있는 namespace제공<br>
		uri : 실제 웹상의 주소가 아니라 해당 라이브러리를 나타내는 식별자
	</p>
	<h2>core set태그: 변수 선언</h2>
	<c:set var="no1" value="${ param.num1 }"/><!-- taglib prefix="c"라고 선언해줬기때문에 가능 c:set은 변수를 만들어준다-->
	<c:set var="no2" value="${ param.num2 }"/>
	
	<c:set var="result" value="${ no1 * no2 }"/>
	<p>${ no1 } * ${ no2 } = ${result }</p>
	
	<hr>
	
	<h2>core remove태그</h2>
	<c:set var="result" value="9999" scope="request"/><!-- 스코프 지정안하면 page이기 때문에 9999가 뜨고 스코프를 지정하면 위에 결과값으로 나온다 -->
	삭제 전 result : ${ result }<br>
	삭제 후 requestScope.result : ${ requestScope.result }<br>
	
	<br>
	
<%-- 	<c:remove var="result"/><!-- 모든 스코프 삭제-스코프 지정하지않아서 --> --%>
	<c:remove var="result" scope="page"/><!-- 지정 스코프에서만 삭제 -->
	삭제 후 result : ${ result }<br>
	삭제 후 requestScope.result : ${ requestScope.result }<br>
</body>
</html>