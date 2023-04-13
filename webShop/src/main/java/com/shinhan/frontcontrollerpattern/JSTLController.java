package com.shinhan.frontcontrollerpattern;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.shinhan.vo.AdminVO;

public class JSTLController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		
		// scope 복습
		application.setAttribute("myName", "앱길동가나다라마바사");
		session.setAttribute("myName", "세션길동가나다라마바사");
		request.setAttribute("myName", "리퀘길동가나다라마바사");
		
		// forEach 복습
		List<AdminVO> adminList = new ArrayList<>();
		adminList.add(new AdminVO("aa@com", "1철수", "1234"));
		adminList.add(new AdminVO("bb@com", "2철수", "1234"));
		adminList.add(new AdminVO("cc@com", "3철수", "1234"));
		request.setAttribute("admins", adminList);
		
		// if 복습
		request.setAttribute("score", 89);
		
		// format 태그 사용
		request.setAttribute("today", new Date());
		
		return "/jsptest/jstlTest3.jsp"; 
//		return "jsptest/jstlTest3.jsp"; // /webShop이 생략되어 있기 때문에 절대, 상대 둘 다 가능 (이 경우에는) 
	}

}
