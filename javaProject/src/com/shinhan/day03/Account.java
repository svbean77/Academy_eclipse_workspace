// 09 6장 LAB2
package com.shinhan.day03;

public class Account {
	private String accNo;
	private int balance;

	Account(String accNo, int balance) {
		this.accNo = accNo;
		this.balance = balance;
		System.out.println(this.accNo + " 계좌가 개설되었습니다.");
		getInfo();
		print("계좌가 개설되었습니다.");
	}

	public void deposit(int money) {
		// 입금
		this.balance += money;

		System.out.println(this.getAccNo() + " 계좌에 " + money + "원이 입금되었습니다.");
		getInfo();
		print("계좌에 " + money + "원이 입금되었습니다.");
	}

	public void withdraw(int money) {
		// 출금
		this.balance -= money;

		System.out.println(this.getAccNo() + " 계좌에 " + money + "원이 출금되었습니다.");
		getInfo();
		print("계좌에 " + money + "원이 출금되었습니다.");
	}

	// getter: private 변수를 외부에서 읽기 위함. 수정은 불가능
	public int getBalance() {
		// 잔액 확인
		return balance;
	}

	public String getAccNo() {
		// 계좌번호 확인
		return accNo;

	}

	private void getInfo() { // 해당 클래스 내부에서만 사용
		// 계좌의 잔고를 출력
		System.out.println(this.getAccNo() + " 계좌의 잔고는 " + this.getBalance() + "원입니다.");
	}

	/* 교수님 풀이 */
	private void print(String message) {
		System.out.println("   " + accNo + message);
		System.out.println("   " + this.getAccNo() + " 계좌의 잔고는 " + this.getBalance() + "원입니다.");
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", balance=" + balance + "]";
	}

	
}
