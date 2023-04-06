package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.AdminService;
import com.shinhan.vo.AdminVO;

// 지금 경로는 http://localhost:포트번호/contextPath 까지! 따라서 슬래시(/)부터 넣어줘야 함!
@WebServlet("/auth/loginCheck.do") // URL mapping 주소를 정의
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getParameter는 input의 name과 동일해야 함!
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		AdminService service = new AdminService();

		AdminVO admin = service.loginCheck(email, pass);

		System.out.println(admin == null ? "로그인 실패.. " : admin);

		// 응답 문서 만들기: header + ResponseBody에 문자열을 출력하기 -> void니까 리턴은 아니고 그냥 문서에 출력만(print, write)
		response.setContentType("text/html;charset=utf-8"); // 한글 깨지지 않기 위한 인코딩 설정
		PrintWriter out = response.getWriter();

		if (admin == null) {
			// header: 화면에는 보이지 않는 정보, 3초 후 다시 login.jsp로 새로고침
			response.setHeader("refresh", "3;login.jsp"); 
			// servlet 경로가 auth 폴더 내부에 있다고 여김 따라서 상대경로인 login.jsp는 auth/login.jsp가 됨!
			// servlet은 contextPath까지는 되어있기 때문에 절대경로를 주고 싶다면 /contextPath/auth로 적으면 됨! 
			// <meta http-equiv="refresh" content="3;auth/login.jsp">와 같은 의미!
			out.print("<h1>Login Fail..</h1>");
			return;
		}
		out.print("<h1>Login Information</h1>");
		out.printf("<h1>이메일: %s</h1>", email);
		out.printf("<h1>이름: %s</h1>", admin.getManager_name());
	}
}
