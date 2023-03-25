// 09
package com.shinhan.day06;

//11장 LAB
public class DiceGame {
	public static void main(String args[]) {
		// 0~1 사이의 랜덤 실수를 만들어주는 함수!
		double a = Math.random();
		System.out.println("Math.random(): " + a);
		// 0 <= num < 10
		int b = (int) (a * 10);
		System.out.println("0 <= num < 10: " + b);
		// 1 <= num < 11
		System.out.println("1 <= num < 11: " + (b + 1));

		DiceGame game = new DiceGame();

		int result1 = game.countSameEye(10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result1);

		int result2 = game.countSameEye(-10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result2);

	}

	int countSameEye(int n) {
		// if(n < 0) throw new IllegalArgumentException("음수가 들어올 수 없다!");
		// 맨 처음에 예외 넣어버리고 그냥 try 쓰지 말고 해도 되잖아..
		int cnt = 0;
		int cnt2 = 0;
		try {
			if (n < 0)
				throw new IllegalArgumentException("던지는 횟수는 0 이상입니다.");

			Dice dice1 = new Dice(8);
			Dice dice2 = new Dice(8);

			// for문 버전
			System.out.println("--- for ---");
			for (int i = 0; i < n; i++) {
				int num1 = dice1.play();
				int num2 = dice2.play();
				System.out.println(num1 + " vs " + num2);

				if (num1 == num2)
					cnt++;
			}

			// while문 버전
			System.out.println("--- while ---");
			while (n > 0) {
				int num1 = dice1.play();
				int num2 = dice2.play();
				System.out.println(num1 + " vs " + num2);

				if (num1 == num2)
					cnt2++;
				n--;
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		System.out.println();
		return cnt2;
	}
}
