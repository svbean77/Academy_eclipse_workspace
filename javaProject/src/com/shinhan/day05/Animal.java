// 02 - f2()
package com.shinhan.day05;

public sealed class Animal permits Cat, Dog {
	// 15버전부터 추가된 기능: 상속받을 자식을 제한할 수 있다!
	// sealed 클래스명 permits 자식1, 자식2...
	int a = 10;

	void method1() {
		System.out.println("Animal의 method1");
	}
}
