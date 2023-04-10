package com.shinhan.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.EmpService;
import com.shinhan.util.DateUtil;
import com.shinhan.vo.EmpVO;

@WebServlet("/emp/empinsert.do")
public class EmpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// index.jsp에서 직원등록 페이지를 누름
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("empInsert.jsp"); // 이 화면을 보여줘!
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력된 파라미터를 읽어 실제 직원 등록! (DB에 저장하기 위함)
		EmpVO emp = makeEmp(request);
		EmpService service = new EmpService();
		String message = service.empInsert(emp);
		
		// 재요청: browser로 내려가서 새로운 요청(emplist.do)으로 감
		response.sendRedirect("emplist.do");
	}

	private EmpVO makeEmp(HttpServletRequest request) throws UnsupportedEncodingException {
//		request.setCharacterEncoding("utf-8"); // filter에서 수행 함!
		// int empid = Integer.parseInt(request.getParameter("employee_id")); // 시퀀스니까 읽을 필요 없어 그냥 빼!
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		double salary = Double.parseDouble(request.getParameter("salary"));
		int department_id = Integer.parseInt(request.getParameter("department_id"));
		int manager_id = Integer.parseInt(request.getParameter("manager_id"));
		double commission_pct = Double.parseDouble(request.getParameter("commission_pct"));
		Date hire_date = DateUtil.convertToDate(request.getParameter("hire_date"));
		String job_id = request.getParameter("job_id");
		
		EmpVO emp = new EmpVO();
		emp.setCommission_pct(commission_pct);
		emp.setDepartment_id(department_id);
		emp.setEmail(email);
		// emp.setEmployee_id(empid); // 시퀀스니까 읽을 필요 없어 그냥 빼!
		emp.setFirst_name(first_name);
		emp.setHire_date(hire_date);
		emp.setJob_id(job_id);
		emp.setLast_name(last_name);
		emp.setManager_id(manager_id);
		emp.setPhone_number(phone_number);
		emp.setSalary(salary);
		
		System.out.println(emp);
		return emp;
	}
	
	

}
