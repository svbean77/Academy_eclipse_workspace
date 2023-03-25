// 07
package com.shinhan.day05;

// 8장 LAB2 상속
public abstract class LabShape {
	int numSides;

	LabShape(int numSides) {
		this.numSides = numSides;
	}

	public int getNumSides() {
		return numSides;
	}

	abstract double getArea();

	abstract double getPerimeter();
}
