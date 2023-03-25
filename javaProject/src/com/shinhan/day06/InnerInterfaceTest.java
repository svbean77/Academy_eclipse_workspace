// 02
package com.shinhan.day06;

public class InnerInterfaceTest {

	public static void main(String[] args) {
		Button b = new Button();
		Button.ClickListener listener = new OKListener();
		b.setListener(listener);
		b.buttonClick();

		Button.ClickListener listener2 = new CancelListener();
		b.setListener(listener2);
		b.buttonClick();

		// 함수로 묶어서 부르는 버전
		System.out.println("(((((( 함수로 묶어 부르는 버전 ))))))");
		Button b1 = new Button();
		Button b2 = new Button();

		OKListener ok = new OKListener(); // 클래스에 넣는 것도 가능 (어차피 함수 들어가면 자동 형변환)
		Button.ClickListener cancel = new CancelListener();

		test(b1, ok);
		test(b2, cancel);
	}

	static void test(Button b, Button.ClickListener listener) {
		// 어떤 버튼, 어떤 리스너?
		b.setListener(listener); // callback (나중에 배움)
		b.buttonClick();

	}
}
