// 07 - f1()
package com.shinhan.day03;

// JavaBeans기술 규격서에 나옴 (데이터는 외부에서 접근할 수 없도록 private로 선언해 정보 은닉을 한다.): field는 private (정보 은닉)
public class Computer {
	private String model; // private로 선언함으로써 클래스 외부에서 값에 직접적으로 접근할 수 없음 (보통 변수는 private로 사용, 필수는 아님)
	private String os;
	private int price;

	// 컴퓨터를 몇 대 생성했는지 구하고싶어
	static int count; // 변수: instance변수, static변수(class변수 = object가 공유함) 2가지 존재: default는 instance 변수 (생성할 때마다 생김)
	// => 해당 클래스를 사용하는 모든 객체끼리 개수를 공유하고 싶기 때문에 클래스 생성시에만 생기는 static 변수 사용

	// Java는 생성자 여러 개 생성 가능 -> 매개변수 형태는 달라야 함
	// 생성자 오버로딩: overloading: 생성자 이름은 같고 매개변수 사양이 다르다.
	// 지금 방식은 '객체를 생성한다'라는 기능은 똑같기 때문에 너무 다시 쓴 코드들 -> 한 번에 부르면 좋겠는데?
	// => 기능이 작은 쪽에서 큰 쪽을 부름 (하나의 생성자가 다른 모양의 생성자를 호출!)
	public Computer() { // 다른 패키지에서도 new Computer()를 하고싶다면 public으로 사용
		// System.out.println("default 생성자로 생성");

		// 생성자 묶기
		this("기본모델", "기본os", 12345);
	}

	public Computer(String model) {
		// System.out.println("arg1 생성자로 생성");
		// this.model = model;
		this(model, null, 0);
	}

	public Computer(String os, int price) {
		// System.out.println("arg2 생성자로 생성");
		// this.os = os;
		// this.price = price;
		this(null, os, price);
	}

	public Computer(String model, String os, int price) {
		// 생성자를 묶음으로써 생성자는 여러 개 존재하지만 로직은 가장 많은 해당 생성자에만 존재
		// -> 코드 수정사항이 생기면 가장 큰 생성자만 수정하면 됨! (모든 객체가 해당 생성자를 거쳐 생성됨)
		count++;
		System.out.println("*** arg3 생성자로 생성한 " + count + "번째 컴퓨터 ***");
		this.model = model;
		this.os = os;
		this.price = price;

	}

	// 일반 method
	public void computerInfoPrint() {
		System.out.println("model: " + model);
		System.out.println("os: " + os);
		System.out.println("price: " + price);

	}

	// 정보 은닉을 했기 때문에 public 함수로 정보를 제공해야 함
	public String getModel() {
		return model;
	}

	public String getOs() {
		return os;
	}

	public int getPrice() {
		return price;
	}

}
