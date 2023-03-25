// 02 - f4()
package com.shinhan.day05;

public class CarTest {
	void go(Tire tire) {
		// 금호, 한국타이어 어떤 것을 사용하든 출력이 되어야 하기 때문에 부모인 Tire를 사용

		// 다형성: 코드는 같지만 실행되는 형태는 다름
		tire.roll(); // overriding 했기 때문에 금호, 한국 타이어의 roll() 함수가 호출 -> 다형성

		// tire에 들어오는 객체가 금호인지, 한국인지 모름 -> 누구의 인스턴스인지 물어봐야 함
		if (tire instanceof KumhoTire) {
			KumhoTire kum = (KumhoTire) tire;

			// 이제부터는 금호타이어이기 때문에 KumhoTire의 변수들 사용 가능!
			System.out.println(kum.intro);
			kum.method2();
		} else if (tire instanceof HankookTire han) {
			// 강제형변환이 귀찮으면 위처럼 넣을 수 있음! (12버전에 추가된 기능)
			// 부모변수 instanceof 자식클래스 변수
			System.out.println(han.info);
			han.method1();
		}

	}
}
