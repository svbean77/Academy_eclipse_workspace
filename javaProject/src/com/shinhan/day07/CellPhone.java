// 07
package com.shinhan.day07;

//12장 LAB1 교수님 풀이
public class CellPhone {
	String model;
	double battery;

	CellPhone(String model) {
		this.model = model;
	}

	void call(int time) {
		if (time < 0)
//			IllegalArgumentException은 RuntimeException이기 때문에 자동으로 throws (작성 안 해도 됨)
//			강제 Exception 발생, 처리는 안 함(RuntimeException)
			throw new IllegalArgumentException("통화시간입력오류");

		battery -= time * 0.5;
		if (battery < 0)
			battery = 0;

		System.out.println("통화 시간: " + time + "분");
	}

	void charge(int time) {
		if (time < 0)
			throw new IllegalArgumentException("충선시간입력오류");

		battery += time * 3;
		if (battery > 100)
			battery = 100;

		System.out.println("충전 시간: " + time + "분");
	}

	void printBattery() {
		System.out.println("남은 배터리 양: " + battery);
	}

	@Override
//	함수이름, 매개변수 개수+타입, ruturn타입 같아야 하고 접근 제한자는 같거나 넓어져야 함
//	매개변수 개수+타입이 달라지면 overloading임 (여러 개 작성)
	public boolean equals(Object obj) {
//		CellPhone의 instance가 아닌 경우 바꾸면 안됨! (에러)
		if (obj instanceof CellPhone) {
			CellPhone p = (CellPhone) obj;
//			this.model == p.model은 주소를 비교하는 것 -> new할 때 조작하면 다른 주소가 되는 것..
//			따라서 문자열 비교이기 때문에 equals를 사용해서 내용을 비교하자~
			return this.model.equals(p.model);
		} else
			return false;

	}
}

