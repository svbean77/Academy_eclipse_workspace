// 10 - 스레드 안전 종료 p.619
package com.shinhan.day09;

import lombok.Setter;

@Setter
public class SafeThread extends Thread {
	private boolean stop; // default 값은 false

//	while문을 이용한 safe thread
//	@Override
//	public void run() {
//		while (!stop) {
//			System.out.println("safeThread... 실행중");
//		}
//		System.out.println("자원 정리하자");
//		System.out.println("safeThread... 종료됩니다");
//	}

//	interrupt() 메소드 이용 - sleep() 이용: 일시 정지 상태가 되면 예외가 발생하기 때문에 sleep() 사용
//	@Override
//	public void run() {
//		try {
//			while (true) {
//				System.out.println("safeThread... 실행중");
//				sleep(1);
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("자원 정리하자");
//		System.out.println("safeThread... 종료됩니다");
//	}

//	interrupt() 메소드 이용 - interrupted()로 확인
	@Override
	public void run() {
		while (true) {
			System.out.println("safeThread... 실행중");
			if (Thread.interrupted())
				break;
		}
		System.out.println("자원 정리하자");
		System.out.println("safeThread... 종료됩니다");
	}
}
