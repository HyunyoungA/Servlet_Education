package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.sevice.BoardService;
import board.model.vo.Attachment;
import board.model.vo.Board;

/**
 * Servlet implementation class ImageListServlet
 */
@WebServlet("/list.th")
public class ImageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = new BoardService();//여러번 왔다갔다 할때 레퍼런스 변수를 만들어서 2번 왔다갔다할거다.
		
		//게시글 리스트 가져오기
		ArrayList<Board> bList = service.selectFList(1);
		//파일 리스트 가져오기
		ArrayList<Attachment> fList = service.selectFList(2);
		
		String page = null;
		if(bList != null && fList != null) {
			request.setAttribute("bList", bList);
			request.setAttribute("fList", fList);
			page = "WEB-INF/views/thumbnail/thumbnailList.jsp";
		} else {
			request.setAttribute("msg", "사진 게시판 조회에 실패하였습니다.");
			page = "WEB-INF/views/common/errorPage.jsp";
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
