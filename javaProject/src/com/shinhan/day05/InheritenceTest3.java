// 02
package com.shinhan.day05;

//7장 확인문제 9번
class A {
}

class B extends A {
}

class C extends A {
}

class D extends B {
	int max = 100;
}

class E extends B {
}

class F extends C {
}

public class InheritenceTest3 {

	public static void main(String[] args) {
		f1();
		f2();
		f3();
		f4();
		f5();
	}

	private static void f5() {
		// 7장 확인문제 9번
		System.out.println("** 함수 f5 실행 **");

		// 자동형변환 (부모타입 = 자식객체)
		D v1 = new D();
		B v2 = new D();
		A v3 = new D();

		System.out.println(v1.max);
//		System.out.println(v2.max); // 부모에서 자식에게 접근할 수 없음 -> 강제형변환을 통해 접근 가능 (자식타입)부모타입객체
		System.out.println("B의 강제 형변환: " + ((D) v2).max);
//		System.out.println(v3.max);
		System.out.println("A의 강제 형변환: " + ((D) v3).max);

// 		E v4 = (E) v2; //컴파일은 에러가 안나지만 실행시 에러 -> D에서 B를 바꾼 것을 어떻게 E로 바꿔!!!
		// D에서 B로 바꿨으니 B에서 D로만 형변환 가능!!!! 본래 생성되었던 instance로만 형변환 가능
		// 부모를 거쳐가는 것은 가능 (D -> B -> A)
		B v5 = (B) v3;

		// 형변환이 가능한지 체크!
		System.out.println(v3 instanceof D);
		System.out.println(v3 instanceof E); // false이기 때문에 형변환 불가
		System.out.println(v3 instanceof B);
		
		if(v3 instanceof D dd) {
			// D dd = (D) v3;
			System.out.println(dd.max);
		}

	}

	private static void f4() {
		// 타이어 다형성
		// 객체 생성(현재 클래스와 함수)과 객체 사용 (CarTest의 go)가 다른 예제
		System.out.println("** 함수 f4 실행 **");

		CarTest car = new CarTest();

		car.go(new HankookTire());
		car.go(new KumhoTire());
	}

	private static void f3() {
		System.out.println("** 함수 f3 실행 **");
		Cat c1 = new Cat();
		Dog d1 = new Dog();

		// 자식을 부모에 담을 수 있는 것을 만든 이유!
		// 부모를 상속받은 자식이 많은 경우 어떤 자식이 들어올지는 모르지만 담기는 해야 함
		// 공통적인 모듈을 생성해야하는데 객체 생성, 객체 사용 업무가 나뉘었을 때 어떤 것을 변수로 -> 부모를 매개변수로
		call(c1);
		call(d1);

		// c1.method1();
		// d1.method1();

	}

	private static void call(Animal animal) {
		animal.method1();
		// Animal이 아닌 Cat, Dog의 데이터를 사용하고 싶다면 강제 형변환을 해야 함 => 다형성 (자동형변환 + overriding)
		if (animal instanceof Dog) {
			Dog d2 = (Dog) animal; // Dog이면 에러 없지만 Cat일때는 에러가 발생하는데..? -> if문
			d2.method3();
			System.out.println(d2.c);
		} else if (animal instanceof Cat) {
			Cat c2 = (Cat) animal;
			c2.method2();
			System.out.println(c2.b);
		}

	}

	private static void f2() {
		System.out.println("** 함수 f2 실행 **");
		Animal c1 = new Cat(); // field, method는 instance가 아닌type을 따름 -> 자식의 변수 사용 불가능

		System.out.println(c1.a);
		// System.out.println(c1.b);
		c1.method1();
		// c1.method2();

	}

	private static void f1() {
		System.out.println("** 함수 f1 실행 **");
		Cat c1 = new Cat();

		System.out.println(c1.a);
		System.out.println(c1.b);
		c1.method1();
		c1.method2();

	}

}
