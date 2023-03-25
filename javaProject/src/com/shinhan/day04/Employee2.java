package com.shinhan.day04;

public class Employee2 {
	private String id;
	private String name;
	private int baseSalary;
	
	Employee2(String id, String name, int baseSalary) {
		this.id = id;
		this.name = name;
		this.baseSalary = baseSalary;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
