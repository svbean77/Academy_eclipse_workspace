package com.shinhan.frontcontrollerpattern;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.shinhan.model.EmpService;
import com.shinhan.vo.EmpVO;

public class EmpListController implements CommonControllerInterface{
	@Override
	public String execute(Map<String, Object> data) throws Exception {
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		
		EmpService service = new EmpService();
		List<EmpVO> emplist = service.selectAll();

		request.setAttribute("empAll", emplist); 

		return "empSelect.jsp";
	}

}
