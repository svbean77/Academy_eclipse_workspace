// 03
package com.shinhan.day05;

public class TestShape {

	public static void main(String args[]) {
		Shape[] s = new Shape[3];

		s[0] = new Circle("BLUE", 10);
		s[1] = new Rectangle("RED", 5, 7);
		s[2] = new Circle("GREEN", 8);

		for (int i = 0; i < 3; i++) {
			// s[i]는 toString()을 호출하는 것!!!!!
			if (s[i] instanceof Circle) {
				System.out.println(
						"Shape " + i + " is a " + s[i] + " with an area of " + s[i].calculateArea() + ", a radius of "
								+ ((Circle) s[i]).getRadius() + ", and a perimeter of " + s[i].calculatePerimeter());
			} else if (s[i] instanceof Rectangle) {
				System.out.println("Shape " + i + " is a " + s[i] + " with an area of " + s[i].calculateArea()
						+ " and a perimeter of " + s[i].calculatePerimeter());
			}
		}
	}
}
