package com.shinhan.day12.test;

public class No09 {
	int count = 0;

	No09() {

		count++;

		System.out.print(count + "$");

	}

	public static void main(String[] args) {

		No09 c1 = new No09();

		No09 c2 = new No09();

	}
}
