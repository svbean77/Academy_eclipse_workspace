// 04 - API
// f1: consumer - 매개O, 리턴X 
// f2: supplier - 매개X, 리턴O
// f3: function - 매개O, 리턴O
// f4: binaryOperator - 매개값 연산 후 결과 리턴
// f5: predicate - 매개값 조사 후 boolean 리턴
// f6: 메소드 참조
// f7: 
package com.shinhan.day11;

import java.util.function.*;

public class LambdaTest3 {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
		f7();
	}

	private static void f7() {
		BiFunction<String, String, Account> func1 = (no, owner) -> {
			System.out.println("계좌번호: " + no);
			System.out.println("주인: " + owner);
			return new Account(no, owner);
		};
		Account acc = func1.apply("1234", "hong");
		System.out.println(acc);

		BiFunction<String, String, Account> func2 = Account::new;
		Account acc2 = func2.apply("4321", "park");
		System.out.println(acc2);

	}

	private static void f6() {
//		큰 값 리턴 일반적이 경우
		BiFunction<Integer, Integer, Integer> func1 = (a, b) -> {
			if (a > b)
				return a;
			return b;
		};
		int result = func1.apply(10, 30);
		System.out.println("더 큰 값은 " + result);

//		한 번 간단하게
		BiFunction<Integer, Integer, Integer> func2 = (a, b) -> Math.max(a, b);
		int result2 = func2.apply(20, 50);
		System.out.println("더 큰 값은 " + result2);

//		더 간단하게
		BiFunction<Integer, Integer, Integer> func3 = Math::max;
		int result3 = func3.apply(50, 70);
		System.out.println("더 큰 값은 " + result3);
	}

	private static void f5() {
		Predicate<Integer> func1 = a -> a > 10;
		boolean result = func1.test(20);
		System.out.println(result);

		Predicate<Account> func2 = a -> {
			System.out.println("--- Account의 잔고를 조사하자 (100 이상인가?!) ---");
			System.out.println(a);
			return a.getBalance() >= 100;
		};
		boolean result2 = func2.test(new Account("123", "kim", 20));
		System.out.println("result2: " + result2);
	}

	private static void f4() {
		BinaryOperator<Integer> func1 = (a, b) -> a + b;
		BinaryOperator<Integer> func2 = (a, b) -> a - b;

		System.out.println(func1.apply(1, 2));
		System.out.println(func2.apply(1, 2));
	}

	private static void f3() {
		Function<String, Account> func1 = (a) -> new Account(a, null, 100);
		BiFunction<String, String, Account> func2 = (acc, owner) -> {
			System.out.println("계좌 개설을 시작합니다!");
			System.out.println("계좌번호: " + acc);
			System.out.println("주인: " + owner);
			return new Account(acc, owner, 100);
		};

		Account acc1 = func1.apply("123456");
		Account acc2 = func2.apply("123", "hong");

		System.out.println(acc1);
		System.out.println(acc2);

	}

	private static void f2() {
		Supplier<String> a = () -> "자바";
		String ret1 = a.get();

		Supplier<String> b = () -> {
			System.out.println("--- b ---"); // 리턴이 아닌 결과는 먼저 찍힘
			return "자바2";
		};
		String ret2 = b.get();

		System.out.println(ret1);
		System.out.println(ret2);

		Supplier<Account> c = () -> new Account();
		System.out.println(c.get());

	}

	private static void f1() {
//		추상메소드 하나밖에 없는데 인터페이스 만들기 귀찮아! 다 만들어야해? -> API 사용하자!!
		Consumer<Integer> f = (a) -> System.out.println("a + 10 = " + (a + 10));
		f.accept(20);

		Consumer<String> f2 = (a) -> System.out.println("--- " + a + " ---");
		f2.accept("Consumer API 사용이야");

		BiConsumer<String, Integer> f3 = (str, num) -> {
			System.out.println("*** " + str + " ***");
			System.out.println("num = " + num);
		};
		f3.accept("BiConsumer", 200);

		System.out.println();

		Consumer<Account> f4 = (a) -> {
			System.out.println("a = " + a);
			a.deposit(1000);
			int result = a.withdraw(100);
			System.out.println(result + "원 출금!");
			System.out.println("잔액: " + a.getBalance());
		};
		f4.accept(new Account("123", "홍길동", 1000));
	}

}
