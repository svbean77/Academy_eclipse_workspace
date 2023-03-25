// 02
package com.shinhan.day07;

import java.util.HashSet;
import java.util.Set;

public class ObjectTest2 {

	public static void main(String[] args) {
		f1();
		f2();
		f3();
	}

	private static void f3() {
//		lombok
		System.out.println("** 함수 f3 실행 **");

		Computer c1 = new Computer();
		Computer c2 = new Computer("A", 100, "LG");
		Computer c3 = new Computer("A", 100, "LG");

		System.out.println(c2.getModel());
		c2.setMaker("엘지");
		System.out.println(c2.equals(c3));
		System.out.println(c2);
		System.out.println(c3);
	}

	private static void f2() {
//		record
		System.out.println("** 함수 f2 실행 **");
		Person p1 = new Person("홍길동", 20);
		System.out.println(p1);

		System.out.println(p1.name());
		System.out.println(p1.age());

	}

	private static void f1() {
		System.out.println("** 함수 f1 실행 **");
		ProductVO p1 = new ProductVO("컴퓨터", 100, "삼성");
		ProductVO p2 = new ProductVO("컴퓨터", 100, "삼성");

		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
//		객체이기 때문에 p1과 p2의 주소 비교
//		자바는 연산자 재정의 불가능.. (C++는 가능한데..) -> 함수로 재정의 해야 함
		System.out.println(p1 == p2 ? "p1 == p2" : "p1 != p2");
//		equals를 재정의 하지 않으면 주소 비교
		System.out.println(p1.equals(p2));
//		new로 생성되기 때문에 재정의 하지 않으면 항상 다름 -> Set에 들어갈 때는 동등비교이기 때문에 다른 객체로 판정됨
//		-> Set에서 중복을 제거하기 위해서는 hashCode도 같아야 함!
		System.out.println("p1.hashCode: " + p1.hashCode());
		System.out.println("p2.hashCode: " + p2.hashCode());

//		뒤쪽의 제네릭 생략 가능
		Set<ProductVO> data = new HashSet<>();
		data.add(p1);
		data.add(p2);
		for (ProductVO p : data) {
			System.out.println(p);
		}
	}

}
