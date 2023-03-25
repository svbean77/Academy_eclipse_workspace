// 09
package com.shinhan.day02;

import java.util.Scanner;

public class LAB2 {

	// JVM이 main 함수를 찾아야 하기 때문에 main의 접근 지정자는 public
	// static: >java LAB2 실행하면 실행하기 전에 LAB2 class의 byte code가 method 영역으로 올라감
	// void: return 값이 없다. = 함수 수행 후 돌아갈 때 값을 가지고 가지 않는다.
	public static void main(String[] args) {
		// num1();
		// num2();
		// num3();
		// num4();
		// num5();
		// num6();
		/* num7 */
		// Scanner sc = new Scanner(System.in);
		// System.out.print("궁금한 년도를 입력 >> ");
		// int year = sc.nextInt();
		// System.out.print("궁금한 월을 입력 >> ");
		// int month = sc.nextInt();
		// numDay(year, month);
		// sc.close();
		/* num8 */
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 수를 입력 >> ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 수를 입력 >> ");
		int num2 = sc.nextInt();
		num8(num1, num2);

	}

	private static void num8(int num1, int num2) {
		// 4장 LAB2 8번 문제
		int gcd = 1;
		// 함수를 모를 때: int min = num1 < num2 ? num1 : num2;
		for (int num = Math.min(num1, num2); num > 0; num--) {
			if (num1 % num == 0 && num2 % num == 0) {
				gcd = num;
				break;
			}
		}

		System.out.printf("%d와 %d의 최대 공약수는 %d", num1, num2, gcd);

	}

	// void: return값이 없다.
	// static: class가 메모리에 load 될 때 method 영역에 올라간다.
	// public: 모든 패키지에서 이 함수를 호출할 수 있다.
	public static void numDay(int year, int month) {
		// 4장 LAB2 7번 문제
		int day = 28;

		switch (month) {
		case 4, 6, 9, 11:
			day = 30;
			break;
		case 1, 3, 5, 7, 8, 10, 12:
			day = 31;
			break;
		case 2:
			if (year % 4 == 0) {
				if (year % 100 != 0 || year % 400 == 0)
					day = 29;
			}
			break;
		default:
			System.out.println(month + "월은 존재하지 않습니다. 다시 입력하세요.");
			return;
		}
		System.out.printf("%d년 %d월의 마지막 날은 %d일\n", year, month, day);

		/* 교수님 풀이 */
		int lastDay = 0;
		switch (month) {
		case 1, 3, 5, 7, 8, 10, 12:
			lastDay = 31;
			break;
		case 4, 6, 9, 11:
			lastDay = 30;
			break;
		case 2:
			lastDay = isLeap(year) ? 29 : 28;
			break;
		default:
			System.out.println("잘못된 월 입력함");
		}
		System.out.printf("%d년 %d월 %d일 끝~~~~", year, month, lastDay);

	}

	public static boolean isLeap(int year) {

		boolean result = false;
		if (year % 4 == 0) {
			if (year % 100 != 0 || year % 400 == 0)
				result = true;
		}
		return result;
	}

	private static void num6() {
		// 4장 LAB2 6번 문제
		Scanner sc = new Scanner(System.in);

		System.out.print("궁금한 년도를 입력 >> ");
		int year = sc.nextInt();
		int day;

		if (year % 400 == 0) {
			day = 29;
		} else if (year % 100 == 0) {
			day = 28;
		} else if (year % 4 == 0) {
			day = 29;
		} else {
			day = 28;
		}

		System.out.println(year + "년 2월의 말일은 " + day + "일 입니다. " + (day == 29 ? "(윤년)" : ""));

		/* 교수님 풀이 */
		boolean result = false;
		if (year % 4 == 0) {
			if (year % 100 != 0 || year % 400 == 0)
				result = true;
		}

		if (result) {
			System.out.println(year + "년은 윤년!");
		} else {
			System.out.println(year + "년은 윤년이 아님..");
		}

		sc.close();
	}

	private static void num5() {
		// 4장 LAB2 5번 문제
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 번째 항까지 더하겠습니까 >> ");
		int cnt = sc.nextInt();

		int sum = 0;
		int num = 1; // 첫 항 = 1
		int increment = 1; // 1, 2항의 차 = 1

		for (int i = 1; i <= cnt; i++) {
			sum += num;
			num += increment;
			increment++;
		}

		System.out.println(cnt + "번째까지의 합: " + sum);

		sc.close();

	}

	private static void num4() {
		// 4장 LAB2 4번 문제
		Scanner sc = new Scanner(System.in);

		System.out.print("양의 정수를 입력하세요 >> ");
		int num = sc.nextInt();

		if (num < 1 || num > 1000) {
			System.out.println("잘못된 숫자를 입력했습니다.");
			return;
		}

		int cnt = 0; // 배수 개수
		int sum = 0; // 배수의 합
		for (int i = num; i <= 1000; i += num) {
			cnt++;
			sum += i;

		}

		System.out.println(num + "의 배수 개수 = " + cnt);
		System.out.println(num + "의 배수 합 = " + sum);

		sc.close();

	}

	private static void num3() {
		// 4장 LAB2 3번 문제
		Scanner sc = new Scanner(System.in);

		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요 >> ");
		int num = sc.nextInt();

		if (num < 2 || num >= 10) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			sc.close();
			return;
		}

		int answer = 1;
		for (int i = 1; i <= num; i++) {
			answer *= i;
			System.out.printf("%d! = %d\n", i, answer);
		}

		sc.close();

	}

	private static void num2() {
		// 4장 LAB2 2번 문제
		Scanner sc = new Scanner(System.in);

		System.out.print("2 ~ 100 사이의 정수를 입력하세요 >> ");
		int num = sc.nextInt();
		boolean isPrime = true;

		for (int i = 2; i <= (num / 2); i++) {
			if (num % i == 0) {
				// isPrime = false;
				isPrime = !isPrime;
				break;
			}
		}

		if (isPrime) {
			System.out.println(num + "는(은) 소수입니다.");
		} else {
			System.out.println(num + "는(은) 소수가 아닙니다.");
		}

		sc.close();
	}

	private static void num1() {
		// 4장 LAB2 1번 문제
		Scanner sc = new Scanner(System.in);

		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요 >> ");
		int num = sc.nextInt();

		if (num < 2 || num >= 10) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			return; // 함수 빠지기
		}

		for (int i = 1; i <= 9; i++) {
			System.out.println(num + " * " + i + " = " + (num * i));
			System.out.printf("%d * %d = %d\n", num, i, (num * i));
		}
		sc.close();
	}

}
