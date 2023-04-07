package com.shinhan.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.vo.EmpVO;

@WebServlet("/get")
public class ServletContextTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// servletContext(=application)에 저장하기
		ServletContext app = request.getServletContext();

		int score = (Integer) app.getAttribute("score");
		String name = (String) app.getAttribute("studentname");
		EmpVO emp = (EmpVO) app.getAttribute("empinfo");

		System.out.println("score: " + score);
		System.out.println("name: " + name);
		System.out.println("emp: " + emp);

		String realPath = app.getRealPath("."); 
		// 이 프로그램이 돌고 있는 위치 얻을 수 있음! (실제 실행되고 있는 그 복잡한 경로)
		// 하지만 실제 내 컴퓨터인 C:~~~~의 경로에 브라우저는 접근할 수 없어 -> 실행 경로로 설정할 때는 불가능!
		System.out.println("현재 위치: " + realPath);

		String id = app.getInitParameter("DB_userid");
		String pass = app.getInitParameter("DB_userpass");
		System.out.println(id + " -- " + pass);
		
		InputStream is = app.getResourceAsStream("/WEB-INF/resource/dbinfo.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String s;
		
		 while((s = br.readLine()) != null) {
			 System.out.println(s);
		 }
		 br.close();
	}

}
