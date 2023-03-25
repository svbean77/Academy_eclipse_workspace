// 02 - 멀티 스레드 만들기 방법 1: Thread 상속
package com.shinhan.day09;

// 멀티스레드 만드는 방법 1: Thread 클래스 상속 -> run() 메소드 재정의
public class MyThread2 extends Thread {
	MyThread2() {
	}

	MyThread2(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (char i = 'A'; i <= 'Z'; i++) {
			System.out.println("[" + getName() + "]의 i = " + (char) i);
		}
	}

}
