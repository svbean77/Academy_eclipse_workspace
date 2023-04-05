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

		// 응답 문서 만들기
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		if (admin == null) {
			// header: 화면에는 보이지 않는 정보, 3초 후 다시 login.jsp로 새로고침
			response.setHeader("refresh", "3;login.jsp");
			out.print("<h1>Login Fail..</h1>");
			return;
		}
		out.print("<h1>Login Information</h1>");
		out.printf("<h1>이메일: %s</h1>", email);
		out.printf("<h1>이름: %s</h1>", admin.getManager_name());
	}
}
