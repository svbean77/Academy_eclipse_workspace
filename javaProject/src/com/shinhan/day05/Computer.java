// 08 - ???
package com.shinhan.day05;

public class Computer extends Machine {
	public Computer(int a) {
		super(a);
	}

	@Override
	public void work() {
		// Computer도 추상클래스이면 Computer를 상속받는 자식이 work 구현
		System.out.println("추상메소드를 overriding해야 컴파일 에러가 안나!!!");
	}
}