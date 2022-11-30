package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class InsertMemberServlet
 */
//@WebServlet("/insert.me")//urlPatterns(default)패턴만 지정해서 클래스에 대한 지정이 안되어있다.
@WebServlet(urlPatterns="/insert.me", name="InsertMemberServlet")//속성이 2개면 지정해줘야한다.
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");//인코딩처리 한글깨지기 때문에
		String userId = request.getParameter("joinUserId");
		String userPwd = request.getParameter("joinUserPwd");
		System.out.println(userPwd);
		String userName = request.getParameter("userName");
		String nickName = request.getParameter("nickName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String[] iArr = request.getParameterValues("interest");
		String interest = "";//String반환이기 때문에 담아준다.
		if(iArr != null) {
			for(int i = 0; i < iArr.length; i++) {
				if(i == iArr.length -1) {
					interest += iArr[i];
				}else {
					interest += iArr[i] + ", ";
				}
			}
		}
		Member member = new Member(userId, userPwd, userName, nickName, phone, email, address, interest, null, null, null);
		int result = new MemberService().insertMember(member);//insert, update등 디비에 대한 반환값은 int, 회원정보에 대한 로직을 다르게 짤 수도 있어서 최종적으로 받아오는 값이 무조건 int는 아니다.
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath());//메인으로가면되기때문에 url상관없다. 보낼 데이터도 없다. 회원가입에 성공했다는 메세지를 보내고싶으면 forward(데이터 보내고싶을때)
		} else {//실패하면 에러메세지보내기
			request.setAttribute("msg", "회원가입에 실패하였습니다.");
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
