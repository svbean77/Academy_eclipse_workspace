// 03
package com.shinhan.day04;

// 자바의 최상위 class: Object (무조건 상속 받음)
// 내용: toString, equals, ...
public class Duck {
	String name;
	int legs;
	int length;

	Duck(String name, int legs, int length) {
		this.name = name;
		this.legs = legs;
		this.length = length;
	}

	public void fly() {
		System.out.println("오리(" + name + ")" + "는 날지 않습니다.");
	}

	public void sing() {
		System.out.println("오리(" + name + ")" + "는 소리 내어 웁니다.");
	}

	void setName(String name) {
		this.name = name;
	}

	public void display() {
		System.out.println("오리의 이름은 " + name + "입니다. 다리는 " + legs + "개이고 길이는 " + length + "입니다.");
	}

	// toString이라고 쓰면 주소가 나오는게 싫어.. 내가 직접 바꾸고싶어!
	// -> override(덮어쓰기, 재정의): 이미 가지고 있는 기능을 재정의
	// 이름, 매개변수, return 모두 같아야 함
	// 단, 접근제한자는 같거나 더 넓어져야 함 (넓 public > protected > default(생략) > private 좁)
	public String toString() { // toString의 접근 제한자가 public이었기 때문에 public만 가능, 매개변수가 달라져도 오버라이딩이 아님, 오버로딩임

		return "HI";
	}
}
