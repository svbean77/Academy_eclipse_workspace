// 12
package com.shinhan.day02;

import java.util.Scanner;

public class 오은빈 {

	public static void main(String[] args) {
		ch03no01();
		ch03no02();
		ch03no03();
		ch03no04();
		ch03no05();
		ch03no06();
		ch03no07();

		ch04no01();
		ch04no02();
		ch04no03();
		ch04no04();
		ch04no05();
		ch04no06();
		ch04no07();
	}

	private static void ch04no07() {
		// 4장 확인문제 7번
		Scanner sc = new Scanner(System.in);
		String service = """
				---------------------------------
				1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
				---------------------------------
				""";

		int total = 0;
		int select = 0;
		while (select != 4) {
			System.out.print(service);
			System.out.print("선택 >> ");
			select = sc.nextInt();

			if (select == 1) {
				System.out.print("예금액 >> ");
				int tmp = sc.nextInt();
				if (tmp <= 0) {
					System.out.println("0 이하의 금액은 예금할 수 없습니다.");
				} else {
					total += tmp;
				}
			} else if (select == 2) {
				System.out.print("출금액 >> ");
				int tmp = sc.nextInt();
				if (tmp > total) {
					System.out.println("예금액보다 많은 금액을 출금할 수 없습니다.");
				} else {
					total -= tmp;
				}
			} else if (select == 3) {
				System.out.println("잔고 >> " + total);
			} else {
				if (select != 4)
					System.out.println("존재하지 않는 번호입니다. 다시 선택해주세요.");
			}
		}
		System.out.println("프로그램 종료");

	}

	private static void ch04no06() {
		// 4장 확인문제 6번
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	private static void ch04no05() {
		// 4장 확인문제 5번
		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if (4 * x + 5 * y == 60) {
					System.out.printf("x: %d, y: %d\n", x, y);
				}
			}
		}

	}

	private static void ch04no04() {
		// 4장 확인문제 4번
		while (true) {
			int num1 = (int) (Math.random() * 6) + 1;
			int num2 = (int) (Math.random() * 6) + 1;

			if (num1 + num2 == 5) {
				System.out.printf("주사위1: %d, 주사위2: %d, 합: %d", num1, num2, (num1 + num2));
				break;
			}
		}

	}

	private static void ch04no03() {
		// 4장 확인문제 3번
		int sum = 0;
		for (int i = 3; i <= 100; i += 3) {
			sum += i;
		}
		System.out.println(sum);

	}

	private static void ch04no02() {
		// 4장 확인문제 2번
		String grade = "B";

		int score1 = switch (grade) {
		case "A" -> 100;
		case "B" -> {
			int result = 100 - 20;
			yield result;
		}
		default -> 60;
		};

		System.out.println(score1);
	}

	private static void ch04no01() {
		// 4장 확인문제 1번
		// 1. if 문은 조건식의 결과에 따라 실행 흐름을 달리할 수 있다 -> O
		// 2. switch 문에서 사용할 수 있는 변수의 타입은 int, double이 될 수 있다 -> X
		// 3. for 문은 카운터 변수로 지정한 횟수만큼 반복시킬 때 사용할 수 있다. -> O
		// 4. break 문은 switch 문, for 문, while 문을 종료할 때 사용할 수 있다. -> O

	}

	private static void ch03no07() {
		// 3장 확인문제 7번
		double x = 5.0;
		double y = 0.0;
		double z = 5 % y;

		if (Double.isNaN(z)) {
			System.out.println("0.0으로 나눌 수 없습니다.");
		} else {
			double result = z + 10;
			System.out.println("결과: " + result);
		}

	}

	private static void ch03no06() {
		// 3장 확인문제 6번
		int x = 10;
		int y = 5;

		System.out.println((x > 7) && (y <= 5)); // true
		System.out.println((x % 3 == 2) || (y % 2 != 1)); // false

	}

	private static void ch03no05() {
		// 3장 확인문제 5번
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area1 = (lengthTop + lengthBottom) * height / 2.0;
		double area2 = (lengthTop + lengthBottom) * height * 1.0 / 2;
		double area3 = (double) (lengthTop + lengthBottom) * height / 2;
		double area4 = (double) ((lengthTop + lengthBottom) * height / 2);

		System.out.println(area1); // 52.5
		System.out.println(area2); // 52.5
		System.out.println(area3); // 52.5
		System.out.println(area4); // 52.0

	}

	private static void ch03no04() {
		// 3장 확인문제 4번
		int value = 356;
		System.out.println(value / 100 * 100); // 300

	}

	private static void ch03no03() {
		// 3장 확인문제 3번
		int pencils = 534;
		int students = 30;

		int pencilsPerStudent = pencils / students;
		System.out.println(pencilsPerStudent); // 17

		int pencilsLeft = pencils % students;
		System.out.println(pencilsLeft); // 24

	}

	private static void ch03no02() {
		// 3장 확인문제 2번
		int score = 85;
		String result = (!(score > 90)) ? "가" : "나";
		System.out.println(result); // 가

	}

	private static void ch03no01() {
		// 3장 확인문제 1번
		int x = 10;
		int y = 20;
		int z = (++x) + (y--); // 11 + 20
		System.out.println(z); // 31

	}

}
