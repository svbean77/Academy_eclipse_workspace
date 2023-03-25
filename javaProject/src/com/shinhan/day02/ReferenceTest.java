// 11
package com.shinhan.day02;

import java.util.Arrays;

public class ReferenceTest {

	public static void main(String[] args) {
		f1();
		f2();
		f3();
		f4();

	}

	private static void f4() {
		System.out.println("함수 f4 시작");
		String subjects = "자바,DB,HTML CSS#JavaScript,React,Spring";
		String[] arr = subjects.split(",|#| "); // ,를 기준으로 문자열 분리해 배열로 리턴, 기준이 여러 개면 |로 추가
		System.out.println(Arrays.toString(arr));
		for (String s : arr) {
			// 여러 개가 묶인 요소(ex. 배열)를 한 개씩 출력하는 방법
			// 내부 반복자를 사용하기 때문에 속도가 빠름
			System.out.print(s + " / ");
		}

	}

	private static void f3() {
		System.out.println("함수 f3 시작");
		String subject = "이것이 자바다";
		for (int idx = 0; idx < subject.length(); idx++) {
			System.out.print(subject.charAt(idx)); // 한 글자 추출
			System.out.print(subject.substring(idx, idx + 1)); // 범위 추출

		}
		System.out.println();
		System.out.print(subject.replace("이", "@") + " "); // 문자열 대체

		// 문자열 변환 함수들은 원본은 변하지 않음
		// 원본을 바꾸고싶다면 본인에게 결과 주소를 대입 ex) subject = subject.charAt(idx);

		System.out.println();
		System.out.println(subject.indexOf("것")); // 문자(열) 위치 찾기
	}

	private static void f2() {

		System.out.println("함수 f2 시작");
		String name = null; // heap에 생성된 객체는 없다. ( = stack에는 생겼는데 heap의 주소는 모름)
		System.out.println(name);
		// System.out.println(name.length()); // 문자열이 null이기 때문에 길이가 있을 수 없음
		// null pointer exception: runtime exception의 종류 중 하나

	}

	private static void f1() {
		System.out.println("함수 f1 시작");
		int a = 10; // 지역변수 + 기본형 -> stack에 값이 저장됨
		String s1 = "자바"; // 컴파일시 클래스의 상수pool에 들어감, load시 method 영역의 상수pool에 들어감 (이미 있으면 그대로 씀)
		String s2 = "자바";
		System.out.println(s1 == s2); // 두 문자열의 주소가 같다.
		String s3 = new String("자바");
		String s4 = new String("자바");
		System.out.println(s3 == s4); // 두 문자열의 주소가 다르다. (heap에 올라감)

		s1 = s1 + "aa";
		s2 = s2 + "aa";
		System.out.println(s1 == s2); // 문자열을 변경하니 주소가 달라짐
		System.out.println(s1.equals(s2)); // 문자열의 내용을 비교하기 위해 사용하는 함수
		System.out.println(s3.equals(s4));
	}

}
