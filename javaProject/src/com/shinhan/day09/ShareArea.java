// 08 - 공유클래스 동기화
package com.shinhan.day09;

import lombok.AllArgsConstructor;

// 공유 자원으로 이용할 class
// 2개의 계좌가 존재
@AllArgsConstructor
public class ShareArea {
	Account sung;
	Account lee;

//	synchronized를 사용하지 않으면 일관되지 않은 결과가 나올지도.. (ex. 전체 잔액에 2900원으로 떠!!!!!)
//	공유영역을 하는데 왜 스레드를 동기화해! 공유영역 내에서 알아서 해야지!
//	ver. synchronized 활용방법 이용
	synchronized void printBalance() { // 내가 자체니까 공유 객체 이름 안 써도 됨
//		지금 여기서의 함수는 한 줄이지만 몇 줄이 되든 실행동안 방해받고 싶지 않아 -> synchronized 사용한다
//		출력하는 동안에도 방해가 들어올 수 있잖아! 그러면 출력하는 순간 바뀌어버릴 수 있어
		System.out.println("잔액: " + (lee.getBalance() + sung.getBalance()));

	}

//	ver. synchronized block 이용
	void transfer() {
		synchronized (this) {
			int amount = lee.withdraw(100);
			System.out.println("lee 계좌에서 " + amount + " 출금");

			sung.deposit(amount);
			System.out.println("sung 계좌에 " + amount + " 입금");

		}
	}
}
