package com.shinhan.controller2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.vo.AdminVO;

@WebServlet("/SetSessionServlet")
public class SetSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String userpass = request.getParameter("userpass");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("<h1>세션 저장 연습</h1>");
		
		HttpSession session = request.getSession(); // 최초 접속인 경우 session이 없음, 자동 생성(true)
		System.out.println("seession id: " + session.getId());
		System.out.println("seession 유효기한: " + session.getMaxInactiveInterval());
		System.out.println("새로운 session인가?: " + session.isNew());
		
		// 세션은 객체를 저장할 수 있음! (쿠키는 문자열만)
		session.setAttribute("key1", userid);
		session.setAttribute("key2", 100);
		session.setAttribute("key3", new AdminVO("user@email", "김철수", "1234"));
		
		out.write("seession id: " + session.getId() + "<br>");
		out.write("seession 유효기한: " + session.getMaxInactiveInterval() + "<br>");
		out.write("새로운 session인가?: " + session.isNew() + "<br>");
	}

}
