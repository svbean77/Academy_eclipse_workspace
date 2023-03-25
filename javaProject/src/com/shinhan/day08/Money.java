// 03 - f1(), f2(), f4(), f6()
// 05 - f3()
package com.shinhan.day08;

// 12장 LAB8 4번
public class Money implements Comparable<Money> {
	int amount;

	public Money(int amount) {
		this.amount = amount;
	}

	public Money add(Money money) {
		// 더하기 구현
		return new Money(this.amount + money.amount);
	}

	public Money minus(Money money) {
		// 빼기 구현
		return new Money(this.amount - money.amount);
	}

	public Money multiply(Money money) {
		// 곱하기 구현
		return new Money(this.amount * money.amount);
	}

	public Money devide(Money money) {
		// 나누기 구현
		return new Money(this.amount / money.amount);
	}

	public boolean equals(Object object) {
		// Object equals 메쏘드 재정의
//		내 풀이
//		if (object instanceof Money money) {
////			int는 기본형이기 때문에 == 연산자로 비교해도 값 비교임!
//			return this.amount == money.amount;
//		} else
//			return false;

//		교수님 풀이: hashCode() equals()의 equals()를 따라해봄
		if (this == object)
			return true;
		if (object == null || getClass() != object.getClass())
			return false;
		return this.amount == ((Money) object).amount;
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + "]";
	}

	public static void main(String[] args) {
		Money five = new Money(5);
		Money two = new Money(2);
		Money three = new Money(3);
		Money ten = new Money(10);

//		주소는 다른데 (새로운 객체 리턴이니까) 값이 같은지 보려고 출력해봄
		System.out.println(five);
		System.out.println(two.add(three));

		if (five.equals(two.add(three)) && three.equals(five.minus(two)) && ten.equals(five.multiply(two))
				&& two.equals(ten.devide(five))) {
			System.out.println("Money Class 구현을 완료 하였습니다.");
		}
	}

//	SortTest에서 class를 정렬하기 위해 추가한 method
	@Override
	public int compareTo(Money obj) {
//		결과가 앞 - 뒤라고 생각! 
//		<default>
//		음수: 앞(this)이 작음
//		0: 같음
//		양수: 앞(this)이 큼
//		내림차순으로 바꾸고 싶다면 부호를 바꿔주면 됨!
//		차의 결과 (a-b) 방향으로 이동한다고 생각하면 됨 -> 작으면 배열의 앞으로 (-), 크면 뒤로 (+)

		return -(this.amount - obj.amount);
	}
}
