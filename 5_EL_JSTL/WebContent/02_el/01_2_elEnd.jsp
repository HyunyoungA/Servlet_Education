<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="action.model.vo.Person"%> --%>
<%-- 
// 	Person person = (Person)request.getAttribute("person");
// 	String baverage = (String)request.getAttribute("beverage");
// 	int year = (int)request.getAttribute("year");
// 	String[] products = (String[])request.getAttribute("products");
// 	String book = (String)request.getAttribute("book");
// 	String movie = (String)request.getAttribute("movie");
<%-- %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>.item{font-weight: bold; color: yellowgreen;}</style>
</head>
<body>
<!-- 	<h2>scriptlet을 통해 request객체에 저장된 데이터 출력</h2> -->
<%-- 	<h4>개인정보(<%= year %>)</h4> --%>
<%-- 	이름 : <%= (Person)request.getAttribute("person").getName() %><br> --%>
<%-- 	성별 : <%= (Person)request.getAttribute("person")person.getName() %><br> --%>
<%-- 	나이 : <%= (Person)request.getAttribute("person")person.getName() %><br> --%>
<!-- 	<h4>취향 정보</h4> -->
<%-- 	<%= person.getName() %>님이 가장 좋아하는 음료 : <%= baverage %><br> --%>
<%-- 	<%= person.getName() %>님이 가장 좋아하는 물건 : <%= products[0] %>, <%= products[1] %>, <%= products[2] %><br> --%>
<%-- 	<%= person.getName() %>님이 가장 좋아하는 도서 : <%= book %><br> --%>
<%-- 	<%= person.getName() %>님이 가장 좋아하는 영화 : <%= movie %><br> --%>
	<hr>

	<h2>EL의 내장객체 XXXScope를 통해 저장된 데이터 출력</h2>
	<h4>개인정보(${ requestScope.year })</h4>
	이름 : ${ requestScope.person.name }<br>
	성별 : ${ requestScope.person.gender }<br>
	나이 : ${ requestScope.person.nai }<br>
	<h4>취향 정보</h4>
	${ requestScope.person.name }님이 가장 좋아하는 음료 : ${ requestScope.baverage }<br>
	${ requestScope.person.name }님이 가장 좋아하는 물건 : ${ requestScope.products[0] }, ${ requestScope.products[1] }, ${ requestScope.products[2] }<br>
	${ requestScope.person.name }님이 가장 좋아하는 도서 : ${ sessionScope.book }<br>
	${ requestScope.person.name }님이 가장 좋아하는 영화 : ${ applicationScope.movie }<br>
	<!-- 서블릿에서 book은 세션에 담았고, movie는 application에 담아서 Scope가 다르다 -->
	
	<hr>
	
	<h2> Scope를 생략하여 저장된 데이터 출력</h2>
	
	<p>
		el내장객체 pageScope, requestScope, sessionScope, applicationScope는 생략 가능<br>
		pageScope-> requestScope -> sessionScope -> applicationScope순으로 찾음
		동일한 value가 pageScope, requestScope, sessionScope, applicationScope에 있으면
		제일처음에 나온 값이 들어가고 뒤까지 돌지않는다.
		여러 스코프에 동일한 속성을 기록해 이름 충돌(name conflict)이 의심되면 명시적으로 스코프를 지정해야한다.
	</p>
	<h4>개인정보(${ year })</h4>
	이름 : ${ person.name }<br>
	성별 : ${ person.gender }<br>
	나이 : ${ person.nai }<br>
	<h4>취향 정보</h4>
	${ person.name }님이 가장 좋아하는 음료 : ${ baverage }, ${ sessionScope.beverage }, ${ applicationScope.beverage }<br>
	${ person.name }님이 가장 좋아하는 물건 : ${ products[0] }, ${ products[1] }, ${ products[2] }<br>
	${ person.name }님이 가장 좋아하는 도서 : ${ book }<br>
	${ person.name }님이 가장 좋아하는 영화 : ${ movie }<br>
	<!-- 서블릿에서 book은 세션에 담았고, movie는 application에 담아서 Scope가 다르다 -->
	
</body>
</html>