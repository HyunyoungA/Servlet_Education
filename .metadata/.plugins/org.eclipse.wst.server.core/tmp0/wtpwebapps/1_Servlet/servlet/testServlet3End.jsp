<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%//데이터 받아올 공간 html에 자바코드를 받아오는것
	String name = (String)request.getAttribute("name");
	String age = (String)request.getAttribute("age");
	String city = (String)request.getAttribute("city");
	String height = (String)request.getAttribute("height");
	String gender = (String)request.getAttribute("gender");
	String food = (String)request.getAttribute("foods");
	String recommendation = (String)request.getAttribute("recommendation");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h2{color: red;}
	span{font-weight: bold;}
	.name{color: orange;}
	.gender{color: yellow; background: black;}
	.age{color: green;}
	.city{color: blue;}
	.height{color: navy;}
	.food{color: purple;}
</style>
</head>
<body>
		<h2>개인 취향 테스트 결과</h2><!-- 원하는 형식으로 보이지 않음, 전달받은 데이터를 받아와야됨. -->
		<span class='name'><%= name %></span>님은
		<span class='age'><%= age %></span>이시며,
		<span class='city'><%= city %></span>에 사는
		키<span class='height'><%= height %></span>cm인
		<span class='gender'><%=gender %></span>입니다.
		좋아하는 음식은 <span class='food'><%= food %></span>입니다.
		
		<hr>
		
		<h3><%= age %>에 맞는 선물 추천</h3>
		'<%= recommendation %>' 선물은 어떠신가요?
</body>
</html>