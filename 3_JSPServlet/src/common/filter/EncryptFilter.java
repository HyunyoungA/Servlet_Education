package common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import common.wrapper.EncryptWrapper;

/**
 * Servlet Filter implementation class EncryptFilter
 */
@WebFilter(
		servletNames = { //따로 지정을 해줘야한다.
				"LoginServlet", 
				"InsertMemberServlet", 
				"UpdatePwdServlet"
		})
public class EncryptFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncryptFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		HttpServletRequest hsr = (HttpServletRequest)request;//매개변수 ServletRequest request을 형변환해준다
		EncryptWrapper ew = new EncryptWrapper(hsr);//형변환해준 것을 매개변수에 넣어준다.
		//래퍼를 가지고 다니는 상태에서 돌아다녀야하기 때문에 밑에 ew를 넣어준다.
		// pass the request along the filter chain
		chain.doFilter(ew, response);//chain.doFilter: 래퍼를 가지고 움직여야되기 때문에,  필터가 움직일 수 있다
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
