// 04 - f3()
package com.shinhan.day05;

// interface를 구현한 class
public class Television implements RemoteControl {

	@Override
	public void powerOn() {
		System.out.println(getClass().getSimpleName() + "의 전원을 켰다~");
	}

	@Override
	public void powerOff() {
		System.out.println(getClass().getSimpleName() + "의 전원을 껐다~");
	}

}
