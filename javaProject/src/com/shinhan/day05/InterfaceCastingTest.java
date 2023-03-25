// 05
package com.shinhan.day05;

interface interA {
	void method1();
}

class classB implements interA {
	public void method1() {
		System.out.println("B class에서의 method1 재정의");
	}
}

class classC implements interA {
	public void method1() {
		System.out.println("C class에서의 method1 재정의");
	}
}

class classD extends classB {
	public void method1() {
		System.out.println("D class에서의 method1 재정의");
	}

	public void method2() {
		System.out.println("D class에서의 method2");
	}
}

class classE extends classC {
	public void method1() {
		System.out.println("E class에서의 method1 재정의");
	}
}

public class InterfaceCastingTest {

	public static void main(String[] args) {
		// p.368 그림 구현
		// 자동형변환 (new 하는 것은 자동 형변환! 억지로 (D) a 넣는 것이 강제 형변환!)
		interA v1 = new classD();
		classB v2 = new classD();
		classD v3 = new classD();

		// D, E에서 재정의하지 않았을 때
//		v1.method1(); // B에 재정의한 코드가 있음 (A가 B로 타고 내려옴)
//		v2.method1(); // B에 재정의한 코드가 있음 (B가 그대로 실행됨)
//		v3.method1(); // 자신에게 없기 때문에 부모인 B에게 감

		v1.method1(); // A -> B -> D
		v2.method1(); // B -> D
		v3.method1(); // D

		// 강제형변환: D를 넣었던 것이기 때문에 D로 형변환하는 것이 가능!
		((classD) v1).method2();
		((classD) v2).method2();
		((classD) v3).method2();

// 		classE e = (classE) v1; // 실행오류: D였던 애를 E로 바꿀 수는 없음..

	}

}
