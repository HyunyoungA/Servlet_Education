package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.model.sevice.BoardService;
import board.model.vo.Attachment;
import board.model.vo.Board;
import common.MyFileRenamePolicy;
import member.model.vo.Member;

/**
 * Servlet implementation class InsertThumbnailServlet
 */
@WebServlet("/insert.th")
public class InsertThumbnailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertThumbnailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		
//		String title = request.getParameter("title");
//		System.out.println(title);
//		encType="multipart/form-data" 인코딩지정때문에 getParameter("title"); title 값을 가져올 수 없다.
//		==> MultipartRequest 
		
		if(ServletFileUpload.isMultipartContent(request)) {// multipart/form-data로 전송되었는지 확인
			// MultipartRequest 객체 사용법
			// MultipartRequest multiRequest = new MultipartRequest(HttpServletRequest, 파일저장소 경로, 파일 최대 크기, 인코딩 타입, 파일 명 변환 규칙);
			//	파일 명 변환 규칙에 사용되는 기본 클래스 : DefaultFileRenamePolicy
			//	같은 이름의 파일이 존재하면 파일 명 뒤에 숫자 붙임 ex) aaa.png, aaa1.png, aaa2.png
		
			int maxSize = 1024*1024*10; //10Mbyte
			String root = request.getSession().getServletContext().getRealPath("/");// /:WebContent아래를 말하는것
			String savePath = root + "thumbnail_uploadFiles/";
			
			File f = new File(savePath);
			if(!f.exists()) {
				f.mkdirs();
			}
//			System.out.println(savePath); //C:\5_Servlet_workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\3_JSPServlet\thumbnail_uploadFiles/
			// cos.jar 라이브러리 필요
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			//따로 규약을 넣지 않으면  new DefaultFileRenamePolicy()를 가져와서 쓰면된다. import 확인해보면 cos.jar를 사용햇는지 알 수 있다 
			//파일저장소에 저장이 되는 것 이다.
			
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			String writer = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
			
			ArrayList<String> saveFiles = new ArrayList<String>(); //파일의 바뀐 이름을 저장할 ArrayList
			ArrayList<String> originFiles = new ArrayList<String>(); //파일의 원래 이름을 저장할 ArrayList
			
			Enumeration<String> files = multiRequest.getFileNames();// input type="file"의 name값 반환값 Enumaratioin
			while(files.hasMoreElements()) {
//				System.out.println(files.nextElement());//name속성값의 Parameter명 나옴 thumbnailImg4/thumbnailImg3/thumbnailImg2/thumbnailImg1
				String name = files.nextElement(); //전송 순서 역순
				
				if(multiRequest.getFilesystemName(name) != null) {
					saveFiles.add(multiRequest.getFilesystemName(name));//바뀐이름의 파일명
					originFiles.add(multiRequest.getOriginalFileName(name));//원래 이름의 파일명
				}
			}
			
			Board b = new Board();
			b.setBoardContent(content);
			b.setBoardTitle(title);
			b.setBoardWriter(writer);
			b.setBoardType(2);
			b.setCategory("10");//카테고리 인설트보드 그대로 활용할 것이다(쿼리) 임의로 10을 넣어줌
			
			ArrayList<Attachment> fileList = new ArrayList<>();
			for(int i = originFiles.size() -1; i >= 0; i--) {//파일이 역순이어서 for문도 역순으로 씀.
				Attachment a = new Attachment();
				a.setFilePath(savePath);
				a.setOriginName(originFiles.get(i));
				a.setChangeName(saveFiles.get(i));
				
				if(i == originFiles.size() -1) {//썸네일 /역순으로 들어오니까 -1을 해서 
					a.setFileLevel(0);
				} else {
					a.setFileLevel(1);
				}
				
				fileList.add(a);
			}
			
			int result = new BoardService().insertFile(b, fileList);
			
			if(result == fileList.size() +1) {//잘들어갔다는 전제하에 +1과 같다면 진행
				response.sendRedirect("list.th");
			}else {
				request.setAttribute("msg", "사진게시판 등록에 실패하였습니다.");
				request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
			
				for(int i = 0; i < saveFiles.size(); i++) {
					File failFile = new File(savePath + saveFiles.get(i));
					failFile.delete();
				}
			}
			
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
