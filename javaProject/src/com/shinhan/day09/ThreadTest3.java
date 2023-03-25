// 04 - 스레드 연습 다시
package com.shinhan.day09;

public class ThreadTest3 {

	public static void main(String[] args) {
		System.out.println("** main 스레드 시작 **");

		MyThread1 t1 = new MyThread1("숫자출력 T");
		MyThread2 t2 = new MyThread2("대문자출력 T");
		MyThread3 r = new MyThread3();
		Thread t3 = new Thread(r);
		t3.setName("소문자출력 T");

//		NEW
		System.out.println("t1: " + t1.getState());
		System.out.println("t2: " + t2.getState());
		System.out.println("t3: " + t3.getState());

		t1.start();
		t2.start();
		t3.start();
		
//		RUNNABLE
		System.out.println("t1: " + t1.getState());
		System.out.println("t2: " + t2.getState());
		System.out.println("t3: " + t3.getState());

		System.out.println("** main 스레드 종료 **");

	}

}
