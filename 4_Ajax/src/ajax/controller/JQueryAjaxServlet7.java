package ajax.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import ajax.model.vo.User;

/**
 * Servlet implementation class JQueryAjaxServlet7
 */
@WebServlet("/jQuery7.do")
public class JQueryAjaxServlet7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JQueryAjaxServlet7() {
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
		int e = 0;
		while(e <= userList.size()) {
			for(int i = 0; i < userList.size(); i++) {
				if(userList.get(i).getUserNo() == userNo) {
					user = userList.get(i);
				}
			}e++;
		}
	
		JSONArray userArr = new JSONArray();
		JSONObject userObj = null;
		
		if(user != null) {
			userObj = new JSONObject();
			userObj.put("userNo", user.getUserNo());
			userObj.put("userName", user.getUserName());
			userObj.put("userNation", user.getUserNation());
				
			userArr.add(userObj);
		
			
		}
	
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(userArr);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
