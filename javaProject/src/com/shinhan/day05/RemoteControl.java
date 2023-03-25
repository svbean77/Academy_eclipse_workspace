// 04 - f3(), f4()
package com.shinhan.day05;

// 규격서: 상수, 추상메소드 (+ default메소드, 정적메소드, private메소드, private 정적메소드)
// abstract class와 interface의 차이
// abstract class는 변수, 상수, 생성자, 일반메소드, 추상메소드 (+ 블록, 클래스)
public interface RemoteControl {
	void powerOn();
	public abstract void powerOff();
	
	default void display() {
		System.out.println("모든 구현class에 기능이 추가됩니다!");
	}
	
	static void display2() {
		System.out.println("모든 구현 class에 추가되지만 재정의할 수 없어....");
	}
}
