package com.shinhan.controller;

import java.io.IOException;
// javax 패키지: tomcat이 가지고 있는 패키지 -> server가 없으면 에러
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet: 주소 창에서 이렇게 입력하면 해당 servlet을 연결하라 (요청 URL에 의해 실행할 servlet 연결, servlet mapping)
// ** 주의 ** 요청 url은 반드시 /로 시작! (/를 빼면? [error] 서블릿 매핑에서 유효하지 않은 <url-pattern> + server start X)
// 현재 경로는 http://localhost:포트번호/webShop 까지임 -> 경로에 /가 필요한 이유
// 배열 -> 내가 직접 추가해도 됨
// @WebServlet({ "/FirstServlet", "/first", "/ff" }) // 이거는 Web module 3에서 추가된 내용 -> 쓰지 않으면 패키지 이름 경로로 나와버려
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FirstServlet() {
		System.out.println("FirstServlet의 생성자!");
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("FirstServlet의 init!");
	}

	public void destroy() {
		System.out.println("FirstServlet의 destroy!");
	}

	/*
	 // service는 모든 요청방식을 처리하고자 하는 경우 사용 
	 public void service(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
	 System.out.println("FirstServlet의 서비스!"); }
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("FirstServlet의 doGet!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("FirstServlet의 doPost!");
	}

}
