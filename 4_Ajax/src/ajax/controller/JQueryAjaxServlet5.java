package ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import ajax.model.vo.User;

/**
 * Servlet implementation class JQueryAjaxServlet5
 */
@WebServlet("/jQuery5.do")
public class JQueryAjaxServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JQueryAjaxServlet5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User(1, "강건강", "대한민국"));
		userList.add(new User(2, "타일러 라쉬", "미국"));
		userList.add(new User(3, "쯔위", "중국"));
		userList.add(new User(4, "모모", "일본"));
		userList.add(new User(5, "리사", "태국"));
		userList.add(new User(6, "알베르토 몬디", "이탈리아"));
		userList.add(new User(7, "조나단", "콩고"));
		//원래 디비에 갔다와야되는데 일단 그런 효과만 주기위해 작성한 것이다.
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		User user = null;
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getUserNo() == userNo) {
				user = userList.get(i);
			}
		}
		
		JSONObject userObj = null;
		if(user != null) {//해당 유저번호가 있을때
			userObj = new JSONObject();//JSONObject() Map형식이라 put 사용
			userObj.put("userNo", user.getUserNo());//키,벨류로 다 옮겨적음
			userObj.put("userName", user.getUserName());
			userObj.put("userNation", user.getUserNation());
		}
		
//		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");//제이슨방식+인코딩 문제점을 한번에 해결
		PrintWriter pw = response.getWriter();
		pw.print(userObj);//스트링으로 넘어가서 활용하기 좋지 않은 방법이다.User [userNo=6, userName=알베르토 몬디, userNation=이탈리아]
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
