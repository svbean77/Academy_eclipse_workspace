// 01
package com.shinhan.day06;

public class Label implements Changeable{
	private int width, height;
	String text;
	String color;
	String font;

	public Label(int width, int height, String text, String color, String font) {
		super();
		this.width = width;
		this.height = height;
		this.text = text;
		this.color = color;
		this.font = font;
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void setForeground(String color) {
		
	}

	@Override
	public void setBackground(String color) {
		
	}

	@Override
	public void setFont(String font) {
		
	}
	
}
