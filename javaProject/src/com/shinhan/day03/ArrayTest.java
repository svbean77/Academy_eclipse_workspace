// 02
package com.shinhan.day03;

import java.util.Arrays;

// cmd > java com/shinhan/day03/ArrayTest 100 200
// 100, 200: 명령행 매개변수 (실행시 외부에서 값을 줄 수 있음)
public class ArrayTest {

	public static void main(String[] args) {
		f1();
		f2();
		f3();
		f4();
		f5();
		f6();

		// 명령행 매개변수: run configuration > arguments에서 설정할 수 있음
		System.out.println("** 명령행 매개변수 **");
		System.out.println(args.length);
		System.out.println(Arrays.toString(args));

		if (args.length < 2) {
			// 방법1: main 함수 빠져나가기
			// return;

			// 방법2: 프로그램 강제 종료
			System.exit(0); // (일반적으로) 0: 정상 종료, -1: 비정상 종료
		}

		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		System.out.printf("명령행 %d + %d = %d", a, b, a + b);

	}

	private static void f6() {
		// 배열 복사
		System.out.println("** 함수 6 시작 **");
		int[] arr1 = new int[] { 100, 90, 80, 70, 60 };
		int[] arr2 = new int[10];
		int[] arr3 = new int[10];

		// 일반 for문을 사용한 방법
		for (int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		// 함수를 사용한 바법
		System.arraycopy(arr1, 0, arr3, 3, arr1.length);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));

	}

	private static void f5() {
		// 배열 선언과 생성을 동시에
		System.out.println("** 함수 5 시작 **");

		int[] arr = new int[5]; // 자동 초기화
		int[] arr2 = new int[] { 10, 20, 30, 40, 50 }; // 직접 초기화 하고 싶다면 길이를 생략해야 함
		int[] arr3 = { 10, 20, 30, 40, 50 }; // 변수 선언시에는 new int를 제외해도 됨 (단순 생성 부분에는 생략할 수 없음)

		System.out.println("1차원 배열 예제!");
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));

		int[][] arr4 = new int[][] { { 10, 20, 30 }, { 40, 50, 60, 70, 80 } };

		System.out.println("2차원 배열 예제!");
		for (int[] row : arr4) {
			System.out.println(Arrays.toString(row));
		}
	}

	private static void f4() {
		// 열이 초기화되지 않은 2차원 배열
		System.out.println("** 함수 4 시작 **");

		int[] arr[];
		arr = new int[3][]; // 열의 길이가 모두 다를 수 있기 때문에 미리 초기화하지 않은 경우도 있음
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		arr[0] = new int[4];
		arr[1] = new int[2];
		arr[2] = new int[3];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%d행%d열 = %d, ", i, j, arr[i][j]);
			}
			System.out.println();
		}

	}

	private static void f3() {
		System.out.println("** 함수 3 시작 **");
		// 2차원 배열
		// 1. 배열 변수 선언
		int[][] arr1;
		int[] arr2[];
		int arr3[][];
		// 2. 배열 생성
		arr1 = new int[3][4];
		arr2 = new int[3][]; // arr2의 입장에서는 행만 알아도 되기 때문에 뒷자리는 null도 가능
		// arr3 = new int[][]; // 첫 번째 행은 무조건 알아야 함
		// 3. 배열 사용
		System.out.println(arr1[0][0]);
		System.out.println(arr2[0]);

		// 일반 for문
		System.out.println("일반 for문입니당");
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.printf("%d행%d열 = %d, ", i, j, arr1[i][j]);
			}
			System.out.println();
		}

		// 확장 for문: 외부 반복자를 사용하지 않기 때문에 값만 출력할 수 있음
		System.out.println("확장 for문입니당");
		for (int[] row : arr1) {
			for (int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

	}

	private static void f2() {
		System.out.println("** 함수 2 시작 **");
		int[] scores;
		scores = new int[26];

		scores[0] = 100;
		scores[1] = 90;
		scores[2] = 80;

		int total = 0;

		// 일반 for문 이용
		for (int idx = 0; idx < scores.length; idx++) {
			// 배열의 길이는 속성 (변수)(.length)
			// 문자열의 길이는 함수 (.length())
			System.out.print(scores[idx] + " ");
			total += scores[idx];
		}
		System.out.println("일반 for문 총점은 " + total);

		total = 0;
		// 향상된, 확장된 for문 이용: 일반 for문보다 깔끔하게 사용할 수 있음
		for (int score : scores) {
			System.out.print(score + " ");
			total += score;
		}
		System.out.println("확장 for문 총점은 " + total);

	}

	private static void f1() {
		System.out.println("** 함수 1 시작 **");
		// 배열: 하나의 이름으로 같은 타입의 연속공간(힙에 만들어짐)을 만드는 자료구조
		// 1. 배열 변수 선언
		int[] arr1 = null;
		double[] arr2;
		boolean[] arr3;
		String[] arr4;
		// 2. 배열 생성: 배열의 길이가 필수
		// 생성시 자동으로 초기화 (정수: 0, 실수: 0.0, boolean: false, 객체: null
		arr1 = new int[5];
		arr2 = new double[6];
		arr3 = new boolean[6];
		arr4 = new String[6];
		// 3. 배열 사용
		System.out.println(arr1[0]);
		System.out.println(Arrays.toString(arr1)); // 정수: 0
		System.out.println(Arrays.toString(arr2)); // 실수: 0.0
		System.out.println(Arrays.toString(arr3)); // boolean: false
		System.out.println(Arrays.toString(arr4)); // 기본형이 아닌 나머지: null
	}

}
