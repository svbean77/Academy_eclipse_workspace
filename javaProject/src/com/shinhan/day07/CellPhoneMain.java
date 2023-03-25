// 07
package com.shinhan.day07;

//12장 LAB1 교수님 풀이
public class CellPhoneMain {

	public static void main(String[] args) {
		CellPhone myPhone = new CellPhone("SCH-600");

		myPhone.charge(20); // 20분간 충전을 한다.
		myPhone.printBattery();

		myPhone.call(300); // 300분간 통화를 한다.
		myPhone.printBattery();

		myPhone.charge(50); // 50분간 충전을 한다.
		myPhone.printBattery();

		myPhone.call(40); // 40분간 통화를 한다.
		myPhone.printBattery();

		try {
			myPhone.call(-20); // 통화시간이 잘못 입력되었다.
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		CellPhone yourPhone = new CellPhone("SCH-600");

//		주소로는 다른 객체임! (new로 생성되었기 때문에 각각이 객체잖아)
//		Object.equals()는 기본적으로 객체 주소를 비교하는 함수 (String.equals()는 내용 비교! overriding 했어)
		System.out.println(System.identityHashCode(myPhone));
		System.out.println(System.identityHashCode(yourPhone));

		if (myPhone.equals(yourPhone)) {
			System.out.println("동일 모델입니다.");
		} else {
			System.out.println("다른 모델입니다.");
		}
	}
}
