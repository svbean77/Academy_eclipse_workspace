// 06 (Student)
package com.shinhan.day03;

public class StudentTest {

	public static void main(String[] args) {
		f1();

	}

	private static void f1() {
		Student student1 = new Student(); // 개발자들은 대부분 클래스명 = 변수명
		Student student2 = new Student("성하암", "000", "WEB", 50);

		student1.name = "이르음";
		student1.stdId = "777";
		student1.subject = "자바";
		student1.score = 100;

		display(student1);
		display(student2);
	}

	private static void display(Student std) {
		System.out.println("* - * - * - * - * - *");
		System.out.println(std.name);
		System.out.println(std.stdId);
		System.out.println(std.subject);
		System.out.println(std.score);
		std.study();
	}

}
