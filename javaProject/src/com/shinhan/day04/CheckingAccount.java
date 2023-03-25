// 10 - f2()
package com.shinhan.day04;

// 상속: 기존 class(변경 가능) + 생성자, field, method 추가
public class CheckingAccount extends Account {
	// 부모의 class에서 private이 아닌 요소들 사용 가능
	// 자식 class는 부모 class의 기본 생성자를 default로 호출: super(); -> 명시적으로 호출해야 함
	String cardNo;

	CheckingAccount(String accNo, String owner, int balance, String cardNo) {
		super(accNo, owner, balance); // 명시적으로 부모 생성자를 호출 (명시하지 않으면 default 생성자 호출함)
		this.cardNo = cardNo;
	}

	public int pay(String cardNo, int amount) {
		if (this.cardNo.equals(cardNo)) {
			return withdraw(amount);
		} else {
			System.out.println("카드 도둑이야아아");
		}
		return 0;
	}

	void test() {

		System.out.println(getAccNo());

		System.out.println(getOwner());
		System.out.println(getBalance());

		setAccNo("777");
		System.out.println(getAccNo());

		deposit(1);
		withdraw(2);
	}
}
