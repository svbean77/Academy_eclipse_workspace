// 09 - wait, notify p.615
package com.shinhan.day09;

public class ThreadB extends Thread{
	WorkObject workObject;
	public ThreadB(WorkObject workObject) {
		setName("[Thread-B]");
		this.workObject = workObject;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			workObject.methodB();
		}
	}
}
