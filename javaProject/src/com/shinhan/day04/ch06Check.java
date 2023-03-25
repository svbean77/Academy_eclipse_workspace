package com.shinhan.day04;

import java.util.Scanner;

public class ch06Check {

	public static void main(String[] args) {
		ch06no01();
		ch06no02();
		ch06no03();
		ch06no04();
		ch06no05();
		ch06no06();
		ch06no07();
		ch06no08();
		ch06no09();
		ch06no09();
		ch06no10();
		ch06no11();
		ch06no15();
		ch06no16();
		ch06no18();
		ch06no19();
		ch06no20();

	}

	private static void ch06no20() {
		// 6장 확인문제 20번
		BankApplication app = new BankApplication();
		Scanner sc = new Scanner(System.in);
		int select = -1;

		while (true) {
			System.out.println("------------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("------------------------------------------------");
			System.out.print("선택 >> ");
			select = Integer.parseInt(sc.nextLine());

			if (select == 1) {
				System.out.println("--------------------");
				System.out.println("계좌생성");
				System.out.println("--------------------");

				System.out.print("계좌번호: ");
				String accNo = sc.nextLine();

				System.out.print("계좌주: ");
				String owner = sc.nextLine();

				System.out.print("초기입금액: ");
				int balance = Integer.parseInt(sc.nextLine());

				app.createAccount(accNo, owner, balance);
				System.out.println("계좌가 생성되었습니다");

			} else if (select == 2) {
				app.showAccounts();

			} else if (select == 3) {
				System.out.println("--------------------");
				System.out.println("예금");
				System.out.println("--------------------");

				System.out.print("계좌번호: ");
				String accNo = sc.nextLine();
				System.out.print("예금액: ");
				int amount = Integer.parseInt(sc.nextLine());

				if (amount > 100) {
					app.diposit(accNo, amount);
				} else {
					System.out.println("1 이상의 금액을 입력해주세요");
				}

			} else if (select == 4) {
				System.out.println("--------------------");
				System.out.println("출금");
				System.out.println("--------------------");

				System.out.print("계좌번호: ");
				String accNo = sc.nextLine();
				System.out.print("출금액: ");
				int amount = Integer.parseInt(sc.nextLine());

				app.withdraw(accNo, amount);

			} else if (select == 5) {
				System.out.println("프로그램 종료");
				break;
			}

		}
	}

	public static class Account20 {
		// 6장 확인문제 20번
		private String accNo;
		private String owner;
		private int balance;

		Account20() {

		}

		Account20(String accNo, String owner, int balance) {
			this.accNo = accNo;
			this.owner = owner;
			this.balance = balance;
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

	public static class BankApplication {
		// 6장 확인문제 20번
		Account20[] accounts;
		private static int cnt;

		BankApplication() {
			accounts = new Account20[100];

		}

		public void createAccount(String accNo, String owner, int balance) {
			accounts[cnt] = new Account20();
			accounts[cnt].setAccNo(accNo);
			accounts[cnt].setOwner(owner);
			accounts[cnt].setBalance(balance);
			cnt++;
			System.out.println("결과: 계좌가 생성되었습니다.");
		}

		public void showAccounts() {
			System.out.println("--------------------");
			System.out.println("계좌목록");
			System.out.println("--------------------");
			for (int i = 0; i < cnt; i++) {
				System.out.println(
						accounts[i].getAccNo() + "\t" + accounts[i].getOwner() + "\t" + accounts[i].getBalance());
			}
		}

		public void diposit(String accNo, int amount) {
			for (int i = 0; i < cnt; i++) {
				if (accounts[i].getAccNo().equals(accNo)) {
					int tmp = accounts[i].getBalance();
					tmp += amount;
					accounts[i].setBalance(tmp);
					break;
				}
			}
		}

		public void withdraw(String accNo, int amount) {
			for (int i = 0; i < cnt; i++) {
				if (accounts[i].getAccNo().equals(accNo)) {
					int tmp = accounts[i].getBalance();
					if (tmp > accounts[i].getBalance()) {
						System.out.println("예금액보다 큰 금액을 출금할 수 없습니다.");
					} else {
						tmp -= amount;
						accounts[i].setBalance(tmp);
						System.out.println("결과: 출금이 성공되었습니다.");
					}
					break;
				}
			}
		}
	}

	private static void ch06no19() {
		// 6장 확인문제 19번
		Account account = new Account();

		account.setBalance(10000);
		System.out.println("현재 잔고: " + account.getBalance());

		account.setBalance(-100);
		System.out.println("현재 잔고: " + account.getBalance());

		account.setBalance(2000000);
		System.out.println("현재 잔고: " + account.getBalance());

		account.setBalance(300000);
		System.out.println("현재 잔고: " + account.getBalance());

	}

	public static class Account {
		// 6장 확인문제 19번
		private int balance;

		Account() {
		}

		public int getBalance() {
			return balance;
		}

		public void setBalance(int balance) {
			if (balance >= 0 && balance <= 1000000)
				this.balance = balance;
		}
	}

	private static void ch06no18() {
		// 6장 확인문제 18번
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();

		if (obj1 == obj2) {
			System.out.println("같은 ShopService 객체입니다.");
		} else {
			System.out.println("다른 ShopService 객체입니다.");
		}
	}

	public static class ShopService {
		// 6장 확인문제 18번
		private static ShopService instance = new ShopService();

		public static ShopService getInstance() {
			return instance;
		}
	}

	private static void ch06no16() {
		// 6장 확인문제 16번, 17번
		// 16번: 함수에 static 없음
		Printer printer = new Printer();
		printer.println(10);
		printer.println(true);
		printer.println(5.7);
		printer.println("홍길동");

		// 17번: 함수에 static 추가
		Printer.println(10);
		Printer.println(true);
		Printer.println(5.7);
		Printer.println("홍길동");
	}

	public static class Printer {
		// 6장 확인문제 16번, 17번
		public static void println(int value) {
			System.out.println(value);
		}

		public static void println(boolean value) {
			System.out.println(value);
		}

		public static void println(double value) {
			System.out.println(value);
		}

		public static void println(String value) {
			System.out.println(value);
		}
	}

	private static void ch06no15() {
		// 6장 확인문제 15번
		MemberService memberService = new MemberService();
		boolean result = memberService.login("hong", "12345");
		if (result) {
			System.out.println("로그인 되었습니다.");
			memberService.logout("hong");
		} else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}

	}

	public static class MemberService {
		// 6장 확인문제 15번
		public boolean login(String id, String password) {
			boolean result;

			if (id.equals("hong") && password.equals("12345"))
				result = true;
			else
				result = false;

			return result;
		}

		public void logout(String id) {
			System.out.println(id + "님이 로그아웃 되었습니다.");
		}
	}

	public class Member2 {
		// 6장 확인문제 13번, 14번
		// 13번
		private String name;
		private String id;
		private String password;
		private int age;

		// 14번
		Member2(String name, String id) {
			this.name = name;
			this.id = id;
		}
	}

	public class Member {
		// 6장 확인문제 12번
		private String name; // 필드

		public Member(String name) {
		} // 생성자

		public void setName(String name) {
		} // 메소드
	}

	private static void ch06no11() {
		// 6장 확인문제 11번
		// 1. 접근 제한자는 클래스, 필드, 생성자, 메소드의 사용을 제한한다. -> O
		// 2. public 접근 제한은 아무런 제한 없이 해당 요소를 사용할 수 있게 한다. -> O
		// 3. default 접근 제한은 해당 클래스 내부에서만 사용을 허가한다. -> X
		// 4. 외부에서 접근하지 못하도록 하려면 private 접근 제한을 해야 한다. -> O

	}

	private static void ch06no10() {
		// 6장 확인문제 10번
		// 1. 패키지는 클래스들을 그룹화시키는 기능을 한다. -> O
		// 2. 클래스가 패키지에 소속되려면 패키지 선언을 반드시 해야 한다. -> O
		// 3. import 문은 다른 패키지의 클래스를 사용할 때 필요하다. -> O
		// 4. com.mycom 패키지에 소속된 클래스는 com.yourcom에 옮겨 놓아도 동작한다. -> X

	}

	private static void ch06no09() {
		// 6장 확인문제 9번
		// 1. final 필드와 상수는 초기값이 저장되면 값을 변경할 수 없다. -> O
		// 2. final 필드와 상수는 생성자에서 초기화될 수 있다. -> X
		// 3. 상수의 이름은 대문자로 작성하는 것이 관례이다. -> O
		// 4. 상수는 객체 생성 없이 클래스를 통해 사용할 수 있다. -> O

	}

	private static void ch06no08() {
		// 6장 확인문제 8번
		// 1. 정적 멤버는 static으로 선언된 필드와 메소드를 말한다. -> O
		// 2. 인스턴스 필드는 생성자 및 정적 블록에서 초기화될 수 있다. -> X
		// 3. 정적 필드와 정적 메소드는 객체 생성 없이 클래스를 통해 접근할 수 있다. -> O
		// 4. 인스턴스 필드와 메소드는 객체를 생성하고 사용해야 한다. -> O

	}

	private static void ch06no07() {
		// 6장 확인문제 7번
		// 1. 동일한 이름의 메소드를 여러 개 선언하는 것을 말한다. -> O
		// 2. 반드시 리턴 타입이 달라야 한다. -> X
		// 3. 매개변수의 타입, 수, 순서를 다르게 선언해야 한다. -> O
		// 4. 매개값의 타입 및 수에 따라 호출될 메소드가 선택된다. -> O

	}

	private static void ch06no06() {
		// 6장 확인문제 6번
		// 1. 리턴값이 없는 메소드는 리턴 타입을 void로 해야 한다. -> O
		// 2. 리턴 타입이 있는 메소드는 리턴값을 지정하기 위해 반드시 return 문이 있어야 한다. -> O
		// 3. 매개값의 수를 모를 경우 "..."을 이용해서 매개변수를 선언할 수 있다. -> O
		// 4. 메소드의 이름은 중복해서 선언할 수 없다. -> X

	}

	private static void ch06no05() {
		// 6장 확인문제 5번
		// 1. 객체를 생성하려면 생성자 호출이 반드시 필요한 것은 아니다. -> X
		// 2. 생성자는 다른 생성자를 호출하기 위해 this()를 사용할 수 있다. -> O
		// 3. 생성자가 선언되지 않으면 컴파일러가 기본 생성자를 추가한다. -> O
		// 4. 외부에서 객체를 생성할 수 없도록 생성자에 private 접근 제한자를 붙일 수 있다. -> O

	}

	private static void ch06no04() {
		// 6장 확인문제 4번
		// 1. 필드는 메소드에서 사용할 수 있다. -> O
		// 2. 인스턴스 필드 초기화는 생성자에서 할 수 있다. -> O
		// 3. 필드는 반드시 생성자 선언 전에 선언되어야 한다. -> X
		// 4. 필드는 초기값을 주지 않더라도 기본값으로 자동 초기화된다. -> O

	}

	private static void ch06no03() {
		// 6장 확인문제 3번
		// 1. 필드는 객체의 데이터를 저장한다. -> O
		// 2. 생성자는 객체의 초기화를 담당한다. -> O
		// 3. 메소드는 객체의 동작 부분으로, 실행 코드를 가지고 있는 블록이다. -> O
		// 4. 클래스는 반드시 필드와 메소드를 가져야 한다. -> X

	}

	private static void ch06no02() {
		// 6장 확인문제 2번
		// 1. 필드 (field) -> O
		// 2. 생성자 (constructor) -> O
		// 3. 메소드 (method) -> O
		// 4. 로컬 변수 (local variable) -> X

	}

	private static void ch06no01() {
		// 6장 확인문제 1번
		// 1. 클래스는 객체를 생성하기 위한 설계도(청사진)와 같은 것이다. -> O
		// 2. new 연산자로 클래스의 생성자를 호출함으로써 객체가 생성된다. -> O
		// 3. 하나의 클래스로 하나의 객체만 생성할 수 있다. -> X
		// 4. 객체는 클래스의 인스턴스이다. -> O

	}

}
