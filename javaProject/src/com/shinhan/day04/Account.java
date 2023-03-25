// 10 - f1()
package com.shinhan.day04;

// 부모 class로 사용
public class Account { // 모든 클래스에는 extends Object가 생략됨 (최상위 클래스)
	private String accNo;
	private String owner;
	private int balance;

	Account() {
		// defualt 생성자는 사용하지 않아도 코드를 작성하는 것이 좋음 (빈 함수여도 적어두자)
	}

	public Account(String accNo, String owner, int balance) {
		this.accNo = accNo;
		this.owner = owner;
		this.balance = balance;
	}

	public void deposit(int amount) {
		balance += amount;
	}

	public int withdraw(int amount) {
		if (amount > balance) {
			System.out.println("잔고 부족");
			return 0;
		}

		balance -= amount;
		return amount;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
