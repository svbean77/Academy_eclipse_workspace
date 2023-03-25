// 08
package com.shinhan.day06;

public class ExceptionTest2 {

	public static void main(String[] args) {
		// Exception: 원래는 자동으로 발생 ('예외'잖아. 0으로 나눠라!였지 예외를 발생시켜라!가 아니었음)'
		// 강제로 예외 발생시키고싶음(사용자 정의는 무조건 이거) -> throw 예약어 사용하면 가능! (throw's'는 예외 던지기)

//		int a = 10 / 0; // 자동으로 발생하는 예외
		// ex. 첫 글자가 영어 대문자가 아니면 오류야!
		String pass = "123456";

		char ch = pass.charAt(0);
		try {
			if (ch < 'A' || ch > 'Z') {
				throw new LoginException("첫 글자는 대문자로 시작해야해..."); // 예외 객체를 만든다고 했잖아
			}
		} catch (LoginException e) {
			e.printMessage();
			e.printStackTrace();
		}

		System.out.println("-- main 종료 --");
	}

}
