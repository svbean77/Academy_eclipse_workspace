// 10
package com.shinhan.day04;

public class AccountTest {

	public static void main(String[] args) {
		f1();
		f2();
		f3();

	}

	private static void f3() {
		System.out.println("*** Account class를 상속받은 CheckingAccount class ***");
		CreditLineAccount acc = new CreditLineAccount("123-543-234", "철수", 1000, 800);

		acc.deposit(2000);
		int amount = acc.withdraw(100);;

		System.out.println(amount + "원이 출금되었습니다.");
		System.out.println("잔액은 " + acc.getBalance());

	}

	private static void f2() {
		// Account class를 상속받은 CheckingAccount class
		System.out.println("*** Account class를 상속받은 CheckingAccount class ***");
		CheckingAccount acc = new CheckingAccount("123-543-234", "철수", 1000, "23456543");

		acc.deposit(2000);
		int amount = acc.pay("23456543", 100);
		int amount2 = acc.pay("0", 100);

		System.out.println(amount + "원이 출금되었습니다.");
		System.out.println(amount2 + "원이 출금되었습니다.");
		System.out.println("잔액은 " + acc.getBalance());

		acc.test();

	}

	private static void f1() {
		// Account class: 부모
		System.out.println("*** Account class ***");
		Account acc = new Account("123-543-234", "철수", 1000);

		acc.deposit(2000);
		int amount = acc.withdraw(100);

		System.out.println(amount + "원이 출금되었습니다.");
		System.out.println("잔액은 " + acc.getBalance());

	}

}
