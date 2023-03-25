// 03
package com.shinhan.day06;

// 중첩 클래스 테스트
public class InnerClassTest {

	public static void main(String[] args) {
		f1();
		f2();
		f3();
		f4();
	}

	private static void f4() {
		// 4. local inner class 사용
		System.out.println("** 함수 f4 실행 **");
		OuterClass outer = new OuterClass();
		outer.f1(123);

	}

	private static void f3() {
		// 3. class inner class 사용
		System.out.println("** 함수 f3 실행 **");

		OuterClass.StaticInnerClass v1;
		v1 = new OuterClass.StaticInnerClass(); // new하는 방식이 조금 다름

		System.out.println(v1.s1);
		System.out.println(OuterClass.StaticInnerClass.s2);

		v1.method3();
		OuterClass.StaticInnerClass.method4();

	}

	private static void f2() {
		// 2. instance inner class 사용: outer new -> inner new (inner는 outer에서 .으로 연결)
		System.out.println("** 함수 f2 실행 **");

		System.out.println("instance inner class의 static method를 객체 생성 전에 실행!");
		OuterClass.InstanceInnerClass.method4();

		OuterClass outer = new OuterClass();
		OuterClass.InstanceInnerClass v1 = outer.new InstanceInnerClass();
// 		OuterClass.InstanceInnerClass v1 = new OuterClass().new InstanceInnerClass(); // 한 줄에 쓰는 방법

//		System.out.println("outer class's instance field: " + outer.a);
//		System.out.println("outer class's static field: " + OuterClass.b);
		System.out.println("inner class's instance field: " + v1.s1);
		System.out.println("inner class's static field: " + OuterClass.InstanceInnerClass.s2);

//		outer.method1();
//		OuterClass.method2();

		v1.method3();
		OuterClass.InstanceInnerClass.method4();
	}

	private static void f1() {
		// 1. 일반적인 class 사용
		System.out.println("** 함수 f1 실행 **");
		OuterClass v1 = new OuterClass();

		System.out.println("instance field: " + v1.a);
		System.out.println("static field: " + OuterClass.b);

		v1.method1();
		OuterClass.method2();

	}

}
