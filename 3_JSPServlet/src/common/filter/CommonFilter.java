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

/**
 * Servlet Filter implementation class CommonFilter
 */
@WebFilter("/*")//문자셋 인코딩 ->모든 url에 다 들어가게 할것이다./*
public class CommonFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CommonFilter() {
    	System.out.println("comminfilter 실행");
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
		HttpServletRequest req = (HttpServletRequest)request;
//		System.out.println(req.getMethod()); //GET찍힘
		if(req.getMethod().equals("POST")) {//post일때만 찍힘.
			request.setCharacterEncoding("UTF-8");
		}
		//포스트 방식때만 들어갔으면 좋겠다 =>if문 작성
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
