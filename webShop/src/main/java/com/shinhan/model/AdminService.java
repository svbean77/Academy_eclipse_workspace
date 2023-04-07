package com.shinhan.model;

import com.shinhan.vo.AdminVO;

public class AdminService {
	AdminDAO dao = new AdminDAO();

	// day031
	public AdminVO loginCheck(String email, String pass) {
		return dao.loginCheck(email, pass);
	}
	
	// day032
	public int registerAdmin(AdminVO admin) {
		return dao.registerAdmin(admin);
	}
	
	// day033
	public int dupCheck(String email) {
		return dao.dupCheck(email);
	}
}
