package com.shinhan.frontcontrollerpattern;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.shinhan.model.AdminService;
import com.shinhan.vo.AdminVO;

public class SignUpController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		
		String mname = request.getParameter("manager_name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		AdminService service = new AdminService();
		AdminVO admin = new AdminVO(email, mname, pass);
		int result = service.registerAdmin(admin);
		
		return "redirect:loginCheck.do";
	}

}
