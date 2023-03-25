// 02 - f1(), f2(), f3(), 
package com.shinhan.day05;

public non-sealed class Cat extends Animal {
	// sealed로 상속받은 자식은 final, non-sealed 중 하나 필요 or sealed로 다른 클래스 봉인
	int b = 20;
	
	void method2() {
		System.out.println("(자식에서 추가) Cat의 method2");
	}
}
