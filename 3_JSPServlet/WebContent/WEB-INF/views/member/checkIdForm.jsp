<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="inputValue();">
	<b>아이디 중복 검사</b>
	<br>
	<form action="<%= request.getContextPath() %>/checkId.me" id="idCheckForm">
		<input type="text" id="inputId" name="inputId">
		<input type="submit" value="중복확인"/>
	</form>
	
	<br>
	
	<%
		Integer result = (Integer)request.getAttribute("result");//Integer 사용이유
		if(result != null){
			if(result == 0){
	%>			
				사용 가능한 아이디입니다.
	<%
			}else{
	%>			
				이미 사용 중인 아이디 입니다.
	<%			
			}
		}
	%>
	
	
	<br>
	<br>
	
	<input type="button" id="usedId" value="확인">
	<input type="button" id="cancel" value="취소" onclick="window.close();">
	
	<script>
		function inputValue(){//아이디 중복확인
			if('<%= request.getAttribute("checkedId")%>'=='null'){
	// 		 아무것도 없어서 null '감싸서 나오기때문에' 'null' 문자열 body->onload=
			document.getElementById('inputId').value = opener.document.joinForm.joinUserId.value;
			} else{
				document.getElementById("inputId").value = '<%= request.getAttribute("checkedId") %>';
			}
		}
		
		document.getElementById('usedId').onclick=function(){
			opener.document.joinForm.joinUserId.value = document.getElementById('inputId').value;
			self.close();
		}
		
	</script>
	
	
</body>
</html>