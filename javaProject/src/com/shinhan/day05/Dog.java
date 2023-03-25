// 02 - f3()
package com.shinhan.day05;

public final class Dog extends Animal {
	// sealed로 상속받은 자식은 final, non-sealed 중 하나 필요 or sealed로 다른 클래스 봉인
	int c = 30;

	void method3() {
		System.out.println("(자식에서 추가) Dog의 method3");
	}
}
