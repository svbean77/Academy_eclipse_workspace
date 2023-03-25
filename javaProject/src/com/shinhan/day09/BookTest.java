// 01 - 복습
package com.shinhan.day09;

class Box {
}

public class BookTest {

	public static void main(String[] args) {
//		제네릭: 사용할 때 타입을 결정
		Book<String> b1 = new Book<String>("이것이 자바다", 20000, "한빛", new String[] { "홍길동", "김철수" });
		Book<Integer> b2 = new Book<>(1234567890, 25000, "한빛", new String[] { "홍길동", "김철수" });
		Book<Box> b3 = new Book<>(new Box(), 30000, "한빛", new String[] { "홍길동", "김철수" });
		Book<String> b4 = Book.makeBook("자바 웹 구현", 35000);
		Book<Box> b5 = Book.makeBook(new Box(), 50000);
		Book<String> b6 = new Book<String>("이것이 자바다", 20000, "한빛출파안사", new String[] { "영희", "김철수" });
		
//		정렬하기 위해 각 객체들을 배열에 넣음! (은 Book의 제네릭이 같아야 함.. b1,b4만 비교하자)
		int result = b1.compareTo(b4);
		System.out.println(result);
		
		System.out.println(b1.equals(b6)); // 가격, 제목이 같으면 같은 것으로 정해둠
		
		System.out.println(Book.getCount() + "권의 책!");
	}

}
