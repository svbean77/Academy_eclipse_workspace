package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/bind1")
public class BindingTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// application 영역(=Servlet context =WAS가 살아있는 동안 유효)에 저장하고 싶다!
		ServletContext application = request.getServletContext();
		application.setAttribute("mydata1", "application에서 저장함");
		
		// session 영역(=browser가 살아있는 동안 유효)에 저장하고 싶다!
		// 서버를 종료했어도 'browser'를 그대로 사용한다면 유지됨!
		HttpSession browser = request.getSession();
		browser.setAttribute("mydata2", "browser에서 저장함");
		
		// request 영역(request가 살아있는 동안 유효)
		request.setAttribute("mydata3", "request에서 저장함");
		
		// 이번엔 변수명이 전부 같다면?! 누구를 읽어야해?! (명확하게 ~~에게서 읽어라!라고 하지 않은 경우)
		application.setAttribute("myname", "application name");
		browser.setAttribute("myname", "browser name");
		request.setAttribute("myname", "request name");
		
		
		// 1. request를 넘겨주는 방법 -> request를 넘겼기 때문에 bind2에서도 해당 request 사용 가능!
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("bind2");
		rd.forward(request, response);
		
		// 2. 넘겨주지 않을 때 -> bind1의 request는 이미 끝났기 때문에 bind2, index에서는 request가 null로 나온다
//		response.setContentType("text/html;charset=utf-8");
//		response.getWriter().append("Served at: ")
//		.append(request.getContextPath() + "<br>")
//		.append((String)application.getAttribute("mydata1") + "<br>")
//		.append((String)browser.getAttribute("mydata2") + "<br>")
//		.append((String)request.getAttribute("mydata3"));
		
	}

}
