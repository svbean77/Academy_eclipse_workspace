// 08
package com.shinhan.day02;

public class StringUtil {
	// 4장 LAB1 4번 문제

	public static void hokeyGraphics(char cell, int size, boolean isRect) {
		// 특정 도형을 출력하는 메소드 구현
		if (isRect) {
			System.out.println("사각형 모양을 찍어보자!");
			for (int row = 1; row <= size; row++) {
				for (int col = 1; col <= size; col++) {
					System.out.print(cell);
				}
				System.out.println();
			}
		} else {
			System.out.println("삼각형 모양을 찍어보자!");
			for (int row = 1; row <= size; row++) {
				for (int col = 1; col <= row; col++) {
					System.out.print(cell);
				}
				System.out.println();
			}
		}

		System.out.println("두 코드를 합친 버전");
		for (int row = 1; row <= size; row++) {
			for (int col = 1; col <= (isRect ? size : row); col++) {
				System.out.print(cell);
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		hokeyGraphics('&', 4, false);
		hokeyGraphics('@', 7, true);
	}

}
