package board.model.sevice;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDAO;
import board.model.vo.Attachment;
import board.model.vo.Board;
import board.model.vo.PageInfo;
import board.model.vo.Reply;

public class BoardService {

	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new BoardDAO().getListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Board> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Board> list = new BoardDAO().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public Board selectBoard(int bId) {
		Connection conn = getConnection();
		
		//카운드도 진행되기 때문에 업데이트 카운트를 먼저 지정해준다.
		int result = new BoardDAO().updateCount(conn, bId);
		Board board = null;
		if(result > 0) {
			board = new BoardDAO().selectBoard(conn, bId);
			if(board != null) {//result가 1보다 크고 보드가 null값이 아닐때 커밋
				commit(conn);
			} else {
				rollback(conn);
			}
		} else {
			rollback(conn);
		}
		
		close(conn);
		return board;
	}

	public int updateBoard(Board board) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().updateBoard(conn, board);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteBoard(int bId) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().deleteBoard(conn, bId);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public ArrayList selectFList(int i) {
		Connection conn = getConnection();
		
		BoardDAO dao = new BoardDAO();
		ArrayList list = null;
		if(i == 1) {//게시글 리스트일때
			list = dao.selectBList(conn);
		} else {//파일 리스트 가져오기
			list = dao.selectFList(conn);
		}
		close(conn);
		
		return list;
	}

	public int insertFile(Board b, ArrayList<Attachment> fileList) {
		Connection conn = getConnection();
		
		BoardDAO dao = new BoardDAO();
		
		int result1 = dao.insertBoard(conn, b);
		int result2 = dao.insertFile(conn, fileList);
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result1 + result2;
	}

	public int insertBoard(Board b) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().insertBoard(conn, b);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ArrayList<Attachment> selectFiles(int bId) {
		Connection conn = getConnection();
		
		ArrayList<Attachment> list = new BoardDAO().selectFiles(conn, bId);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Reply> selectReplyList(int bId) {
		Connection conn = getConnection();
		
		ArrayList<Reply> list = new BoardDAO().selectReplyList(conn, bId);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Reply> insertReply(Reply r) {
		Connection conn = getConnection();
		
		BoardDAO dao = new BoardDAO();
		
		int result = dao.insertReply(conn, r);
		ArrayList<Reply> list = null;
		if(result > 0) {
			commit(conn);
			list = dao.selectReplyList(conn, r.getRefBoardId());
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return list;
	}
	
}
