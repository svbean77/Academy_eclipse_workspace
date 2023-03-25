package com.shinhan.day12.test;

public class No06 {
	int amount = 1000;

	String accNO;

	No06(String accNO) {
		this.accNO = accNO;
	}

	public void save(int amount) {

		System.out.println(this.amount + amount);

	}

	public static void main(String[] args) {

		No06 account = new No06("112-18845-120-999");

		account.save(5000);

	}

}
