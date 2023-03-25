// 06
package com.shinhan.day05;

public interface Volume {
	void volumeUp(int level);

	public abstract void volumeDown(int level);
}

// 추상클래스로 구현할 수도 있음!
// 인터페이스와의 공통점: 객체 생성 불가능
// 인터페이스와의 차이점: 클래스는 변수, 생성자, 일반메소드 선언+구현 가능
//public abstract Volume {
//	abstract void volumeUp(int level);
//	abstract void volumeDown(int level);
//}