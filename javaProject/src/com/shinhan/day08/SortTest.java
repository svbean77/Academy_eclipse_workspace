// 05
package com.shinhan.day08;

import java.util.Arrays;
import java.util.Comparator;

// java 모듈 사용
public class SortTest {

	public static void main(String[] args) {
		f1();
		f2();
		f3();
		f4();
	}

	private static void f4() {
		System.out.println("** 함수 f4 실행 **");
		Car[] arr = { new Car("A", 5000), new Car("D", 1000), new Car("C", 3000), new Car("E", 1000),
				new Car("B", 1000) };
//		System.out.println("정렬전: " + Arrays.toString(arr));
		print("정렬전: ", arr);
		Arrays.sort(arr);

//		System.out.println("정렬후: " + Arrays.toString(arr));
		print("정렬후: ", arr);

		System.out.println("-- 가격 내림차순, 모델 오름차순 정렬 (익명) 사용! --");
		Car[] arr2 = { new Car("A", 5000), new Car("D", 1000), new Car("C", 3000), new Car("E", 1000),
				new Car("B", 1000) };
		System.out.println("정렬전: " + Arrays.toString(arr2));
		Arrays.sort(arr2, new Comparator<Car>() {
			@Override
			public int compare(Car c1, Car c2) {
//				가격은 오름차순, 가격이 같으면 모델명 내림차순
				if (c1.price == c2.price)
					return c1.model.compareTo(c2.model);
				return c2.price - c1.price;
			}
		});
		System.out.println("정렬후: " + Arrays.toString(arr2));
	}

	private static void print(String title, Car[] arr) {
		System.out.println("--- " + title + " ---");
		for (Car car : arr) {
			System.out.println(car);
		}

	}

	private static void f3() {
		System.out.println("** 함수 f3 실행 **");
		Money[] arr = { new Money(10), new Money(5), new Money(7), new Money(3), new Money(6) };
		System.out.println("정렬전: " + Arrays.toString(arr));
		Arrays.sort(arr); // 비교가 가능해야 sort method 사용 가능! (Comparable interface를 구현해야 함)
//		내림차순으로 정렬해둠^^
		System.out.println("정렬후: " + Arrays.toString(arr));

		System.out.println("-- 내림차순 정렬 (익명) 사용! --");
		Money[] arr2 = { new Money(10), new Money(5), new Money(7), new Money(3), new Money(6) };
		System.out.println("정렬전: " + Arrays.toString(arr2));
		Arrays.sort(arr2, new Comparator<Money>() {
			@Override
			public int compare(Money m1, Money m2) {
//				나는 내림차순 하고 싶으니까 뒤의 값을 기준으로
				return m2.amount - m1.amount;
			}
		});
		System.out.println("정렬후: " + Arrays.toString(arr2));

		System.out.println("-- 오름차순 정렬 (익명) 사용! --");
		Money[] arr3 = { new Money(10), new Money(5), new Money(7), new Money(3), new Money(6) };
		System.out.println("정렬전: " + Arrays.toString(arr3));
		Arrays.sort(arr3, new Comparator<Money>() {
			@Override
			public int compare(Money m1, Money m2) {
				return m1.amount - m2.amount;
			}
		});
		System.out.println("정렬후: " + Arrays.toString(arr3));
	}

	private static void f2() {
		System.out.println("** 함수 f2 실행 **");
		String[] arr = { "Spring", "java", "jsp", "servlet", "html", "CSS", "React" };
		System.out.println("정렬전: " + Arrays.toString(arr));
		Arrays.sort(arr); // ASCII 'A': 65, 'a': 97 -> 소문자가 뒤로 감
		System.out.println("정렬후: " + Arrays.toString(arr));

//		내림차순 쓰고는 싶은데 한 번만 쓸거야.. 굳이 클래스..? -> 익명 클래스 만들기
		System.out.println("-- 내림차순 정렬 (익명) 사용! --");
		String[] arr2 = { "Spring", "java", "jsp", "servlet", "html", "CSS", "React" };
		System.out.println("정렬전: " + Arrays.toString(arr2));
		Arrays.sort(arr2, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
//				나는 내림차순 하고 싶으니까 뒤의 값을 기준으로
				return s2.compareTo(s1);
			}
		});
		System.out.println("정렬후: " + Arrays.toString(arr2));
	}

	private static void f1() {
		System.out.println("** 함수 f1 실행 **");
		int[] arr = new int[] { 100, 30, 80, 20, 99 };
		System.out.println("-- 오름차순 정렬 (기본) 사용! --");
		System.out.println("정렬전: " + Arrays.toString(arr));
		Arrays.sort(arr); // 원본 자체를 바꿈, 기본적으로는 ascending
		System.out.println("정렬후: " + Arrays.toString(arr));

//		어떤 순서로 정렬할지 직접 정하고 싶을 땐 Comparator 구현한 클래스를 Comparator에 넣어주면 됨 (기본형은 불가)
		Integer[] arr2 = new Integer[] { 100, 30, 80, 20, 99 };
		System.out.println("-- 내림차순 정렬 (Comparator) 사용! --");
		System.out.println("정렬전: " + Arrays.toString(arr2));
		Arrays.sort(arr2, new DescendingInteger());
		System.out.println("정렬후: " + Arrays.toString(arr2));

	}
}
