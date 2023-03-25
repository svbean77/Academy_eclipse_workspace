// 06 - 동기화
package com.shinhan.day09;

import lombok.AllArgsConstructor;

// 스레드
@AllArgsConstructor
public class BathThread extends Thread {
	BathRoom room;
	String userName;

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			room.use3(userName);
		}
	}

}
