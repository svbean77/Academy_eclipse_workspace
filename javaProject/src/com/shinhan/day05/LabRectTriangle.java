// 07
package com.shinhan.day05;

//8장 LAB2 상속
public class LabRectTriangle extends LabShape {
	double width;
	double height;

	LabRectTriangle(double w, double h) {
		super(3);
		this.width = w;
		this.height = h;
	}

	@Override
	double getArea() {
		return width * height / 2.0;
	}

	@Override
	double getPerimeter() {
		return width + height + Math.sqrt((height * height) + (width * width));
	}

}
