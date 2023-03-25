// 01. 리뷰
package com.shinhan.day10;

//스레드 만드는 방법
//1. Thread를 상속
class MyThreadA extends Thread {
	MyThreadA(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(getName() + "'s i = " + i);
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

//2. Runnable 인터페이스를 구현 (이미 다른 클래스를 상속중이라면)
class MyThreadB extends Object implements Runnable {
	@Override
	public void run() {
		for (int i = 100; i <= 110; i++) {
			System.out.println(Thread.currentThread().getName() + "'s i = " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Review {

	public static void main(String[] args) {
//		t1: Thread 클래스 사용
//		t2: Runnable 클래스 사용
//		t3: Thread 익명 객체
//		t4: Runnable 익명 객체
		Thread t1 = new MyThreadA("Thread-A");
		Thread t2 = new Thread(new MyThreadB());
		Thread t3 = new Thread() {
			@Override
			public void run() {
				for (char i = 'A'; i <= 'J'; i++) {
					System.out.println(getName() + "'s i = " + (char) i);
					try {
						sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (char i = 'a'; i <= 'j'; i++) {
					System.out.println(Thread.currentThread().getName() + "'s i = " + (char) i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		t2.setName("Thread-B");
		t3.setName("Thread-C");
		t4.setName("Thread-D");

//		thread.start(); 하면 run() method가 호출됨
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		System.out.println("main 종료!");
	}

}
