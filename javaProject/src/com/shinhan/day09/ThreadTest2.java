// 03 - 멀티 스레드: 익명 객체
package com.shinhan.day09;

public class ThreadTest2 {

	public static void main(String[] args) {
		f1();
		System.out.println("** main 종료 ** ");
	}

	private static void f1() {
//		Thread를 익명 구현 객체로 만들기
//		Thread t1 = new MyThread1();  // 이렇게 클래스를 만든 방법 말고!!
		Thread t1 = new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					System.out.println("[" + getName() + "]의 i = " + i);
				}
				try {
					sleep((long) (Math.random() * 100));

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				for (char i = 'A'; i <= 'Z'; i++) {
					System.out.println("[" + getName() + "]의 i = " + (char) i);

//					run()은 Override한 함수이기 때문에 모두 같아야 해서 에러 던지기도 안됨!!!!
					try {
						sleep((long) (Math.random() * 100));

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (char i = 'a'; i <= 'z'; i++) {
					System.out.println("[" + Thread.currentThread().getName() + "]의 i = " + (char) i);
				}
				try {
					Thread.sleep((long) (Math.random() * 100));

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
		t3.start();

	}

}
