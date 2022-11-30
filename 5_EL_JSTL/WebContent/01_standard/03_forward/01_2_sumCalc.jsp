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
		int first = Integer.parseInt(request.getParameter("firstNum"));
		int second = Integer.parseInt(request.getParameter("secondNum"));
		
		int result = 0;
		for(int i = first; i <= second; i++){
			result += i;
		}
		
		request.setAttribute("result", result);
	%>
	
	<jsp:forward page="01_3_sumView.jsp"></jsp:forward>
<!-- 	forward() : request/response객체 유지
		jsp:forward하는건 똑같은데 url이 그대로 유지된 상태로 전달!! 
		한번 request요청만 된다. 한번더 요청하려면 request에 담아야한다-->
</body>
</html>