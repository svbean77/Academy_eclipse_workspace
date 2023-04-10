package com.shinhan.controller2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/setcookie")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿠키를 만들어 응답문서에 추가
		// 왜? -> 이 요청이 끝나도 정보를 유지하고 싶음!
		String userid = request.getParameter("userid");
		String userpass = request.getParameter("userpass");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("<h1>쿠키 저장 연습</h1>");
		
		Cookie c1 = new Cookie("userid", userid);
		c1.setMaxAge(60 * 10); // 10분동안 유지
		Cookie c2 = new Cookie("userpass", userpass);
		c2.setMaxAge(60); // 1분 후 새로고침 하면 사라질 것! 1분동안 유지니까!
		
		response.addCookie(c1);
		response.addCookie(c2);
	}


}
