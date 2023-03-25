// 04
package com.shinhan.day01;

public class VariableTest2 {

	
	public static void main(String[] args) {
		System.out.println("main 함수 시작");
		f1(); // 함수 호출(함수로 갔다가 main으로 돌아온다)
		f2();
		f3();
	
		System.out.println("main 함수 종료");
	}
	
	private static void f3() {
		System.out.println("*** 함수 f3 실행 ***");
		// 정수
		short v1 = 32767; //-32868~32767
		char v2 = 'a';
		int v3 = Integer.MAX_VALUE; //정수의 기본형
		System.out.println(v3);
		long v4 = 2147483648L; //반드시 L(대소문자 구분 없음)을 적어줘야 함
		
		// 실수
		float v5 = 3.14f; // 반드시 f(대소문자 구분 없음)을 적어줘야 함
		double v6 = 3.14; //실수의 기본형
		
		char v7 = 65; //10진수
		char v8 = 0x0041; //16진수
		System.out.println(++v7);
		System.out.println(v8);
		
		boolean result;
		result = 10 > 20;
		System.out.println(result);
	}

	private static void f2() {
		// java의 data type (종류(byte))
		// 정수 (byte(1), short(2), char(2), int(4), long(8)),
		// 실수 (float(4), double(8))
		// 논리 (boolean(1)): true, false
		System.out.println("*** 함수 f2 실행 ***");
		
		byte v1 = 127; //1byte -128~127
		byte v2 = -128;
		System.out.println(Integer.toBinaryString(v1));
		System.out.println(Integer.toBinaryString(v2));
		v1++;
		System.out.println(v1); //범위를 넘어갔기 때문에 최소값으로 돌아감		
	}

	private static void f1() {
		// 함수 정의
		System.out.println("*** 함수 f1 실행 ***");
		int a;
		System.out.println(a = 10);
		System.out.println(a == 10);
	}

}
