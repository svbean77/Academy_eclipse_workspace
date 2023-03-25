// 02
package com.shinhan.day08;

class OverridingTest {
	public static void main(String args[]) {
		int i = 10;
		int j = 20;

		MySum ms1 = new MySum(i, j);
		MySum ms2 = new MySum(i, j);
		String s1 = new String("30");

		System.out.println(ms1); // 30

		if (ms1.equals(ms2))
			System.out.println("ms1과 ms2의 합계는 동일합니다.");
		else
			System.out.println("ms1과 ms2의 합계는 동일하지 않습니다.");
		if (ms1.equals(s1))
			System.out.println("ms1과 s1의 합계는 동일합니다.");
		else
			System.out.println("ms1과 s1의 합계는 동일하지 않습니다.");
	}

}

class MySum {
	int first;
	int second;

	MySum(int first, int second) {
		this.first = first;
		this.second = second;
	}

	/*
	 * 조건1 main 메소드에서 MySum 객체를 출력하면 객체 생성시에 전달한 두 정수의 덧셈 결과를 출력하도록 toString 메소드를
	 * 오버라이딩합니다
	 */
	@Override
	public String toString() {
		int sum = first + second;
//		내가 사용한 방법
//		return Integer.toString(sum);
//		교수님이 사용한 방법
		return String.valueOf(sum);
	}

	/*
	 * 조건2 main 메소드에서 MySum 클래스의 equals 메소드 호출시 전달하는 매개변수가 MySum 객체를 참조하고 현재 객체의
	 * toString 메소드와 전달 객체의 toString 메소드 내용이 동일하면 true를 리턴하고 나머지 경우에는 false 를 리턴하도록
	 * equals 메소드를 오버라이딩합니다
	 */
	@Override
	public boolean equals(Object obj) {
//		내 풀이
//		boolean result = false;
//
//		if (obj instanceof MySum sum) {
//			this.equals(my)는 다름! toString()이 자동으로 불려지는 것은 출력할 때!
//			if (this.toString().equals(sum.toString()))
//				result = true;
//		}
//		return result;

//		교수님 풀이
		if (!(obj instanceof MySum))
			return false;
		MySum my = (MySum) obj;
//		return first+second == (my.first + my.second);
//		String.equals()는 boolean을 return하니까 굳이 나처럼 결과를 만들지 않고 바로 return 해도 되잖아
		return this.toString().equals(my.toString());
//		return this.equals(my)를 한다면 계속 자신을 부르는 것을 반복 -> overflow
	}

}
