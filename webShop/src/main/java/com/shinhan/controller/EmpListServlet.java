package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.model.EmpService;
import com.shinhan.vo.AdminVO;
import com.shinhan.vo.EmpVO;

// @WebServlet("/emp/emplist.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminVO user = (AdminVO) request.getAttribute("loginUser2"); // request로 저장한 데이터를 가져올 수 없음
		System.out.println("request user: " + user); // (forward가 아니잖아.. sendRedirect는 브라우저에 내려갔다 새로운 요청을 받은거야)
		
//		HttpSession browser = request.getSession();
//		user = (AdminVO) browser.getAttribute("loginUser");
//		System.out.println("session user: " + user);
//		
//		if(user == null) {
//			// 로그인하지 않았다면 로그인 창으로 이동하도록!
//			response.sendRedirect("../auth/loginCheck.do");
//			return;
//		}
		
		
		EmpService service = new EmpService();
		List<EmpVO> emplist = service.selectAll();

		// request가 유지되는 동안 emplist를 공유영역에 저장!
		request.setAttribute("empAll", emplist); // 무조건 object로 저장됨 -> 받을 때 무조건 형변환 필요!
		// 위임: 내가 요청을 받고 응답은 다른 페이지가 함!
//		RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath() + "/emp/empSelect.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("empSelect.jsp");
		rd.forward(request, response);
	}
}
