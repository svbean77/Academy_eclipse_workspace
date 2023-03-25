// 01
package com.shinhan.day06;

// 익명 객체 예제
public class Cup implements Colorable{
	String foregroundColor;
	String backgroundColor;
	int size;

	@Override
	public void setForeground(String color) {
		System.out.println("Cup의 Foreground를 변경: " + color);
		foregroundColor = color;
	}

	@Override
	public void setBackground(String color) {
		System.out.println("Cup의 Background를 변경: " + color);
		backgroundColor = color;
	}

}
