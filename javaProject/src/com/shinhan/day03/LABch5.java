// 03
package com.shinhan.day03;

import java.util.Arrays;

public class LABch5 {

	public static void main(String[] args) {
		num1();
		num2();

	}

	private static void num2() {
		// 5장 LAB 2번
		int[][] a = { { 30, 30, 30, 30 }, { 40, 40, 40, 40 }, { 50, 50, 50, 50 } };
		int[][] b = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int[][] c = new int[3][4];

		int[][] d = sub(a, b, c); // 리턴 안 해도 되긴 함
		// c와 d가 가리키는 배열의 주소가 같음
		prn(c);
		prn(d);
	}

	public static int[][] sub(int[][] a, int[][] b, int[][] c) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				c[i][j] = a[i][j] - b[i][j];
			}
		}
		return c;
	}

	public static void prn(int[][] c) {
		System.out.println("행렬의 차를 계산해보자");
		for (int[] row : c) {
			for (int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	private static void num1() {
		// 5장 LAB 1번
		// 선택정렬 문제: 한 회차가 끝날 때마다 작은 값이 정렬됨 = arr[idx]보다 작으면 자리 바꿈
		int[] arr = { 3, 24, 1, 55, 17, 43, 5 };

		System.out.println("원본: " + Arrays.toString(arr));
		for (int i = 0; i < arr.length - 1; i++) { // 바로 뒤의 값과 비교하기 때문에 마지막 - 1까지 계산하면 됨 (작은쪽)
			for (int j = i + 1; j < arr.length; j++) { // 바로 앞의 값과 비교하기 때문에 시작 + 1부터 계산하면 됨 (큰쪽)
				if (arr[j] < arr[i]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}

		System.out.println("정렬: " + Arrays.toString(arr));

	}

}
