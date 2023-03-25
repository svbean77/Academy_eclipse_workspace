// 01
package com.shinhan.day05;

// final이 붙을 수 있는 3가지: class, field, method
// final class 클래스명: 해당 클래스를 상속받을 수 없음 (내가 마지막 자식)
// final field: 값 수정 불가능
// final method: 함수 재정의 불가 (자식이 override 할 수 없음)
class Parent {
	// 부모는 자식이 누군지 모름!

	int a = 10; // Child에서 a가 없으면 부모의 a를 사용

	Parent() {
		System.out.println("부모의 생성자입니당");
	}

	void method1() {
		System.out.println("부모의 method1");
	}

	void method3() {
		System.out.println("부모의 method3");
	}
}

class Child extends Parent {
	// 자식은 부모를 앎! (자식이 부모를 선택)
// 	String a = "java"; // Child에서 a가 있으면 자신의 a를 사용 (=부모의 a를 덮어쓰기)
	int b = 20;

	Child() {
		// super(); -> new Child()를 하면 부모의 생성자가 먼저 불려짐 (Object -> Parent -> Child)
		System.out.println("자식의 생성자입니당");
	}

	void method3() {
		// overriding: 덮어쓰기
		System.out.println("자식의 method3");
	}

	void method3(String str) {
		// overloading: 덮어쓰기가 아님!

	}

	void method2() {
		System.out.println("자식의 method2");
	}
}

public class InheritenceTest2 {

	public static void main(String[] args) {

		f1();
		f2();
		f3();

	}

	private static void f3() {
		// 상속 형변환 예제: 부모를 통해 자식을 본다 -> 부모의 변수, method만 호출 가능
		System.out.println("** 함수 f2 실행 **");

		// 부모의 타입으로 선언
		Parent ch = new Child();
		System.out.println(ch.a + " "); // + ch.b);
		ch.method1();
		// ch.method2();
		ch.method3(); // override는 자식의 함수 호출 가능!!!

	}

	private static void f2() {
		// 상속 형변환 예제
		System.out.println("** 함수 f2 실행 **");

		// 자신의 타입으로 선언
		Child ch = new Child();
		System.out.println(ch.a + " " + ch.b);
		ch.method1();
		ch.method2();
		ch.method3();

	}

	private static void f1() {
		// Student, exchangeStudemt class를 테스트
		System.out.println("** 함수 f1 실행 **");
		Student st1 = new Student("123", "홍길동");
		Student st2 = new Student("456", "김철수", "컴퓨터공학");
		Student st3 = new Student("789", "김영희", "컴공", 99);
		ExchangeStudent st4 = new ExchangeStudent("012", "교환이", new String[] { "영어", "프랑스어" });

		// 각 class에서 toString을 재정의했기 때문에 주소가 아닌 문자열이 출력!
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st3);
		System.out.println(st4);

		System.out.println(Student.getCount() + "명의 학생이 있다!");

	}

}
