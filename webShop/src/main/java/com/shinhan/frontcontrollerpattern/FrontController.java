package com.shinhan.frontcontrollerpattern;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[FRONT] getMethod: " + request.getMethod());
		System.out.println("[FRONT] getRequestURI: " + request.getRequestURI());
		System.out.println("[FRONT] getServletPath: " + request.getServletPath());
		
		String path = request.getServletPath();
		CommonControllerInterface controller = null;
		Map<String, Object> data = new HashMap<>();
		data.put("method", request.getMethod()); // get 방식 or post 방식 넣어주기
		data.put("request", request);
		
		switch (path) {
		case "/auth/loginCheck.do":
			controller = new LoginController();
			break;
		case "/auth/logout.do":
			controller = new LogoutController();
			break;
		case "/auth/signup.do":
			controller = new SignUpController();
			break;
		case "/auth/emailDupCheck.do":
			controller = new EmailDupCheckController();
			break;
		case "/emp/emplist.do":
			controller = new EmpListController();
			break;
		case "/emp/empdetail.do":
			controller = new EmpDetailController();
			break;
		case "/emp/empinsert.do":
			controller = new EmpInsertController();
			break;
		case "/emp/empDelete.do":
			controller = new EmpDeleteController();
			break;
		default:
			break;
		}
		
		String page = null;
		try {
			page = controller.execute(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		
		// 세션에 저장할 데이터가 있는가? 등의 모든 처리를 front controller에서 하고싶다!
		for(String key: data.keySet()) {
			if(key.equals("loginUser")) {
				session.setAttribute(key, data.get(key));
			}
		}
		
		// 처리 다 했으면 페이지 처리
		if(page.indexOf("redirect:") >= 0) {
			response.sendRedirect(page.substring(9));
		}
		else if (page.indexOf("responseBody:") >= 0) {
			response.getWriter().append(page.substring(13)); // 이거 자체가 success의 responseData임!
		}
		else {
			RequestDispatcher rd;
			rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
	}

}
