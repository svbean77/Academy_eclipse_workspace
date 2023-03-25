// 05 (Car)
package com.shinhan.day03;

public class CarTest {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		// 자동차 객체를 만듦
		// 1. 객체 참조 변수 선언
		// 2. 객체 생성
		// 3. 객체 사용

		// 객체 참조 변수 선언
		int a; // a 변수에 int 타입의 값을 담을 수 있음
		Car car1; // car1 변수에 Car 타입의 객체를 담을 수 있음
		Car car2;

		// 객체 생성: heap에 객체 생성, 주소는 변수에 담음
		// 객체가 생성되면 멤버 변수들은 자동으로 초기화
		car1 = new Car();
		car2 = new Car();

		// 객체 사용
		car1.model = "A모델";
		car1.color = "black";
		car1.price = 10000;
		System.out.println("----- 값을 변경한 객체 car1 -----");
		System.out.println(car1.model);
		System.out.println(car1.color);
		System.out.println(car1.price);
		System.out.println("----- 기본 초기화 값인 객체 car2 -----");
		System.out.println(car2.model);
		System.out.println(car2.color);
		System.out.println(car2.price);

		car1.go();
	}

}
