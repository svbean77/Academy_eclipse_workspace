// 05 - 플젝
package com.shinhan.day10.project;

// Service: 비지니스 로직
import java.util.List;

// Service: Controller와 DAO의 접점 역할 (C가 요청한 정보를 DAO로 전달
// DAO에서 받은 응답을 Controller에게 전달
// DB와 상관 없는 Business logic 수행
public class DeptService {
	private DeptDAO dao = new DeptDAO();

	public List<DeptVO> selectAll() {
		return dao.selectAll();
	}

	public DeptVO selectById(int deptid) {
		return dao.selectById(deptid);
	}

	public void insert(DeptVO dept) {
		dao.insert(dept);
	}
}
