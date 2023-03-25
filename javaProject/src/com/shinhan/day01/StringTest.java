// 05
package com.shinhan.day01;

public class StringTest {

	public static void main(String[] args) {
		f1();
		f2();
		f3();
		f4();
		f5();
		f6();
		f7();
		f8();
	}

	private static void f8() {
		int a = 10;
		float b = 20.123f;
		System.out.println("a = " + a + ", b = " + b);
		// -: 왼쪽 정렬, %md: m자리만큼 출력, %m.nf: 실수를 전체 m자리, 소숫점 n자리가지 출력
		// %d: decimal(정수), %f: float(실수)
		System.out.printf("a = %-10d, b = %.5f", a, b);
	}

	private static void f7() {
		// 변수의 scope
		System.out.println(("*** 함수 f7 실행 ***"));
		int a = 100;
		{
			int b = 200;
			System.out.println(a + b);
		}
		// System.out.println(a + b); // b의 범위는 블록 내부이기 때문에 변수 b 사용할 수 없음
		// 블록을 벗어나면 변수 사용 불가
	}

	private static void f6() {
		// 자바 기본타입: byte, short, char, int, long, float, double, boolean -> 데이터 저장, 연산, 비교
		// Wrapper Class: 자바 기본타입 + 기능(함수 등)
		// Byte, Short, Character, Integer, Long, Float, Double, Boolean
		System.out.println(("*** 함수 f6 실행 ***"));
		String score = "90";
		System.out.println(score + 10); // 문자 + 숫자 = 문자
		System.out.println(Integer.parseInt(score) + 10);
		
		int i = 1000;
		String str = String.valueOf(i);
		
	}

	private static void f5() {
		// 연산식에서 int의 자동 형변환
		System.out.println(("*** 함수 f5 실행 ***"));
		byte v1 = 100;
		byte v2 = 100;
		byte v3 = (byte) (v1 + v2); // 연산식에서 byte가 자동으로 int로 변함
		int v4 = v1 + v2;
		System.out.println(v3);
		System.out.println(v4);
		
	}

	private static void f4() {
		// 강제 형변환: 작은 방 = 큰 값 -> 데이터 손실 가능성
		System.out.println(("*** 함수 f4 실행 ***"));
		byte v1;
		int v3 = 128;
		v1 = (byte)v3;
		System.out.println(v1); // 강제 형변환된 범위를 넘어 데이터 손실 (byte는 127까지만 가능)
	}

	private static void f3() {
		// 자동 형변환: 큰 방 = 작은 값
		// byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
		System.out.println(("*** 함수 f3 실행 ***"));
		byte v1 = 127;
		short v2 = v1;
		// char v3 = v1; // char는 음수가 없는데 byte는 음수가 존재
		int v3 = v1;
		long v4 = v1;
		float v5 = v1;
		double v6 = v1;
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
		System.out.println(v5);
		System.out.println(v6);
	}

	private static void f2() {
		// 이스케이프 문자 사용
		System.out.println(("*** 함수 f2 실행 ***"));
		String str1 = "자바 '프로그램' 완성!";
		String str2 = "자바 \"프로그램\" 완성";
		String str3 = "{\"name\": \"hong\", \"age\": 20}"; // json: javascript 형태의 문자열
		String str4 = """
				{"name": "hong", "age": 20}
				"""; // 여러 줄 문자열을 만들 때 큰따옴표 3개로 묶어 사용: 이스케이프 문자 그대로 사용 가능
		
		System.out.println(str3);
		System.out.println(str4);
	}

	private static void f1() {
		// String class 사용: java.base 모듈의 java.lang 패키지 내부에 존재
		// 기본형이 아님
		// String: 고정 문자열 -> 절대 변할 수 없음
		System.out.println(("*** 함수 f1 실행 ***"));
		String s1 = "자바"; // 컴파일 시점에 .class의 상수 pool에 넣음
		String s2 = "자바"; // 이미 만들어진 '상수'가 있기 때문에 s1와 s2의 주소가 같음
		String s3 = new String("자바"); // new로 생성하면 'heap'이라는 메모리에 저장됨: 객체 생성
		String s4 = new String("자바"); // new는 실행시 만들어지기 때문에 s3와 s4의 주소가 다름
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		System.out.println(System.identityHashCode(s3));
		System.out.println(System.identityHashCode(s4));
		
		s1 = s1 + "프로그램"; // String buffer에서 두 문자열을 합친 후 새로운 문자열로 변환
		s2 = s2 + "프로그램"; // 따라서 새로운 문자열이 생겨 메모리 낭비, 즉 string 더하기는 좋지 않은 방식
		System.out.println(s1 == s2);
		
	}

}
