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
 * Servlet implementation class updateServlet
 */
@WebServlet("/update.me")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//인코딩 방식을 설정을 해주지 않았기 때문에 한글이 깨졌고 그래서 최대 범위를 넘은 것이다.
		
		String myId = request.getParameter("myId");
		String myName = request.getParameter("myName");
		String myNickName = request.getParameter("myNickName");
		String myPhone = request.getParameter("myPhone");
		String myEmail = request.getParameter("myEmail");
		String myAddress = request.getParameter("myAddress");
		String[] Arr = request.getParameterValues("myInterest");
		String interest = "";
		if(Arr != null) {
			for(int i = 0; i < Arr.length; i++) {
				if(i == 0) {
					interest += Arr[i];
				} else {
					interest += ", " + Arr[i];
				}
			}
		
		}
		Member newInfo = new Member(myId, null, myName, myNickName, myPhone, myEmail, myAddress, interest, null, null, null);
		int result = new MemberService().update(newInfo);
		
		if(result > 0) {
			//내 정보 보기 쪽으로 넘어가면 되는데, 이때 내 정보 보기 url을 이용해서 넘어갈 것
			response.sendRedirect("myPage.me");
		} else {
			request.setAttribute("msg", "회원 정보 수정에 실패하였습니다.");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
//		request.getRequestDispatcher("newInfo", newInfo);
//		request.getRequestDispatcher("WEB-INF/views/member/memberUpdateForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
