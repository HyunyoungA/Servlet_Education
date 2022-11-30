package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet2 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("연결이 잘 됐군");//url로 요청을 보낸후 url맵핑을 안해줬기때문에 프린트내용"연결이 잘 됐군"이 콘솔에 안찍힌다.-->web.xml에 서블릿맵핑해야함.
		request.setCharacterEncoding("UTF-8");//인코딩하기!POST방식일때!
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String height = request.getParameter("height");
		String[] foods = request.getParameterValues("food");
		
		System.out.println(name);
		System.out.println(gender);
		System.out.println(age);
		System.out.println(city);
		System.out.println(height);
		for(String f : foods) {
			System.out.println(f);//ê°ì§ë ë¨ì..인코딩해줘야됨. 한글은 이상하게나옴
			
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>개인 정보 출력 화면</title>");
		out.println("<style>");
		out.println("h2{color: red;}");
		out.println("span{font-weight: bold;}");
		out.println(".name{color: orange;}");
		out.println(".gender{color: yellow; background: black;}");
		out.println(".age{color: green;}");
		out.println(".city{color: blue;}");
		out.println(".height{color: navy;}");
		out.println(".food{color: purple;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>개인 취향 테스트 결과</h2>");
		out.printf("<span class='age'>%s</span>이시며, ", age);
		out.printf("<span class='city'>%s</span>에 사는 ", city);
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
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
