// 02
// 03
package com.shinhan.day10;

import java.util.Objects;

public class Account implements Comparable<Account> {
	private String accNo;
	private String owner;
	private int balance;

	public Account() {

	}

	public Account(String accNo, String owner, int balance) {
		this.accNo = accNo;
		this.owner = owner;
		this.balance = balance;
	}

	// 메서드
	public void deposit(int amount) {
		balance += amount;
	}

	public int withdraw(int amount) {
		if (amount > balance) {
			System.out.println("잔고부족");
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

//	02
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", owner=" + owner + ", balance=" + balance + "]";
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(accNo, balance, owner);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Account other = (Account) obj;
//		return Objects.equals(accNo, other.accNo) && balance == other.balance && Objects.equals(owner, other.owner);
//	}

	@Override
	public int hashCode() {
		return Objects.hash(accNo, owner);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accNo, other.accNo) && Objects.equals(owner, other.owner);
	}

	// 03
	@Override
	public int compareTo(Account acc) {
		if (this.equals(acc))
			return 0;
//		정렬할 때 같은 값이 존재한다면 요소가 줄어들어!! -> 같은 값이 존재하면 다른 것으로 비교할 수 있도록 해야 함
//		1. owner로 내림차순 정렬
//		return -1 * (owner.compareTo(acc.owner));

//		2. 계좌번호로 오름차순 정렬
//		return accNo.compareTo(acc.accNo);

//		3. 잔액으로 내림차순 정렬
		int result = acc.balance - balance;
		if (result == 0) {
			return owner.compareTo(acc.owner);
		}
		return result;
	}

}
