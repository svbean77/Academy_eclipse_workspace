// 05 - f1()
package com.shinhan.day03;

// class: 설계도, object를 만드는 틀
// object: class를 이용해서 만든 '독립된' 개체(실체) = instance
public class Car {
	// class가 가질 수 있는 5가지 (필수 요소는 없음. 5가지 전부 선택 요소)
	// 1. field(속성, 멤버변수, 변수)
	// 2. 생성자 method (생성시 초기화가 목적)
	// 컴파일시 자동으로 .class에 (파라미터가 없는)default 생성자 만들어짐 -> 생성사 정의는 필수가 아님
	// 3. 일반 method (기능, 동작)
	// 4번부터는 잘 사용하지 않음 (static block은 간간히 보임)
	// 4. block (instance block, static block)
	// 5. inner class

	// 실행 순서: static block -> instance block -> 생성자 
	// 클래스에서는 단순 문장을 사용할 수 없음 -> method 내부에서 실행하나 block 내부에서 실행해야 함 (사용에 따라 instance, static block으로 나뉨)
	
	// field
	String model;
	String color;
	int price;

	// 생성자 method
	// 필수는 아니지만 생성자 재정의: default 생성자가 자동으로 만들어지지 않음 (내가 정의 했으니까)
	Car() { // 생성자는 return에 대한 정의가 없어야 함, 생성자 이름 = 클래스명
		System.out.println("Car의 default 생성자");
	}

	// 일반 method
	void go() {
		System.out.println("자동차가 간다!");
	}

	// instance block: 객체 생성시마다 실행 (생성자보다 먼저)
	{
		System.out.println("instance block ... 객체 생성시마다 실행");
	}

	// static block: class load시 실행
	static {
		System.out.println("static block ... class load시 실행");
	}
}
