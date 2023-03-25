// 08 (Person)
package com.shinhan.day03;

public class PersonTest {

	public static void main(String[] args) {
		f1();

	}

	private static void f1() {
		System.out.println("인구: " + Person.getPopulation());
		Person person1 = new Person();
		Person person2 = new Person(3, "철수");

		person1.selfIntroduce();
		person2.selfIntroduce();

		int pop = person1.getPopulation();
		System.out.println("전체 인구는 " + pop + "명 입니다.");
		
		// 배열을 사용하면 더 깔끔하게 코드를 작성할 수 있고 관리도 편함
		Person[] persons = new Person[3];
		persons[0] = new Person();
		persons[1] = new Person(30, "철수");
		persons[2] = new Person(20, "영희");
		
		for(Person p: persons) {
			p.selfIntroduce();
		}

	}
}
