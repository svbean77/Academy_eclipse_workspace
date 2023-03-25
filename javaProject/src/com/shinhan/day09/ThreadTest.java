// 02 - 스레드
package com.shinhan.day09;

public class ThreadTest {

	public static void main(String[] args) {
//		프로그램의 흐름은 하나인데 갔다가 돌아오는 것 -> 다른 함수들의 스레드 이름도 main임
		System.out.println("Thread 이름: " + Thread.currentThread().getName() + " 시작!");
//		f1(); // 동기 (끝날 때까지 기다림) (* 비동기: 돌아오든 말든 내 갈 길을 간다: 멀티 스레드와 비슷한 개념!)
//		f2();

		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		Runnable r = new MyThread3(); // interface를 구현한 것이기 때문에 Thread의 자식이 아님! 담길 수 없음
		Thread t3 = new Thread(r); // Runnable을 Thread로 바꿔줘야 스레드가 됨

//		스레드가 run을 수행하도록 한다. (start가 run을 호출!)
		t1.start();
		t2.start();
		t3.start();

		for (int i = 100; i < 110; i++) {
			System.out.println("[" + Thread.currentThread().getName() + "]의 i = " + i);
		}

		System.out.println("Thread 이름: " + Thread.currentThread().getName() + " 끝..");
	}

	private static void f2() {
		System.out.println("Thread 이름: " + Thread.currentThread().getName() + " f2다!");
		for (int i = 1; i <= 26; i++) {
			System.out.println(Thread.currentThread().getName() + "의 f2 i = " + i);
		}

	}

	private static void f1() {
		System.out.println("Thread 이름: " + Thread.currentThread().getName() + " f1이다!");
		for (char i = 'A'; i <= 'Z'; i++) {
			System.out.println(Thread.currentThread().getName() + "의 f1 i = " + (char) i);
		}
	}

}
