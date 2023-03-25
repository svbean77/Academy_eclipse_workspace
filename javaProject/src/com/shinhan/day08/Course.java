// 04
package com.shinhan.day08;

//책 p.584
public class Course {
//	모든 사람이 등록 가능
	public static void registerCourse1(Applicant<?> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) course1 등록 (all)");
	}

//	학생만 등록 가능 (Student의 상속: Student, HighStudent, MiddleStudent)
//	extends: 상위를 제한 (상속받은 class만 가능이니 상위는 사용할 수 없음)
	public static void registerCourse2(Applicant<? extends Student> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) course2 등록 (student)");
	}

//	직장인 및 일반인 등록 가능 (Worker의 상위: Worker, Person)
//	super: 하위를 제한 (나를 상속한 class만 가능이니 하위는 사용할 수 없음)
	public static void registerCourse3(Applicant<? super Worker> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) course3 등록 (worker 이상)");
	}
}
