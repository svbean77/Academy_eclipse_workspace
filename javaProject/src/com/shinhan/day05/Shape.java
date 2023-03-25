// 03
package com.shinhan.day05;

// abstract class: abstract method를 가질 수 있음
// 추상클래스는 직접 객체를 생성할 수 없음: new Shape() 불가능!
// 추상클래스를 상속받은 자식클래스를 이용해 객체를 생성해야 함
public abstract class Shape {

	private String color;
	private String type;

	public Shape() {
	}

	public Shape(String color, String type) {
		this.color = color;
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public String getType() {
		return type;
	}

	//abstract method: 정의는 있고 구현은 상속받은 자식 class에서 반드시 해야 함 (overriding)
	public abstract double calculateArea();

	public abstract double calculatePerimeter();

	public String toString() {
		return color + " " + type;
	}

}
