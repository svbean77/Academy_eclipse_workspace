// 07
package com.shinhan.day05;

//8장 LAB2 상속
public class LabRectangle extends LabShape implements LabResizable {
	double width;
	double height;

	LabRectangle(double w, double h) {
		super(4);
		this.width = w;
		this.height = h;
	}

	@Override
	public void resize(double s) {
		this.width = width * s;
		this.height = height * s;
	}

	@Override
	double getArea() {
		return width * height;
	}

	@Override
	double getPerimeter() {
		return 2 * (width + height);
	}

}
