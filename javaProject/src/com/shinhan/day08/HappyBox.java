// 03 - f2(), f6(), f9()
package com.shinhan.day08;

// 제네릭을 사용한 클래스
public class HappyBox<T> {
	T kind; // 종류는 문자열, 숫자 등등 여러 타입으로 올 수 있다! -> 어떤 타입이 들어올지는 사용자가 결정해줄거야!
	int price;

	public HappyBox(T kind, int price) {
		super();
		this.kind = kind;
		this.price = price;
	}

	public Object getKind() {
		return kind;
	}

	public void setKind(T kind) {
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
