package com.shinhan.day05;

public class ch07Check {

	public static void main(String[] args) {
		ch07no01();
		ch07no02();
		ch07no03();
		ch07no04();
		ch07no05();
		ch07no07();
		ch07no08();
		ch07no09();
		ch07no12();

	}

	private static void ch07no12() {
		// 7장 확인문제 12번
		action(new A12());
		action(new B12());
		action(new C12());

	}

	public static class A12 {
		// 7장 확인문제 12번
		public void method1() {
			System.out.println("A-method1()");
		}
	}

	public static class B12 extends A12 {
		// 7장 확인문제 12번
		public void method1() {
			System.out.println("B-method1()");
		}
	}

	public static class C12 extends A12 {
		// 7장 확인문제 12번
		public void method1() {
			System.out.println("C-method1()");
		}

		public void method2() {
			System.out.println("C-method2()");
		}
	}

	public static void action(A12 a) {
		// 7장 확인문제 12번
		a.method1();
		if (a instanceof C12 c) {
			c.method2();
		}
	}

	public static class Activity {
		// 7장 확인문제 11번
		public void onCreate() {
			System.out.println("기본적인 실행 내용");
		}
	}

	public static class MainActivity extends Activity {
		// 7장 확인문제 11번
		@Override
		public void onCreate() {
			super.onCreate();
			System.out.println("추가적인 내용 실행");
		}
	}

	public static class Computer extends Machine {
		// 7장 확인문제 10번
		// 부모 class의 추상메소드를 구현하지 않았다.
		public void work() {
		}
	}

	public static abstract class Machine {
		// 7장 확인문제 10번
		public void powerOn() {
		}

		public void powerOff() {
		}

		public abstract void work();

	}

	private static void ch07no09() {
		// 7장 확인문제 9번
		B b1 = new B();
		// B b2 = (B) new A();
		B b3 = new D();
		B b4 = new E();

	}

	static class A {
	}

	static class B extends A {
	}

	static class C extends A {
	}

	static class D extends B {
	}

	static class E extends B {
	}

	static class F extends C {
	}

	private static void ch07no08() {
		// 7장 확인문제 8번
		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire;

		snowTire.run();
		tire.run();

		// 출력 결과
		// 스노우 타이어가 굴러갑니다.
		// 스노우 타이어가 굴러갑니다.
	}

	public static class Tire {
		// 7장 확인문제 8번
		public void run() {
			System.out.println("일반 타이어가 굴러갑니다.");
		}
	}

	public static class SnowTire extends Tire {
		// 7장 확인문제 8번
		@Override
		public void run() {
			System.out.println("스노우 타이어가 굴러갑니다.");
		}
	}

	private static void ch07no07() {
		// 7장 확인문제 7번
		Child07 child = new Child07();

		// 출력 결과
		// Parent(String nation) call
		// Parent() call
		// Child(String) call
		// Child() call

	}

	public static class Parent07 {
		// 7장 확인문제 7번
		public String nation;

		public Parent07() {
			this("대한민국");
			System.out.println("Parent() call");
		}

		public Parent07(String nation) {
			this.nation = nation;
			System.out.println("Parent(String nation) call");
		}
	}

	public static class Child07 extends Parent07 {
		// 7장 확인문제 7번
		public String name;

		public Child07() {
			this("홍길동");
			System.out.println("Child() call");
		}

		public Child07(String name) {
			this.name = name;
			System.out.println("Child(String) call");
		}
	}

	public static class Parent {
		// 7징 확인문제 6번
		public String name;

		public Parent(String name) {
			this.name = name;
		}

	}

	public static class Child extends Parent {
		// 7징 확인문제 6번
		public int studentNo;

		public Child(String name, int studentNo) {
			// 코드의 맨 첫 부분에서 super()를 불러오는데 부모 class에 기본 생성자가 존재하지 않는다.
			// 문제를 해결하기 위해 부모 class에 기본 생성자를 만들거나 생성자를 명시적으로 호출해야 한다.
			super(name);
			this.name = name;
			this.studentNo = studentNo;
		}
	}

	private static void ch07no05() {
		// 7장 확인문제 5번
		// 1. 직접 객체를 생성할 수 없고, 상속만 할 수 있다. -> O
		// 2. 추상 메소드를 반드시 가져야 한다. -> X
		// 3. 추상 메소드는 자식 클래스에서 재정의 (오버라이딩)할 수 있다. -> O
		// 4. 추상 메소드를 재정의하지 않으면 자식 클래스도 추상 클래스가 되어야 한다. -> O

	}

	private static void ch07no04() {
		// 7장 확인문제 4번
		// 1. 부모 메소드의 시그니처(리턴 타입, 메소드명, 매개변수)와 동일해야 한다. -> O
		// 2. 부모 메소드보다 좁은 접근 제한자를 붙일 수 없다. (예: public(부모) -> private(자식)) -> O
		// 3. @Override 어노테이션을 사용하면 재정의가 확시란지 컴파일러가 검증한다. -> O
		// 4. protected 접근 제한을 갖는 메소드는 다른 패키지의 자식 클래스에서 재정의할 수 없다. -> X

	}

	private static void ch07no03() {
		// 7장 확인문제 3번
		// 1. final 클래스는 부모 클래스로 사용할 수 있다. -> X
		// 2. final 필드는 초기화된 후에는 변경할 수 없다. -> O
		// 3. final 메소드는 재정의(오버라이딩)할 수 없다. -> O
		// 4. static final 필드는 상수를 말한다. -> O

	}

	private static void ch07no02() {
		// 7장 확인문제 2번
		// 1. 자식 객체는 부모 타입으로 자동 타입 변환된다. -> O
		// 2. 부모 객체는 어떤 자식 타입으로도 강제 타입 변환된다. -> X
		// 3. 자동 타입 변환을 이용해서 필드와 매개변수의 다형성을 구현한다. -> O
		// 4. 강제 타입 변환 전에 instanceof 연산자로 변환 가능한지 검사하는 것이 좋다. -> O

	}

	private static void ch07no01() {
		// 7장 확인문제 1번
		// 1. 자바는 다중 상속을 허용한다. -> X
		// 2. 부모의 메소드를 자식 클래스에서 재정의(오버라이딩) 할 수 있다. -> O
		// 3. 부모의 private 접근 제한을 갖는 필드와 메소드는 상속의 대상이 아니다. -> O
		// 4. final 클래스는 상속할 수 없고, final 메소드는 오버라이딩할 수 없다. -> O

	}

}
