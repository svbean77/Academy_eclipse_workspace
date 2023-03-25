// 07
package com.shinhan.day02;

import java.util.Scanner;

public class LAB1 {

	public static void main(String[] args) {
//		num1();
//		num2();
//		num3();
//		num4();
		num5();

	}

	public static void num5() {
		// 4장 LAB1 5번 문제
		Scanner sc = new Scanner(System.in);

		System.out.print("원하는 줄 수를 입력 >> ");
		int cnt = sc.nextInt();

		for (int row = 1; row <= cnt; row++) {
			for (int col = 1; col <= cnt + 1 - row; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void num4() {
		// 4장 LAB1 4번 문제는 StringUtil.java에 있음
		Scanner sc = new Scanner(System.in);

	}

	public static void num3() {
		// 4장 LAB1 3번 문제
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 입력 >> ");
		int num = sc.nextInt();
		int total = 0;

		int start = num % 2 == 0 ? 2 : 1;
		System.out.println(start);

		if (num % 2 == 0) {
			for (int i = 0; i <= num; i += 2) {
				total += i;
			}
		} else {
			for (int i = 1; i <= num; i += 2) {
				total += i;
			}
		}

		System.out.println("결과 값: " + total);

	}

	public static void num2() {
		// 4장 LAB1 2번 문제
		Scanner sc = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 >> ");
		String str = sc.nextLine();

		for (int i = 1; i <= str.length(); i++) {
			System.out.println(str.substring(0, i).toUpperCase());
		}

		sc.close();
	}

	public static void num1() {
		// 4장 LAB1 1번 문제

		// 시작하기 전 start, end, increment 변수를 먼저 선언해도 됨
		Scanner sc = new Scanner(System.in);

		System.out.print("초기값을 정수로 입력하세요 >> ");
		int start = sc.nextInt();
		System.out.print("마지막 값을 정수로 입력하세요 >> ");
		int end = sc.nextInt();
		System.out.print("증가분을 정수로 입력하세요 >> ");
		int increment = sc.nextInt();

		int total = 0;

		for (int i = start; i <= end; i += increment) {
			total += i;
		}

		if (total > 1000)
			total += 2000;
		System.out.println("총합은 " + total + "입니다.");
		System.out.printf("총합은 %d입니다.", total);

		sc.close();

	}

}
