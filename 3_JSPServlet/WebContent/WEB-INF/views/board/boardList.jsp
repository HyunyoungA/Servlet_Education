<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, board.model.vo.*"%>
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.outer{
		width: 800px; height: 500px; background: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left: auto; margin-right: auto; margin-top: 50px;
	}
	#listArea{text-align: center;}
	.tableArea{width:650px;	height:350px; margin-left:auto;	margin-right:auto;}
	th{border-bottom: 1px solid grey;}
	.pagingArea button{border-radius: 15px; background: #D5D5D5;}
	.buttonArea{margin-right: 50px;}
	.buttonArea button{background: #D1B2FF; border-radius: 5px; color: white; width: 80px; heigth: 25px; text-align: center;}
	button:hover{cursor: pointer;}
	#numBtn{background: #B2CCFF;}
	#choosen{background: #FFD8D8;}
	#listArea{margin: auto;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">게시판</h2>
		<div class="tableArea">
			<table id="listArea">
				<tr>
					<th width="100px">글번호</th>
					<th width="100px">카테고리</th>
					<th width="300px">글제목</th>
					<th width="100px">작성자</th>
					<th width="100px">조회수</th>
					<th width="150px">작성일</th>
				</tr>
				<% if(list.isEmpty()){ %>
				<tr>
					<td colspan="6">조회된 리스트가 없습니다.</td>
				</tr>
				<% } else{ %>
					<% for(Board b : list){ %>
					<tr>
						<td><%= b.getBoardId() %></td>
						<td><%= b.getCategory() %></td>
						<td><%= b.getBoardTitle() %></td>
						<td><%= b.getNickName() %></td>
						<td><%= b.getBoardCount() %></td>
						<td><%= b.getModifyDate() %></td>
					</tr>
					<% } %>
				<% } %>
			</table>
		</div>
		<!-- 페이징 -->
		<div class="pagingArea" align="center">
			<!-- 맨 처음으로 -->
			<button onclick="location.href='<%= request.getContextPath()%>/list.bo?currentPage=1'">&lt;&lt;</button>
			<!-- 이전 페이지로 -->
			<button onclick="location.href='<%= request.getContextPath()%>/list.bo?currentPage=<%= pi.getCurrentPage()-1 %>'"id="beforeBtn">&lt;</button>
			<script>
				if(<%= pi.getCurrentPage() %> <= 1){
					$('#beforeBtn').prop('disabled', true);
				}
			</script>
			<!-- 숫자 페이지로 -->
			<% for(int p = pi.getStartPage(); p <= pi.getEndPage(); p++){ %>
				<% if(p == pi.getCurrentPage()){ %>
					<button  id="choosen" disabled><%= p %></button>
				<% } else { %>
					<button id="numBtn" onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= p %>'"><%= p %></button>
				<% } %>
			<% } %>
			<!-- 다음 페이지로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= pi.getCurrentPage()+1 %>'" id="afterBtn">&gt;</button>
			<script>
				if(<%= pi.getCurrentPage() %> >= <%= pi.getMaxPage() %>){
					$('#afterBtn').prop('disabled', true);
				}
			</script>
			
			<!-- 맨 마지막으로 -->
			<button onclick="location.href='<%=request.getContextPath()%>/list.bo?currentPage=<%=pi.getMaxPage()%>'">&gt;&gt;</button>
		</div>
		<div class="buttonArea" align="right">
			<% if(loginUser != null){ %>
				<button onclick="location.href='<%= request.getContextPath()%>/writeBoardFrom.bo'">작성하기</button>
			<% } %>
		</div>
	</div>
	
	<script>
		$(function(){//게시글 상세보기
			$('#listArea td').mouseenter(function(){
				$(this).parent().css({'background':'darkgray', 'cursor':'pointer'});
			}).mouseout(function(){
				$(this).parent().css('background','none');
			}).click(function(){
				var bId = $(this).parent().children().eq(0).text();
				
// 				로그인이 되어있으면 진행하고 아니면 알림창띄어서 회원만 이용할 수 있는 서비스라고 나오게 한다.
// 				null값이 아니라 null이라는 값이 들어간다.(글자 null) ->로그인할 때 'null'이라고 안하면 if문에 로그인유저 했을때의 toString이 들어가게된다
<%-- 				'<%= loginUser%>' -> String으로 인지한다 ''을 꼭 넣어준다 --%>
// 				''을 감싸지않고 null로 하면 알림창이 뜨지않고 서버로 넘어가게 된다. 그렇게 때문에 꼭 ''로 감싸서 String으로 만들어줘서 비교가 잘 이루어질 수 있게 한다
				if('<%= loginUser%>' != 'null'){
					location.href = '<%= request.getContextPath() %>/detail.bo?bId=' + bId;
				} else {
					alert('회원만 이용할 수 있는 서비스입니다.');
				}
			});
		})
	</script>
</body>
</html>