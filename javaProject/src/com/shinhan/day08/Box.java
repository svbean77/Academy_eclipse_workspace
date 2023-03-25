// 03 - f1()
package com.shinhan.day08;

// 제네릭을 사용하지 않은 클래스
public class Box {
	Object kind; // 종류는 문자열, 숫자 등등 여러 타입으로 올 수 있다!
	int price;

	public Box(Object kind, int price) {
		super();
		this.kind = kind;
		this.price = price;
	}

	public Object getKind() {
		return kind;
	}

	public void setKind(Object kind) {
		this.kind = kind;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Box [kind=" + kind + ", price=" + price + "]";
	}

}
