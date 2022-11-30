package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import board.model.sevice.BoardService;
import board.model.vo.Reply;

/**
 * Servlet implementation class InsertReplyServlet
 */
@WebServlet("/insertReply.bo")
public class InsertReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = request.getParameter("writer");
		int bId = Integer.parseInt(request.getParameter("bId"));
		String content = request.getParameter("content");
		
		Reply r = new Reply();
		r.setRefBoardId(bId);
		r.setReplyWriter(writer);
		r.setReplyContent(content);
		
		ArrayList<Reply> list = new BoardService().insertReply(r);
		response.setContentType("application/json; charset=UTF-8");
//		Gson gson = new Gson();//스트링, 인코딩 안되는 문제
//		gson.toJson(list, response.getWriter());
		
//		GsonBuilder gb = new GsonBuilder();
//		GsonBuilder dateGb = gb.setDateFormat("yyyy-MM-dd");
//		Gson gson = dateGb.create();
//		gson.toJson(list, response.getWriter());
		
		//위에 4줄코드 밑에 메소그 체이닝으로 한줄작성(날짜 폼을 지정해준다.)
		new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
