// 08 - 공유클래스 동기화
package com.shinhan.day09;

import lombok.AllArgsConstructor;

//@AllArgsConstructor
public class TransferThread extends Thread {
	ShareArea share;

	public TransferThread(ShareArea share) {
		this.share = share;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 12; i++) {
//			출금한다.
//			입금한다. <- 이 순서가 이체지!
//			하나의 이체만 묶으면 되기 때문에 for문 내부에서 동기화
			share.transfer();
		}
	}

}
