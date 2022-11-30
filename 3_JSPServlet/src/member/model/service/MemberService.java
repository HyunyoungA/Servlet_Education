package member.model.service;

import static common.JDBCTemplate.*;
import java.sql.Connection;

import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {

	public Member loginMember(Member member) {//jdbc
		Connection conn = getConnection();//jdbc템플릿에서 해주기 때문에 템플릿을 만들어야한다.
		
		Member loginMember = new MemberDAO().loginMember(conn, member);
		
		close(conn);
		
		return loginMember;
	}

	public int insertMember(Member member) {
		Connection conn = getConnection();
		
		int result = new MemberDAO().insertMember(conn, member);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int checkId(String inputId) {
		Connection conn = getConnection();
		
		int result = new MemberDAO().checkId(conn, inputId);
		
		close(conn);
		
		return result;
	}

	public int nickname(String inputNickname) {
		Connection conn = getConnection();
		
		int result = new MemberDAO().nickname(conn, inputNickname);
		
		close(conn);
		
		return result;
	}

	public Member selectMember(String loginUserId) {
		Connection conn = getConnection();
		
		Member member = new MemberDAO().selectMember(conn, loginUserId);
		
		close(conn);
		
		return member;
	}

	public int update(Member newInfo) {
		Connection conn = getConnection();
		
		int member = new MemberDAO().update(conn, newInfo);
		
		if(member > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return member;
	}

	public int updatePwd(String userId, String userPwd, String newPwd) {
		Connection conn = getConnection();
		
		int result = new MemberDAO().updatePwd(conn, userId, userPwd, newPwd);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteMember(String userId) {
		Connection conn = getConnection();
		
		int result = new MemberDAO().deleteMember(conn, userId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;	
	}

}
