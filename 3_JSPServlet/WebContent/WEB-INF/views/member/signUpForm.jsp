<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
			width: 48%; height: 450px; background-color: rgba(255, 255, 255, 0.4); border: 5px solid white;
			margin-left: auto; margin-right: auto; margin-top: 5%;
		}
		#idCheck, #nickCheck, #emailCheck{border-radius: 15px; color: white; background: #FFD8D8;}
		#joinForm td {text-align: right;}
		#joinForm tr:nth-child(1) > td:nth-child(3),
			#joinForm tr:nth-child(5) > td:nth-child(3){text-align: left;}
		.signUpBtns{text-align: center;}
		.signUpBtns input {background: #D1B2FF; color: white;}
		.signUpBtns input+input {background: #B2CCFF; color: white;}
		td>.must{color: red; font-weight: bold;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
		
	<div class="outer">
		<br>
		<h2 align="center">회원가입</h2>
		
		<form action="<%= request.getContextPath() %>/insert.me" method="post" id="joinForm" name="joinForm" onsubmit="return insertValidate();">
			<table>
				<tr>
					<td width="200px"><label class="must">*</label> 아이디</td>
					<td><input type="text" maxlength="13" name="joinUserId" required id="joinUserId"></td>
<!-- 					<td width="200px"><input type="button" id="idCheck" value="중복확인"></td> -->
					<td width="200px"><label id="idResult"></label></td>
				</tr>
				<tr>
					<td><label class="must">*</label> 비밀번호</td>
					<td><input type="password" maxlength="13" name="joinUserPwd" required></td>
				</tr>
				<tr>
					<td><label class="must">*</label> 비밀번호 확인</td>
					<td><input type="password" maxlength="13" name="joinUserPwd2" required></td>
					<td><label id="pwdResult"></label></td>
				</tr>
				<tr>
					<td><label class="must">*</label> 이름</td>
					<td><input type="text" name="userName" required></td>
				</tr>
				<tr>
					<td><label class="must">*</label> 닉네임</td>
					<td><input type="text" maxlength="15" name="nickName" required></td>
					<td width="200px"><input type="button" id="nickCheck" value="중복확인"></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>
						<input type="tel" maxlength="11" name="phone" placeholder="(-없이)01012345678">
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email"></td>
					<td><input type="button" value="이메일 확인" id="emailCheck"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address"></td>
					<td></td>
				</tr>
				<tr>
					<td>관심분야</td>
					<td>
						<input type="checkbox" id="sports" name="interest" value="운동">
						<label for="sports">운동</label>
						<input type="checkbox" id="climbing" name="interest" value="등산">
						<label for="climbing">등산</label>
						<input type="checkbox" id="fishing" name="interest" value="낚시">
						<label for="fishing">낚시</label>
						<input type="checkbox" id="cooking" name="interest" value="요리">
						<label for="cooking">요리</label>
						<input type="checkbox" id="game" name="interest" value="게임">
						<label for="game">게임</label>
						<input type="checkbox" id="etc" name="interest" value="기타">
						<label for="etc">기타</label>
					</td>
					<td></td>
				</tr>
			</table>
			
			<br clear="all">
			
			<div class="signUpBtns">
				<input type="submit" value="가입하기">
				<input type="button" onclick="location.href='<%= request.getContextPath() %>'" value="메인으로">
			</div>
		</form>
	</div>
	
	<script>
// 		document.getElementById('idCheck').onclick = function(){//request id~사용해도 상관없음.
// 			window.open('checkIdForm.me', 'idCheckForm', 'width=300, height=200');//창에 대한 네임값'idCheckForm'
// 		}
		
		var isUsable = false;		//id 중복 시 false, 사용 가능 시 true
		var isIdChecked = false;	//id 중복확인 했는지 여부
		
		$('#joinUserId').on('change paste keyup', function(){//바뀐다거나, 붙혀넣거나, 키보드가 쓰여진다 의  3가지의 이벤트를 다 넣어줘야한다.
			isIdChecked = false;
		});
		$('#joinUserId').change(function(){
			var userId = $('#joinUserId');
			
			if(!userId || userId.val().length < 4){
				alert('아이디는 최소 4자리 이상이어야 합니다.');
				userId.focus();
			} else{
				$.ajax({
					url: '<%= request.getContextPath() %>/checkId.me',
					type: 'post',
					data: {inputId:userId.val()},
					success: function(data){
						console.log(data);
						if(data == '0'){//자바스크립트의 특성상 프로그램에서 파싱을 어느정도해서 인지한다(정확히 ''로 구분해준다.)
							$('#idResult').text('사용 가능합니다.').css({'color':'green', 'float':'left', 'display':'inline-block'});
							isUsable = true;
							isIdChecked = true;
						} else if(data == '1'){
							$('#idResult').text('사용 불가능합니다.').css({'color':'red', 'float':'left', 'display':'inline-block'});
							userId.focus();
							isUsable = false;
							isIdChecked = false;
						}
					},
					error: function(data){
						console.log(data);
					}
				});
			}
		});
		
		function insertValidate(){
			if(isUsable && isIdChecked){
				return true;
			} else{
				alert('아이디 중복확인을 해주세요');
				return false;
			}
		}
		
		
		
		
		document.getElementById('nickCheck').onclick = function(){
			window.open('nickCheckForm.me', 'nickCheckForm', 'width=300, height=200');//창에 대한 네임'nickCheckForm'
		}
		
		$('#emailCheck').click(function(){
			var email = $('input[name=email]').val();
			console.log(email);
			location.href='<%= request.getContextPath() %>/checkEmail.me?email=' + email;
		});
		
		
	</script>
	
	
	
	
</body>
</html>