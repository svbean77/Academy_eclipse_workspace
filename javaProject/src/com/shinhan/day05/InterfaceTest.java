// 04
package com.shinhan.day05;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class InterfaceTest {

	public static void main(String[] args) {
		f1();
		f2();
		f3();
		f5();

	}

	private static void f5() {
		// 자료구조 미리보기: List, Set, Map <- interface들임.
		System.out.println("** 함수 f5 실행 **");
		String[] arr = new String[] { "자바", "SQL", "WEB", "Spring" };

		// List(interface): 순서가 있다. 중복을 허용한다. -> 구현클래스: ArrayList, Vector, LinkedList
		// Set(interface): 순서가 없다. 중복을 허용하지 않는다.

		Vector<String> data = new Vector<String>();
//		data.add(10); // 원래의 ArrayList는 타입 상관 없음 -> 그게 단점이 될 수 있으니 generic으로 만듦
		data.add("Java");
		data.add("SQL");
		data.add("WEB");
		data.add("Java");

		ArrayList<String> data2 = new ArrayList<String>();
		data2.add("Java");
		data2.add("SQL");
		data2.add("WEB");
		data2.add("Java");

		print(data);
		print(data2);

	}

	static void print(List<String> data) {
		// ArrayList, Vector 등등 전부 List이기 때문에 interface로 적어줌
		for (String str : data) {
			System.out.print(str + " ");
		}
		System.out.println();
	}

	private static void f3() {
		System.out.println("** 함수 f3 실행 **");
		f4(new Television());
		System.out.println("---------------------------------");
		f4(new Audio());
	}

	// 자동형변환 + 오버라이딩 -> 다형성: 사용법은 같고 결과는 다양함
	private static void f4(RemoteControl remote) { // 자동형변환 (부모 = 자식)
		// Television, Audio 둘 다 받기 위해 interface로 적어둠
		remote.powerOn();

		remote.display();
		RemoteControl.display2(); // interface의 static method
		if (remote instanceof Audio audio) {
			// 다중 인터페이스의 다른 메소드도 출력
			audio.wifiTurnOn();

			// 우연히 이름이 같았던 Audio의 함수 호출: 강제형변환 해야 함
			audio.display2();
		}
		if (remote instanceof Wifi wifi) {
			wifi.wifiTurnOn();
		}

		remote.powerOff();
	}

	private static void f2() {
		System.out.println("** 함수 f2 실행 **");
		String s1 = "Z";
		String s2 = "A";

		System.out.println(s1.compareTo(s2)); // 사이에 25개의 문자가 존재
	}

	private static void f1() {
		// Oracle DB 사용
		// Sybase DB 사용
		System.out.println("** 함수 f1 실행 **");
		// 1. 객체 생성
		OracleDB db1 = new OracleDB();
		SybaseDB db2 = new SybaseDB();

		// 사용한다-라는 기능을 함께 사용하고 싶음 -> Interface를 매개변수로 전달
		use(db1);
		use(db2);
	}

	private static void use(JDBCInterface db) {
		db.dbConnect("데이터베이스");

	}

}
