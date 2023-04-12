package com.shinhan.controller2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.vo.AdminVO;

// @WebServlet("/emp/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession(false).invalidate(); // 세션 지우기 -> browser 접속 해제
		
		ServletContext app = getServletContext();
		HttpSession session = request.getSession();
		AdminVO admin = (AdminVO) session.getAttribute("loginUser");
		
		Object obj = app.getAttribute("userList");
		List<AdminVO> userList = null;

		if(obj != null) {
			userList = (List<AdminVO>) obj;
			userList.remove(admin);
			app.setAttribute("userList", userList);
		}
			
	}
}
