// 02 - f4()
package com.shinhan.day05;

public class KumhoTire extends Tire {
	String intro = "최고~~";

	public void roll() {
		// 부모의 추상메소드는 반드시 overriding 해야 함!
		System.out.println("금호타이어가 굴러갑니다");
	}

	void method2() {
		System.out.println("금호타이어만 가지고 있는 method2!");
	}
}
