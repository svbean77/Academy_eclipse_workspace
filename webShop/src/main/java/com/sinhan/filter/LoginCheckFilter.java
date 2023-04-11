package com.sinhan.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.vo.AdminVO;

//@WebFilter("/*") // css, js, jsp, servlet, image 등 모든 자원이 들어감!
@WebFilter("*.do") // 따라서 확장자명으로 사용하는 것이 가장 좋음!
public class LoginCheckFilter extends HttpFilter implements Filter {
       

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		AdminVO user = (AdminVO) session.getAttribute("loginUser");
		String uri = req.getRequestURI();
		System.out.println(".do를 지난다");
		System.out.println(req.getServletPath());
		
		// 선생님 풀이
//		if(req.getServletPath().equals("/auth/loginCheck.do") || req.getServletPath().equals("/auth/signup.do") || req.getServletPath.equaps("/auth/emailDupCheck.do")) {}
//		else {
//			if (user == null) {
//				res.sendRedirect(req.getContextPath() + "/auth/loginCheck.do");
//				return;
//			}
//		}
//		chain.doFilter(request, response);
		
		// 내 풀이
		if (uri.contains("loginCheck.do") || uri.contains("signup.do") || uri.contains("emailDupCheck.do") || user != null || uri.equals(req.getContextPath() + "/")) {
			chain.doFilter(request, response);
		} else {
			res.setContentType("text/html;charset=utf-8");
			res.setHeader("refresh", "2;" + req.getContextPath()  + "/auth/loginCheck.do");
			PrintWriter out = res.getWriter();
			
			out.print("<h1>로그인 후 이용 가능!</h1>");
		}
		
	}


}
