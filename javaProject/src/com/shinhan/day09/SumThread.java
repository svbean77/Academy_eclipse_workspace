// 06 - 스레드 join p.605
package com.shinhan.day09;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SumThread extends Thread {
	private long sum;
	int start = 1;
	int end = 100;

	SumThread() {
	}

	SumThread(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		for (int i = start; i <= end; i++) {
			sum += i;
		}
	}

}
