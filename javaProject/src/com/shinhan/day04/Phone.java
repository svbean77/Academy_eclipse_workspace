// 08
package com.shinhan.day04;

public class Phone {
	// public을 지우면 day05 패키지에서는 불러올 수 없음

	protected String model;
	// 1. 멤버 변수
	// public을 지우면 day05 패키지에서는 불러올 수 없음
	// 생략하면 같은 패키지에서는 사용할 수 있음
	// private은 동일 class 내에서만 사용할 수 있음
	// protected는 같은 패키지 or 상속 받은 class 내에서 사용

	public Phone() {
		// 2. 생성자
		// public을 지우면 day05 패키지에서는 불러올 수 없음
		// 생략하면 같은 패키지에서는 사용할 수 있음
		// private은 동일 class 내에서만 사용할 수 있음
		System.out.println("default 생성자 정의");
	}

	// 3. 일반 메소드
	public void f1() {
		System.out.println("public"); // 모든 패키지
	}

	protected void f2() {
		System.out.println("protected"); // 같은 패키지 + 상속받은 클래스

	}

	void f3() {
		System.out.println("default"); // 같은 패키지

	}

	private void f4() {
		System.out.println("private"); // 같은 클래스

	}

}
