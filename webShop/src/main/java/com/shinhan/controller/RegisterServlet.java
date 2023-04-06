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

@WebServlet("/auth/signup.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post 방식은 parameter가 넘어올 때 요청 문서의 body에 들어감 -> 한글이 깨져 (insert도 깨진 한글이 들어간다! user3은 깨진 한글!)
		// get 방식은 parameter가 넘어올 때 URL에 인코딩되어 들어감 -> 한글 정상
		request.setCharacterEncoding("utf-8");

		String mname = request.getParameter("manager_name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		AdminService service = new AdminService();
		AdminVO admin = new AdminVO(email, mname, pass);
		int result = service.registerAdmin(admin);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); // 응답 문서의 body 부분에 출력됨!

		if (result == 1) {
			out.print("<h1>계정 등록 성공!</h1>");
			response.addHeader("refresh", "1;login.jsp");
		} else {
//			response.sendRedirect(request.getContextPath() + "/auth/login.jsp"); // 재요청! 시간이 지난 후가 아닌 바로 login.jsp로 이동시킴!
			out.print("<h1>계정 등록 실패..</h1>"); // 바로 이동이기 때문에 이 내용은 보이지 않음
			response.addHeader("refresh", "1;login.jsp");
		}
	}

}
