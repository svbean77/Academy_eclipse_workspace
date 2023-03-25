// 09
package com.shinhan.day04;

// servlet(java + html): server에서 수행되는 java 프로그램
// JSP(html + java): 서버가 JSP -> servlet 변경해서 실행
// 차이점: servlet에서는 java가 주인공 (html은 되도록 X), JSV에서는 html이 주인공 (java는 되도록 X)
// servlet은 싱글톤으로 동작함 = new를 한 번만 한다.
public class MyServlet {
	private static MyServlet my; // 객체 생성 전에 접근 가능해야 함 + 다른 패키지에서 접근 불가능

	private MyServlet() {
		System.out.println("MyServlet이 생성됨!");
	}

	public static MyServlet getInstance() { // 객체 생성 없이도 접근할 수 있어야 함 + 함수를 통해서만 my에서 접근
		if (my == null) {
			my = new MyServlet();
		}
		return my;
	}

	public void print() {
		System.out.println("싱글톤 연습1");
	}

	public void print2() {
		System.out.println("싱글톤 연습2");
	}

}
