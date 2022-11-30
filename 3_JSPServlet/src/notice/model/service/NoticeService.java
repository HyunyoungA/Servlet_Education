package notice.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;

public class NoticeService {

	public ArrayList<Notice> selectList() {
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDAO().selectList(conn);
		
		close(conn);
		
		return list;
	}

	public int insertNotice(Notice n) {
		Connection conn = getConnection();
		
		int result = new NoticeDAO().insertNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Notice selectNotice(int no) {
		Connection conn = getConnection();
		
		//조회수 업데이트
		int result = new NoticeDAO().updateCount(conn, no);
		//공지사항 상세보기
		Notice notice = null;
		if(result > 0) {
			notice = new NoticeDAO().selectNotice(conn, no);
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return notice;
	}

	public int updateNotice(Notice n) {
		Connection conn = getConnection();
		
		int result = new NoticeDAO().updateNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteNotice(int no) {
		Connection conn = getConnection();
		
		int result = new NoticeDAO().deleteNotice(conn, no);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	

}
