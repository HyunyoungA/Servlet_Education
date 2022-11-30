package com.kh.servlet.pizza;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Pizza extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pizza = request.getParameter("pizza");
		String[] topping = request.getParameterValues("topping");
		String toppingNum = request.getParameter("topping");
		String[] side = request.getParameterValues("side");
		
		System.out.println(pizza);
		System.out.println(topping);
		System.out.println(side);
		
		int recommendation = 0;
		switch(pizza){
		case "치즈피자" : recommendation += 5000; break;
		case "콤비네이션피자" : recommendation += 6000; break;
		case "포테이토피자" : recommendation += 7000; break;
		case "고구마피자" : recommendation += 7000; break;
		case "불고기피자" : recommendation += 8000; break;
		}
		//토핑과 사이드가 체크안됬을때
		if(topping != null) {
			for(int i = 0; i < topping.length; i++) {
				switch(topping[i]) {
				case "고구마무스" : recommendation += 1000; break;
				case "콘크림무스" : recommendation += 1500; break;
				case "파인애플토핑" : recommendation += 2000; break;
				case "치즈토핑" : recommendation += 2000; break;
				case "치즈크러스트" : recommendation += 2000; break;
				case "치즈바이트" : recommendation += 3000; break;
				}
			}
		}
		
		if(side != null) {
			for(int i = 0; i < side.length; i++) {
				switch(side[i]) {
				case "오븐구이통닭" : recommendation += 9000; break;
				case "치킨스틱&윙" : recommendation += 4900; break;
				case "치즈오븐스파게티" : recommendation += 4000; break;
				case "새우링&웨지감자" : recommendation += 3500; break;
				case "갈릭포테이토" : recommendation += 3000; break;
				case "콜라" : recommendation += 1500; break;
				case "사이다" : recommendation += 1500; break;
				case "갈릭소스" : recommendation += 500; break;
				case "피클" : recommendation += 300; break;
				case "핫소스" : recommendation += 100; break;
				case "파마산 치즈가루" : recommendation += 100; break;
				}
			}
		}
		
		for(String t : topping) {
			System.out.println(t);
		}
		
		for(String s : side) {
			System.out.println(s);
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>주문 내역</title>");
		out.println("<style>");
		out.println("h3{color: black;}");
		out.println("span{font-weight: bold;}");
		out.println(".pizza{color: red;}");
		out.println(".topping{color: green;}");
		out.println(".side{color: blue;}");
		out.println("h2{color: pink;}");
		out.println("</style");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>주문 내역</h3>");
		out.println("피자는<span class='pizza'>"+ pizza +"</span>,");
		out.println("토핑은<span class='topping'>");
		if(topping != null) {
			for(int i = 0; i < topping.length; i++) {
				if(i == 0) {
					out.printf("%s", topping[i]);
				} else {
					out.printf(", %s", topping[i]);
				}
			}
		}else {
			out.printf("없음");
		}
		out.println("</span>,");
		out.println("사이드는<span class='side'>");
		if(side != null) {
			for(int i = 0; i < side.length; i++) {
				if(i == 0) {
					out.printf("%s", side[i]);
				} else {
					out.printf(", %s", side[i]);
				}
			}
		} else {
			out.printf("없음");
		}
		out.println("</span>주문하셨습니다.<br><br>");
		out.println("총합:<span>");
		
		request.setAttribute("recommendation", recommendation);
		out.println(recommendation+"원");
		out.println("</span>");
		
		out.println("<h2>즐거운 식사시간 되세요~<h2>");
		out.println("</body>");
		out.println("</html>");
	}
}
