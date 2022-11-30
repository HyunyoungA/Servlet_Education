package member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static common.JDBCTemplate.close;
import member.model.vo.Member;

public class MemberDAO {
	//바로 프로퍼티즈 연결
	
	private Properties prop = new Properties();
	
	public MemberDAO() {
		
		String fileName = MemberDAO.class.getResource("/sql/member/member-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public Member loginMember(Connection conn, Member member) {//로그인
		PreparedStatement pstmt = null;
		Member loginUser = null;
		ResultSet rset= null;
		String query = prop.getProperty("loginUser");
		try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1,member.getUserId());
				pstmt.setString(2,member.getUserPwd());
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					loginUser = new Member(rset.getString("USER_ID"),
										   rset.getString("USER_PWD"),
										   rset.getString("USER_NAME"),
										   rset.getString("NICKNAME"),
										   rset.getString("PHONE"),
										   rset.getString("EMAIL"),
										   rset.getString("ADDRESS"),
										   rset.getString("INTEREST"),
										   rset.getDate("ENROLL_DATE"),
										   rset.getDate("MODIFY_DATE"),
										   rset.getString("STATUS"));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return loginUser;
	}

	public int insertMember(Connection conn, Member member) {//회원가입
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getNickName());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getAddress());
			pstmt.setString(8, member.getInterest());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int checkId(Connection conn, String inputId) {//아이디 중복
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("checkId");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);//1개의 컬럼이기 때문에 (1)
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int nickname(Connection conn, String inputNickname) {//닉네임 중복
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("nickname");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputNickname);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public Member selectMember(Connection conn, String loginUserId) {//내정보 보기
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		
		String query = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, loginUserId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				member = new Member(rset.getString("USER_ID"),
						   			rset.getString("USER_PWD"),
						   			rset.getString("USER_NAME"),
						   			rset.getString("NICKNAME"),
						   			rset.getString("PHONE"),
						   			rset.getString("EMAIL"),
						   			rset.getString("ADDRESS"),
						   			rset.getString("INTEREST"),
						   			rset.getDate("ENROLL_DATE"),
						   			rset.getDate("MODIFY_DATE"),
						   			rset.getString("STATUS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}

	public int update(Connection conn, Member newInfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("update");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newInfo.getUserName());
			pstmt.setString(2, newInfo.getNickName());
			pstmt.setString(3, newInfo.getPhone());
			pstmt.setString(4, newInfo.getEmail());
			pstmt.setString(5, newInfo.getAddress());
			pstmt.setString(6, newInfo.getInterest());
			pstmt.setString(7, newInfo.getUserId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updatePwd(Connection conn, String userId, String userPwd, String newPwd) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updatePwd");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPwd);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
