// 10 - f3()
package com.shinhan.day04;

public class CreditLineAccount extends Account {

	int creditLine;

	CreditLineAccount() {
		super();
	}

	public CreditLineAccount(String accNo, String owner, int balance, int creditLine) {
		super(accNo, owner, balance);
		this.creditLine = creditLine;
	}

	// 마이너스 통장이기 때문에 withdraw 함수를 override 하고싶음
	// 덮어쓰기, 재정의: signature이 같아야 함 = 이름, 매개변수, return type
	// modifier(접근제한자)는 같거나 더 넓어져야 함
	@Override // 생략 가능
	public int withdraw(int amount) { // 매개변수, 리턴타입등 모두 같아야 함
		// overriding해 내 함수만 실행 (부모 함수 패스)
		int total = getBalance() + creditLine;

		if (amount > total) {
			System.out.println("잔고 부족");
			return 0;

		}
		setBalance(getBalance() - amount);
		return amount;

	}

	@Override
	public void deposit(int amount) {
		// 내 함수와 부모 함수를 모두 실행할 때
		System.out.println("입금.. override test");
		super.deposit(amount);
	}

	void test() {
		System.out.println(getAccNo());
		System.out.println(getBalance());
		System.out.println(getOwner());

		deposit(100);
		withdraw(100);
	}

}
