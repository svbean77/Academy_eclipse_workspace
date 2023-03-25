// 10
package com.shinhan.day06;

public class CellPhone {
	String model;
	double battery;

	CellPhone(String model) {
		this.model = model;
	}

	void call(int time) {
		if (time < 0)
			throw new IllegalArgumentException("통화시간 입력 오류");

		battery -= (time * 0.5);
		if (battery < 0)
			battery = 0;
		System.out.println("통화 시간: " + time);
	}

	void charge(int time) {
		if (time < 0)
			throw new IllegalArgumentException("충전시간 입력 오류");

		battery += (time * 3);
		if (battery > 100)
			battery = 100;

		System.out.println("충전 시간: " + time);

	}

	void printBattery() {
		System.out.println("남은 배터리 양: " + battery);
	}

	public boolean equals(Object otherObject) {
		boolean result = false;

		if (otherObject instanceof CellPhone c) {
			if (this.model.equals(c.model)) {
				result = true;
			}
		}

		return result;
	}
}
