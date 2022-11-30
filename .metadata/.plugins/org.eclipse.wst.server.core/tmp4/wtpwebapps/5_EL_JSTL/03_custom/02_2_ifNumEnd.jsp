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
	<c:if test="${ Integer.parseInt(param.num1) > Integer.parseInt(param.num2) }"><!--param은 문자열로 넘어와서 숫자형식으로 바꿔줘야한다.-->
		${ param.num1 } 숫자는 ${ param.num2 } 숫자보다 크다
	</c:if><!-- test에 조건식을 넣음 /true면 문이열리고 false면 if문 실행막음-->
	<c:if test="${ Integer.parseInt(param.num2) > Integer.parseInt(param.num1) }"><!--param은 문자열로 넘어와서 문자열로 인지한다 마지막 문자10->1,0 0으로 비교 -->
		${ param.num2 } 숫자는 ${ param.num1 } 숫자보다 크다
	</c:if>
	<c:if test="${ param.num1 == param.num2 }"><!-- 문자열비교지만 똑같기때문에 문자열로 바꾸지않음 정확히하려면 하긴해야됨. -->
		${ param.num1 } 숫자는 ${ param.num2 } 숫자와 같다
	</c:if>
</body>
</html>