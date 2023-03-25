package com.shinhan.day08;

// 12장 LAB5
public class Adder {
	public static void main(String[] args) {
		Adder adder = new Adder(); // 함수가 static이 아니기 때문에 클래스의 객체를 생성함
		String expr = "3+5+9+1";
		System.out.println(expr + "=" + adder.execute(expr));
		expr = "11+45+77+3";
		System.out.println(expr + "=" + adder.execute(expr));
		expr = "33+51+12+11";
		System.out.println(expr + "=" + adder.execute(expr));
	}

	public int execute(String expr) {
		int result = 0;
		String strNum = ""; // 숫자만 따로 저장하는 문자열
		for (int i = 0; i < expr.length(); i++) { // 문자열의 길이만큼 반복문 돌리기
			char c = expr.charAt(i); // 문자열에서 한 자씩 문자를 확인
			if (c == '+') {
				result += Integer.parseInt(strNum);
				strNum = ""; // 숫자 하나가 끝났으니 다시 새로운 숫자를 시작하기 위함
			} else {
				strNum += expr.charAt(i); // 숫자면 계속 문자열에 추가해가기
			}
		}
		return (result + Integer.parseInt(strNum)); // 마지막은 '+'가 없으니 지금까지의 숫자를 더해줘야 최종 결과가 나옴
	}
}
