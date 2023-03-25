// 03
package com.shinhan.day08;

import java.util.ArrayList;

// 제네릭
// Box.java
public class GenericTest {

	public static void main(String[] args) {
		f1();
		f2();
		f3();
		f4();
		f5();
		f6();
		f7();
		f8();
		f9();

	}

	private static void f9() {
//		제네릭 메소드 - 타입 제한 2
		System.out.println("** 함수 f9 실행 **");
		genericExtendMethod(new ChildA());
		genericExtendMethod(new ChildB());
//		genericExtendMethod(new Money(10)); // Parent를 상속받지 않기 때문에 호출 불가

//		HappyBox<?>: generic에 제한 없이 모두 올 수 있음! (?는 제한 없는 것)
		genericExtendMethod2(new HappyBox<String>("나는 제한이 없다", 0)); // ?
		genericExtendMethod3(new HappyBox<Integer>(100, 0)); // ? extends Number
		genericExtendMethod4(new HappyBox<Number>(3.14, 10)); // ? super
//		genericExtendMethod4(new HappyBox<Double>(3.14, 10)); // ? super: Double은 Number의 하위이기 때문에 컴파일 에러 (super가 아님)
//		genericExtendMethod4(new HappyBox<String>("A", 10)); // ? super: String은 Number의 super가 아니기 때문에 컴파일 에러
//		정확한 예제는 GenericExample 참고! (책의 예제임)

		genericExtendMethod5(new HappyBox<ChildA>(new ChildA(), 10));
//		genericExtendMethod5(new HappyBox<ChildB>(new ChildB(), 10)); // ChildB는 extends ChildA가 아니기 때문에 에러
		genericExtendMethod5(new HappyBox<Parent>(new Parent(), 10));
	}

	private static <T extends Parent> void genericExtendMethod(T param) {
//		제네릭 메소드 - 제네릭에 타입 제한 2 (상속)
		System.out.println(param.getClass().getSimpleName() + ": " + "generic 상속 부르기..");
	}

	private static void genericExtendMethod2(HappyBox<?> param) {
//		제네릭 메소드 - 매개변수 제네릭에 타입 제한 3 (와일드카드)
		System.out.println(param.getClass().getSimpleName() + ": " + "generic ? 부르기..");
	}

	private static void genericExtendMethod3(HappyBox<? extends Number> param) {
//		제네릭 메소드 - 매개변수 제네릭에 타입 제한 3 (와일드카드)
		System.out.println(param.getClass().getSimpleName() + ": " + "generic ? extends Number 부르기..");
	}

	private static void genericExtendMethod4(HappyBox<? super Number> param) {
//		제네릭 메소드 - 매개변수 제네릭에 타입 제한 3 (와일드카드)
		System.out.println(param.getClass().getSimpleName() + ": " + "generic ? super Number 부르기..");
	}

	private static void genericExtendMethod5(HappyBox<? super ChildA> param) {
//		제네릭 메소드 - 매개변수 제네릭에 타입 제한 3 (와일드카드)
		System.out.println(param.getClass().getSimpleName() + ": " + "generic ? extends ChildA 부르기..");
	}

	private static void f8() {
//		제네릭 메소드 - 타입 제한 1
		System.out.println("** 함수 f8 실행 **");
		int a = 10;
		int b = 20;
		boolean result = compare(a, b); // 기본형이 Wrapper class로 자동 Boxing되어 들어감
		if (result)
			System.out.println("int 같아!");
		else
			System.out.println("int 달라!");

//		compare의 타입을 Number를 상속 받은 하위 class만 가능하도록 제한함 -> 숫자 타입만 가능
//		String s1 = "자바";
//		String s2 = "자바";
//		boolean result2 = compare(s1, s2);
//		if (result2)
//			System.out.println("String 리터럴 같아!");
//		else
//			System.out.println("String 리터럴 달라!");
//		String s3 = new String("자바");
//		String s4 = new String("자바");
//		boolean result3 = compare(s3, s4);
//		if (result3)
//			System.out.println("String new 같아!");
//		else
//			System.out.println("String new 달라!");
	}

	public static <T extends Number> boolean compare(T a, T b) {
//		제네릭 메소드 - 타입 제한 1
//		Object이면 ==는 주소 비교지만 wrapper class가 들어온 경우 자동으로 언박싱 되어 값 비교가 됨!
//		String이면 리터럴인 경우(String = "") ==는 주소가 같음, 객체인 경우(new String("")) 주소가 다름
//		-> equals를 사용해주는게 좋아
//		return a == b;
		return a.equals(b);
	}

	private static void f7() {
		System.out.println("** 함수 f7 실행 **");
		System.out.println(Boxing2("더하기", 10, 20, "끝~"));

	}

	private static <T, A, B> int Boxing2(T kind, A a, B b, String s) {
//		제네릭 메소드 - 여러 개 + 존재하는 타입과 혼용
		System.out.print(kind.toString() + " " + s + " = ");
		return Integer.parseInt(a.toString()) + Integer.parseInt(b.toString());

	}

	private static void f6() {
//		제네릭 메소드 - 1개
		System.out.println("** 함수 f6 실행 **");
		HappyBox<String> box1 = Boxing("문자열인 해피박스~"); // 사용자는 타입을 알잖아~
		HappyBox<Integer> box2 = Boxing(12345); // 사용자는 타입을 알잖아~
		HappyBox<Money> box3 = Boxing(new Money(100)); // 사용자는 타입을 알잖아~
		System.out.println(box1);
		System.out.println(box2);
		System.out.println(box3);
	}

	private static <T> HappyBox<T> Boxing(T kind) {
//		제네릭 메소드 - 1개
//		p s <T>(제네릭이야!) return타입 method(T var)(T타입의 변수가 들어올거야){}

		return new HappyBox<T>(kind, 10);

	}

	private static void f5() {
//		제네릭을 사용한 예제 - Product, Lombok을 사용해 class method 생성
		System.out.println("** 함수 f5 실행 **");

		Product<String, Integer> p1 = new Product<>("책", 1000); // 일반적으로 뒤의 타입은 생략
		System.out.println(p1);

		Product<String, Integer> p2 = new Product<>("책", 100); // 일반적으로 뒤의 타입은 생략
		System.out.println(p1.equals(p2)); // Lombok의 equals는 '내용이 같다'의 의미, of로 비교할 내용 제한 가능
	}

	private static void f4() {
//		제네릭을 사용한 예제 - Money
		System.out.println("** 함수 f4 실행 **");

		ArrayList<Money> data = new ArrayList<>();
		data.add(new Money(1));
		data.add(new Money(2));
		data.add(new Money(3));
		data.add(new Money(4));
//		data.add(1234); // String이 아니기 때문에 컴파일 에러

		for (Money money : data) {
			System.out.print(money + " ");
		}
		System.out.println();
	}

	private static void f3() {
//		제네릭을 사용한 예제 - ArrayList
		System.out.println("** 함수 f3 실행 **");

		ArrayList<String> data = new ArrayList<>();
		data.add("월요일");
		data.add("목요일");
		data.add("금요일");
		data.add("월요일");
//		data.add(1234); // String이 아니기 때문에 컴파일 에러

		for (String str : data) {
			System.out.print(str + " ");
		}
		System.out.println();
	}

	private static void f2() {
//		제네릭을 사용한 예제 - Money (직접 만든 클래스)
		System.out.println("** 함수 f2 실행 **");
		HappyBox<String> b1 = new HappyBox<String>("바나나", 100); // T는 String이야!
//		Object 타입이기 때문에 기본형들은 Wrapper class로 작성! (int -> Integer...)
		HappyBox<Integer> b2 = new HappyBox<>(12345, 100); // 뒷부분의 타입은 생략 가능
//		HappyBox<Integer> b2 = new HappyBox<>("12345", 100); // 다른 타입이 들어가면 컴파일 에러 발생!
		HappyBox<Money> b3 = new HappyBox<>(new Money(300), 1000);
		HappyBox<Money> b4 = new HappyBox<>(new Money(300), 1000);

//		타입을 정해줬기 때문에 강제 형변환이 필요 없음!
		String s1 = b1.kind;
		int s2 = b2.kind;
		Money s3 = b3.kind;
		Money s4 = b4.kind;

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);

//		amount가 같으면 동일하다고 리턴
		System.out.println(s3.equals(s4) ? "돈이 같아" : "돈이 달라");
	}

	private static void f1() {
//		제네릭을 사용하지 않은 예제
		System.out.println("** 함수 f1 실행 **");
		Box b1 = new Box("바나나", 100);
		Box b2 = new Box(12345, 100);
		Box b3 = new Box(new Money(300), 1000);

//		kind가 Object이기 때문에 강제 형변환이 필요!
		String s1 = (String) b1.kind;
		int s2 = (Integer) b2.kind;
		Money s3 = (Money) b3.kind;

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

//		실수로 잘못된 타입으로 형변환 -> 실행 오류 (컴파일시 정상이기 때문에 오류 찾아내기 힘듦)
//		String s4 = (String) b3.kind;
//		System.out.println(s4);

	}

}
