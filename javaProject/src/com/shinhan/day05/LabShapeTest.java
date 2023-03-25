// 07
package com.shinhan.day05;

//8장 LAB2 상속
public class LabShapeTest {
	public static void main(String[] args) {
		LabShape[] shapes = new LabShape[2];

		shapes[0] = new LabRectangle(5, 6);
		shapes[1] = new LabRectTriangle(6, 2);

		for (LabShape shape : shapes) {
			System.out.println("area: " + shape.getArea());
			System.out.println("perimeter: " + shape.getPerimeter());
			if (shape instanceof LabResizable) {
				LabRectangle newShape = (LabRectangle) shape;
				newShape.resize(0.5);
				System.out.println("new area: " + newShape.getArea());
				System.out.println("new perimeter: " + newShape.getPerimeter());
			}

		}
	}
}
