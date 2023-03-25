package com.shinhan.day03;

import java.util.Scanner;

public class ch05Check {

	public static void main(String[] args) {
		ch05no01();
		ch05no02();
		ch05no03();
		ch05no04();
		ch05no05();
		ch05no06();
		ch05no07();
		ch05no08();
		ch05no09();

	}

	private static void ch05no09() {
		// 5장 확인문제 9번
		Scanner sc = new Scanner(System.in);

		int[] scores = null;
		int max = Integer.MIN_VALUE;
		int sum = 0;

		while (true) {
			System.out.println("---------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("---------------------------------------------------");
			System.out.print("선택 >> ");

			int select = sc.nextInt();

			if (select == 1) {
				System.out.print("학생수 >> ");
				int num = sc.nextInt();
				scores = new int[num];
			} else if (select == 2) {
				for (int i = 0; i < scores.length; i++) {
					System.out.printf("scores[%d] >> ", i);
					int score = sc.nextInt();
					scores[i] = score;
					sum += score;
					if (max < score)
						max = score;
				}
			} else if (select == 3) {
				for (int i = 0; i < scores.length; i++) {
					System.out.printf("score[%d] = %d\n", i, scores[i]);
				}
			} else if (select == 4) {
				System.out.println("최고 점수: " + max);
				System.out.println("평균 점수: " + ((double) sum / scores.length));
			} else if (select == 5) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("잘못된 번호입니다. 다시 선택해주세요.");
			}
		}

	}

	private static void ch05no08() {
		// 5장 확인문제 8번
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
		int sum = 0;
		int cnt = 0;

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sum += array[i][j];
				cnt++;
			}
		}

		double avg = (double) sum / cnt;

		System.out.println("배열의 총합: " + sum + ", 배열의 평균: " + avg);
	}

	private static void ch05no07() {
		// 5장 확인문제 7번
		int[] array = { 1, 5, 3, 8, 2 };

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		System.out.println("최대값: " + max);

	}

	private static void ch05no06() {
		// 5장 확인문제 6번
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
		System.out.println(array.length); // 3
		System.out.println(array[2].length); // 5

	}

	private static void ch05no05() {
		// 5장 확인문제 5번
		// 1. 정수 타입 배열 항목의 기본 초기값은 0이다. -> O
		// 2. 실수 타입 배열 항목의 기본 초기값은 0.0f 또는 0.0이다. -> O
		// 3. boolean 타입 배열 항목의 기본 초기값은 true이다. -> X
		// 4. 참조 타입 배열 항목의 기본 초기값은 null이다. -> O

	}

	private static void ch05no04() {
		// 5장 확인문제 4번
		// 1. int[] array = {1, 2, 3}; -> O
		// 2. int[] array; array = {1, 2, 3} -> X
		// 3. int[] array = new int[3]; -> O
		// 4. int[][] array = new int[2][3]; -> O
	}

	private static void ch05no03() {
		// 5장 확인문제 3번
		// 1. String은 클래스이므로 참조 타입이다. -> O
		// 2. String 타입 문자열 비교는 ==를 사용해야 한다. -> X
		// 3. 동일한 문자열 리터럴을 저장하는 변수는 동일한 String 객체를 참조한다. -> O
		// 4. new String ("문자열")은 문자열이 동일하더라도 다른 String 객체를 생성한다. -> O

	}

	private static void ch05no02() {
		// 5장 확인문제 2번
		// 1. 로컬 변수는 스택 영역에 생성되며 실행 블록이 끝나면 소멸된다. -> O
		// 2. 메소드 코드나 상수, 열거 상수는 정적(메소드) 역역에 생성된다. -> O
		// 3. 참조되지 않는 객체는 프로그램에서 직접 소멸 코드를 작성하는 것이 좋다. -> X
		// 4. 배열 및 객체는 힙 영역에 생성된다. -> O

	}

	private static void ch05no01() {
		// 5장 확인문제 1번
		// 1. 참조 타입에는 배열, 열거, 클래스, 인터페이스가 있다. -> O
		// 2. 참조 타입 변수의 메모리 생성 위치는 스택이다. -> O
		// 3. 참조 타입에서 ==, != 연산자는 객체 번지를 비교한다. -> O
		// 4. 참조 타입은 null 값으로 초기화할 수 없다. -> X

	}

}
