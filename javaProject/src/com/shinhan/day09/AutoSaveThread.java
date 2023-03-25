// 11 - 데몬 p.624
package com.shinhan.day09;

public class AutoSaveThread extends Thread {
	public void save() {
		System.out.println("작업 내용을 저장한다");
	}

	@Override
	public void run() {
		while (true) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			save();
		}
	}
}
