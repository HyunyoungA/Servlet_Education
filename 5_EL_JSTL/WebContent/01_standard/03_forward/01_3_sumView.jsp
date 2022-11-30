<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String num1 = request.getParameter("firstNum");
		String num2 = request.getParameter("secondNum");
		int result = (int)request.getAttribute("result");
		
	%>
	<%= num1 %>부터<%= num2 %>까지의 합은? <span style="color:pink;"><%= result %></span>
</body>
</html>