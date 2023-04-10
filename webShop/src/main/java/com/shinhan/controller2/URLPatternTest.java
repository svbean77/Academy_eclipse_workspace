package com.shinhan.controller2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/url/test") // 이름이 일치하는 URL pattern
//@WebServlet("/url/test/*") // 디렉토리가 일치하는 URL pattern 
@WebServlet("*.go") // 확장자가 일치하는 URL parttern (확장자 URL 패턴인 경우(*) 폴더와 함께 사용 불가! ex. /aa/bb/*.do
public class URLPatternTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("getContextPath: " + request.getContextPath()); // web application 주소
		System.out.println("getRequestURI: " + request.getRequestURI()); // contextPath~끝
		System.out.println("getRequestURL: " + request.getRequestURL()); // http://~끝
		System.out.println("getMethod: " + request.getMethod()); // get, post
		System.out.println("getRemoteAddr: " + request.getRemoteAddr()); // 서버에 접속한 client의 IP address
		System.out.println("getServletPath: " + request.getServletPath()); // contextPath 이후(제외)~끝
		System.out.println("getPathInfo: " + request.getPathInfo()); // 경로 이후의 내용(=요청한 URL 이름 뒷부분)
		System.out.println("getQueryString: " + request.getQueryString()); // parameter 
	}


}
