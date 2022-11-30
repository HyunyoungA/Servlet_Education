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
	<c:choose>
		<c:when test="${ Integer.parseInt(param.num) % 5 == 0 }">
			인형을 뽑았습니다.
		</c:when>
		<c:when test="${ Integer.parseInt(param.num) % 5 == 1 }">
			물티슈를 뽑았습니다.
		</c:when>
		<c:when test="${ Integer.parseInt(param.num) % 5 == 2 }">
			열쇠고리를 뽑았습니다.
		</c:when>
		<c:otherwise>
			꽝입니다.
		</c:otherwise>
	</c:choose>
	<!-- when: 각 case역할 -->
	<!-- defalut -->
</body>
</html>