package action.el.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.model.vo.Person;

/**
 * Servlet implementation class MyElservlet
 */
@WebServlet("/myEL.do")
public class MyElservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyElservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		char gender = request.getParameter("gender").charAt(0);
		int age = Integer.parseInt(request.getParameter("age"));
		
		Person p = new Person(name, gender, age);
		
		String baverage = request.getParameter("beverage");
		String products[] = request.getParameterValues("product");
		String book = request.getParameter("book");
		String movie = request.getParameter("movie");
		
		request.setAttribute("person", p);
		request.setAttribute("baverage", baverage);
		request.setAttribute("products", products);
		request.setAttribute("year", 2022);
		
		//세션에 담음
		HttpSession session = request.getSession();
		session.setAttribute("book", book);
		session.setAttribute("beverage", "물");
		//어플리케이션에 담음
		ServletContext application = request.getServletContext();
		application.setAttribute("movie", movie);
		application.setAttribute("beverage", "포카리스웨트");
		
		request.getRequestDispatcher("/02_el/01_2_elEnd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
