package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/bind2")
public class BindingTestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// application 영역(=Servlet context =WAS가 살아있는 동안 유효)에 저장하고 싶다!
		ServletContext application = request.getServletContext();
		
		// session 영역(=browser가 살아있는 동안 유효)에 저장하고 싶다!
		HttpSession browser = request.getSession();
		
		Object obj = (Integer) application.getAttribute("visitor");
		int cnt = 1;
		
		if(obj != null) {
			cnt = (Integer) obj;
		}
		application.setAttribute("visitor", cnt);
		System.out.println(cnt);
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<h1>bind2</h1>Served at: ")
		.append(request.getContextPath() + "<br>")
		.append((String)application.getAttribute("mydata1") + "<br>") // 있음 (WAS가 공유하기 때문)
		.append((String)browser.getAttribute("mydata2") + "<br>") // 1. 있음 (bind1과 같은 브라우저에서 실행한 경우) 2. null (bind1과 다른 브라우저에서 실행한 경우)
		.append((String)request.getAttribute("mydata3") + "<br>")
		.append((String)request.getAttribute("myname")) // 가장 좁은 범위인 request가 출력됨! (forward로 request를 받았기 때문!)
		; // null (bind1과는 다른 요청이니까)
	}

}
