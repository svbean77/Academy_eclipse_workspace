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

@WebServlet("/GetSessionServlet")
public class GetSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("<h1>세션 읽기 연습</h1>");
		
		HttpSession session = request.getSession(false); // 요청을 통해 존재하는 세션을 가져옴! 이미 있는 것을 가져오고 싶기 때문에 false로 설정
		
		if(session == null) {
			out.write("정보가 없습니다..<br>");
			out.write("session: " + session);
		} else {
			System.out.println("seession id: " + session.getId());
			System.out.println("seession 유효기한: " + session.getMaxInactiveInterval());
			System.out.println("새로운 session인가?: " + session.isNew());
			
			// 읽은 값이 object이기 때문에 형 변환 필요
			String userid = (String) session.getAttribute("key1");
			int score = (Integer) session.getAttribute("key2");
			AdminVO admin = (AdminVO) session.getAttribute("key3");
			
			out.write("seession id: " + session.getId() + "<br>");
			out.write("seession 유효기한: " + session.getMaxInactiveInterval() + "<br>");
			out.write("새로운 session인가?: " + session.isNew() + "<br>");

			out.write("userid: " + userid + "<br>");
			out.write("score: " + score + "<br>");
			out.write("admin: " + admin + "<br>");
		}
	}

}
