package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvc2model/calc")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 페이지 보여주는 것은 주소창 로드 시 get 방식으로 요청
	// 계산 결과는 버튼 입력 시 post 방식으로 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 Redirect와 forward의 차이점이 무엇인가?
		 - 간단히
		   - Redirect: '페이지를 이동'시키는 것
		   - forward: '페이지를 유지'하는 것
		 - Redirect: client -> servlet, servlet -> client, client -> 다른servlet, 다른servlet -> client
		   : 요청하면 servlet이 결과를 client로 반환, 다른 servlet을 다시 재요청
		   ex) 직원 등록을 완료하면 모든 직원을 조회하는 '페이지로 이동'한다
		 - forward: client -> servlet -> jsp
		   : 요청하면 servlet이 jsp에게 위임한다
		   ex) 직원 등록을 완료하면 '동일한 페이지에' 등록한 정보를 보인다
		*/
		// page 보여주기 (주소창의 주소를 변경한다! = 재요청) (client -> servlet, servlet -> client, client -> 다른servlet(재요청), servlet -> client)
		// response.sendRedirect("calc.jsp"); // 이 경우에는 forward가 맞는 방법!
		
		// page 보여주기 (주소창의 주소를 그대로 두고 위임한다!)
		RequestDispatcher rd = request.getRequestDispatcher("calc.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 계산
		int num1 = Integer.parseInt(request.getParameter("su1"));
		int num2 = Integer.parseInt(request.getParameter("su2"));
		String op = request.getParameter("op");
		int result = 0;
		
		switch(op) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			result = num1 / num2;
			break;
		default:
			break; 
		}
		
//		response.setContentType("text/plain;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.print("결과는 " + result);
		
		// 페이지가 이동되지 않은 것처럼 같은 화면에 보이기!
		request.setAttribute("su1", num1);
		request.setAttribute("su2", num2);
		request.setAttribute("op", op);
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("calc.jsp");
		rd.forward(request, response);
	}

}
