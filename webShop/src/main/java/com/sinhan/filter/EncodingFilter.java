package com.sinhan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("*.do") // .do로 끝나는 모든 요청에 대해 인코딩 작업을 수행!
public class EncodingFilter extends HttpFilter implements Filter {
   
    public EncodingFilter() {
    	System.out.println("EncodingFilter 생성자^^");
    }

	public void destroy() {
		System.out.println("EncodingFilter 소멸자..");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 요청 filter
		request.setCharacterEncoding("utf-8"); // 사실상 추가한 코드는 이거!!
		
		// 내용들은 ServletRequest, 우리가 사용하는 건 HttpServletRequest -> 자식의 함수를 사용하기 위해!
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println("getContextPath(): " + req.getContextPath());
		System.out.println("getRequestURI(): " + req.getRequestURI());
		System.out.println("getRequestURL(): " + req.getRequestURL());
		
		// servlet으로 요청과 응답이 간다! -> 절대 지우면 안돼..
		chain.doFilter(request, response);
		
		// 응답 filter
		// 브라우저에 응답하러 가고 있는 중이다
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("EncodingFilter init..");
	}

}
