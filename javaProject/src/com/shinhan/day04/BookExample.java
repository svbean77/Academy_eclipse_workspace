// 05
package com.shinhan.day04;

public class BookExample {

	public static void main(String[] args) {
		// final, static 연습
		// final이 붙을 수 있는 위치: 변수(값 수정 불가), method(override 불가), class(상속 불가)

		System.out.println("책 생성 전 개수: " + BookVO.count);

		BookVO[] b = new BookVO[5];
		b[0] = new BookVO("Java Program", 30000);
		b[1] = new BookVO("JSP Program", 25000);
		b[2] = new BookVO("SQL Fundamentals", 20000);
		b[3] = new BookVO("JDBC Program", 32000);
		b[4] = new BookVO("EJB Program", 25000);

		System.out.println("책 생성 후 개수: " + BookVO.count);

		// final 값은 초기화 이후 변경 불가능
		// b[0].isbn = "111";
		// b[0].publisher = "222";
		// BookVO.publisher = "aa";

		// final 읽기는 가능
		System.out.println(b[0].isbn + ", " + b[0].isbn2);
		System.out.println(BookVO.PUBLISHER);

		Integer a = new Integer(100); // new 방식으로 사용하는 것이 아니라고 표시 (에러는 아닌데 추천 X)
		Integer a2 = 100; // 이 방식으로 쓰는 것을 권장!
		System.out.println(a.MAX_VALUE); // 권장은 안 함.. (static이니까 class 변수잖아)
		System.out.println(Integer.MAX_VALUE); // class 변수는 class 이름.field로 작성하자!
	}

}
