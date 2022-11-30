/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.62
 * Generated at: 2022-05-08 13:58:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import board.model.vo.Board;
import member.model.vo.Member;

public final class boardUpdateForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/board/../common/menubar.jsp", Long.valueOf(1651547496775L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.vo.Member");
    _jspx_imports_classes.add("board.model.vo.Board");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
 Board b = (Board)request.getAttribute("b"); 
      out.write("\r\n");
      out.write("<!-- 게시판 수정하기에 들어갔을 때 게시판에 기존 내용이 들어가 있어야하므로 진행한다 -->\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("	.outer{\r\n");
      out.write("		width: 800px; height: 500px; background: rgba(255, 255, 255, 0.4); border: 5px solid white;\r\n");
      out.write("		margin-left: auto; margin-right: auto; margin-top: 50px;\r\n");
      out.write("	}\r\n");
      out.write("	.tableArea {width:500px; height:350px; margin-left:auto; margin-right:auto;}\r\n");
      out.write("	#updateBtn, #cancelBtn{background: #B2CCFF; border-radius: 10px; color: white; width: 80px; height: 25px; display: inline-block;}\r\n");
      out.write("	#updateBtn:hover, #cancelBtn:hover{cursor: pointer;}\r\n");
      out.write("	#cancelBtn{background: #D1B2FF;}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("    \r\n");

	Member loginUser = (Member)session.getAttribute("loginUser");

      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>JSP&Servlet</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print( request.getContextPath() );
      out.write("/js/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("	body{\r\n");
      out.write("		background:url('");
      out.print( request.getContextPath() );
      out.write("/images/bg.png') no-repeat center center fixed;\r\n");
      out.write("		background-size: cover;\r\n");
      out.write("	}\r\n");
      out.write("	.loginArea{float: right;}\r\n");
      out.write("	#loginTable{text-align: right;}\r\n");
      out.write("	#loginTable td:nth-child(1){padding-right: 15px;}\r\n");
      out.write("	.loginBtns{float: right; margin-left: 5px;}\r\n");
      out.write("	.loginBtns input{background: #D1B2FF;}\r\n");
      out.write("	.loginBtns input+input{background: #B2CCFF;}\r\n");
      out.write("	input[type=button], input[type=submit]{cursor: pointer; border-radius: 15px; color: white;}\r\n");
      out.write("	#userInfo label{font-weight: bold;}\r\n");
      out.write("	.wrap{background: white; width: 100%; height: 50px;}\r\n");
      out.write("	.menu{\r\n");
      out.write("		background: white; color: navy; text-align: center; font-weight: bold; \r\n");
      out.write("		vertical-align: middle; width: 150px; height: 50px; display: table-cell;\r\n");
      out.write("	}\r\n");
      out.write("	nav{width: 600px; margin-left: auto; margin-right: auto;}\r\n");
      out.write("	.menu:hover {background: beige; color:orangered; font-weight:bold; cursor:pointer;}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h1 align=\"center\">Welcome to JSP&amp;Servlet World!</h1>\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"loginArea\">\r\n");
      out.write("		");
 if(loginUser == null){ 
      out.write("\r\n");
      out.write("		<form id=\"loginForm\" action=\"");
      out.print( request.getContextPath() );
      out.write("/login.me\" method=\"post\" onsubmit=\"return validate();\">\r\n");
      out.write("			<table id=\"loginTable\">\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td><label>ID</label></td>\r\n");
      out.write("					<td><input type=\"text\" name=\"userId\" id=\"userId\"></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td><label>PWD</label></td>\r\n");
      out.write("					<td><input type=\"password\" name=\"userPwd\" id=\"userPwd\"></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</table>\r\n");
      out.write("			<div class=\"loginBtns\">\r\n");
      out.write("				<input type=\"submit\" value=\"로그인\">\r\n");
      out.write("				<input type=\"button\" value=\"회원가입\" onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/signUpForm.me'\">\r\n");
      out.write("			</div>\r\n");
      out.write("		</form>\r\n");
      out.write("		");
 } else{
      out.write("\r\n");
      out.write("		<div id=\"userInfo\" align=\"right\">\r\n");
      out.write("			<label>");
      out.print( loginUser.getUserName() );
      out.write("님의 방문을 환영합니다.</label>\r\n");
      out.write("			<br clear=\"all\">\r\n");
      out.write("			<div class=\"loginBtns\">\r\n");
      out.write("				<input type=\"button\" value =\"내 정보 보기\" onclick=\"location.href='");
      out.print(request.getContextPath() );
      out.write("/myPage.me'\">\r\n");
      out.write("				<input type=\"button\" value=\"로그아웃\" onclick=\"location.href='");
      out.print(request.getContextPath() );
      out.write("/logout.me'\">\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		");
 } 
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("	<br clear=\"all\">\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"wrap\">\r\n");
      out.write("		<nav>\r\n");
      out.write("			<div class=\"menu\" onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("'\">HOME</div>\r\n");
      out.write("			<div class=\"menu\" onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/list.no'\">NOTICE</div>\r\n");
      out.write("			<div class=\"menu\" onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/list.bo'\">BOARD</div>\r\n");
      out.write("			<div class=\"menu\" onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/list.th'\">IMAGE</div>\r\n");
      out.write("		</nav>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	<script>\r\n");
      out.write("		function validate(){\r\n");
      out.write("			var id = $('#userId');\r\n");
      out.write("			var pwd = $('#userPwd');\r\n");
      out.write("			\r\n");
      out.write("			if(id.val().trim().length == 0){\r\n");
      out.write("				alert('아이디를 입력하세요');\r\n");
      out.write("				id.focus();\r\n");
      out.write("				return false;\r\n");
      out.write("			}\r\n");
      out.write("			if(pwd.val().trim().length == 0){\r\n");
      out.write("				alert('비밀번호를 입력하세요');\r\n");
      out.write("				pwd.focus();\r\n");
      out.write("				return false;\r\n");
      out.write("			}\r\n");
      out.write("			return true;\r\n");
      out.write("		}\r\n");
      out.write("	</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("		\r\n");
      out.write("	<div class=\"outer\">\r\n");
      out.write("		<br>\r\n");
      out.write("		<h2 align=\"center\">게시판 수정</h2>\r\n");
      out.write("		<div class=\"tableArea\">\r\n");
      out.write("			<form action=\"");
      out.print( request.getContextPath() );
      out.write("/update.bo\" method=\"post\">\r\n");
      out.write("				<table>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th>분야<input type=\"hidden\" name=\"bId\" value=\"");
      out.print( b.getBoardId() );
      out.write("\"></th>\r\n");
      out.write("						<td>\r\n");
      out.write("							<select name=\"category\">\r\n");
      out.write("								<option>--------</option>\r\n");
      out.write("<!-- 								게시판 수정하기에 들어갔을 때 게시판에 기존 내용이 들어가 있어야하므로 진행 -->\r\n");
      out.write("								<option value=\"10\"");
      out.print( b.getCategory().equals("공통") ? "selected":"" );
      out.write(">공통</option>\r\n");
      out.write("								<option value=\"20\"");
      out.print( b.getCategory().equals("운동") ? "selected":"" );
      out.write(">운동</option>\r\n");
      out.write("								<option value=\"30\"");
      out.print( b.getCategory().equals("등산") ? "selected":"" );
      out.write(">등산</option>\r\n");
      out.write("								<option value=\"40\"");
      out.print( b.getCategory().equals("게임") ? "selected":"" );
      out.write(">게임</option>\r\n");
      out.write("								<option value=\"50\"");
      out.print( b.getCategory().equals("낚시") ? "selected":"" );
      out.write(">낚시</option>\r\n");
      out.write("								<option value=\"60\"");
      out.print( b.getCategory().equals("요리") ? "selected":"" );
      out.write(">요리</option>\r\n");
      out.write("								<option value=\"70\"");
      out.print( b.getCategory().equals("기타") ? "selected":"" );
      out.write(">기타</option>\r\n");
      out.write("							</select>\r\n");
      out.write("						</td>	\r\n");
      out.write("					</tr>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th>제목</th>\r\n");
      out.write("						<td colspan=\"3\"><input type=\"text\" size=\"58\" name=\"title\" value='");
      out.print( b.getBoardTitle() );
      out.write("'></td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th>내용</th>\r\n");
      out.write("						<td colspan=\"3\">\r\n");
      out.write("							<textarea rows=\"15\" cols=\"60\" name=\"content\" style=\"resize:none;\">");
      out.print( b.getBoardContent() );
      out.write("</textarea>\r\n");
      out.write("						</td>\r\n");
      out.write("					</tr>\r\n");
      out.write("				</table>\r\n");
      out.write("				<br>\r\n");
      out.write("				<div align=\"center\">\r\n");
      out.write("					<button type=\"submit\" id=\"updateBtn\">수정</button>\r\n");
      out.write("					<div id=\"cancelBtn\" onclick=\"location.href=' value='");
      out.print( request.getContextPath() );
      out.write("/list.bo'\">취소</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</form>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
