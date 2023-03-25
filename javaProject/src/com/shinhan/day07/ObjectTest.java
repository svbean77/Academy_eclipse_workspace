// 01
package com.shinhan.day07;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Car {
	private String model;
	private int price;

	public Car(String model, int price) {
//		extends Object가 생략되었기 때문에 super는 Object임!
		super();
		this.model = model;
		this.price = price;
	}
//// 		내가 직접 작성하기에는 해야할 게 많아 -> eclipse에서 기본으로 제공해주는 override 함수 사용하자! (우클릭->source)
//	@Override
//	public boolean equals(Object obj) {
//		if (obj instanceof Car car) {
////			Car car = (Car) obj;
////			price는 기본형(int)이기 때문에 == 연산자는 값 비교임
////			model은 참조형(Stirng)이기 때문에 == 연산자는 주소 비교임 -> equals를 사용해 값 비교
//			return price == car.price && model.equals(car.model);
//		} else
//			return false;
//	}
//
//	@Override
//	public String toString() {
//		return "model: " + model + ", price: " + price;
//	}
//
////	f5()에서 Set에 객체를 넣어도 새로운 객체이기 때문에 hashCode가 달라 제대로 중복 제거가 되지 않아 
//	@Override
//	public int hashCode() {
////		모델과 가격이 같으면 같은 hashCode를 주기 위해 hashCode를 직접 만듦 (좋은 hashCode는 아니긴 함..)
//		return model.hashCode() + price;
//	}

//	eclipse에서 기본으로 제공하는(우클릭 -> source) 함수 사용
	@Override
	public String toString() {
		return "Car [model=" + model + ", price=" + price + "]";
	}
//  동등 비교를 할 때는 hashCode도 비교해야 함! (단순히 내용 비교면 equals만 사용)
//	동등비교(ex. hashSet): hashCode(), equals()가 같아야 같은 객체로 판별
	@Override
	public int hashCode() {
		return Objects.hash(model, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(model, other.model) && price == other.price;
	}

}

public class ObjectTest {

	public static void main(String[] args) {
		f1();
		f2();
		f3();
		f4();
		f5();
		f6();
	}

	private static void f6() {
		// f5()의 객체들을 Set에 넣음
		System.out.println("** 함수 f6 실행 **");
		// Set: 순서가 없다. 중복을 허용하지 않는다.
		Set<String> data = new HashSet<String>();
//		generic으로 타입을 제한했기 때문에 정해진 타입만 넣을 수 있음!
//		data.add(100);
		data.add("월");
		data.add("화");
		data.add("수");
//		중복을 허용하지 않기 때문에 이전의 값을 덮어씀
		data.add("월");
		data.add("월");

		for (String s : data) {
			System.out.print(s + " ");
		}
		System.out.println();

	}

	private static void f5() {
		System.out.println("** 함수 f5 실행 **");

		Set<Car> data = new HashSet<Car>();
		Car obj1 = new Car("A", 100);
		Car obj2 = new Car("B", 100);
		Car obj3 = new Car("C", 100);

		data.add(obj1);
		data.add(obj2);
		data.add(obj3);
//		add 과정에서 생성해도 됨
		data.add(new Car("D", 100));
		data.add(new Car("A", 100));
		data.add(new Car("A", 100));

//		Set은 중복 허용이 아닌데 왜 같은 A가 들어가는가? -> hashCode 값과 equals 결과 값 둘 다를 비교해야 함!
//		매번 new 되어 생성되기 때문에 hashCode는 다른 것!
//		순서가 없기 때문에 뒤죽박죽 나온다
		for (Car c : data) {
			System.out.println(c + ", hashCode: " + c.hashCode());
		}
	}

	private static void f4() {
//		사용자 정의 Class
		System.out.println("** 함수 f4 실행 **");

//		기본 생성자는 현재 시간을 생성
		Car obj1 = new Car("A모델", 100);
		Car obj2 = new Car("A모델", 100);

//		내용이 나오는 것으로 toString도 재정의!
		System.out.println("obj1: " + obj1);
		System.out.println("obj2: " + obj2);
//		두 객체의 주소 비교 (== 연산자: 기본형이면 값 비교, 객체이면 주소 비교)
		System.out.println(obj1 == obj2 ? "== 주소 같음" : "== 주소 다름");
//		두 객체의 내용 비교 (Object의 equals는 객체의 주소 비교, 직접 내용 비교로 재정의 함)
		System.out.println(obj1.equals(obj2) ? "equals 내용 같음" : "equals 내용 다름");

	}

	private static void f3() {
//		Date
		System.out.println("** 함수 f3 실행 **");

//		기본 생성자는 현재 시간을 생성
		Date obj1 = new Date();
		Date obj2 = new Date();

		System.out.println("obj1: " + System.identityHashCode(obj1));
		System.out.println("obj2: " + System.identityHashCode(obj2));
//		두 객체의 주소 비교 (== 연산자: 기본형이면 값 비교, 객체이면 주소 비교)
		System.out.println(obj1 == obj2 ? "== 주소 같음" : "== 주소 다름");
//		두 객체의 내용 비교 (Date의 equals는 객체의 내용 비교로 재정의됨)
		System.out.println(obj1.equals(obj2) ? "equals 내용 같음" : "equals 내용 다름");

	}

	private static void f2() {
//		String
		System.out.println("** 함수 f2 실행 **");

		String obj1 = new String("ㅁ");
		String obj2 = new String("ㅁ");

		System.out.println("obj1: " + System.identityHashCode(obj1));
		System.out.println("obj2: " + System.identityHashCode(obj2));
//		두 객체의 주소 비교 (== 연산자: 기본형이면 값 비교, 객체이면 주소 비교)
		System.out.println(obj1 == obj2 ? "== 주소 같음" : "== 주소 다름");
//		두 객체의 내용 비교 (String의 equals는 객체의 내용 비교로 재정의됨)
		System.out.println(obj1.equals(obj2) ? "equals 내용 같음" : "equals 내용 다름");
	}

	private static void f1() {
//		Object
		System.out.println("** 함수 f1 실행 **");

		Object obj1 = new Object();
		Object obj2 = new Object();

		System.out.println("obj1: " + System.identityHashCode(obj1));
		System.out.println("obj2: " + System.identityHashCode(obj2));
//		두 객체의 주소 비교 (== 연산자: 기본형이면 값 비교, 객체이면 주소 비교)
		System.out.println(obj1 == obj2 ? "== 주소 같음" : "== 주소 다름");
//		두 객체의 주소 비교 (Object의 equals는 객체의 주소 비교)
		System.out.println(obj1.equals(obj2) ? "equals 주소 같음" : "equals 주소 다름");

	}

}
