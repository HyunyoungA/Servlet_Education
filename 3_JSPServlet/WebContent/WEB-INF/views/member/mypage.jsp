<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member member = (Member)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.outer{
		width: 48%; height: 450px; background-color: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left: auto; margin-right: auto; margin-top: 5%;
	}
	#myForm td {text-align: center;}
	#myForm>table{margin: auto;}
	#updateBtn {background: #D1B2FF; color: white;}
	#updatePwdBtn {background: #FFD8D8; color: white;}
	#deleteBtn {background: #D5D5D5; color: white;}
	#goMain {background: #B2CCFF; color: white;}
</style>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
		<br>
		<h2 align="center">내 정보 보기</h2>
		
		<form action="<%= request.getContextPath() %>/updateForm.me" method="post" id="myForm" name="myForm">
			<table>
				<tr>
					<td width="200px">아이디</td>
					<td width="200px">
						<%= member.getUserId() %>
						<input type="hidden" maxlength="13" name="myId" required value=<%= member.getUserId() %>>
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
						<%= member.getUserName() %>
						<input type="hidden" name="myName" required value="<%= member.getUserName() %>">
					</td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td>
						<%= member.getNickName() %>
						<input type="hidden" maxlength="15" name="myNickName" required value="<%= member.getNickName() %>"></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>
						<%= member.getPhone() == null ? "-" : member.getPhone() %>
						<input type="hidden" name="myPhone" value="<%= member.getPhone() == null ? "-" : member.getPhone() %>">
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<%= member.getEmail() == null ? "-" : member.getEmail() %>
						<input type="hidden" name="myEmail" value="<%= member.getEmail() == null ? "-" : member.getEmail() %>">
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<%= member.getAddress() == null ? "-" : member.getAddress() %>
						<input type="hidden" name="myAddress" value="<%= member.getAddress() == null ? "-" : member.getAddress() %>">
					</td>
				</tr>
				<tr>
					<td>관심분야</td>
					<td>
						<%= member.getInterest() == null ? "-" : member.getInterest() %>
						<input type="hidden" name="myInterest" value="<%= member.getInterest() == null ? "-" : member.getInterest() %>">
					</td>
				</tr>
			</table>
			
			<br>
			
			<div class="myPageBtns" align="center">
				<input id="updateBtn" type="submit" value="수정하기">
				<input id="updatePwdBtn" type="button" value="비밀번호 변경 하기" onclick="location.href='updatePwdForm.me'">
				<input id="deleteBtn" type="button" value="탈퇴하기" onclick="deleteMember();">
				<input type="button" id="goMain" onclick="goMain();" value="메인으로">
			</div>
		</form>
	</div>
	
	<script>
		function deleteMember(){
			// 정말 삭제할거냐고 물어본 후, 삭제하겠다고 하면 delete.me로 요청
			var bool = confirm('정말 탈퇴하시겠습니까?');
			if(bool){
				location.href='<%= request.getContextPath() %>/delete.me';
					//또는
<%-- 				$('#myForm').attr('action', '<%= request.getContextPath() %>/delete.me'); --%>
// 				$('#myForm').submit();
				// 아무 방볍으로 해도 괜찮음 다만 위처럼 sttr로 진행하면 action이 바뀌어져 있는 상태이기 때문에
				// 수정하기를 눌러도 delete.me로 넘어감(주의!)
				
			}
			
		}
	</script>
</body>
</html>