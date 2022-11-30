<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>숫자 데이터 : formatNumber</h3>
	<fmt:formatNumber value="123456789"/><br>
	<fmt:formatNumber value="123456789" groupingUsed="false"/><br>
	<!-- groupingUsed="false" 자릿수 구분없이 진행 안넣으면 기본이 true이다. -->
	<fmt:formatNumber value="1.234567"/><br>
	<!-- 반올림되서나옴 -->
	<fmt:formatNumber value="1.234567" pattern="#.##"/><br>
	<!-- pattern="#.##" 원하는 포맷설정 소수2번째수까지 나오고 +반올림된다 -->
	<fmt:formatNumber value="1.234567" pattern="#.00"/><br>
	<fmt:formatNumber value="1.2" pattern="#.##"/><br>
	<fmt:formatNumber value="1.2" pattern="#.00"/><br>
	<!-- #.##은 소수점 2째자리가 비어있으면 안나오고, #.00은 0이 채워져서 나온다. -->
	<fmt:formatNumber value="0.12" type="percent"/><br>
	<fmt:formatNumber value="123456789" type="currency"/><br>
	<!--type="percent"=12% // type="currency"=￦123,456,789 -->
	<fmt:formatNumber value="123456789" type="currency" currencySymbol="$"/><br>
	<!-- currencySymbol="$" 형식변경 -->
	<fmt:setLocale value="ko_kr"/>
	<!-- 형식이 잘 안나올때 설정 -->
</body>
</html>