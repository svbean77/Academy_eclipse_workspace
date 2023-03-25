// day015 - 05 -  미니 프로젝트 (개인 프로젝트 MVC2 model 연습하기)
// day016 - 02 - 추가 기능
// 4. View: 출력하는 로직 만들자
package aproject.view;

import java.util.List;

import aproject.vo.EmpVO;

public class EmpView {
//	객체 지향 프로그래밍의 장점: 오버로딩!! (매개변수 사양이 다른 같은 함수 정의)
//	day015
	public static void print(List<EmpVO> emplist) {
		System.out.println("----- 직원들 상세 정보 -----");

		for (EmpVO emp : emplist) {
			System.out.println(emp);
		}
	}

//	day015
	public static void print(EmpVO emp) {
		System.out.println("----- 직원 상세 정보 -----");
		if (emp == null) {
			print("직원이 존재하지 않습니다.");
		} else {
			System.out.println(emp);
		}
	}

//	day015
	public static void print(String message) {
		System.out.println("[알림] " + message);
	}
}
