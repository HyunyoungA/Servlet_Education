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
	EL에서 문자열 비교시 == 연산자로 내용 비교 가능하다.
	
	<br><br>
	
	<b>== 비교</b>
	<c:if test="${ param.str1 == param.str2 }">
		'${ param.str1 }' 문자와 '${ param.str2 }' 문자는 같습니다.
	</c:if>
	<c:if test="${ param.str1 != param.str2 }">
		'${ param.str1 }' 문자와 '${ param.str2 }' 문자는 같지 않습니다.
	</c:if>
	
	<br><br>
	
	<b>eq 비교</b><br>
	<c:if test="${ param.str1 eq param.str2 }">
		'${ param.str1 }' 문자와 '${ param.str2 }' 문자는 같습니다.
	</c:if>
	<c:if test="${ param.str1 ne param.str2 }">
		'${ param.str1 }' 문자와 '${ param.str2 }' 문자는 같지 않습니다.
	</c:if>
	
	<br><br>
	
	<b>equals 비교</b><br>
	<c:if test="${ param.str1.equals(param.str2) }">
		'${ param.str1 }' 문자와 '${ param.str2 }' 문자는 같습니다.
	</c:if>
	<c:if test="${ !param.str1.equals(param.str2) }">
		'${ param.str1 }' 문자와 '${ param.str2 }' 문자는 같지 않습니다.
	</c:if>
	
	
	
	
	
	
	
</body>
</html>