// 03
package com.shinhan.day02;

// 자동완성 기능 사용: ctrl + space
// 코드 자동 줄맞춤: ctrl + shift + F

public class Review {

	public static void main(String[] args) {
		System.out.println("main 시작");
		f1();
		f2();
		System.out.println("main 종료");

	}

	private static void f2() {
		System.out.println("f2 함수입니당");

	}

	private static void f1() {
		System.out.println("f1 함수입니당");
		
		// 기본형 data type: byte, short, char, int, long(정수), float, double(실수), boolean(논리)
		// 기본형의 목적: 값의 저장, 연산, 비교 -> Wrapper class를 사용하면 추가 기능 사용할 수 있음
		// 1. 자동 형 변환
		byte v1 = 100;
		int v2;
		v2 = v1;
		
		// 2. 강제 형 변환 = casting한다
		v1 = (byte) v2;
		
		// 3. 기본형이 아닌 경우 (ex. String)
		String s = "100";
		// int v3 = s;
		int v3 = Integer.parseInt(s);
		System.out.println(v3 + 300);
	}

}
