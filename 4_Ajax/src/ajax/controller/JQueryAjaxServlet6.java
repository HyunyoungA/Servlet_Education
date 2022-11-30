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
 * Servlet implementation class JQueryAjaxServlet6
 */
@WebServlet("/jQuery6.do")
public class JQueryAjaxServlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JQueryAjaxServlet6() {
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
		for(int i = 0; i < userList.size(); i++) {//없으면 다 출력, 있으면 그 유저정보만 출력
			if(userList.get(i).getUserNo() == userNo) {
				user = userList.get(i);
			}
		}
		//JSONObject 중첩
//		JSONObject userObj = new JSONObject();
//		if(user != null) {
//			//user 1개 => 해당 user 전송
//			userObj.put("userNo", user.getUserNo());//키,벨류로 다 옮겨적음
//			userObj.put("userName", user.getUserName());
//			userObj.put("userNation", user.getUserNation());
//		} else {
//			//user null => 전체 user 전송
//			for(int i = 0; i < userList.size(); i++) {
//				JSONObject obj = new JSONObject();
//				obj.put("userNo", userList.get(i).getUserNo());//키,벨류로 다 옮겨적음
//				obj.put("userName", userList.get(i).getUserName());
//				obj.put("userNation", userList.get(i).getUserNation());
//				
//				userObj.put(i, obj);
//			}
//		}
		
		//JSONArray 사용 (ArrayList와 비슷)
		//순서를 유지하면서 여러개를 담을 수 있다.
		JSONArray userArr = new JSONArray();
		JSONObject userObj = null;
		if(user != null) {
			userObj = new JSONObject();
			userObj.put("userNo", user.getUserNo());
			userObj.put("userName", user.getUserName());
			userObj.put("userNation", user.getUserNation());
			
			userArr.add(userObj); //else일때 여러개를 담을 수 있게 이렇게 설정한다
		} else {
			for(User userInfo : userList) {
				userObj = new JSONObject();
				userObj.put("userNo", userInfo.getUserNo());
				userObj.put("userName", userInfo.getUserName());
				userObj.put("userNation", userInfo.getUserNation());
				
				userArr.add(userObj);
			}
		}
		response.setContentType("application/json; charset=UTF-8");
//		response.getWriter().print(userObj);
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
