<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.model.vo.Board, board.model.vo.Reply, java.util.ArrayList" %>
<%
	Board b = (Board)request.getAttribute("board");
	ArrayList<Reply> list = (ArrayList<Reply>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		width:800px; height:500px; background: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left:auto; margin-right:auto; margin-top:50px;
	}
	.tableArea {width: 450px; height:350px; margin-left:auto; margin-right:auto; align: center;}
	table{align: center;}
	#updateBtn{background: #B2CCFF;}
	#menuBtn{background: #D1B2FF;}
	#deleteBtn{background: #D5D5D5;}
	#addReply{background: #B2CCFF;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
		
	<div class="outer">
		<br>
		<h2 align="center">게시판 상세보기</h2>
		<div class="tableArea">
			<form action="<%= request.getContextPath() %>/boardUpdateForm.bo" id="detailForm" method="post">
				<table>
					<tr>
						<th>분야</th>
						<td>
							<%= b.getCategory() %>
							<input type="hidden" name="category" value="<%= b.getCategory() %>">
						</td>
						<th>제목</th>
						<td colspan="3">
							<%= b.getBoardTitle() %>
							<input type="hidden" name="title" value="<%= b.getBoardTitle() %>">
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><%= b.getNickName() %></td>
						<th>조회수</th>
						<td><%= b.getBoardCount() %></td>
						<th>작성일</th>
						<td><%= b.getModifyDate() %></td>
					</tr>
					<tr>
						<th>내용</th>
					</tr>
					<tr>
						<td colspan="6">
							<textarea cols="60" rows="15" style="resize:none;" readonly name="content"><%= b.getBoardContent() %></textarea>
							<input type="hidden" name="bId" value="<%= b.getBoardId() %>">
						</td>
					</tr>
				</table>
				
				<div align="center">
<!-- 					글을 쓴 사람만 수정할 수 있다 -->
					<% if(b.getBoardWriter().equals(loginUser.getUserId()) && loginUser != null){ %>
						<input type="submit" id="updateBtn" value="수정">
						<input type="button" onclick="deleteBoard();" id="deleteBtn" value="삭제">
					<% } %>
					<input type="button" onclick="location.href='<%= request.getContextPath() %>/list.bo'" id="menuBtn" value="메뉴로">
				</div>
			</form>
		</div>
		<div class="replyArea">
			<div class="replyWriterArea">
				<table>
					<tr>
						<td>댓글 작성</td>
						<td><textarea row="3" cols="80" id="replyContent" style="resize:none;"></textarea></td>
						<td><button id="addReply">댓글 등록</button></td>
					</tr>
				</table>
			</div>
			<div id="replySelectArea">
				<table id="replySelectTable">
					<% if(list.isEmpty()){ %>
						<tr><td colspan='3'>댓글이 없습니다.</td></tr>
					<% } else { %>
						<% for(int i = 0; i < list.size(); i++){ %>
							<tr>
								<td width="100px"><%= list.get(i).getNickName() %></td>
								<td width="400px"><%= list.get(i).getReplyContent() %></td>
								<td width="200px"><%= list.get(i).getModifyDate() %></td>
							</tr>
						<% } %>
					<% } %>
				</table>
			</div>
		</div>
	</div>
	<script>
		function deleteBoard(){
			if(confirm('정말 삭제하시겠습니까?')){
				location.href="<%= request.getContextPath() %>/delete.bo?bId=" + <%= b.getBoardId()%>
			}
		}
		
		$(function(){
			$('#addReply').click(function(){
				var writer = '<%= loginUser.getUserId() %>';
				var bId = <%= b.getBoardId() %>;
				var content = $('#replyContent').val();
				
				$.ajax({
					url: "insertReply.bo",
					type: 'post',
					data: {writer:writer, content:content, bId:bId},
					success: function(data){
						console.log(data);
						$replyTable = $('#replySelectTable');
						$replyTable.html('');//한번 비워줘야 연속해서 댓글이 등록되지않는다.
						
						for(var i in data){//i는 배열이라 인덱스이다.
							var $tr = $('<tr>');
							var $writerTd = $('<td>').text(data[i].nickName).css('width', '100px');
							var $contentTd = $('<td>').text(data[i].replyContent).css('width', '400px');
							var $dataTd = $('<td>').text(data[i].modifyDate).css('width', '200px');
							
							$tr.append($writerTd);
							$tr.append($contentTd);
							$tr.append($dataTd);
							$replyTable.append($tr);
						}
						$('#replyContent').val('');//댓글달면 등록이되면서 내가쓴 댓글 지워지면서 등록되는 코드.
					},
					error: function(data){
						console.log(data);
					}
				});
				
			});
		})
	</script>
</body>
</html>