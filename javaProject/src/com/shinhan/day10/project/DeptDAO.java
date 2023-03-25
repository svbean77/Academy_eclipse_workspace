// 05? 마지막시간 - 플젝 비슷 (데이터가 있다고 가정)
package com.shinhan.day10.project;

import java.util.*;

// CRUD 작업(Create(=Insert), Read(=Select), Update, Delete)

// DAO: Data Access Object
// 업무 로직이 존재 (DB와 연계되는 내용)
public class DeptDAO {
	private List<DeptVO> data = new ArrayList<>();

	List<DeptVO> selectAll() {
//		모두 조회

		/*
		 * DB 가서 데이터 가져오는 코드 추가 select * from departments;
		 */

		return data;
	}

	public DeptVO selectById(int deptid) {
		for (DeptVO dept : data) {
			if (dept.getDepartment_id() == deptid)
				return dept;
		}
		return null;
	}

	public void insert(DeptVO dept) {
		data.add(dept);
	}
}
