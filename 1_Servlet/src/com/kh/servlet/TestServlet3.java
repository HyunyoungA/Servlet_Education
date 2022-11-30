package com.kh.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet3 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	System.out.println("연결 성공!");//인덱스에서 서블릿, 서블릿매핑 진행해서 연결
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String height = request.getParameter("height");
		String[] foods = request.getParameterValues("food");
		
		String recommendation = null;//추첨
		switch(age) {
		case "10대 미만": recommendation="막대사탕"; break;
		case "10대": recommendation= "운동화"; break;
		case "20대": recommendation="지갑"; break;
		case "30대": recommendation="상품권"; break;
		case "40대": recommendation="스포츠용품"; break;
		case "50대": recommendation="안마기"; break;
		}
		//뷰+모델 = MVC1패턴
		//뷰 모델 컨드롤러 다 따로 되있는게 MVC2패턴
		//결과화면을 나타내주는 곳으로 이동-->화면에 데이터 필요
		
		//내가 보낼 데이터들을 어떤이름과 어떤 메소드를 보낼지 .setAttribute(,)에 지정해주는것이다
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("age", age);
		request.setAttribute("city", city);
		request.setAttribute("height", height);
		request.setAttribute("foods", String.join(", ", foods));//join메소드로 문자로 만들어줌
		request.setAttribute("recommendation", recommendation);
		
		RequestDispatcher view = request.getRequestDispatcher("servlet/testServlet3End.jsp");//어디로 이동할 건지 경로 지정
		view.forward(request, response);//response에 담은건 없지만 같이 보내줘야하기때문에 보내준다.
		
		
//		System.out.println(name);
//		System.out.println(gender);
//		System.out.println(age);
//		System.out.println(city);
//		System.out.println(height);
//		System.out.println(foods);
//		for(String f : foods) {
//			System.out.println(f);
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
