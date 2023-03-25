// 04
// 05
// 07
package com.shinhan.day04;

// 업무 로직은 없다 -> 책에 대한 정보만 존재
// = VO (value object): 데이터를 저장하는 가방
// = DTO (data transfer object): 데이터를 저장해서 전송하는 목적
// JavaBeans 기술에서 사용: 멤버변수 private으로 설정, 멤버 method public으로 설정
// : JspServlet, Spring, MyBatis framework에서 사용됨
public class BookVO {
	// instance 변수 vs class 변수를 판단하는 것은 static의 존재!
	// instance 변수
	private String title;
	private int price;
	final String isbn = "23456789"; // final: 수정 불가 (생성할 때 초기화 -> 선언시, new 생성시)
	final String isbn2; // new 시점에 초기화: 생성자에서 선언 (매개변수를 받아 사용해도 됨)

	// class 변수
	static int count; // 책 개수
	final static String PUBLISHER = "신한DS"; // 상수는 선언시에만 가능 (final static), 관례상 대문자로 작성

	BookVO(String title, int price) {
		System.out.println("day04에 있는 BookVO class 입니다.");
		this.title = title;
		this.price = price;
		count++;
		isbn2 = title + "23456789";
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "BookVO [title=" + title + ", price=" + price + "]";
	}

}
