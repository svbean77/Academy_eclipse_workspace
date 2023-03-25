// 09
package com.shinhan.day04;

public class SingletonTest {

	public static void main(String[] args) {
		MyServlet a = MyServlet.getInstance(); // 생성자의 접근지정자가 private이기 때문에 new로 생성 불개능
		MyServlet b = MyServlet.getInstance();

		System.out.println(a == b); // 같은 객체를 가리키기 때문에 주소가 같음
		a.print();
		a.print2();

	}

}
