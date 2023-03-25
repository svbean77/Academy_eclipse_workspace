// 02 - 멀티 스레드 만들기 방법 2: Runnable interface
package com.shinhan.day09;

// 이미 부모 클래스가 존재해 Thread를 상속받을 수 없다면
// 멀티스레드 만드는 방법 2: Runnable interface 구현
public class MyThread3 extends Object implements Runnable {

	@Override
	public void run() {
		for (char i = 'a'; i <= 'z'; i++) {
//			Runnable interface를 구현한 것은 Thread가 아님! (Thread로 쓸 수 있다는 것) -> getName()을 정확히 불러와야 함
			System.out.println("[" + Thread.currentThread().getName() + "]의 i = " + (char) i);
		}
	}

}
