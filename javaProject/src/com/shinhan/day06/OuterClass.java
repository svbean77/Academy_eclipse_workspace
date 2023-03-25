// 03 - f1(), f2(), f3(), f4()
package com.shinhan.day06;

// * 자바는 global이 없음 -> class 외부에서 변수 선언 불가능
// 중첩 클래스
public class OuterClass {
	// 1. field (instance field, static field)
	int a = 10;
	static int b = 20;

	// 2. constructor (구현하지 않아도 컴파일시 default 생성자가 생김)

	// 3. method (instance method, static method)
	void method1() {
		System.out.println("OuterClass의 instance method");
	}

	static void method2() {
		System.out.println("OuterClass's static method");
	}

	// 4. block (instance block, static block)

	// 5. inner class <- 지금의 목적!!!! 이거 할거야
	// instance, class, local (누구의 것인가~가 3종류 있음)

	int score = 100;

	class InstanceInnerClass {
		int score = 70; // 멤버 변수 (클래스 내의 변수)
		String s1 = "InstanceInnerClass's instance field";
		static String s2 = "InstanceInnerClass's static field";

		void method3() { // 매개 변수도 지역 변수
			int score = 50; // 지역 변수 (함수 내의 변수)
			System.out.println("InstanceInnerClass's instance method");
			System.out.println("outer's instance field a = " + a);
			System.out.println("outer's static field b = " + b);
			System.out.println(score + ": score (method 내부)"); // 함수 자신
			System.out.println(this.score + ": this.score (inner class)"); // 내부 클래스
			System.out.println(OuterClass.this.score + ": OuterClass.this.score (outer class)"); // 바깥 클래스의 객체 접근
			// static field이면 OuterClass.v1으로 접근, instance field이면 그 객체!라는 표현을 위해
			// OuterClass.this.v2
		}

		static void method4() {
			System.out.println("InstanceInnerClass's static method");
//			System.out.println("outer's instance field a = " + a); // static에서 instance를 그냥 사용할 수 없음 -> new를 해야 가능
			System.out.println("outer's static field b = " + b);
		}
	}

	static class StaticInnerClass {
		// static은 static이 아닌 것을 사용할 수 없음
		String s1 = "StaticInnerClass instance field";
		static String s2 = "StaticInnerClass static field";

		void method3() {
			System.out.println("StaticInnerClass instance method");
//			System.out.println("outer's instance field a = " + a); // static에서 instance 접근 불가
			System.out.println("outer's static field b = " + b);
		}

		static void method4() {
			System.out.println("StaticInnerClass static method");
//			System.out.println("outer's instance field a = " + a); // static에서 instance 접근 불가
			System.out.println("outer's static field b = " + b);
		}
	}

	void f1(int min) {
		// 이것만 헷갈리지 마라: static에서 non-static 호출 불가!
		// local class는 해당 method 내부에서만 사용 가능 (외부에서 사용 불가능)
		// local class에서는 static을 사용할 수 없다! -> 버전 바뀌면서 가능하게 됨
		// : 함수는 호출 해야 실행, static은 실행 전 메모리에 로드 따라서 맞지 않아
		
		// * 지역 변수는 내부 class에서 사용하면 final 특성을 가짐!
		int max = 100;
		int test = 0;
		test++;
		class LocalInnerClass {
			String s3 = "LocalInnerClass instance field";
			static String s4 = "LocalInnerClass static field";

			void method5() {
				System.out.println("LocalInnerClass instance method");
				System.out.println("field -- " + s3);
				System.out.println("field -- " + s4);
				System.out.println("outer's instance field: " + a);
				System.out.println("outer's static field: " + b);
				System.out.println(max);
				System.out.println(min);
//				System.out.println(test); // 수정을 한 변수는 사용 불가능..
//				max = 200; // 외부 변수는 수정할 수 없음 (내부class에서 final 특성을 가지기 때문)
//				min = 0; // 내부에 변경한 것이 외부에 영향을 끼치기 때문에 불가!

			}

			static void method6() {
				System.out.println("LocalInnerClass static method");
//				System.out.println("field -- " + s3); // static에서 instance 사용 불가
				System.out.println("field -- " + s4);
//				System.out.println("outer's instance field: " + a); // static에서 instance 사용 불가
				System.out.println("outer's static field: " + b);
			}
		}

		LocalInnerClass local = new LocalInnerClass();
		System.out.println(local.s3);
		System.out.println(LocalInnerClass.s4);

		local.method5();
		LocalInnerClass.method6();
	}

}
