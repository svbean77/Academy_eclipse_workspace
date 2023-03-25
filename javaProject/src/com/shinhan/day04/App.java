// 06
package com.shinhan.day04;

public class App {

	public static void main(String[] args) {
		// f1();

		// method overloading: method 이름은 같은데 매개변수 사양(개수, 타입)이 다름
		// main은 static인데 sum은 instance -> new class를 해줘야 부를 수 있음
		// 쉬운 방법은 함수를 static으로 만드는 것인데 그렇다면 시작하자마자 메모리에 너무 다 올라와
		// -> 객체 생성시 필요한지, 처음부터 필요한지 잘 판단해서 하기
		sum(1, 2); // 매개변수가 int인 함수가 없다면 자동으로 형변환이 이루어짐
		sum(1.5, 2.7);
		new App().sum(1, 2, 3);
		sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); // 자신에게 맞는 유형의 함수가 없으면 가변길이 함수로 이동
		sum(1, 2, 3, 4, 5, 6);
		sum();
	}

	static void sum(int... arr) { // int ... arr || int arr[]: 가변 길이인 매개변수가 배열로 들어옴
		int total = 0;

		for (int num : arr) {
			total += num;
		}
		if (total == 0) {
			System.out.println("합이 0이군..");
			return; // 함수를 중단하고 호출한 곳으로 돌아감 (이 예제에서 호출한 곳은 main)
		}

		System.out.println("가변길이 매개변수 함수의 합: " + total);

	}

	void sum(int a, int b, int c) {
		System.out.println(a + " + " + b + " + " + c + " = " + (a + b + c));
	}

	static void sum(double a, double b) {
		System.out.println(a + " + " + b + " = " + (a + b));
	}

	private static void f1() {
		// Calculator.java

		Calculator.powerOn(); // static이 붙은 것은 instance 생성 없이 사용 가능 = instance 내용은 사용 불가

		System.out.println("*** 하나씩 변수로 선언한 객체들 ***");
		Calculator v1 = new Calculator("red"); // heap 영역에 만들어짐 (company: method 영역 (static임), 나머지: heap 영역)

		// 너무 반복되는 내용이니 얘도 함수로 만들자!
//		v1.model = "A모델";
//		v1.powerOn();
//		v1.powerOff();
//		int add = v1.add(10, 20);
//		int sub = v1.sub(10, 20);

		Calculator v2 = new Calculator("C모델", "orange");
		Calculator v3 = new Calculator("E모델", "green", 777);

		print(v1);
		print(v2);
		print(v3);

		// 변수를 많이 만들기 힘드니 배열로 생성
		System.out.println("*** 배열로 만든 객체들 ***");
		Calculator[] arr = new Calculator[3];
		arr[0] = new Calculator("red");
		arr[1] = new Calculator("C모델", "orange");
		arr[2] = new Calculator("E모델", "green", 777);

		for (Calculator cal : arr) {
			print(cal);
		}

	}

	private static void print(Calculator cal) { // Calculator 객체의 주소가 들어감
		System.out.println("*** main의 print 함수입니다. ***");
		System.out.printf("%s %s %d\n", cal.getModel(), cal.getColor(), cal.getPrice());
		cal.powerOn(); // static은 class의 것이기 때문에 클래스 명에서 호출하라고 주의를 주는 것
		System.out.println("add: " + cal.add(1, 3));
		System.out.println("sub: " + cal.sub(1, 3));
		cal.powerOff();

	}

}
