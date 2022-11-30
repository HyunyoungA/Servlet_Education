package common.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper{

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {//(String name)에는 파라미터명이 들어간다. 
		// TODO Auto-generated method stub
		String value = null;
		//비밀번호와 관련된 것들만 암호화 진행하면된다.
		//회원가입, 비밀번호변경, 로그인 3가지에 진행한다.
		
		if(name != null && (name.equals("userPwd") || name.equals("joinUserPwd") || name.equals("newPwd"))) {
			//암호화 진행 : SHA-512(암호화만 가능 복호화 불가능) --> 이미 만들어져 있는 것을 가져다 쓰는것이다. 원본 데이터에서 암호화가 된 값에서 다시 원본으로 가는 것을 복호화라고 한다.
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-512");//MessageDigest 암호화된 메세지 객체생성. 암호화는 Digest()가 해준다
				String pwd = super.getParameter(name);
				byte[] bytes = pwd.getBytes(Charset.forName("UTF-8"));//스트링을 바이트배열로 만들어준다
				md.update(bytes);//update배열을 사용하기위해서 바이트배열을 만들었음. MessageDigest가 암호화를 할 수 있게 준비.
				
				value = Base64.getEncoder().encodeToString(md.digest());//배열이 아닌 스트링이 필요함. encodeToString: byte배열을 String값으로 바꿔준다.
			} catch (NoSuchAlgorithmException e) {//NoSuchAlgorithmException : SHA-512알고리즘이 아닌 다른것을 넣었을때 없다고 알려준다. 
				e.printStackTrace();
			}
		} else {
			value = super.getParameter(name);
		}
		return value;
	}

}
