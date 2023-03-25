// 05 - stream
// f1: 내부 반복자 - 배열 (int)
// f2: 내부 반복자 - 배열 (String) 
// f3: 내부 반복자 - 배열 (Account) 
// f4: 내부 반복자 - 컬렉션 (List<Account>)
// f5: 내부 반복자 - 컬렉션 (Set<Account>) p.723
// f6: 내부 반복자 - 병렬 p.725
package com.shinhan.day11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
		f6();
	}

	private static void f6() {
		Account[] arr = { new Account("1234", "김1"), new Account("2345", "김2"), new Account("1234", "김1"),
				new Account("2345", "김2"), new Account("1234", "김1"), new Account("2345", "김2"),
				new Account("1234", "김1"), new Account("2345", "김2"), new Account("3456", "김3") };
		List<Account> data1 = Arrays.asList(arr); // asList는 수정은 불가능 (값 변경 못해!!!)

		data1.parallelStream().forEach(acc -> {
			System.out.println(acc);
			System.out.println(Thread.currentThread().getName());
			System.out.println();
		});
		System.out.println();
		data1.forEach(acc -> System.out.println(acc));
	}

	private static void f5() {
		Set<Account> data1 = new HashSet<>();
		data1.add(new Account("1234", "김1"));
		data1.add(new Account("2345", "김2"));
		data1.add(new Account("3456", "김3"));

		data1.stream().forEach(acc -> System.out.println(acc));
		System.out.println();
		data1.forEach(acc -> System.out.println(acc));
	}

	private static void f4() {
		Account[] arr = { new Account("1234", "김1"), new Account("2345", "김2"), new Account("3456", "김3") };
		List<Account> data1 = Arrays.asList(arr); // asList는 수정은 불가능 (값 변경 못해!!!)

		data1.stream().forEach(acc -> System.out.println(acc));
		System.out.println();
//		List는 stream으로 바꾸지 않아도 forEach를 사용할 수 있다!
//		단, 필터링 등 중간 과정을 거치고 싶다면 stream()을 사용해 original stream으로 만들어야 함! 이거는 최종 처리만 하는거 
		data1.forEach(acc -> System.out.println(acc));
	}

	private static void f3() {
		Account[] arr = { new Account("1234", "김1"), new Account("2345", "김2"), new Account("3456", "김3") };
		Arrays.stream(arr).forEach(acc -> System.out.println(acc));

	}

	private static void f2() {
		String[] arr1 = { "자바", "웹", "프론트", "back", "framework" };

//		1. 내부 반복자를 이용하기 위해 stream으로 바꾸기
		Stream<String> st = Arrays.stream(arr1);
//		2. 내부 반복자로 값 처리
		Consumer<String> consumerF = s -> System.out.println(s + "!!");
		st.forEach(consumerF);

//		한 줄에 모두 묶어 사용
		Arrays.stream(arr1).forEach(s -> System.out.println("** " + s + " **"));
	}

	private static void f1() {
//		1. 배열
		int[] arr1 = new int[] { 100, 40, 70, 20, 50 };
//		내부 반복자를 이용하는 방법
		Arrays.stream(arr1).forEach(a -> System.out.println("a: " + a));
		IntStream is = Arrays.stream(arr1); // 오리지널 스트림
		IntConsumer func1 = a -> System.out.println(a);
		is.forEach(func1);
	}

}
