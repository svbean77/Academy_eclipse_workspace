// 11
package com.shinhan.day04;

class Parent {
	int a = 10;

	Parent() {
		System.out.println("parents 생성");
	}

	void f1() {
		System.out.println("부모의 f1 함수");
	}

	void f2() {
		System.out.println("부모의 f2 함수");
	}
}

class Child extends Parent {
	String a = "java"; // 나와 부모 같은 이름의 변수가 있다면? -> 내가 없으면 부모한테 가는 것.
	int b = 20;

	Child() {
		System.out.println("child 생성");
	}

	void f1() {
		super.f1(); // override 하지 않고 부모의 f1 함수도 부름!
		System.out.println("자식의 f1 함수");
	}

	void f2() {
		System.out.println("자식의 f2 함수");

	}

}

public class InheritenceTest {
	public static void main(String[] args) {
		Child ch = new Child();
		System.out.println(ch.a); // 나한테 있는데 왜 상속해? String으로 변한다~
		System.out.println(ch.b); // 부모의 것을 '가져오는' 것이 X

		ch.f1();
		ch.f2();
	}

}
