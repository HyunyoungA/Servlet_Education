<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--JSP 주석 --%>
	<%
		int total = 0;
		for(int i = 1; i <= 10; i++){
	%>
	<%--for문을 끊어서 사용 가능 --%>
	이렇게하면 어떻게될까나?<%--for문안에 있기 때문에 "이렇게하면 어떻게될까나?" 10번 출력됨 --%>
	<%
			total += i;
		}
	%>
	
	1부터 10까지의 합은<%= total %>입니다.<br>
	1부터 10까지의 합은<% out.print(total); %> 입니다.<%--자바코드 들어갈때 세미콜론 넣어줘야됨.안넣어주면 500에러뜸 --%>
	
	
	
	
	
</body>
</html>