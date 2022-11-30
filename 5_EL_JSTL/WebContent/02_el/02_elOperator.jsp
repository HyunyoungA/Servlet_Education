<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="action.model.vo.Person, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String str1 = "안녕";
		String str2 = new String("안녕");
		
		int big = 10;
		int small = 3;
		
		Person p1 = new Person("강건강", '남', 20);
		Person p2 = new Person("강건강", '남', 20);
		
		pageContext.setAttribute("str1", str1);
		pageContext.setAttribute("str2", str1);
		pageContext.setAttribute("big", big);
		pageContext.setAttribute("small", small);
		pageContext.setAttribute("p1", p1);
		pageContext.setAttribute("p2", p1);
		
		ArrayList<String> list = new ArrayList<>();
		list.add(str1);
		pageContext.setAttribute("list", list);
		
		ArrayList<String> list2 = new ArrayList<>();
		pageContext.setAttribute("list2", list2);
		
		ArrayList<String> list3 = null;
		pageContext.setAttribute("list3", list3);
	%>
	
	<h3>산술연산</h3>
	10 * 7 = ${ 10 * 7 }<br>
	100 / 3 = ${ 100 / 3 } = ${ 100 div 3 }<br>
	15 % 4 = ${ 15 % 4 } = ${ 15 mod 4 }<br>
	
	<hr>
	
	<h3>비교연산</h3>
	스크립트 : <%= str1 == str2 %> / <%= str1 != str2 %><%--주소값 비교이기때문에  --%>
	el: ${ str1 == str2 } 또는 ${ str1 eq str2 }
		/ ${ str1 != str2 } 또는 ${ str1 ne str2 }<br>
	big > small : ${big > small } 또는 ${big gt small }<br>
	big < small : ${big < small } 또는 ${big lt small }<br>
	big >= small : ${big >= small } 또는 ${big ge small }<br>
	big <= small : ${big <= small } 또는 ${ big le small }<br>
	
	<br>
	
	p1 == p2 : <%= p1 == p2 %> / ${ p1 == p2 } 또는 ${ p1 eq p2 }<br>
	
	<br>
	
	<h3>객체가 비어있는지 null인지 체크 null이면 true</h3>
	${empty list }<br>
	${empty list2 }<br>
	${empty list3 }
	
	<br>
	
	<h3>논리연산자/부정연산자</h3>
	${ true and true }, ${ true && true }<br>
	${ true or false }, ${ true || false }<br>
	${ !true }, ${ not true }
	
	
	
	
	
	
</body>
</html>