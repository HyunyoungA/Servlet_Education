<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>입력한 두 개의 수 사이의 값들을 더한 누적 값 구하기</h2>
	<form action="01_2_sumCalc.jsp" method="post">
		첫 번째 수 : <input type="text" name="firstNum"><br>
		두 번째 수 : <input type="text" name="secondNum"><br>
		<button>계산하기</button><!-- form태그 안에 있는 버튼은 자동으로 submit역할을해서 따로 적어주지 않아도됨 -->
	</form>
</body>
</html>