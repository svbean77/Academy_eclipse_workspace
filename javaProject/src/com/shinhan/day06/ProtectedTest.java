// 04
package com.shinhan.day06;

import com.shinhan.day05.Machine; // 다른 패키지니까 import 필요

// com.shinhan.day05의 Machine에서 접근제한자 테스트
public class ProtectedTest extends Machine {
	public ProtectedTest(int a) {
		super(a);
	}

	void test() {
		// Machine m = new Machine(); // 추상클래스는 new 불가능
	}

	void test2() {
		System.out.println(a); // public
		System.out.println(b); // protected
//		System.out.println(c); // 생략
//		System.out.println(d); // private

		f1(); // public
		f2(); // protected
//		f3(); // 생략
//		f4(); // private
	}
	
	protected void f2() {
		System.out.println("재정의 가능!");
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub

	}

}
