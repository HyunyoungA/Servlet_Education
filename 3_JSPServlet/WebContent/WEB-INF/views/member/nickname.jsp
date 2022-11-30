<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="inputValue();">
	<b>닉네임 중복 검사</b>
	<br>
	<form action="<%= request.getContextPath() %>/nickname.me" id="nicknameForm">
		<input type="text" id="inputNickname" name="inputNickname">
		<input type="submit" value="중복확인"/>
	</form>
	
	<br>
	
	<%
		Integer result = (Integer)request.getAttribute("result");//Integer 사용이유: 이미사용중인 아이디,사용가능아이디 이 문구를 숨기기위해
		if(result != null){
			if(result == 0){
	%>			
				사용 가능한 닉네임 입니다.
	<%
			}else{
	%>			
				이미 사용 중인 닉네임 입니다.
	<%			
			}
		}
	%>
	
	
	<br>
	<br>
	
	<input type="button" id="nickname" value="확인">
	<input type="button" id="cancel" value="취소" onclick="window.close();">
	
	<script>
		function inputValue(){//닉네임 중복확인
			if('<%= request.getAttribute("nicknamed")%>'=='null'){
	// 		 아무것도 없어서 null '감싸서 나오기때문에' 'null' 문자열 body->onload=
			document.getElementById('inputNickname').value = opener.document.joinForm.nickName.value;
			} else{
				document.getElementById("inputNickname").value = '<%= request.getAttribute("nicknamed") %>';
			}
		}
		
		document.getElementById('nickname').onclick=function(){
			opener.document.joinForm.nickName.value = document.getElementById('inputNickname').value;
			self.close();
		}
		
	</script>
	
	
</body>
</html>