// 02
package com.shinhan.day06;

public class Button {
	// field
	private ClickListener listener; // new를 한 것이 아니기 때문에 객체 생성이 아님! 인터페이스 변수는 가능

	// method
	void setListener(ClickListener listener) {
		this.listener = listener; // new 한 객체가 listener로 들어오면 그거를 ClickListener 타입으로 저장
		// new한 클래스는 구현 클래스임!
	}

	public void buttonClick() {
		listener.onClick();
	}

	// 중첩 인터페이스 (class의 멤버 변수로 존재하는 인터페이스)
	// button class 내부에서만 사용하고싶은 규격서이기 때문에 button class 내부에서 선언하는 것! 
	// (외부에서 선언하면 다른 사람들이 쓰잖아)
	static interface ClickListener {
		void onClick();
	}
}
