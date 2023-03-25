// 02 - f4()
package com.shinhan.day05;

public class HankookTire extends Tire {
	String info = "한국타이어 최고~";

	public void roll() {
		// 부모의 추상메소드는 반드시 overriding 해야 함!
		// 나 또한 누군가의 부모이면 나를 추상으로 만들고 자식에게로 roll 구현을 미룰 수 있음
		System.out.println("한국타이어가 굴러갑니다");
	}

	void method1() {
		System.out.println("한국타이어만 가지고 있는 method1!");
	}

};