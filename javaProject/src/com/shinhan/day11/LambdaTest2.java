// 03 - 람다식
// f1: Calculable2 - 익명객체 final
// f1: Calculable2 - 람다 final
package com.shinhan.day11;

public class LambdaTest2 {

	public static void main(String[] args) {
//		f1(100);
		new LambdaTest2().f2(100);
	}

	 String subject = "자바"; // f2()
	
	private  void f2(int num1) {
//		내부 클래스에서 지역변수를 사용한다면 final 특성을 가짐 (수정 불가)
		int num2 = 200;
		int num3 = 1;
//		num1++; // 여기서 값을 변경시키면 내부 클래스에서 사용 불가능
//		num2++; // 여기서 값을 변경시키면 내부 클래스에서 사용 불가능
		num3++;// 내부 클래스에서 사용하지 않았기 때문에 수정 가능!

		Calculable2 f = (x, y) -> {
			System.out.println("-- 람다식 --" + subject);
//			num1++; // final 특성을 갖기 때문에 불가능
//			num2++; // final 특성을 갖기 때문에 불가능
			return x + y + num1 + num2;
		};
		int result = f.calculate(1, 2);
		System.out.println("result: " + result);
	}

	private static void f1(int num1) { // 파라미터도 지역변수임
//		내부 클래스에서 final 특성을 가짐
//		1. 익명구현클래스 -> 얘도 내부 클래스임! 클래스를 작성하지 않고 익명으로 구현한거야!

//		내부 클래스에서 지역변수를 사용한다면 final 특성을 가짐 (수정 불가)
		int num2 = 200;
		int num3 = 1;
//		num1++; // 여기서 값을 변경시키면 내부 클래스에서 사용 불가능
//		num2++; // 여기서 값을 변경시키면 내부 클래스에서 사용 불가능
		num3++;// 내부 클래스에서 사용하지 않았기 때문에 수정 가능!

		Calculable2 f = new Calculable2() {
			@Override
			public int calculate(int x, int y) {
				System.out.println("-- 익명 구현 객체 -- ");
//				num1++; // final 특성을 갖기 때문에 불가능
//				num2++; // final 특성을 갖기 때문에 불가능
				return x + y + num1 + num2;
			}
		};
		int result = f.calculate(1, 2);
		System.out.println("result: " + result);
	}

}
