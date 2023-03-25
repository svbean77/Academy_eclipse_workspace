// 01
// 06 - f1()
package com.shinhan.day04;

// class: object를 만들기 위한 틀 (=설계도)
// object: class를 이용해 만들어진 실체 (=instance)
public class Calculator {
	// 1. field(특징, 속성, 멤버변수): static(class 변수), non-static(instance 변수: new를 해야 사용)
	// 외부에서의 접근을 막기 위해 보통 private으로 작성, getter setter를 따로 만드는 것이 일반적
	private String color;
	private String model = "기본모델"; // 처음부터 초기화 가능
	private int price;
	static String company = "신한DS"; // 객체들이 다 같은 값이면 static으로 사용 = 모든 객체가 기본모델이다.

	// 2. 생성자: new할 때 자동으로 실행되는 메소드. 초기화가 목적
	// 컴파일시 자동으로 default 생성자가 제공 -> 정의하지 않아도 됨
	// 생성자를 정의하면 default 생성자가 제공되지 않음
	// 생성자 overloading: 이름은 같고 매개변수 사양이 다름
	Calculator(String color) {
		// this: 이 class를 이용해서 만든 현재 객체
		// -> 매개변수명 == 멤버변수명일 때 구분하기 위해 사용
		// -> 하나의 생성자가 다른 생성자를 호출할 때 사용
		// this.color = color;

		// 생성자가 여러 개인 경우 유지보수를 위해 큰 쪽에서 코드를 묶음
		this(null, color, 0);
	}

	Calculator(String model, String color) {
		// this.model = model;
		// this.color = color;

		// 생성자가 여러 개인 경우 유지보수를 위해 큰 쪽에서 코드를 묶음
		this(model, color, 1000);
	}

	Calculator(String model, String color, int price) {
		this.model = model;
		this.color = color;
		this.price = price;
	}

	// 3. 일반 method: 기능, 보통 이름을 동사로 작성
	// static(class method), non-static(instance method: new를 해야 사용 가능)
	// static에서는 this를 사용할 수 없음 (생성되는 시점이 다르기 때문)
	// void: return 값이 없다: 함수 종료를 의미하는 return;만 가능 (자동으로 되니 코드 작성은 안 함)
	// java를 이용한 다른 기술을 사용하려면(ex. Spring) getter, setter를 public으로 만들어줘야 사용 가능
	static public void powerOn() {
		System.out.println(company + "회사의 계산기 전원 On!");
		// System.out.printf("%s모델 - %s색 - %d원\n", model, color, price);
	}

	public void powerOff() {
		System.out.println("전원 Off!");
		System.out.printf("%s모델 - %s색 - %d원\n", model, color, price);
	}

	public int add(int num1, int num2) {
		return num1 + num2;
	}

	public int sub(int num1, int num2) {
		return num1 - num2;
	}

	// 내가 getter, setter를 각각 만들기에는 너무 오래 걸려 -> eclipse에 기능이 있음!
	// 우클릭 -> source -> generate getter/setter -> 원하는 변수 선택
	/*
	 * // getter: private로 정보 은닉 되어있는 멤머 변수들을 읽기 위한 method public String getModel()
	 * { return model; }
	 * 
	 * public String getColor() { return color; }
	 * 
	 * public int getPrice() { return price; }
	 * 
	 * // setter: private로 정보 은닉 되어있는 멤머 변수들을 수정하기 위한 method public void
	 * setModel(String model) { this.model = model; }
	 * 
	 * public void setColor(String color) { this.color = color; }
	 * 
	 * public void setPrice(int price) { this.price = price; }
	 */

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// 4. block: instance block, static block
	{
		// 그냥 block은 잘 사용되지 않음
		System.out.println("-- instance 블록: instance 생성시마다 실행 --");
	}
	static {
		// static block은 가끔 쓰임
		System.out.println("-- static 블록: class load시 실행 --");
	}

	// 5. inner class: 현재 클래스만 사용하겠다
	class AA {

	}
}
