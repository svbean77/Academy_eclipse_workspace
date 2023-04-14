package com.shinhan.frontcontrollerpattern;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.shinhan.model.AdminService;
import com.shinhan.vo.AdminVO;

public class PictureAjaxController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		HttpServletResponse response = (HttpServletResponse) data.get("response");
		AdminService service = new AdminService();
		List<AdminVO> adminList = service.adminsPicture();
		// 1. JSP 만드는 방법
//		request.setAttribute("adminsPicture", adminList);
//		return "adminPicture.jsp";

		// 2. JSON 만드는 방법
		JSONArray arr = new JSONArray();
		for(AdminVO admin: adminList) {
			JSONObject obj = new JSONObject();
			obj.put("picture", admin.getPic());
			obj.put("name", admin.getManager_name());
			arr.add(obj);
		}
		
		JSONObject admins = new JSONObject();
		admins.put("adminsPicture", arr);
		response.setCharacterEncoding("UTF-8");
		return "responseBody:" + admins.toJSONString();
	}

}
