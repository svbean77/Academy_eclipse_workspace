// 02
package com.shinhan.day10;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
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

//	02
	@Override
	public int hashCode() {
		return Objects.hash(name, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(name, other.name) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", title=" + title + ", baseSalary=" + baseSalary + ", totalSalary="
				+ totalSalary + "]";
	}

	public void print() {
		System.out.println(title + "직급의 " + name + "씨의 본봉은 " + baseSalary + " 원이고 총급여는 " + totalSalary + " 원입니다.");

	}

//	03
	@Override
	public int compareTo(Employee emp) {
//		1. 직원 이름 오름차순
//		return name.compareTo(emp.name);

//		2. 이름이 같을 때 기본급 오름차순
//		int result = name.compareTo(emp.name);
//		if (result == 0) {
//			return baseSalary - emp.baseSalary;
//		}
//		return result;

//		3. 이름(내림차순)과 기본급(오름차순)이 같을 때 직금 내림차순
		int result = name.compareTo(emp.name) * -1;
		int result2 = baseSalary - emp.baseSalary;
		if (result2 == 0)
			return title.compareTo(emp.title);
		if (result == 0)
			return result2;
		return result;
	}

}
