// 02 - f4()
package com.shinhan.day05;

// 어차피 재정의 되는데 구현할 필요가 없어 -> 추상클래스로 사용하자!
// 함수가 존재하지 않으면 부를 수 없기 때문에 있기는 해야 함
// 추상클래스: abstract method가 존재할 수 있는 클래스 -> 없어도 되긴 함!!!!
// 추상클래스는 new를 이용해 객체를 생성할 수 없음
public abstract class Tire {

	// 추상메소드
	public abstract void roll(); // 정의는 있고 구현{}은 없다: 구현은 상속받은 자식class가 반드시 해야 함(override 의무)

	void f1() {
		System.out.println("Tire class f1 method");
	}

	void f2() {
		System.out.println("Tire class f2 method");
	}
}
