// 06
package com.shinhan.day02;

public class 반복문 {

	public static void main(String[] args) {
		forTest();
		forTest2();
		whileTest2();
		forTest4();

	}

	private static void forTest4() {
		// continue, 1~10까지의 합계
		int su = 1;
		int total = 0;

		for (; su <= 10; su++) {
			total += su;
			System.out.print(su);
			System.out.print(su == 10 ? "" : " + ");
		}
		System.out.println("\ncontinue가 없는 합계 = " + total);

		su = 1;
		total = 0;
		for (; su <= 10; su++) {
			if (su % 2 == 0) { // 짝수일 때만 문장을 실행하겠다

				total += su;

				System.out.print(su);
				System.out.print(su == 10 ? "" : " + ");
			}
		}
		System.out.println("\nif를 이용한 짝수 합계 = " + total);

		su = 1;
		total = 0;
		for (; su <= 10; su++) {
			if (su % 2 != 0) // 홀수일 때는 실행하지 않겠다
				continue; // 밑의 코드를 실행하지 않고 다시 반복문 조건으로 돌아감

			total += su;

			System.out.print(su);
			System.out.print(su == 10 ? "" : " + ");
		}
		System.out.println("\ncontinue를 이용한 짝수 합계 = " + total); // 위의 if와 같은 결과

	}

	private static void whileTest2() {
		int i = 1;
		while (i <= 10) {
			System.out.println(i);
			i++;

		}
		System.out.println("while 언제 빠져냐갔니: i = " + i);

		int j = 100;
		do {
			System.out.println(j);
			j++;

		} while (j <= 20);
		System.out.println("do while 언제 빠져냐갔니: j = " + j);

	}

	private static void forTest2() {
		int i = 1;
		while (true) {
			if (i > 10)
				break;
			System.out.println(i);
			i++;

		}
		System.out.println("기본 while 언제 빠져냐갔니: i = " + i);
	}

	private static void forTest() {
		// 반복문 for
		// 1부터 10까지 출력한다.
		int i;
		for (i = 1; i <= 10; i++) {
			System.out.println(i);

		}
	}

}
