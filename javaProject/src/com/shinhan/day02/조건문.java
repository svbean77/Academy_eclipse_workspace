// 05
package com.shinhan.day02;

import java.util.Scanner;

// 클래스 명으로 한글도 되긴 함 (근데 안 써 쓰지 마)
public class 조건문 {

	public static void main(String[] args) {
		method1();
		method2();
		method3();
	}

	private static void method3() {
		// switch 예제 문제: 4계절 출력
		System.out.println("함수 3 실행~");
		Scanner sc = new Scanner(System.in);
		System.out.print("월을 입력 >> ");
		int month = sc.nextInt();
		String message = "";

		if (month == 12 || month == 1 || month == 2) {
			message = "겨울이다";
		} else if (month == 3 || month == 4 || month == 5) {
			message = "봄이다";
		} else if (month == 6 || month == 7 || month == 8) {
			message = "여름이다";
		} else if (month == 9 || month == 10 || month == 11) {
			message = "가을이 오면~";
		} else {
			message = "존재하지 않는 월입니다.";
		}

		System.out.println("if의 " + message);

		switch (month) {
		case 12:
		case 1:
		case 2:
			message = "겨울이다";
			break;
		case 3:
		case 4:
		case 5:
			message = "봄이다";
			break;
		case 6:
		case 7:
		case 8:
			message = "여름이다";
			break;
		
		// java 17 버전에서 사용 가능 (이전 버전은 묶을 수 없음)
		case 9, 10, 11:
			message = "가을이~ 오면~";
			break;
		default:
			message = "존재하지 않는 월";
			break;
		}

		System.out.println("switch의 " + message);

	}

	private static void method2() {
		// 조건문 switch
		System.out.println("함수 2 실행~");

		Scanner sc = new Scanner(System.in);
		System.out.print("점수 입력 >> ");
		int score = sc.nextInt();
		String grade;

		switch (score / 10) {
		case 10:
			grade = "A";
			// 10과 9의 결과가 같기 때문에 break를 넣지 않아도 됨
			// 17 버전은 case 묶기(10, 9)가 가능
			// 이전 버전들은 case 묶기 불가능
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
			break;

		}

		System.out.println("switch 결과는 " + score + " -> " + grade);
	}

	private static void method1() {
		// 조건문 if
		System.out.println("함수 1 실행~");

		Scanner sc = new Scanner(System.in);
		System.out.print("점수 입력 >> ");
		int score = sc.nextInt();
		String grade;

		if (score >= 90) {
			grade = "A";
		} else if (score >= 80) {
			grade = "B";
		} else if (score >= 70) {
			grade = "C";
		} else if (score >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}

		System.out.println("if 결과는 " + score + " -> " + grade);

	}

}
