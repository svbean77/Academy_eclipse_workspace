// 05 - 스레드 양보 p. 607
package com.shinhan.day09;

public class WorkThread extends Thread {
	public boolean work = true;

	public WorkThread(String name) {
		setName(name);
	}

	@Override
	public void run() {
		while (true) {
			if (work) {
				System.out.println("[" + getName() + "]의 작업 처리");
			} else {
				Thread.yield(); // 나의 스레드가 잠깐 멈춤 (대기상태로 감!), 다른 스레드에 양보, 그 이후 계속 진행
			}
		}
	}

}
