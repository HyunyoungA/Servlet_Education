<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>
	<h2>JSP액션태그 중 useBean의 param속성 이용하기</h2>
	<jsp:useBean id="person" class="action.model.vo.Person">
		<!-- person.param으로 넘어온값을 param을 사용 parameter=name값 param="name"name이라는 name값을 셋팅  -->
		<!-- property="gender" param="gender" 값이 같으면 param은 안적어도 된다 알아서 매칭해준다-->
<%-- 		<jsp:setProperty property="name" name="person" ></jsp:setProperty> --%>
<%-- 		<jsp:setProperty property="gender" name="person"></jsp:setProperty> --%>
<%-- 		<jsp:setProperty property="nai" name="person"></jsp:setProperty> --%>
		
<!-- 		*를 이용하여 전체를 불러오고 파라미터명과 세터명이 같을 때만 자동매칭되서 사용할 수 있다 -->
		<jsp:setProperty property="*" name="person"></jsp:setProperty>
	</jsp:useBean>
	
	이름 : <jsp:getProperty property="name" name="person"/><br><%-- <%= person1.getName() / getName의 name부분이 property="name"으로 들어간다. 게터의이름이 property안에 들어간다.  %> --%>
	성별 : <jsp:getProperty property="gender" name="person"/><br><!-- getAge -> getage로 소문자로 바꾸면 에러난다. -->
	나이 : <jsp:getProperty property="nai" name="person"/><br>
	
</body>
</html>