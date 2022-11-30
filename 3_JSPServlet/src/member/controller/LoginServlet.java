package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns="/login.me", name="LoginServlet")//Annotation으로 servlet-mapping하는 방법
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//HttpServletRequest.getParemeter(String name) VS HttpServletRequest.getAttribute(String name)
		// 반환 타입		String 											Object
		// 사용 용도		뷰에서 보낸 데이터를 가져올 때							Servlet에서 보낸 데이터 가져올 때(뷰 제외)
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");//("input태그의 name속성값")
		System.out.println(userPwd);
		Member member = new Member();
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		
		Member loginUser = new MemberService().loginMember(member);//로그인하려고, 디비에 해당 아이디 비번이 있는지 확인(반환값 생각하기)
		
		if(loginUser != null) {//로그인 성공!
			//서블릿에서 뷰로 다시 돌아가는것, 로그인 후 메인페이지로 돌아가는 기능
			//RequestDispatcher.forward()				VS 					HttpsServletResponse.sendRedirect()
			//뷰(우리한테는 인덱스)에 보낼 데이터 전송 가능(뷰에 보낼 데이터 존재할 때)			뷰에 데이터 전송 불가능(뷰에 보낼 데이터가 존재하지 않을 때)
			//URL유지															지정 URL로 변경
			//request/response객체 유지										request/response객체 새로 생성
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);//session 영역에->loginUser나타나면 로그인이됬다
			session.setMaxInactiveInterval(600);//session유효시간 설정 : 10분(기본 값 30분) 세션이 만료되기까지의 시간
			
//			response.sendRedirect("index.jsp");//이렇게 하면 url에 index.jsp라고 나온다 이걸 숨기기위해 밑에 코드 작성
			response.sendRedirect(request.getContextPath());//주소창에 개발한 경로를 보여주지 않고 가짜 주소만 보여주는 html이다.
			
			
			//RequestDispatcher.forward()
			//서블릿에서 뷰로 다시 돌아가는것
			
		} else {//로그인 실패ㅠㅠ
			request.setAttribute("msg", "로그인 실패");
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
