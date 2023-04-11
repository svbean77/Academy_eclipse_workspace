package com.shinhan.frontcontrollerpattern;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.shinhan.model.EmpService;
import com.shinhan.util.DateUtil;
import com.shinhan.vo.EmpVO;

public class EmpDetailController implements CommonControllerInterface {
	public String execute(Map<String, Object> data) throws Exception {
		String method = (String) data.get("method");
		String page = "empDetail.jsp";
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		
		if(method.equals("GET")) {
			int empid = Integer.parseInt(request.getParameter("empid"));
			
			EmpService service = new EmpService();
			EmpVO emp = service.selectById(empid);
			
			request.setAttribute("emp", emp); 
		}
		else {
			EmpVO emp = makeEmp(request);
			EmpService service = new EmpService();
			String message = service.empUpdate(emp);
			
			page = "redirect:emplist.do";
		}
		
		return page;
	}
	
	private EmpVO makeEmp(HttpServletRequest request) throws UnsupportedEncodingException {
		int empid = Integer.parseInt(request.getParameter("employee_id")); 
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
		emp.setEmployee_id(empid); 
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
