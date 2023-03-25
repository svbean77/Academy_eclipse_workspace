// 06 - f1()
package com.shinhan.day06;

// 익명 객체 예제
public class Book implements Colorable {
	String foregroundColor;
	String backgroundColor;
	String title;

	@Override
	public void setForeground(String color) {
		System.out.println("Book의 Foreground를 변경: " + color);
		foregroundColor = color;
	}

	@Override
	public void setBackground(String color) {
		System.out.println("Book의 Background를 변경: " + color);
		backgroundColor = color;
	}

}
