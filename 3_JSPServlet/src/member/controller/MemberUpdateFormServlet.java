package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateFormServlet
 */
@WebServlet("/updateForm.me")
public class MemberUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String myId = request.getParameter("myId");
		String myName = request.getParameter("myName");
		String myNickName = request.getParameter("myNickName");
		//데이터가 없었다면 "-"로 넘어올 것
		String myPhone = request.getParameter("myPhone");
		String myEmail = request.getParameter("myEmail");
		String myAddress = request.getParameter("myAddress");
		String myInterest = request.getParameter("myInterest");
		
		Member myInfo = new Member(myId, null, myName, myNickName, myPhone, myEmail, myAddress, myInterest, null, null, null);
		System.out.println("Servlet myInfo : " + myInfo);
		request.setAttribute("myInfo", myInfo);
		
//		member.setUserId(myId);
//		member.setUserId(myName);
//		member.setUserId(myNickName);
//		member.setUserId(myPhone);
//		member.setUserId(myEmail);
//		member.setUserId(myAddress);
//		member.setUserId(myInterest);
	
		request.getRequestDispatcher("WEB-INF/views/member/memberUpdateForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
