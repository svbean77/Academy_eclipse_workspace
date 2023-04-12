package com.shinhan.frontcontrollerpattern;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.shinhan.vo.AdminVO;

public class LogoutController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		HttpServletRequest request = (HttpServletRequest) data.get("request");	
		ServletContext app = request.getServletContext();
		HttpSession session = request.getSession();
		AdminVO admin = (AdminVO) session.getAttribute("loginUser");
		
		Object obj = app.getAttribute("userList");
		List<AdminVO> userList = null;

		if(obj != null) {
			userList = (List<AdminVO>) obj;
			userList.remove(admin);
			app.setAttribute("userList", userList);
		}
		
		request.getSession(false).invalidate();
		return "responseBody:OK";
	}

}
