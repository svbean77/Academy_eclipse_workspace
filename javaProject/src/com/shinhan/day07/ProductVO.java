// 02 - f1()
// 03
package com.shinhan.day07;

import java.util.Objects;

public class ProductVO {
	private String name;
	private int price;
	private String maker;

	public ProductVO(String name, int price, String maker) {
		this.name = name;
		this.price = price;
		this.maker = maker;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String toString() {
		return "ProductVO [name=" + name + ", price=" + price + ", maker=" + maker + "]";
	}
	
//	ObjectTest2 f1()을 위한 함수 재정의
	@Override
	public int hashCode() {
		return Objects.hash(maker, name, price);
	}

	@Override
	public boolean equals(Object obj) {
//		this.equals(obj);
//		나와 나를 비교하는 경우
		if (this == obj)
			return true;
//		나와 null을 비교하는 경우
		if (obj == null)
			return false;
//		두 객체의 클래스가 다른 경우 ex)Date와 String 비교
		if (getClass() != obj.getClass())
			return false;
//		제대로 된 ProductVO 타입을 넣었다면 비교 시작!
		ProductVO other = (ProductVO) obj;
//		maker, name은 참조타입(String)니까 equals로 비교
//		price는 기본타입(int)니까 == 연산자로 비교
		return Objects.equals(maker, other.maker) && Objects.equals(name, other.name) && price == other.price;
	}

	
}
