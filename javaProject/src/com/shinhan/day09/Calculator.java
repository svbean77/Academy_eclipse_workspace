// 07 - 동기화 p.611
package com.shinhan.day09;

import lombok.Getter;

// 공유 영역
@Getter
public class Calculator {
	int memory;

//	그냥 실행하면 공유 영역의 메모리가 같은 값이 되어버림! (가~끔 정상적)
	public void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + "의 메모리 저장값 >> " + this.memory);
	}

//	동기화 ver.1 - 동기화 함수
	public synchronized void setMemory2(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + "의 메모리 저장값 >> " + this.memory);
	}

//	동기화 ver.2 - 동기화 블록
	public void setMemory3(int memory) {
		synchronized (this) {

			this.memory = memory;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName() + "의 메모리 저장값 >> " + this.memory);
		}
	}

}
