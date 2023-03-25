// 07 (Computer)
package com.shinhan.day03;

public class ComputerTest {

	public static void main(String[] args) {
		f1();

	}

	private static void f1() {
		Computer com1 = new Computer();
		System.out.println(com1.getModel());
		com1.computerInfoPrint();

		Computer com2 = new Computer("완전멋진컴퓨터");
		com2.computerInfoPrint();

		Computer com3 = new Computer("윈도우", 1000);
		com3.computerInfoPrint();

		Computer com4 = new Computer("커엄퓨터어", "리눅스", 333);
		com4.computerInfoPrint();

		// static 변수는 클래스 내 하나이기 때문에 클래스명.변수로 사용해야 함!
		System.out.println("\n생성된 컴퓨터는 " + Computer.count + "입니다~\n정보보기>>");
		// com.print();를 반복할 필요 없도록 함수로 만듦
		display(com1);
		display(com2);
		display(com3);
		display(com4);
		
	}

	private static void display(Computer com) {
		System.out.println("============================");
		System.out.println(com.getModel());
		com.computerInfoPrint();
		System.out.println("============================");

	}

}
