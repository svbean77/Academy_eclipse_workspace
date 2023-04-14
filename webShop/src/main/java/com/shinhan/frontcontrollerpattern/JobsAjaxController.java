package com.shinhan.frontcontrollerpattern;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.shinhan.model.CompanyService;
import com.shinhan.vo.JobVO;

public class JobsAjaxController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		// 문의하기를 누르면 모든 job을 조회! (공지사항에 넣어두자)
		// javascript로 작성된 ajax 부분에 전달할 때 어떻게 전달할 것인가?
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		CompanyService service = new CompanyService();
		List<JobVO> jobList = service.jobSelectAll();
		
		// 방법 1. JSP 만들어 보내기
		// +) 디자인을 jsp로 하기 때문에 쉬움(html 사용 가능)
//		request.setAttribute("jobList", jobList);
//		return "jobView.jsp";
				
		// 방법 2. JSON 만들어 보내기
		// -) js로 디자인해야 하기 때문에 어려움
		JSONArray arr = new JSONArray();
		for(JobVO job: jobList) {
			JSONObject obj = new JSONObject();
			obj.put("job_id", job.getJob_id());
			obj.put("job_title", job.getJob_title());
			arr.add(obj); // [{}, {}, {}] // 이거는 json 형태가 아니고 array 형태이기 때문에 나중에 파싱할 수 없어!
		}
		// 나는 {"jobList":[]}의 타입을 원함! (파싱해야 함)
		JSONObject jobsObj = new JSONObject();
		jobsObj.put("jobList", arr);
		
		return "responseBody:" + jobsObj.toJSONString();
	}

}
