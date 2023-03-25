// 04 - f1()
package com.shinhan.day05;

// interface: 규격서 (정의만 있고 구현은 없음)
public interface JDBCInterface {
	// 1. 상수 (변수는 선언할 수 없음 -> modifier(public static final)를 생략할 수 있음)
	public static final String JDBC = "JAVA Database Connection";
	String JDBC2 = "Java Database Connection2"; // interface에서의 생략은 public임!!!!

	// 2. 추상메소드 (modifier(public abstract)를 생략할 수 있음)
	public abstract void dbConnect(String dbName);
	void dbConnect2(String dbName); // interface에서의 생략은 public임!!!!

	// 3번부터는 상위 버전에서 추가된 내용
	// 3. default 메소드 (public 생략 가능)
	default void select() {
		// 인터페이스를 받는 모든 클래스에 동일한 코드가 적용되었으면 좋겠다
		System.out.println("default method: 인터페이스를 구현한 모든 class의 공통 코드");
		System.out.println("구현 class에서 overriding(재정의) 가능");
		insert();
	}

	// 4. static 메소드
	static void update() {
		// 인터페이스가 공유하는 코드: Interface.함수로 작성
		System.out.println("static method: 인터페이스가 공유하는 코드");
		System.out.println("구현 class에서 overriding(재정의) 불가능!!!!!!!");
//		insert(); // static에서 instance 사용 불가능
		insert2();
	}

	// 5. private 메소드
	private void insert() {
		// 해당 interface 내부에서만 사용 가능
		// non-static method에서 호출 가능 (default에서 호출)
		System.out.println("-------------------------------------------------");
	}

	// 6. private static 메소드
	private static void insert2() {
		// 해당 interface 내부에서만 사용 가능
		// static method에서 호출 가능 (static, default에서 호출)
		System.out.println("-------------------------------------------------");
	}
}
