package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/param")
public class ParameterTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid"); // parameter 이름을 아는 경우
		String salary = request.getParameter("salary");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");

		// 칼럼이 너무 많아! 내가 파라미터 이름을 어떻게 다 써! -> parameter 이름만 불러와서(열거형) 하나씩 데리고 오자 (nextElement)
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String param = paramNames.nextElement();
			if (param.equals("hobby")) {
				String[] value = request.getParameterValues(param);
				System.out.println(param + ": " + Arrays.toString(value));
			} else {
				String value = request.getParameter(param);
				System.out.println(param + ": " + value);
			}
		}
		System.out.println("---------------------------------");

		System.out.println("userid: " + userid);
		System.out.println("salary: " + salary);
		System.out.println("gender: " + gender);
		System.out.println("hobby: " + Arrays.toString(hobby));

		// 응답 문서
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String str = "<table border='1'><caption>내가 입력한 정보</caption>";
		str += "<tr><td>아이디</td><td>" + userid + "</td></tr>";
		str += "<tr><td>급여</td><td>" + salary + "</td></tr>";
		str += "<tr><td>성별</td><td>" + gender + "</td></tr>";
		str += "<tr><td>취미</td><td>" + Arrays.toString(hobby) + "</td></tr>";
		str += "</table>";
		out.print(str);
	}

}
