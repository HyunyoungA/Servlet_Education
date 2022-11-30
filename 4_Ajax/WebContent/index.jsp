<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
<style>
.test{width: 300px; min-height: 50px; border: 1px solid red;}
</style>
</head>
<body>
	<h1>jQuery를 이용한 Ajax구현</h1>
	<h3>1. 버튼 선택 시 전송 값 서버에 출력</h3>
	이름 : <input type="text" id="myName">
	<button id="nameBtn">이름 전송</button>
	<script>
// 		$('#nameBtn').click(function(){}
		$('#nameBtn').on('click', function(){
			var name = $('#myName').val();
			
			$.ajax({
				url: 'jQuery1.do',
				data: {sendName:name},//name(변수)사용 위에 var name을 사용하는거다
				success: function(){
					alert('통신성공');
				},
				error: function(data){
					alert('통신 실패');
					console.log(data);
				}, 
				complete: function(){
					alert('난 무조건이야');
				}
			});
		});
	</script>
	
	<br>
	
	<h3>2. 버튼 선택시 서버에서 보낸 값 사용자가 수신</h3>
	<button id="getServerTextBtn">서버에 보낸 값 확인</button>
	<p class="test" id="p1"></p>
	<script>
		$('#getServerTextBtn').click(function(){//보낼 데이터없을때
			$.ajax({
				url: 'jQuery2.do',
				success: function(data){//함수data: pw.print("서버에서 전송한 값입니다.");의 "서버에서 전송한 값입니다."를 담아오는 것이다
					console.log(data);
					$('#p1').text(data);
				}
			});
		});
	</script>
	
	<br>
	
	<h3>3. 서버로 기본형 전송 값이 있고, 결과로 문자열을 받아 처리</h3>
	<h4>두 개의 값을 더한 결과를 받아옴</h4>
	첫 번째 숫자 : <input type ="text" id="firstNum"><br>
	두 번째 숫자 : <input type ="text" id="secondNum"><br>
	<button id ="plusBtn">더하기</button>
	<p class="test" id="p2"></p>
	<script>
		//더하기 버튼을 누르면 첫 번째 숫자의 값과 두번째 숫자의 값을
		//ajax를 통해 jQuery3.do 쪽으로 전송하는 코드 작성
		$('#plusBtn').click(function(){
			var num1 = $('#firstNum').val();
			var num2 = $('#secondNum').val();
			
			$.ajax({
				url: 'jQuery3.do',
				data: {firstNum:num1, secondNum:num2},
				success: function(data){
					console.log(typeof data);//String
					console.log(Number(data) + 3);//숫자로 형변환해서 계산식을하고싶을때 이렇게 사용한다.
					$('#p2').text(data);
				},
				error: function(data){
					console.log(data);
				}
			});
		});
		
	</script>
	
	<br>
	<h3>4. Object형태의 데이터를 서버에 전송, 서버에서 데이터 처리 후 서버 console로 출력</h3>
	학생1 : <input type="text" id="student1"><br>
	학생2 : <input type="text" id="student2"><br>
	학생3 : <input type="text" id="student3"><br>
	<button id ="studentTest">결과확인</button>
	<script>
		//결과 확인 버튼을 누르면 학생1, 학생2, 학생3의 이름이 jQuery4.do 쪽으로 전송
		//전송된 학생들의 이름은 서버의 console창에 아래 예시와 같이 출력되고
		//화면에서 "전송 성공"이라는 알림창이 뜸
		//console 출력 예시 : 수업을 들을 학생은 OOO, XXX, ㅁㅁㅁ입니다.
		
		$('#studentTest').click(function(){
			var s1 = $('#student1').val();
			var s2 = $('#student2').val();
			var s3 = $('#student3').val();
			
			var ss = {student1:s1, student2:s2, student3:s3};
			
			$.ajax({
				url: 'jQuery4.do',
// 				data: {student1:s1, student2:s2, student3:s3},//키값:value
				data: ss,
				success: function(data){
					console.log(data);
					alert('전송 성공');
				},
				error: function(data){
					console.log(data);
				}
			});
		});
	
	</script>
	
	<br>
	
	<h3>5. 서버로 기본형 데이터 전송, 서버에서 객체 반환</h3>
	<h4>유저 번호 보내서 해당 유저 정보 가져오기</h4>
	유저 번호 : <input type="text" id="userNo"><br>
	<button id="getUserInfoBtn">정보 가져오기</button>
	<p class="test" id="p3"></p>
	<textarea class="test" id="textarea3" rows="5" cols="40"></textarea>
	
	<script>
		$('#getUserInfoBtn').click(function(){
			var userNo = $('#userNo').val();
			
			$.ajax({
				url: 'jQuery5.do',
				data: {userNo:userNo},
				dataType: 'json',//제이슨 데이터타입을 작성해주는것을 권장한다.
				success: function(data){//서버에서 보낸 데이터 매개변수data로 받음, data써놓고 안사용해도되니까 일단 습관적으로 써놓는다
					console.log(data);//data(object) 안에 key가 있다. key=userNation, userNo, userName 
// 					console.log(typeof data);//string 활용 어려움
					var resultStr = "";
					if(data != null){
						//1. 강건강, 대한민국
						resultStr = data.userNo + ", " + data.userName + ", " + data.userNation;
					}else{
						resultStr = "해당 회원이 없습니다.";
					}
					$('#p3').text(resultStr);
					$('#textarea3').val(resultStr);//input, textarea는 val()사용해야한다.
// 					$('#textarea3').text(resultStr);
				},
				error: function(data){
					console.log(data);
				}
			});
		});
	
	
	</script>
	
	<br>
	
	<h3>6. 서버로 기본 값 전송, 서버에서 리스트 객체 반환</h3>
	<h4>유저 번호 전송 --> 해당 유저가 있는 경우 유저 정보, 없는 경우 전체 가져오기</h4>
	유저 번호 : <input type="text" id="userNo2">
	<button id="getUserInfoBtn2">정보 가져오기</button>
	<p class="test" id = "p4"></p>
	<textarea rows="5" cols="40" class="test" id="textarea4"></textarea>
	<script>
	
		$('#getUserInfoBtn2').click(function(){
			$.ajax({
				url: 'jQuery6.do',
				data: {userNo:$('#userNo2').val()},
				success: function(data){
					console.log(data);//객체배열 , 없는 유저번호를 찍으면 객체배열
					
					//JSONObject 중첩
// 					var result = "";
// 					for(var i in data){//data:객체 i:객체의 키 (벼열이라면 인덱스)
// 						if(typeof data[i] != 'object'){//타입이 오브젝트인지 아닌지 나눠준다.//키값이 쭉 나오기때문에
// 							result = data.userNo + ", " + data.userName + ", " + data.userNation;
// 						} else{//객체의 오브젝트
// // 							result += data[i].userNo + ', ' + data[i].userName + ', ' + data[i].userNation + "<br>";//p태그 버전
// 							result += data[i].userNo + ', ' + data[i].userName + ', ' + data[i].userNation + "\n";//textarea 버전
							
// 						}//이어서 들어가니까 꼭 +=를 사용한다
// 					}
// // 					$('#p4').html(result);//br을 텍스트로 인지해서 .html로 해준다.
// 					$('#textarea4').val(result);//textarea 버전
					
					////JSONArray 사용 (ArrayList와 비슷)
					var result = "";
					for(var i in data){//i:인덱스
// 						result += data[i].userNo + ", " + data[i].userName + ", " + data[i].userNation + "<br>";//p
						result += data[i].userNo + ", " + data[i].userName + ", " + data[i].userNation + "\n";//textarea
					}					
					
					$('#p4').html(result);
					$('#textarea4').val(result);
					
				},
				error: function(data){
					console.log(data);
				}
			});
		});
	</script>
	
	<br>
	
	<h3>7. 서버로 데이터 여러 개 전송, 서버에서 리스트 객체 반환</h3>
	<h4>유저 번호 전송 --> 현재 있는 유저 정보만 모아서 출력</h4>
	유저 정보(번호,번호,번호) : <input type="text" id="userNo3">
	<button id="getUserInfoBtn3">정보 가져오기</button>
	<p class="test" id="p5"></p>
	<script>
		$('#getUserInfoBtn3').click(function(){
			
			
			$.ajax({
				url:'jQuery7.do',
				data:{userNo:$('#userNo3').val()},
				success: function(data){
					console.log(data);
					
					var result = "";
					for(i in data){
						result += data[i].userNo + ", " + data[i].userName + ", " + data[i].userNation + "<br>";
					}
					
					$('#p5').html(result);
				},
				error: function(data){
					console.log(data);
				}
			});
		});
	</script>
   
	<br>
   
	<h3>8. 서버로 데이터 여러개 전송, 서버에서 맵 형태의 객체 반환</h3>
	<h4>이하 내용은 7번 문제와 동일</h4>
	유저 정보(이름,이름,이름) : <input type="text" id="userName">
	<button id="getUserInfoBtn4">정보 가져오기</button><br><br>
	<textarea id="textarea6" class="test" cols="40" rows="5"></textarea>
	
	<h3>9. 서버 유지 정보로 표 구성하기</h3>
	<button id="userInfoBtn">유저 정보 불러오기</button>
	<table id="userInfoTable" border="1" cellpadding='0' cellspacing='0'>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>국적</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	<script>
		$('#userInfoBtn').click(function(){
			$.ajax({
				url:'jQuery9.do',
				success: function(data){
					console.log(data);
					$tableBody = $('#userInfoTable tbody');//구조적으로 분리tbody로
					//변수에 $집어넣는 이유: 제이쿼리는 객체형태로 반환됨. 자바는 inner로 가져오지만 제이쿼리는 텍스트 로 다르게 가져와서 반환값이 다르다 둘이 다른 언어이기 때문에
					//자바,제이쿼리 두개 차이가 있다.표시를 해줘야한다.이름만 보고 제이쿼리인지 자바인지 구분해줘야하기때문에
					$tableBody.html('');//리셋해서 위에 덮어씌어지는거다, 넣지않으면 클릭을 할때마다 추가되서 밑으로 이어붙혀진다,
					$.each(data, function(index, value){//인덱스
						var $tr = $('<tr>');
						var $noTd = $('<td>').text(value.userNo);
						var $nameTd = $('<td>').text(value.userName);
						var $nationTd = $('<td>').text(value.userNation);
						
						$tr.append($noTd);//append ~의 끝에 붙이다, 추가하다 
						$tr.append($nameTd);
						$tr.append($nationTd);
						
						$tableBody.append($tr);
					});
				},
				error: function(data){
					console.log(data);
				}
			});
		});
	
	
	</script>
	
	<br>
	
	<h3>10. 서버에서 List객체 반환 받아 select태그를 이용해 보여줌</h3>
	유저 이름 : <input type="text" id="selectUserName"><br>
	<button id="selectListBtn">유저 정보 불러오기</button><br>
	<select id="selectListTest"></select>
	<script>
		$('#selectListBtn').click(function(){
			$.ajax({
				url: 'jQuery10.do',
				success: function(data){
					console.log(data);
					$select = $('#selectListTest');
					$select.find('option').remove();//옵션 추가에 계속 이어서 생성되는걸 막는다
					
					for(var i in data){
						var name = data[i].userName;
						var selected = (name == $('#selectUserName').val()) ? 'selected' : '';
						
						$select.append('<option value="' + data[i].userNo + '"' + selected + '>' + name + "</option");
					}
				},
				error: function(data){
					console.log(data);
				}
			});
		});
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>