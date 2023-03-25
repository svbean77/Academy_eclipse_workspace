package com.shinhan.day06;

public class Ch08Check {

	public static void main(String[] args) {
		ch08no01();
		ch08no02();
		ch08no03();
		ch08no04();
		ch08no05();
		ch08no06();
		ch08no07();
		ch08no08();

	}

	private static void ch08no08() {
		// 8장 확인문제 8
		action(new B8());
		action(new C8());
	}

	public interface A8 {
		public void method1();
	}

	public static class B8 implements A8 {
		public void method1() {
			System.out.println("B - method1()");
		}
	}

	public static class C8 implements A8 {
		public void method1() {
			System.out.println("C - method1()");
		}

		public void method2() {
			System.out.println("C - method2()");
		}
	}

	public static void action(A8 a) {
		a.method1();
		if (a instanceof C8 c) {
			c.method2();
		}
	}

	private static void ch08no07() {
		// 8장 확인문제 7번
		dbWork(new OracleDao());
		dbWork(new MysqlDao());

	}

	public static void dbWork(DataAccessObject dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	}

	interface DataAccessObject {
		void select();

		void insert();

		void update();

		void delete();
	}

	public static class OracleDao implements DataAccessObject {
		public void select() {
			System.out.println("Oracle DB에서 검색");
		}

		public void insert() {
			System.out.println("Oracle DB에 삽입");
		}

		public void update() {
			System.out.println("Oracle DB를 수정");
		}

		public void delete() {
			System.out.println("Oracle DB에서 삭제");
		}
	}

	public static class MysqlDao implements DataAccessObject {
		public void select() {
			System.out.println("MySql DB에서 검색");
		}

		public void insert() {
			System.out.println("MySql DB에 삽입");
		}

		public void update() {
			System.out.println("MySql DB를 수정");
		}

		public void delete() {
			System.out.println("MySql DB에서 삭제");
		}
	}

	private static void ch08no06() {
		// 8장 확인문제 6번
		printSound(new Cat());
		printSound(new Dog());

	}

	public interface Soundable {
		public String sound();
	}

	public static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
	}

	public static class Cat implements Soundable {
		public String sound() {
			return "야옹";
		}
	}

	public static class Dog implements Soundable {
		public String sound() {
			return "멍멍";
		}
	}

	private static void ch08no05() {
		// 8장 확인문제 5번
		Remocon r = new TV();
		r.powerOn();

	}

	public interface Remocon {
		public void powerOn();
	}

	public static class TV implements Remocon {
		public void powerOn() {
			System.out.println("TV를 켰습니다.");
		}
	}

	private static void ch08no04() {
		// 8장 확인문제 4번
		method(new B());
		method(new C());
		method(new D());
		method(new E());
	}

	interface A {
	}

	static class B implements A {
	}

	static class C implements A {
	}

	static class D extends B {
	}

	static class E extends C {
	}

	static void method(A a) {
	}

	private static void ch08no03() {
		// 8장 확인문제 3번
		// 1. 필드가 인터페이스 타입일 경우 다양한 구현 객체를 대입할 수 있다. -> O
		// 2. 매개변수가 인터페이스 타입일 경우 다양한 구현 객체를 대입할 수 있다. -> O
		// 3. 배열이 인터페이스 타입일 경우 다양한 구현 객체를 저장할 수 있다. -> O
		// 4. 구현 객체를 인터페이스 타입으로 변한하려면 강제 타입 변환을 해야 한다. -> X
	}

	private static void ch08no02() {
		// 8장 확인문제 2번
		// 1. 인터페이스는 인스턴스 필드가 없고 상수를 멤버로 가진다. -> O
		// 2. 추상 메소드는 구현 클래스가 재정의해야 하는 멤버이다. -> O
		// 3. 디폴트 메소드는 구현 클래스에서 재정의할 수 없다. -> X
		// 4. 정적 멤버는 구현 객체가 없어도 사용할 수 있는 멤버이다. - O

	}

	private static void ch08no01() {
		// 8장 확인문제 1번
		// 1. 인터페이스로 객체(인스턴스)를 생성할 수 있다. -> X
		// 2. 인터페이스는 다형성의 주된 기술로 사용된다. -> O
		// 3. 인터페이스를 구현한 객체는 인터페이스로 동일하게 사용될 수 있다. -> O
		// 4. 인터페이스를 사용함으로써 객체 교체가 쉬워진다. -> O

	}

}
