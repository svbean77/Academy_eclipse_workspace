// 03
package com.shinhan.day05;

public class Circle extends Shape {
	double radius;
	double circumference;

	Circle(String color, double radius) {
		super(color, "Circle");
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public double calculateArea() {
		circumference = radius * radius * Math.PI;
		return circumference;
	}

	@Override
	public double calculatePerimeter() {
		return 2 * Math.PI * radius;
	}
}
