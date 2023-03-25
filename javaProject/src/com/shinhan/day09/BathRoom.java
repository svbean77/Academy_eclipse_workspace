// 06 - 동기화
package com.shinhan.day09;

// 공유 영역
public class BathRoom {
	boolean isFirst = true;

//	동기화를 사용하지 않음
	void use(String name) {
		System.out.println(name + "님이 입장한다");
		System.out.println(name + "님이 사용한다");
		System.out.println(name + "님이 퇴장한다");
		System.out.println("*** " + name + " ***");
	}

//	동기화 ver.1 -> 함수 접근 불가
	public synchronized void use2(String name) {
		System.out.println(name + "님이 입장한다");
		System.out.println(name + "님이 사용한다");
		System.out.println(name + "님이 퇴장한다");
		System.out.println("*** " + name + " ***");
	}

//	동기화 ver.2 -> 특정 객체를 사용할 때 접근 불가
//	모든 문장을 synchronized 했기 때문에 김씨, 김씨, 김씨, 이씨, 이씨, 이씨, 박씨, 박씨, 박씨, 최씨, 최씨, 최씨 순서로 반복
	public void use3(String name) {
		synchronized (this) {
//			김씨가 처음으로 들어오는 게 마음에 들지 않아!
			if (isFirst && name.equals("김씨")) {
				try {
					wait(); // 데이터가 없으면 신호가 올 때까지 무조건 기다리게 해는 것 (notify를 만날 때까지 일시정지 상태로 바뀜)
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			isFirst = false;
			System.out.println(name + "님이 입장한다");
			System.out.println(name + "님이 사용한다");
			System.out.println(name + "님이 퇴장한다");
			System.out.println("*** " + name + " ***");
			notifyAll(); // 자고 있는 사람이 있다면 다 깨워: 신호를 보냄 => wait() 항태에 있는 스레드가 실행대기상태(runnable)로 바뀜
		}

	}

//	동기화 ver.3 -> 특정 객체를 사용할 때 접근 불가
//	동기화하지 않은 문장이 있기 때문에 문장 실행에 다른 스레드가 들어와 김씨, 박씨, 최씨, ... 순서로 뒤죽박죽 됨
	public void use4(String name) {
		synchronized (this) {
			System.out.println(name + "님이 입장한다");
			System.out.println(name + "님이 사용한다");
			System.out.println(name + "님이 퇴장한다");
		}
		System.out.println("*** " + name + " ***");
	}
}
