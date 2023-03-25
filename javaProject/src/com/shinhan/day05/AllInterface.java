// 08 - ???
package com.shinhan.day05;

public interface AllInterface extends RemoteControl, Wifi {
	// interface는 다중 상속 가능!!!! -> 현재 인터페이스를 구현한 클래스는 상속받은거 다 구현해야 함
	// interface는 추상이기 때문에 interface를 상속받은 interface는 overriding 안해도 됨!
	void print();
}
