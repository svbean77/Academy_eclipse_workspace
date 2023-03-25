// 05? 마지막시간 - 플젝 비슷 (데이터가 있다고 가정)
package com.shinhan.day10.project;

import java.util.List;

// Controller: 사용자의 요청 (여기는 없으니까 main으로 하자)을 받아 Service로 보냄
// Service의 응답 결과를 View를 통해 display
public class DeptController {
	public static void main(String[] args) {
		DeptService service = new DeptService();

//		삽입
		DeptVO[] arr = { new DeptVO(10, "개발부", 200, 2700), new DeptVO(20, "영업부", 200, 2700),
				new DeptVO(30, "총무부", 200, 2700), new DeptVO(40, "R&D", 200, 2700),
				new DeptVO(50, "SI사업부", 200, 2700) };

		for (DeptVO dept : arr) {
			service.insert(dept);
		}

//		전체 조회 및 출력
		List<DeptVO> deptlist = service.selectAll();
		DeptView.print(deptlist);

//		찾기 및 출력
		DeptVO searchVO = service.selectById(40);
		DeptView.print(searchVO);
	}
}
