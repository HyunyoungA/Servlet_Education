package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet1 extends HttpServlet{//extends로 HttpServlet을 상속 받아옴--->서블릿 만들어줌(서블릿의 역할을 하기위해서 상속을 받게한다.)
	//입력한 데이터를 보여주기 위해서 doGet을 사용한다. testServlet1에서 action뒤에 method를 지정안하면 디폴트값이 get이므로.
	@Override//컨트롤+스페이스바 눌러서 doGet을 오버라이드해준다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청이 들어오면 처리 시작
//		System.out.println("요청 잘 들어왔다!");//꼭 프로젝트 파일 선택후 런
		//url로 요청을 보낸후 url맵핑을 안해줬기때문에 프린트내용"요청 잘 들어왔다!"이 콘솔에 안찍힌다.
		//첫번째 파라미터 HttpServletRequest 사용자가 요청한 내용을 받아주는 용도
		//HttpServletRequest.getParameter(String name):String
		//HttpServletRequest.getParameterValues(String name): String[]배열-->여러개의 값을 받을때 사용
		//		view에서 보낸 데이터를 받아오는 역할
		//		매개변수 String name : 
		String name = request.getParameter("name");//뷰에서 인풋에 name속성들을 가지고 온다
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String height = request.getParameter("height");
		String[] foods = request.getParameterValues("food");
		//HttpServletResponse : 처리 결과를 웹 브라우저로 보여주기 위한 용도
		System.out.println(name);
		System.out.println(gender);
		System.out.println(age);
		System.out.println(city);
		System.out.println(height);
		//food는 여러개가 들어가 있다.
		//System.out.println(food);//한식과 양식을 체크한는데 한식만 나온다.
		for(String f : foods) {
			System.out.println(f);//체크박스의 여러개를 찍어도 잘 나옴. 한식과 양식
		}
		//HttpServletResponse : 처리 결과를 웹 브라우저로 보여주기 위한 용도
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>개인정보 출력화면</title>");
		out.println("<style>");
		out.println("h2{color: red;}");
		out.println("span{font-weight: bold;}");
		out.println(".name{color:orange;}");
		out.println(".gender{color: yellow; background: black;}");
		out.println(".age{color: green;}");
		out.println(".city{color: blue;}");
		out.println(".height{color: navy;}");
		out.println(".food{color: purple;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>개인 취향 테스트 결과</h2>");
		out.println("<span class='name'>" + name + "</span>님은");
		out.printf("<span class='age'>%s</span>이시며, ", age);
		out.printf("<span class= 'city'>%s</span>에 사는", city);
		out.printf("키<span class='height'>%s</span>cm인 ", height);
		out.printf("<span class='gender'>%s</span>입니다.", gender);
		out.println("좋아하는 음식은 <span class='food'>");
		for(int i = 0; i < foods.length; i++) {
			if(i == 0) {
				out.printf("%s", foods[i]);
			} else {
				out.printf(", %s", foods[i]);
			}
		}
		out.println("</span>입니다.");
		out.println("</body>");
		out.println("</html>");
		
		
	}
}
