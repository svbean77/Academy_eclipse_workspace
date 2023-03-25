// 06 내가 해보는 MVC2
package aproject.view;

import java.util.List;

import aproject.vo.DeptVO;

public class DeptView {
	public static void print(List<DeptVO> deptlist) {
		System.out.println("----- 모든 부서 정보 -----");
		for (DeptVO dept : deptlist) {
			System.out.println(dept);
		}
	}

	public static void print(DeptVO dept) {
		System.out.println("----- 해당 부서 정보 -----");
		if (dept == null) {
			print("존재하지 않는 부서입니다.");
		} else {
			System.out.println(dept);
		}
	}

	public static void print(String message) {
		System.out.println("[알림] " + message);
	}
}
