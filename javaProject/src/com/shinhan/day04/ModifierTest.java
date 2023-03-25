// 08
package com.shinhan.day04;

// public: 모든 패키지에서 접근 가능
// protected: 같은 패키지에서 접근 가능, 다른 패키지는 상속 받으면 가능
// 생략(default): 같은 패키지에서만 접근 가능
// private: 같은 클래스에서만 접근 가능
public class ModifierTest {
	// 같은 패키지 class 불러옴

	public static void main(String[] args) {
		Phone p = new Phone();
		System.out.println(p);

		p.model = "갤럭시 S23";
		
		p.f1();
		p.f2();
		p.f3();
	}

}
