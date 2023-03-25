//13 - 14장 확인문제 2번
package com.shinhan.day09;

class MovieThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("동영상 재생");
			try {
				sleep(1000);
			} catch (InterruptedException e) {

			}
		}
	}
}

class MusicRunnable implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("음악 재생");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
	}
}

public class ThreadExample {

	public static void main(String[] args) {
		Thread t1 = new MovieThread();
		t1.start();

		Thread t2 = new Thread(new MusicRunnable());
		t2.start();
	}

}
