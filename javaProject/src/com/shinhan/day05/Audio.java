// 04 - f3(), f4()
package com.shinhan.day05;

// interface를 구현한 class
public class Audio implements RemoteControl, Wifi { 
	// 다중 인터페이스: 그냥 콤마(,)로 연결

	@Override
	public void powerOn() {
		System.out.println(getClass().getSimpleName() + "의 전원을 켰다~");
	}

	@Override
	public void powerOff() {
		System.out.println(getClass().getSimpleName() + "의 전원을 껐다~");
	}
	
	@Override
	public void display() {
		RemoteControl.super.display(); // 부모의 display도 호출하고 싶을 때
		System.out.println("Audio는 default method를 재정의~");
	}

	@Override
	public void wifiTurnOn() {
		System.out.println("다중 인터페이스, 이번엔 와이파이 전원~");
		
	}
	
// 	@Override
	// 이것은 overriding이 아니고 우연히 interface의 static과 이름이 같은 것..
	 void display2() {
		System.out.println("Audio의 display2!!");
	}


}
