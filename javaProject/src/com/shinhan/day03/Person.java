// 08 - f1();
package com.shinhan.day03;

public class Person {

	// 멤버변수: instance변수 (객체가 만들어질 때마다 변수 생성), static변수 (객체들이 공유하는 변수)
	private static int numberOfPersons; // 전체 인구 수: Person 객체가 생성될 때마다 증가

	private int age;
	private String name;

	Person() { // 나이는 12, 이름은 Anonymous로 초기화
		// this를 했을 때 위에 코드가 있으면 에러 뜨는 이유
		// : 맨 처음 super()를 자동으로 부름, 따라서 두 번 불렸기 때문에 에러 발생
		// -> 자신을 부르는 코드 (this)를 맨 첫 줄에 써야 함
		this(12, "Anonymous");
	}

	Person(int age, String name) {
		this.age = age;
		this.name = name;
		numberOfPersons++;
	}

	public void selfIntroduce() { // 내 이름은 ~~~이며, 나이는 ~~~살 입니다.
		System.out.println("내 이름은 " + name + "이며, 나이는 " + age + "살 입니다.");
	}

	 // 인구는 모든 객체가 공유하기 때문에 함수도 static으로 만들어줬음
	static public int getPopulation() { // 전체 인구수를 return
		return numberOfPersons;
	}

	

}
