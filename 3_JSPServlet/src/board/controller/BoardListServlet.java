package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.sevice.BoardService;
import board.model.vo.Board;
import board.model.vo.PageInfo;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/list.bo")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징 처리가 들어가면 Service를 두 번 요청하기 때문에 레퍼런스 변수로 생성
		//		- 게시글 전체 개수 가져올 때 : 페이징 처리 계산에 사용
		//		- 게시글 가져올 때
		BoardService service = new BoardService();
		
		int listCount;		// 게시물 총 개수
		int currentPage;	// 현재 페이지 표시
		int pageLimit;		// 한 페이지에서 표시될 페이징 수
		int boardLimit;		// 한 페이지에 보일 게시글 최대 개수
		int maxPage;		// 전체 페이지 중 가장 마지막 페이지
		int startPage;		// 페이징 된 페이지 중 시작 페이지
		int endPage;		// 페이징 된 페이지 중 마지막 페이지
		
		listCount = service.getListCount(); //총 게시물 수를 가져와서 카운트하는 것
//		System.out.println(listCount);//보드에 데이터를 안넣었기 때문에 0이라고 뜬다
		currentPage = 1;
		if(request.getParameter("currentPage") != null) {//넘겨받은 페이지가 currentPage에 페이징 처리된것이 넘어오면
			currentPage = Integer.parseInt(request.getParameter("currentPage"));//데이터가 들어왔다는거고 데이터를 인티저파싱을 해서 현재페이지가 변경된다. currentPage = ?-->들어간 페이지숫자
		}
		//97개 게시물 ->최대 10개 97 나누기 10(boardLimit) = 9..7 나눈 값 9, 나머지 7
		//예시 123개 게시물 -> 최대 13 123 나누기 10 = 12..3
		//260 -> 26 260 나누기 10 = 26
		//총 게시물 나누기 boardLimit
		pageLimit = 10;
		boardLimit = 10;
		//다른방법,int/int = 9 , +1하면 10개 게시글 나눈 값이 9여서 9까지밖에 안나오는데 10까지 만들어서 7도 담아줘야되기때문에.
		//가장최소감이 0.1이니까 0.9를 더해줘서 하나를 더 추가할 수 있게
		//다른방법,(int)((double)listCount/boardLimit + 0.9);
		//ceil = 올려줌 올림 값이 double로 나온다->(int)추가로 강제형변환을 또 해준다.
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		//1..10/11..20/21..30->1,11,21 startPage (n >= 0) 10n+1 -> pageLimit
		//cp : 4 ->1 / cp: 9 -> 1 /10나누기 0은 1이 나오기 때문에 cp-1을 해서 진행한다.(1-1=0 0도 1로 나오기때문에) (currentPage-1)/ pageLimit
		
		startPage = (currentPage - 1)/pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit -1;
		if(maxPage < endPage) {//맥스가 34일때 엔드가 40일때 존재할 것이다
			endPage = maxPage;//같게 만들어준다.
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Board> list = service.selectList(pi);
		System.out.println(list);
		String page = null;
		if(list != null) {
			page = "WEB-INF/views/board/boardList.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			System.out.println(list);
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "게시판 조회에 실패하였습니다.");
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
