/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.62
 * Generated at: 2022-05-20 08:09:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.vo.Member;

public final class signUpForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/member/../common/menubar.jsp", Long.valueOf(1651547496775L));
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("	.outer{\r\n");
      out.write("			width: 48%; height: 450px; background-color: rgba(255, 255, 255, 0.4); border: 5px solid white;\r\n");
      out.write("			margin-left: auto; margin-right: auto; margin-top: 5%;\r\n");
      out.write("		}\r\n");
      out.write("		#idCheck, #nickCheck, #emailCheck{border-radius: 15px; color: white; background: #FFD8D8;}\r\n");
      out.write("		#joinForm td {text-align: right;}\r\n");
      out.write("		#joinForm tr:nth-child(1) > td:nth-child(3),\r\n");
      out.write("			#joinForm tr:nth-child(5) > td:nth-child(3){text-align: left;}\r\n");
      out.write("		.signUpBtns{text-align: center;}\r\n");
      out.write("		.signUpBtns input {background: #D1B2FF; color: white;}\r\n");
      out.write("		.signUpBtns input+input {background: #B2CCFF; color: white;}\r\n");
      out.write("		td>.must{color: red; font-weight: bold;}\r\n");
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
      out.write("		<h2 align=\"center\">회원가입</h2>\r\n");
      out.write("		\r\n");
      out.write("		<form action=\"");
      out.print( request.getContextPath() );
      out.write("/insert.me\" method=\"post\" id=\"joinForm\" name=\"joinForm\" onsubmit=\"return insertValidate();\">\r\n");
      out.write("			<table>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td width=\"200px\"><label class=\"must\">*</label> 아이디</td>\r\n");
      out.write("					<td><input type=\"text\" maxlength=\"13\" name=\"joinUserId\" required id=\"joinUserId\"></td>\r\n");
      out.write("<!-- 					<td width=\"200px\"><input type=\"button\" id=\"idCheck\" value=\"중복확인\"></td> -->\r\n");
      out.write("					<td width=\"200px\"><label id=\"idResult\"></label></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td><label class=\"must\">*</label> 비밀번호</td>\r\n");
      out.write("					<td><input type=\"password\" maxlength=\"13\" name=\"joinUserPwd\" required></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td><label class=\"must\">*</label> 비밀번호 확인</td>\r\n");
      out.write("					<td><input type=\"password\" maxlength=\"13\" name=\"joinUserPwd2\" required></td>\r\n");
      out.write("					<td><label id=\"pwdResult\"></label></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td><label class=\"must\">*</label> 이름</td>\r\n");
      out.write("					<td><input type=\"text\" name=\"userName\" required></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td><label class=\"must\">*</label> 닉네임</td>\r\n");
      out.write("					<td><input type=\"text\" maxlength=\"15\" name=\"nickName\" required></td>\r\n");
      out.write("					<td width=\"200px\"><input type=\"button\" id=\"nickCheck\" value=\"중복확인\"></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>연락처</td>\r\n");
      out.write("					<td>\r\n");
      out.write("						<input type=\"tel\" maxlength=\"11\" name=\"phone\" placeholder=\"(-없이)01012345678\">\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>이메일</td>\r\n");
      out.write("					<td><input type=\"email\" name=\"email\"></td>\r\n");
      out.write("					<td><input type=\"button\" value=\"이메일 확인\" id=\"emailCheck\"></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>주소</td>\r\n");
      out.write("					<td><input type=\"text\" name=\"address\"></td>\r\n");
      out.write("					<td></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>관심분야</td>\r\n");
      out.write("					<td>\r\n");
      out.write("						<input type=\"checkbox\" id=\"sports\" name=\"interest\" value=\"운동\">\r\n");
      out.write("						<label for=\"sports\">운동</label>\r\n");
      out.write("						<input type=\"checkbox\" id=\"climbing\" name=\"interest\" value=\"등산\">\r\n");
      out.write("						<label for=\"climbing\">등산</label>\r\n");
      out.write("						<input type=\"checkbox\" id=\"fishing\" name=\"interest\" value=\"낚시\">\r\n");
      out.write("						<label for=\"fishing\">낚시</label>\r\n");
      out.write("						<input type=\"checkbox\" id=\"cooking\" name=\"interest\" value=\"요리\">\r\n");
      out.write("						<label for=\"cooking\">요리</label>\r\n");
      out.write("						<input type=\"checkbox\" id=\"game\" name=\"interest\" value=\"게임\">\r\n");
      out.write("						<label for=\"game\">게임</label>\r\n");
      out.write("						<input type=\"checkbox\" id=\"etc\" name=\"interest\" value=\"기타\">\r\n");
      out.write("						<label for=\"etc\">기타</label>\r\n");
      out.write("					</td>\r\n");
      out.write("					<td></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</table>\r\n");
      out.write("			\r\n");
      out.write("			<br clear=\"all\">\r\n");
      out.write("			\r\n");
      out.write("			<div class=\"signUpBtns\">\r\n");
      out.write("				<input type=\"submit\" value=\"가입하기\">\r\n");
      out.write("				<input type=\"button\" onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("'\" value=\"메인으로\">\r\n");
      out.write("			</div>\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	<script>\r\n");
      out.write("// 		document.getElementById('idCheck').onclick = function(){//request id~사용해도 상관없음.\r\n");
      out.write("// 			window.open('checkIdForm.me', 'idCheckForm', 'width=300, height=200');//창에 대한 네임값'idCheckForm'\r\n");
      out.write("// 		}\r\n");
      out.write("		\r\n");
      out.write("		var isUsable = false;		//id 중복 시 false, 사용 가능 시 true\r\n");
      out.write("		var isIdChecked = false;	//id 중복확인 했는지 여부\r\n");
      out.write("		\r\n");
      out.write("		$('#joinUserId').on('change paste keyup', function(){//바뀐다거나, 붙혀넣거나, 키보드가 쓰여진다 의  3가지의 이벤트를 다 넣어줘야한다.\r\n");
      out.write("			isIdChecked = false;\r\n");
      out.write("		});\r\n");
      out.write("		$('#joinUserId').change(function(){\r\n");
      out.write("			var userId = $('#joinUserId');\r\n");
      out.write("			\r\n");
      out.write("			if(!userId || userId.val().length < 4){\r\n");
      out.write("				alert('아이디는 최소 4자리 이상이어야 합니다.');\r\n");
      out.write("				userId.focus();\r\n");
      out.write("			} else{\r\n");
      out.write("				$.ajax({\r\n");
      out.write("					url: '");
      out.print( request.getContextPath() );
      out.write("/checkId.me',\r\n");
      out.write("					type: 'post',\r\n");
      out.write("					data: {inputId:userId.val()},\r\n");
      out.write("					success: function(data){\r\n");
      out.write("						console.log(data);\r\n");
      out.write("						if(data == '0'){//자바스크립트의 특성상 프로그램에서 파싱을 어느정도해서 인지한다(정확히 ''로 구분해준다.)\r\n");
      out.write("							$('#idResult').text('사용 가능합니다.').css({'color':'green', 'float':'left', 'display':'inline-block'});\r\n");
      out.write("							isUsable = true;\r\n");
      out.write("							isIdChecked = true;\r\n");
      out.write("						} else if(data == '1'){\r\n");
      out.write("							$('#idResult').text('사용 불가능합니다.').css({'color':'red', 'float':'left', 'display':'inline-block'});\r\n");
      out.write("							userId.focus();\r\n");
      out.write("							isUsable = false;\r\n");
      out.write("							isIdChecked = false;\r\n");
      out.write("						}\r\n");
      out.write("					},\r\n");
      out.write("					error: function(data){\r\n");
      out.write("						console.log(data);\r\n");
      out.write("					}\r\n");
      out.write("				});\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		function insertValidate(){\r\n");
      out.write("			if(isUsable && isIdChecked){\r\n");
      out.write("				return true;\r\n");
      out.write("			} else{\r\n");
      out.write("				alert('아이디 중복확인을 해주세요');\r\n");
      out.write("				return false;\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		document.getElementById('nickCheck').onclick = function(){\r\n");
      out.write("			window.open('nickCheckForm.me', 'nickCheckForm', 'width=300, height=200');//창에 대한 네임'nickCheckForm'\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		$('#emailCheck').click(function(){\r\n");
      out.write("			var email = $('input[name=email]').val();\r\n");
      out.write("			console.log(email);\r\n");
      out.write("			location.href='");
      out.print( request.getContextPath() );
      out.write("/checkEmail.me?email=' + email;\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("	</script>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
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
