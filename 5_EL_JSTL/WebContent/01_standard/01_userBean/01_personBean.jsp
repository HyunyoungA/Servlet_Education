<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP표준액션 태그 중 userBean을 사용하여 VO클래스 객체 정보 불러오기</h2>
<%-- 	<jsp:useBean id="person1" class="action.model.vo.Person"/></jsp:useBean><!-- page scope --> --%>
	<jsp:useBean id="person1" class="action.model.vo.Person" scope="request"/><!-- request scope로 scope지정해서 사용할 수 있다. -->
<%-- 	<% action.model.vo.Person person1 = new action.model.vo.Person(); %>같은 공간에 같은걸 만들어서 빨간줄이생김 --%>
	<!-- 기본생성자를 통해서 객체를 만들고있어서 model.vo안에 Person(){}기본생성자가 없으면 에러가 난다. -->
	<!-- 해당 스코프에서, 해당 클래스 타입으로 paer1이 존재하면 해당 객체를 가지고오고 없으면 새로 생성한다. -->
	<%= person1 %><!-- toString값이 나온다. -->
	
	<br>
	<!--참조해 올 변수명 property="CDATA" /참조할 객체명 name= "IDREF" -->
	이름 : <jsp:getProperty property="name" name="person1"/><br><%-- <%= person1.getName() / getName의 name부분이 property="name"으로 들어간다. 게터의이름이 property안에 들어간다.  %> --%>
	성별 : <jsp:getProperty property="gender" name="person1"/><br><!-- getAge -> getage로 소문자로 바꾸면 에러난다. -->
	나이 : <jsp:getProperty property="nai" name="person1"/><br>
	
	<br><hr><br>
	
	<h2>JSP표준액션 태그 중 useBean을 사용하여 VO클래스에 데이터 초기화하기</h2>
	<jsp:useBean id="person2" class="action.model.vo.Person"></jsp:useBean>
	<jsp:setProperty property="name" name="person2" value="강건강"/>
	<jsp:setProperty property="gender" name="person2" value="남"/>
	<jsp:setProperty property="nai" name="person2" value="20"/>
	
	이름 : <jsp:getProperty property="name" name="person2"/><br><%-- <%= person1.getName() / getName의 name부분이 property="name"으로 들어간다. 게터의이름이 property안에 들어간다.  %> --%>
	성별 : <jsp:getProperty property="gender" name="person2"/><br><!-- getAge -> getage로 소문자로 바꾸면 에러난다. -->
	나이 : <jsp:getProperty property="nai" name="person2"/><br>
	
	
	
</body>
</html>