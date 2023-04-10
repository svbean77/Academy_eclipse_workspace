package com.shinhan.controller2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getcookie")
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 브라우저에 저장된 쿠키가 요청과 함께 옴!
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("<h1>쿠키 읽기 연습</h1>");

		Cookie[] cs = request.getCookies(); // 배열로 받아야 하기 때문에 내가 원하는 쿠키만 가져올 수 없음.. 
		for(Cookie c : cs) {
			System.out.println(c.getName() + " -- " + c.getValue());
			out.write(c.getName() + " -- " + c.getValue() + "<br>");
		}
		
	}


}
