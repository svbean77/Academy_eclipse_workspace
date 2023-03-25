// 08 - ???
// day06 04
package com.shinhan.day05;

public abstract class Machine {
	public int a = 10;
	protected int b = 20;
	int c = 30;
	private int d = 40;

	public void f1() {
	}

	protected void f2() {
	}

	void f3() {
	}

	private void f4() {
	}

	// 추상클래스는 객체 생성을 못하기 때문에 생성자 사용 X
	// 상속받은 자식을 위한 생성자임
	public Machine(int a) {

	}

	public void powerOn() {
	}

	public void powerOff() {
	}

	public abstract void work();
}
