// 02 - 람다식 
// f1: (MyInterface, MyClassImplement)
// f2: Calculable p.697
// f3: Runnable을 람다식으로
// f4: Person, Workable, Speakable p.702
// f5 - Calculable2
package com.shinhan.day11;

public class LambdaTest1 {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
		f5();
	}

	private static void f5() {
		Calculable2 f = (a, b) -> a + b;
		Calculable2 f2 = new Calculable2() {
			public int calculate(int x, int y) {
				return x + y;
			}
		};

		int result1 = f.calculate(1, 2);
		int result2 = f2.calculate(1, 2);

		System.out.println("result1: " + result1 + ", result2: " + result2);

//		여러 문장이면 리턴할 때 중괄호가 있어야 함
		Calculable2 f3 = (a, b) -> {
			System.out.println("--- 여러 줄 ---");
			System.out.println("두 수를 더할 것이군요!");
			return a + b;
		};
		int result3 = f3.calculate(1, 2);
		System.out.println(result3);
	}

	private static void f4() {
//		p.702

		Person p1 = new Person();
//		익명 객체로 만든 경우
		p1.action1(new Workable() {
			@Override
			public void work(String name, String job) {
				System.out.println("--- 익명객체 ---");
				System.out.println("이름은 " + name);
				System.out.println("하는 일은 " + job);
			}
		});
//		람다 표현식 사용 (한 줄)
		p1.action1((name, job) -> System.out.println("--- 람다식 한 줄 --- " + name + " --- " + job));
//		람다 표현식 사용 (여러 줄)
		p1.action1((name, job) -> {
			System.out.println("--- 람다식 여러 줄 ---");
			System.out.println("이름은 " + name);
			System.out.println("하는 일은 " + job);
		});
//		람다 표현식 사용 (인터페이스를 구현)
		Workable f = (a, b) -> {
			System.out.println(a + " --- " + b);
			System.out.println(a + " *** " + b);
		};
		p1.action1(f);
		System.out.println();

//		리턴이 있는 람다식
		Speakable f2 = s -> s + "~~~~";
		p1.action2(f2);
	}

	private static void f3() {
		work(() -> {
			for (int i = 1; i <= 100; i++) {
				System.out.println(Thread.currentThread().getName() + ": " + i);
			}
		});
		work(() -> {
			for (int i = 101; i <= 200; i++) {
				System.out.println(Thread.currentThread().getName() + ": " + i);
			}
		});
		work(() -> {
			for (int i = 201; i <= 300; i++) {
				System.out.println(Thread.currentThread().getName() + ": " + i);
			}
		});
	}

	public static void work(Runnable r) {
//		f3()
		Thread t1 = new Thread(r);
		t1.start();
	}

	private static void f2() {
//		p. 697
		(new Calculable() {
			@Override
			public void calculate(int x, int y) {
				System.out.println("--- 익명 구현 클래스 이용 (바로 실행) ---");
				System.out.println("합: " + (x + y));
			}
		}).calculate(10, 20);

//		action 함수에서는 값만 줌! 어떤 연산을 실행할지는 네가 알아서 짜! (calculate를 직접 구현)
		Calculable f = new Calculable() {
			@Override
			public void calculate(int x, int y) {
				System.out.println("--- 익명 구현 클래스 이용 (함수로 실행) ---");
				System.out.println("합: " + (x + y));
			}
		};
		action(f);
		Calculable f2 = new Calculable() {
			@Override
			public void calculate(int x, int y) {
				System.out.println("--- 익명 구현 클래스 이용 (함수로 실행) ---");
				System.out.println("차: " + (x - y));
			}
		};
		action(f2);

		Calculable f3 = (a, b) -> {
			System.out.println("--- 람다 표현식 이용 ---");
			System.out.println("곱: " + (a * b));
		};
		action(f3);
	}

	private static void action(Calculable func) {
//		f2()
		func.calculate(10, 20);
	}

	private static void f1() {
//		1. MyInterface, MyClassImplement 구현 클래스 이용
//		이렇게 매번 클래스로 구현할 수 없잖아.. -> 2
		MyInterface a = new MyClassImplement();
		a.print();

//		2. 익명 구현 class 이용
//		이렇게 구현하는 것도 불편해.. -> 3
		(new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명 구현 클래스로 구현한다~~~~~~ (일회용)");
			}
		}).print();

		MyInterface b = new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명 구현 클래스로 구현한다~~~~~~ (다회용)");
			}
		};
		b.print();

//		3. 람다식 이용 (js에서는 화살표함수=>라고 부름!, 다른 언어들은 람다식->이라고 부름)
		MyInterface c = () -> System.out.println("람다식으로 구현한다~~~~~~~~~");
		c.print();
	}

}
