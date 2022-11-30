package notice.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdate
 */
@WebServlet("/update.no")
public class NoticeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String content = request.getParameter("content");
		
		
		Date dat = null;
		if(date.equals("")) {
			dat = new Date(new GregorianCalendar().getTimeInMillis());//오늘날짜
		} else {
			String[] dateArr = date.split("-");
			int year = Integer.parseInt(dateArr[0]);
			int month = Integer.parseInt(dateArr[1])-1;//월은 제로베이스로 받아드린다.5월 입력하면 컴퓨터는 6월로 받아드려서 -1을 추가해준다.
			int day = Integer.parseInt(dateArr[2]);
		
			dat = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
		}
		
		Notice n = new Notice();
		n.setNoticeNo(no);
		n.setNoticeContent(content);
		n.setNoticeDate(dat);
		n.setNoticeTitle(title);
		
		int result = new NoticeService().updateNotice(n);
		
		if(result > 0) {
			response.sendRedirect("detail.no?no=" + no);
		} else {
			request.setAttribute("msg", "공지사항 수정에 실패하였습니다.");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
