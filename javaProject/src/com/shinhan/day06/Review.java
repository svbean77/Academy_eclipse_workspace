// 01
package com.shinhan.day06;

// 1~5일차 복습
/*
 * 1. 변수: 데이터를 저장하기 위한 기억 장소 이름 (값 수정 가능)
 * 2. 상수: 데이터를 저장하기 위한 기억 장소 이름 (값 수정 불가능)
 * 3. enum: 관련 있는 상수들의 묶음
 * 4. method: 문장들의 묶음
 * 5. class: object를 만드는 틀 (변수 + 상수 + method + ...)
 * 6. object: class로 new한 실체 (heap 영역에 만들어짐)
 * 7. interface: 규격서 (상수 + 추상메소드 + default메소드 + static메소드 + private메소드 + private static메소드) 
 */
abstract class ParentClass {
	abstract void method1();
}

interface MyInterface {
	// 규격서
	// 보통 '~이 가능한'이라는 기능을 규정한 것이기 때문에 인터페이스명이 보통 -able임 (ex. resizable)
	void method2();
}

interface MyInterface2 {
	void method2_1();
}

interface MyInterface3 extends MyInterface, MyInterface2 {
	// interface는 다중상속 가능!!!1= -> 하위 구현 클래스는 다중상속을 전부 구현해야 함
	void method3_1();
}

class MyClass1 extends ParentClass implements MyInterface3 {
	void method1() {
		// 부모가 추상class이면 무조건 구현해야 함
		System.out.println("Myclass1 - method1");
	}

	public void method2() {
		// interface에서는 public을 생략해서 사용 가능 -> interface 구현하려면 무조건 public
		System.out.println("Myclass1 - method2");
	}

	@Override
	public void method2_1() {
		System.out.println("Myclass1 - method2-1");
	}

	@Override
	public void method3_1() {
		System.out.println("Myclass1 - method3-1");
	}
}

class MyClass2 extends ParentClass implements MyInterface {
	void method1() {
		// 부모가 추상class이면 무조건 구현해야 함
		System.out.println("Myclass2 - method1");
	}

	public void method2() {
		// interface에서는 public을 생략해서 사용 가능 -> interface 구현하려면 무조건 public
		System.out.println("Myclass2 - method2");
	}
}

public class Review {

	public static void main(String[] args) {
		ParentClass v1 = new MyClass1(); // 자동형변환
		ParentClass v2 = new MyClass2();

		work(v1);
		work(v2);
	}

	static void work(ParentClass c) {
		System.out.println(c instanceof MyClass1);
		System.out.println(c instanceof MyClass2);
		System.out.println(c instanceof ParentClass);
		System.out.println(c instanceof MyInterface);
		System.out.println(c instanceof MyInterface2);
		System.out.println(c instanceof MyInterface3);
		
		c.method1();
		if (c instanceof MyInterface3 my) {
			// MyInterface3 my = (MyInterface3) c;
			my.method2();
			my.method2_1();
			my.method3_1();
		}

	}

}
