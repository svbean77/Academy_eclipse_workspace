// 02
package com.shinhan.day04;

public class EmployeeExam {

	public static void main(String[] args) {
		// 6장 LAB5
		num1();
		num2();

	}

	private static void num2() {
		// 6장 LAB5 2번
		
	}

	public static void num1() {
		// 6장 LAB5 1번
		Employee[] employee = new Employee[4];
		employee[0] = new Employee("이부장", "부장", 1500000);
		employee[1] = new Employee("김과장", "과장", 1300000);
		employee[2] = new Employee("최대리", "대리", 1200000);
		employee[3] = new Employee("박사원", "사원", 1000000);

		for (Employee e : employee) {
			e.print();
		}

	}

}
