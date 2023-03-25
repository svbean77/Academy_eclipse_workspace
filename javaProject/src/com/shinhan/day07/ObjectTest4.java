// 05
package com.shinhan.day07;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class ObjectTest4 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		f1();
		f2();
		f3();
		f4();
		f5();
		f6();
		f7();
		f8();
		f9();
		f10();
		f11();
		f12();
		f13();
		f14();
		f15();
	}

	private static void f15() {
//		SimpleDateFormat: 날짜를 형식화된 문자열로 변환
		System.out.println("** 함수 f15 실행 **");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d1 = new Date();
		String result = sdf.format(d1);
		System.out.println("원본: " + d1);
		System.out.println("형식화: " + result);
		
	}

	private static void f14() {
//		Decimal format: 숫자를 형식화된 문자열로 변환
		System.out.println("** 함수 f14 실행 **");

		DecimalFormat df = new DecimalFormat("###,###"); // 원하는 형식대로 변경시켜줌
		DecimalFormat df2 = new DecimalFormat("000,000"); // 원하는 형식대로 변경시켜줌
		long money = 10000000000000L;
		String result = df.format(money);
		System.out.println(result);
		System.out.println(df2.format(100));
	}

	private static void f13() {
//		Date, Calendar
		System.out.println("** 함수 f13 실행 **");

		Date d1 = new Date();
		System.out.println(d1);
		System.out.println(d1.getTime());

		Calendar cal = Calendar.getInstance(); // Class.method인걸 보니 static이구나!
//		Calendar.MONTH는 0월부터 시작 -> 1을 더해줘야 함..
		System.out.println(cal.get(Calendar.YEAR) + "년" + (cal.get(Calendar.MONTH) + 1) + "월"
				+ cal.get(Calendar.DAY_OF_MONTH) + "일");

//		개인적으로 Calendar보다 이게 좋은 것 같아!
		LocalDateTime dt = LocalDateTime.now();
//		getMonth: 영어, getMonthValue: 한글
//		getDayOfWeek: 일주일 중 몇 번째, getDayOfMonth: 월의 며칠, getDayOfYear: 365일의 며칠
		System.out.println(dt.getYear() + "년" + dt.getMonthValue() + "월" + dt.getDayOfMonth() + "일");
	}

	private static void f12() {
//		Math class
		System.out.println("** 함수 f12 실행 **");

//		max, min
		int a = 10;
		int b = 20;
		int max = Math.max(a, b);
//		Math.max를 사용하지 않았다면?
//		int max;
//		if (a > b)
//			max = a;
//		else
//			max = b;

//		round(반올림), ceil(올림), floor(내림)
		double c1 = 3.9;
		double c2 = 3.5;
		double c3 = 3.1;
		System.out.println("round: " + Math.round(c1) + ", ceil: " + Math.ceil(c1) + ", floor: " + Math.floor(c1));
		System.out.println("round: " + Math.round(c2) + ", ceil: " + Math.ceil(c2) + ", floor: " + Math.floor(c2));
		System.out.println("round: " + Math.round(c3) + ", ceil: " + Math.ceil(c3) + ", floor: " + Math.floor(c3));
	}

	private static void f11() {
//		Wrapper class - equals
		System.out.println("** 함수 f11 실행 **");
		Integer a = 10;
		Integer b = 10;
		System.out.println("== 연산자: " + (a == b));
		System.out.println("equals: " + a.equals(b));
		System.out.println("변환 후 비교: " + (a.intValue() == b.intValue()));
	}

	private static void f10() {
//		Wrapper class - Character: 숫자만 추출
		System.out.println("** 함수 f10 실행 **");

		String s = "이것이자바다 12345 This 6778 is 990- Java";
		StringBuilder result = new StringBuilder("");

//		나중에 정규표현식 배우면 아주 쉬워! 지금은 어쩔 수 없이 문자열 시작부터 하나씩 보는 방법밖에..
		char[] arr = s.toCharArray();
		for (char c : arr) {
			if (Character.isDigit(c)) {
				System.out.print(c + " ");
//				문자열을 이렇게 더하는건 새로운 객체 만들어서 별로라고 했으니까 StringBuilder 사용해보자!
				result.append(c);
			}
		}
		System.out.println();
		System.out.println(result);
	}

	private static void f9() {
//		Wrapper class - Character: 대문자이냐
		System.out.println("** 함수 f9 실행 **");

		String s = "이것이자바다 This is Java";
//		문자열은 하나의 덩어리 -> 향상된 for문을 사용할 수 없음! 파이썬처럼 문자열 배열처럼 못 써!
//		문자 하나하나의 배열로 바꾸고 싶다면?! -> toCharArray -> 향상된 for문 사용 가능!!!
		char[] arr = s.toCharArray();
		for (char c : arr) {
			if (Character.isAlphabetic(c) && Character.isUpperCase(c)) {
				System.out.print(c + "대 ");
				continue;
			}

			System.out.print(c + " ");
		}
		System.out.println();

	}

	private static void f8() {
//		Wrapper class - Integer
		System.out.println("** 함수 f8 실행 **");

		String score = "100";
		int score2 = Integer.parseInt(score); // wrapper class를 사용하면 문자열을 기본형 타입으로 parsing 가능
		System.out.println(score2 + 200);

		int num = 10;
		System.out.println(Integer.toBinaryString(num)); // 이진수로 변경
		System.out.println(Integer.bitCount(num)); // 이진수로 변경했을 때 1이 몇 개 있는가

	}

	private static void f7() {
//		Wrapper class - Integer
		System.out.println("** 함수 f7 실행 **");

		int a = 10; // 기본형: 값 저장, 연산, 비교의 용도
//		원래 작성법은 Integer b = new Integer(20); // 지금은 권장하는 방식이 아님! 자동으로 AutoBoxing 해줌
		Integer b = 20; // 참조형(객체 - 기본형에 기능 추가한 것)

		System.out.println(a + b + 200); // b는 객체인데?! -> 자동으로 언박싱(b.intValue()) 해줌

		float f = b.floatValue();
		System.out.println(Integer.MAX_VALUE);
		int num = Integer.compare(10, 5); // a가 크면 1, 같으면 0, a가 작으면 -1, 나중에 정렬할 때 이거 사용함
		System.out.println(num);

		int[] arr = { 10, 90, 20, 70, 50 };
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void f6() {
//		StringTokenizer - example3
		System.out.println("** 함수 f6 실행 **");

		LocalDateTime dt = LocalDateTime.now(); // Class명.메소드인걸 보니 static method이구나!를 알 수 있어야 함
		System.out.println(dt); // dt를 찍어라!라는 것은 dt.toString()과 같은 말! toString()은 생략할 수 있거든

//		연, 월, 일, 시, 분, 초 나누기 내 풀이
//		StringTokenizer st = new StringTokenizer(dt.toString(), "T");
//		while (st.hasMoreTokens()) {
//			StringTokenizer st2 = new StringTokenizer(st.nextToken(), "-:");
//			while (st2.hasMoreTokens()) {
//				System.out.println(st2.nextToken() + " ");
//			}
//		}
//		System.out.println();

//		연, 월, 일, 시, 분, 초 나누기 교수님 풀이 - ver. split()
		String s = dt.toString();
		String[] arr = s.split("T");
		System.out.println(arr[0]);
		System.out.println(arr[1]);

//		연, 월, 일, 시, 분, 초 나누기 교수님 풀이 - ver. StringTokenizer
		StringTokenizer sst = new StringTokenizer(s, "T");
		System.out.println(sst.nextToken());
		System.out.println(sst.nextToken());
//		System.out.println(sst.nextToken()); // 없는데 부르면 에러 -> 그래서 while문으로 확인하라고 하는거야
		StringTokenizer sstt = new StringTokenizer(s, "T-:");
		while (sstt.hasMoreTokens()) {
			System.out.print(sstt.nextToken() + " ");
		}
		System.out.println();
	}

	private static void f5() {
//		StringTokenizer - example2
		System.out.println("** 함수 f5 실행 **");

		String phone = "010-1234-5678 010-9876-5432";
		StringTokenizer st = new StringTokenizer(phone, "- ");
		while (st.hasMoreTokens()) {
			System.out.print(st.nextToken() + " ");
		}
		System.out.println();
	}

	private static void f4() {
//		StringTokenizer - example1
//		split()보다는 StringTokenizer가 더 효율적일 것!
//		: split은 배열 객체를 하나 생성, Tokenizer는 내부 반복자이기 때문에 지나가면 사라짐
		System.out.println("** 함수 f4 실행 **");
		String fruits = "오렌지,키위/복숭아 딸기,체리";
		StringTokenizer st = new StringTokenizer(fruits, ",/ ");
		while (st.hasMoreTokens()) {
			System.out.print(st.nextToken() + " ");
		}
		System.out.println();
	}

	private static void f3() {
//		String.split
		System.out.println("** 함수 f3 실행 **");
		String fruits = "오렌지,키위/복숭아 딸기,체리";
		String[] arr = fruits.split(",| |/");
		for (String f : arr) {
			System.out.print(f + " ");
		}
		System.out.println();

	}

	private static void f2() throws UnsupportedEncodingException {
//		StringBuilder
		System.out.println("** 함수 f2 실행 **");

		String s1 = "자바"; // String은 고정 문자열
		System.out.println(s1 + "프로그램");
		System.out.println(s1); // s1이 바뀌는 것은 아님

		s1 = s1 + "프로그램";
		System.out.println(s1); // 메모리 낭비

//		문자열을 자주 수정하는 경우 StringBuilder or StringBuffer 사용하는 것이 좋음!
		StringBuilder sb = new StringBuilder("자바");
		StringBuffer sf = new StringBuffer("자바");
//		sb = sb + "aa"; // StringBuilder, StringBuffer는 + 연산자를 사용해 문자열을 추가할 수 없음
//		-> append, insert, delete, replace 등의 메소드를 이용해 문자열을 변경 -> 새로운 객체를 만들지 않고도 조작!
		System.out.println(sb);
		sb.append("프로그램");
		System.out.println(sb);
		System.out.println(sf);
		sf.append("프로그램");
		System.out.println(sf);

//		StringBuilder, StringBuffer를 문자열로 만들 수 있음!
		String s2 = new String(sb);
		String s3 = new String(sf);

		String s4 = new String("자바프로그램");
		byte[] arr1 = s4.getBytes("utf-8"); // 한글 1자 -> 3byte
		byte[] arr2 = s4.getBytes("euc-kr"); // 한글 1자 -> 2byte
		System.out.println(Arrays.toString(arr1)); // 총 18개 (1글자 3byte)
		System.out.println(Arrays.toString(arr2)); // 총 12개 (1글자 2byte)
	}

	private static void f1() throws UnsupportedEncodingException {
//		String 클래스
		System.out.println("** 함수 f1 실행 **");

		String s1 = "자바"; // 리터럴을 이용한 방법: 자동으로 new String()됨. 가장 일반적인 방법
		String s2 = new String("자바");
		byte[] arr1 = new byte[] { 65, 66, 67, 97, 98, 99 }; // A, B, C, a, b, c
		char[] arr2 = new char[] { 'A', 'B', 'C', 'a', 'b', 'c' };
		String s3 = new String(arr1);
		String s4 = new String(arr2);

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);

		String s5 = new String(arr1, "utf-8"); // utf-8 부분을 변경하면 몇 바이트씩 처리되는지가 달라짐
		System.out.println(s5);
		System.out.println(s5.length());
	}

}
