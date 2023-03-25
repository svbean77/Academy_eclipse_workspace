// 06
package com.shinhan.day06;

// 익명 객체
public class AnonymousTest {

	public static void main(String[] args) {
		f1();
		f2();
		f3();
		f4();
	}

	public static void f4() {
		System.out.println("** 함수 f4 실행 *");
		// .class에 저장되지 않기 때문에 익명이라고 부름
		RemoteControl tv = new RemoteControl() {
			int a = 10;

			public void method() {
				// RemoteControl에 존재하지 않는 형식이기 때문에 호출할 수 없음....
				// -> 내부에서 사용하기 위해 추가하는 것! 외부에서는 interface 내용만 가능
				System.out.println("구현class에서 추가한 a의 값은?! " + a);
			}

			public void turnOn() {
				System.out.println("TV의 전원을 켰다");
				method();
			}

			public void turnOff() {
				System.out.println("TV의 전원을 껐다");
			}
		};
		
		tv.turnOn();
		tv.turnOff();
//		System.out.println(tv.a);
//		tv.method();

	}

	private static void f3() {
		// 2. 익명객체 - 변수에조차 저장하고싶지 않아 (정말 일회용)
		System.out.println("** 함수 f3 실행 *");
		(new Colorable() {

			@Override
			public void setForeground(String color) {
				System.out.println("나는 익명의 앞판 색이야: " + color);

			}

			@Override
			public void setBackground(String color) {
				System.out.println("나는 익명의 뒷판 색이야: " + color);

			}
		}).setBackground("black"); // 대신 정말 한 번만 가능.. 다른 함수는 사용 못 해..

	}

	private static void f2() {
		// 2. 익명 객체 - 클래스가 아닌 그냥 변수에 넣어 사용 (클래스 만들고 싶지 않아)
		System.out.println("** 함수 f2 실행 *");
		Colorable a = new Colorable() {
			// interface의 객체를 생성할 수 없어 -> 재정의는 가능 == 익명객체
			// interface의 타입 변수에 넣어주면 됨!
			// 한 번 쓰고 버림.. 저장을 하지 않아
			// 굉장히 많이 쓰이는 방법!

			@Override
			public void setForeground(String color) {
				System.out.println("나는 익명의 앞판 색이야: " + color);

			}

			@Override
			public void setBackground(String color) {
				System.out.println("나는 익명의 뒷판 색이야: " + color);

			}
		};

		a.setForeground("green");
		a.setBackground("yellow");
	}

	private static void f1() {
		// 1. 일반적인 방법
		System.out.println("** 함수 f1 실행 *");
		Book book = new Book();
		book.title = "이것이 자바다";
		book.setForeground("white");
		book.setBackground("blue");

		Cup cup = new Cup();
		cup.size = 10;
		cup.setForeground("orange");
		cup.setBackground("purple");
	}

}
