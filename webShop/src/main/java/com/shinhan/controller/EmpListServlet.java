package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.EmpService;
import com.shinhan.vo.EmpVO;

@WebServlet("/emp/emplist.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
