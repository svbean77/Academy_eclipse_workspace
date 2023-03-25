// 04
package com.shinhan.day04;

// 정보 로직은 없다 -> 책에 대한 업무만 존재
// service: business logic 구현 (업무 로직이 들어있는 곳)
public class BookService {
	BookVO[] booklist;

	public BookService(BookVO[] booklist) {
		this.booklist = booklist;
	}

	public void printBookList() {
		System.out.println("=== 책 목록 ===");
		for (BookVO book : booklist) {
			System.out.println(book.getTitle());
			System.out.println(book); // override 해서 변수가 나옴! 원래는 주소
			
		}
	}

	public void printTotalPrice() {
		int total = 0;
		for (BookVO book : booklist) {
			total += book.getPrice();
		}

		System.out.println("=== 책 가격의 총합 === ");
		System.out.println("전체 책 가격의 합: " + total);
	}
}
