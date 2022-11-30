package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/myPage.me")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션의 로그인한 아이디를 통해 얻을 수 있다
//		HttpSession session = request.getSession();
//		Member member = (Member)session.getAttribute("loginUser");
//		String loginUserId = member.getUserId();
		String loginUserId =((Member)(request.getSession().getAttribute("loginUser"))).getUserId();
	
		Member member = new MemberService().selectMember(loginUserId);
		
		String page = null;
		if(member != null) {
			page = "WEB-INF/views/member/mypage.jsp";
			request.setAttribute("member", member);
		} else {//에러페이지 생성
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "회원 조회에 실패했습니다");
		}
		//둘다 포워드를 사용하면 둘다 보낼 데이터가 있어서 둘다 request.getRequestDispatcher 사용해야되서 if, else에 둘다 들어가야되서
		//밖으로 빼줘서 둘다 들어갈 수 있게 해준다
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
