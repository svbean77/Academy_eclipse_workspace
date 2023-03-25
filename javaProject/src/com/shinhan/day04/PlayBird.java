// 03
package com.shinhan.day04;

public class PlayBird {

	public static void main(String[] args) {
		// 6장 LAB3
		Duck duck = new Duck("꽥꽥이", 2, 15);
		duck.fly();
		duck.sing();
		duck.display();

		Sparrow sparrow = new Sparrow("짹짹이", 2, 10);
		sparrow.fly();
		sparrow.sing();
		sparrow.display();

		System.out.println(duck); // 객체를 찍으면 주소가 나옴! (heap 영역에 생성된 주소, 지금은 override해서 string 나옴)
		System.out.println(duck.toString());
		System.out.println(sparrow.toString());
	}

}
