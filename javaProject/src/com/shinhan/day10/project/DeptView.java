// 05? 마지막시간 - 플젝 비슷 (데이터가 있다고 가정)
package com.shinhan.day10.project;

import java.util.List;

// 보여주는 것이 목적 (display 담당, 비즈니스 로직을 담당하거나 그런ㄱ ㅔ없음)
public class DeptView {
//	오버로딩
	public static void print(String message) {
		System.out.println("알림: " + message);
	}

	public static void print(DeptVO dept) {
		System.out.println("dept 정보: " + dept);
	}

	public static void print(List<DeptVO> deptlist) {
		System.out.println("--- dept list ---");
		for (DeptVO dept : deptlist) {
			System.out.println(dept);
		}
	}
}
