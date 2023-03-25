//01 - 복습
package com.shinhan.day09;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 클래스를 만들면 접근 지정자를 제일 먼저 봐야 함
//@NoArgsConstructor
//@AllArgsConstructor // count를 증가시키는 로직을 작성할 수 없으니 삭제
@Getter // instance만 만들어줌.. static은 직접 작성해
@Setter
@ToString
@EqualsAndHashCode(of = { "price", "title" }) // 동등비교 (객체가 동등한가?): 기본은 주소, 재정의로 내용으로 바꿈)
public class Book<T> /* extends Objects */ implements Comparable<Book> { // 비교 속성을 만들기 -> Comparable
//	Comparable에 제네릭을 작성하지 않으면 Object와 비교 -> Object를 Book으로 형변환 해야 함! -> 처음부터 Book만 들어오게 제한하자~
//	클래스 변수의 목적: 데이터 저장 (틀이기 때문에 값 대입은 안함)
//	외부에서 변수에 막 접근할 수 없게 하기 위해 접근지정자 설정
	private T title; // 가변 타입이다 (타입이 뭔지 몰라)
	private int price;
	private String publisher;
	private String[] author;
	private static int count; // 전체 책의 권 수
	private final String company; // static이 안붙었으면 생성자에서 초기화 가능
	private static final String COMPANY = "신한출판사"; // static이 붙으면 클래스거라 선언시 초기화

	Book() {
		company = "신한";
		count++;
	}

	public Book(T title, int price, String publisher, String[] author) {
		super();
		this.title = title;
		this.price = price;
		this.publisher = publisher;
		this.author = author;
		company = "신한";
		count++;
	}

	@Override
	public int compareTo(Book book) {
		return price - book.price; // 가격 오름차순
	}

//	T의 타입은 클래스 생성시 이미 정해짐 따라서 클래스 매소드에서는 T 타입임을 알리지 않아도 됨!
//	단, static 메소드는 객체 생성 전 메모리에 올라가기 때문에 제네릭을 알려야 함
	public static <T> Book<T> makeBook(T title, int price) {
//		new Book();
		return new Book<>(title, price, "홍대출판사", new String[] { "홍길동", "김철수" });
	}

	/*
	 * @Override public int hashCode() { return Objects.hash(price, title); }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; Book other = (Book) obj; return price == other.price &&
	 * Objects.equals(title, other.title); }
	 */

	/*
	 * @Override public String toString() { return "Book [title=" + title +
	 * ", price=" + price + ", publisher=" + publisher + ", author=" +
	 * Arrays.toString(author) + "]"; }
	 */

	/*
	 * public String getTitle() { return title; }
	 * 
	 * public void setTitle(String title) { this.title = title; }
	 * 
	 * public int getPrice() { return price; }
	 * 
	 * public void setPrice(int price) { this.price = price; }
	 * 
	 * public String getPublisher() { return publisher; }
	 * 
	 * public void setPublisher(String publisher) { this.publisher = publisher; }
	 * 
	 * public String[] getAuthor() { return author; }
	 * 
	 * public void setAuthor(String[] author) { this.author = author; }
	 * 
	 * public static int getCount() { return count; }
	 * 
	 * public static void setCount(int count) { Book.count = count; }
	 * 
	 * public static String getCompany() { return COMPANY; }
	 */
	public static int getCount() {
		return count;
	}

}
