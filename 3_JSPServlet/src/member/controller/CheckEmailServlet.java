package member.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.Session;
import javax.mail.Transport;

import sun.security.krb5.internal.Authenticator;

/**
 * Servlet implementation class CheckEmailServlet
 */
@WebServlet("/checkEmail.me")
public class CheckEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sender = "dome96@naver.com";//보내는사람
		String password = "실제비밀번호";
		
		String reseiver = request.getParameter("email");//받는 사람
		String title = "[JSP/Servlet] 이메일 인증";
		String content = "<b><span style='color: red;'>이메일이 정상적으로 도착했습니다.</span></b>";//css, html로 꾸밀수있다
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.name.com");//smtp:간이 우편 전송 프로토콜(Simple Mail Transfer Protocol)3

		prop.put("mail.smtp.auth", "true");
		
		
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender, password);
			}
		}); //상속받아집어넣지않고, 익명클래스로 만든다(마치 상속받은것처럼 사용하는것),
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(reseiver));
			
			message.setSubject(title);
			message.setText(content, "UTF-8", "html");
			
			Transport.send(message);
		} catch(AddressException e) {
			e.printStackTrace();
		} catch(MessagingException e) {
			e.printStackTrace();
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
