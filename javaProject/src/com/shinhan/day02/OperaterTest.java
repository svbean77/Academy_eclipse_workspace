// 01
package com.shinhan.day02;

public class OperaterTest {

	public static void main(String[] args) {
		method1();
		method2();
		method3();
		method4();
		method5();
		method6();
		method7();

	}

	private static void method7() {
		// 삼항 연산자, 연산자 우선순위
		System.out.println("함수 6 실행!");
		int a = 70;
		if (a >= 70) {
			System.out.println("조건문 합격!");
		} else {
			System.out.println("조건문 불합격..");
		}

		System.out.println(a >= 70 ? "삼항 합격!" : "삼항 불합격..");
		String result = a >= 70 ? "삼항 변수 대입 합격!" : "삼항 변수 대입 불합격..";
		System.out.println(result);

		System.out.println(a + 20 > 10 && ++a <= 20);
	}

	private static void method6() {
		// 대입 연산자
		System.out.println("함수 6 실행!");
		int a = 10;
		a += 1; // a = a + 1;
		System.out.println(a);

	}

	private static void method5() {
		// 비교 연산자
		System.out.println("함수 5 실행!");
		int a = 10;
		int b = 20;
		System.out.println(a == b);
		System.out.println(a != b);
		System.out.println(!(a == b));

	}

	private static void method4() {
		// 논리 연산자
		System.out.println("함수 4 실행!");
		int a = 10;
		int b = 20;
		int c = 10;
		int d = 20;
		boolean result = a >= 10 || ++b == 20;
		boolean result2 = c >= 10 | ++d == 20;
		System.out.println(result);
		System.out.println("b = " + b); // ||(단축구문): a > 10의 결과부터 틀렸기 때문에 ++b의 연산은 수행되지 않음
		System.out.println("d = " + d); // |: 앞의 결과가 틀렸어도 모든 연산 수행
	}

	private static void method3() {
		// 논리 연산자
		System.out.println("함수 3 실행!");
		int a = 10;
		int b = 20;
		int c = 10;
		int d = 20;
		boolean result = a > 10 && ++b == 20;
		boolean result2 = c > 10 & ++d == 20;
		System.out.println(result);
		System.out.println("b = " + b); // &&(단축구문): a > 10의 결과부터 틀렸기 때문에 ++b의 연산은 수행되지 않음
		System.out.println("d = " + d); // &: 앞의 결과가 틀렸어도 모든 연산 수행

	}

	private static void method2() {
		// NaN과 Infinity
		System.out.println("함수 2 실행!");
		int a = 10;
		double b = 0.0; // 정수 0으로는 나눌 수 없음 -> Arithmetic Exception (runtime exception 중 하나)
		// runtime exception: 컴파일시 오류가 없지만 실행시 오류 발생

		if (Double.isInfinite(a / b)) {
			System.out.println("무한대로 가버려..");
		} else {
			System.out.println(a / b);
		}

		if (Double.isNaN(a % b)) {
			System.out.println("나머지가 나올 수 없어..");
		} else {
			System.out.println(a % b);
		}
	}

	private static void method1() {
		// 함수가 길어지면 보기 힘듦 -> 조각조각 모듈화 해서 사용하는 게 좋음
		// 모듈화의 장점: 함수가 간편해짐, 반복해서 사용할 수 있음
		System.out.println("함수 1 실행!");
		int a = 10;
		int b = 5;

		System.out.println(++a); // 증가 후 변수 사용: 11
		System.out.println(a++); // 변수 사용 후 증가: 11
		System.out.println(a); // 12

		System.out.println("덧셈: " + (a + b)); // 문자 + 숫자인 경우 연결연산자가 됨 -> 괄호로 연산자 우선순위 바꿈
		System.out.println("뺄셈: " + (a - b));
		System.out.println("곱셈: " + (a * b)); // 곱하기의 우선순위가 더하기보다 높기 때문에 괄호가 없어도 됨
		System.out.println("몫: " + (a / b)); // 12를 5로 나눈 몫
		System.out.println("나머지: " + (a % b)); // 12를 5로 나눈 나머지
	}

}
