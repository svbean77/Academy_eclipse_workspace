// 05
package com.shinhan.day06;

class Car {
	class Tire {
	}

	static class Engine {
	}

	void go(int score2) {
		// 지역 변수는 '내부 class에서 사용되면' final 특성을 가진다.
		int score = 100;
//		score = 10; // 수정하면 final이 아니기 때문에 f1에서 사용 불가능
		class LocalClass {
			// method 내부에서만 사용 가능
			void f1() {
				System.out.println(score);
				System.out.println(score2);
//				score2 = 200; // final이기 때문에 수정 불가능
			}
		}

		LocalClass v1 = new LocalClass();
		System.out.println(v1);
		v1.f1();
	}
}

public class CarExample {

	public static void main(String[] args) {
		// 9장 확인문제 4번
		Car myCar = new Car();

		Car.Tire tire = myCar.new Tire();
		Car.Tire tire2 = new Car().new Tire();
		Car.Engine engine = new Car.Engine();

		myCar.go(12);

	}

}
