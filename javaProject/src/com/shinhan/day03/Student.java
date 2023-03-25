// 06 - f1();
package com.shinhan.day03;

// class = 변수 + method
public class Student {
	// field(변수, 속성, 특징), constructor(생성자 - 정의 안 했으면 컴파일시 default 자동으로 생성),
	// 일반method(행위)
	// block(instance - 생성시마다 수행, static - block 로드시 1회 수행), inner class 5가지만 가능

	String name;
	String stdId;
	String subject;
	int score;

	Student() {
		// 이 형식은 main에서 사용자가 직접 값을 설정해줘야 함 -> 정보 은닉 측면에서 좋지 않음
		System.out.println("default 생성자에 의해 Student가 만들어짐");

	}

	// 생성자의 오버로딩(overlading): 이름은 같고 매개변수 사양이 다름
	Student(String name, String stdId, String subject, int score) {
		System.out.println("arg4개 생성자에 의해 Student가 만들어짐");
		// 멤버 변수(==field)와 매개 변수(==argument)가 충돌 (이름이 같음) -> 구별이 필요: 이 클래스로 만든 현재 객체를 this라고 부름
		this.name = name;
		this.stdId = stdId;
		this.subject = subject;
		this.score = score;
	}

	void study() {
		System.out.println(name + "학생이 공부한다.");
	}

	{
		System.out.println("instance block입니다...");
	}
	static {
		System.out.println("static block입니다...");
	}

	class Phone { // inner class

	}
}
