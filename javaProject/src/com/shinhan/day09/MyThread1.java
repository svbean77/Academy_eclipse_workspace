// 02 - 멀티 스레드 만들기 방법 1: Thread 상속
package com.shinhan.day09;

// 멀티스레드 만드는 방법 1: Thread 클래스 상속 -> run() 메소드 재정의
public class MyThread1 extends Thread {
	MyThread1() {
	}

	MyThread1(String name) {
//		스레드 이름 설정
		super(name);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 26; i++) {
//			Thread를 상속 받았으니까 instance method를 그냥 사용할 수 있어!
			System.out.println("[" + getName() + "]의 i = " + i);
		}
	}

}
