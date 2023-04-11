package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.model.AdminService;
import com.shinhan.vo.AdminVO;

// 지금 경로는 http://localhost:포트번호/contextPath 까지! 따라서 슬래시(/)부터 넣어줘야 함!
// @WebServlet("/auth/loginCheck.do") // URL mapping 주소를 정의
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext app; // HttpServlet에도 getServletContext 함수가 존재하기 때문에 request 빼도 됨
	
	// day33
	// 주소창에 .jsp가 보에는게 싫어! -> get을 위임하는 방법으로 변경
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		app = getServletContext();
		// 몇 번째 방문자인지!!!
		// 서버가 꺼지면 다시 null이기 때문에 정말 방문자를 원한다면 따로 파일 등에 데이터를 저장해야 함
//		Object obj = (Integer) app.getAttribute("visitor");
//		int cnt = 1;
//		
//		if(obj != null) {
//			cnt = (Integer) obj;
//			cnt++;
//		}
//		app.setAttribute("visitor", cnt);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	// 주소창에 .jsp 보이는게 싫어! -> signin을 doPost로 수정
	protected void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getParameter는 input의 name과 동일해야 함!
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		AdminService service = new AdminService();

		AdminVO admin = service.loginCheck(email, pass);

		System.out.println(admin == null ? "로그인 실패.. " : admin);
		
		Object obj = app.getAttribute("userList");
		List<AdminVO> userList = null;
		if(admin != null) {
			if(obj == null) {
				userList = new ArrayList<>();
			}
			else {
				userList = (List<AdminVO>) obj;
			}
			userList.add(admin);
			app.setAttribute("userList", userList);
			
			System.out.println("*** 현재 접속자 ***");
			for(AdminVO vo : userList) {
				System.out.println(vo);
			}
			System.out.println("****************");
		}
		

		// 응답 문서 만들기: header + ResponseBody에 문자열을 출력하기 -> void니까 리턴은 아니고 그냥 문서에 출력만(print, write)
		response.setContentType("text/html;charset=utf-8"); // 한글 깨지지 않기 위한 인코딩 설정
		PrintWriter out = response.getWriter();

		if (admin == null) {
			// header: 화면에는 보이지 않는 정보, 3초 후 다시 login.jsp로 새로고침
			// 응답문서의 header를 작성해 내려감. 3초 후 '재요청'의 의미
			response.setHeader("refresh", "3;loginCheck.do"); 
			// servlet 경로가 auth 폴더 내부에 있다고 여김 따라서 상대경로인 login.jsp는 auth/login.jsp가 됨!
			// servlet은 contextPath까지는 되어있기 때문에 절대경로를 주고 싶다면 /contextPath/auth로 적으면 됨! 
			// <meta http-equiv="refresh" content="3;auth/login.jsp">와 같은 의미!
			out.print("<h1 style='background-color:orange;'>Login Fail..</h1>");
			return;
		}

		// 로그인한 사용자 이름 정보를 페이지에 띄우고 싶다 -> session 영역에 로그인 정보를 저장!
		request.setAttribute("loginUser2", admin);
		HttpSession session = request.getSession(); // 이 브라우저에 저장!
		session.setAttribute("loginUser", admin);
		
		
		// 응답문서의 주소창을 바꾼다! (=location.href=""와 같은 의미) 
		// -> servlet의 default는 http:localhost:port/contextPath, sendRedirect의 defualt는 http://localhost:port
		String path = request.getContextPath();
		String encodeName = URLEncoder.encode(admin.getManager_name(), "utf-8"); // 주소창이니까 한글은 인코딩해서 보내야 함
		// sendRedirect 방식은 '이 경로를 브라우저 주소창에 넣어라!'이기 때문에 한글을 직접 인코딩하는 과정이 필요'
		// 그냥 get 방식(=주소창 입력)은 주소창에 입력된 한글이 인코딩되는 것!
		response.sendRedirect(path + "/emp/emplist.do?myname=" + encodeName); // sendRedirect 자체는 get방식임! 
		
		// 재요청
//		out.print("<script>"
//				+ "alert('로그인 성공! 업무 화면으로 이동합니다!');"
//				+ "location.href='"
//				+ path
//				+ "/emp/emplist.do';"
//				+ "</script>");
	}
}
