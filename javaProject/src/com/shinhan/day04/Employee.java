// 02 - num1()
package com.shinhan.day04;

public class Employee {
	// 6장 LAB5
	private String name;
	private String title;
	private int baseSalary;
	private int totalSalary;

	// 생성자도 우클릭 -> source -> generate constructor...로 자동 생성 가능
	public Employee(String name, String title, int baseSalary) {
		this.name = name;
		this.title = title + "님"; // 문자열을 수정했기 때문에 주소가 달라짐
		this.baseSalary = baseSalary;

		getTotalSalary(); // 무조건 필요한 값이고 변수가 다 있기 때문에 그냥 생성자에서 부름
	}

	public void getTotalSalary() {
		// title == "부장님"으로 하면 문자열 비교 대상인 주소가 달라지기 때문에 false
		// 따라서 문자열을 비교할 때는 내용을 비교할 수 있도록 .equals()를 사용해야 한다.
		if (title.equals("부장님"))
			totalSalary = (int) (baseSalary * 1.25);
		else if (title.equals("과장님"))
			totalSalary = (int) (baseSalary * 1.15);
		else
			totalSalary = (int) (baseSalary * 1.05);
	
//		switch (title) {
//		case "부장":
//			// totalSalary의 변수 타입이 int이기 때문에 계산 후 형변환 필요
//			totalSalary = (int) (baseSalary * 1.25);
//			break;
//		case "과장":
//			totalSalary = (int) (baseSalary * 1.15);
//			break;
//		default:
//			totalSalary = (int) (baseSalary * 1.05);
//			break;
//		}
	}

	public void print() {
		System.out.println(title + "직급의 " + name + "씨의 본봉은 " + baseSalary + " 원이고 총급여는 " + totalSalary + " 원입니다.");

	}
}
