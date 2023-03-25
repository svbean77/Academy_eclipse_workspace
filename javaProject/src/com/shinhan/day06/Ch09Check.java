package com.shinhan.day06;

public class Ch09Check {

	public static void main(String[] args) {
		ch09no01();
		ch09no02();
		ch09no03();
		ch09no04();
		ch09no05();
		ch09no06();

	}

	class Chat {
		// 9장 확인문제 7번
		void start() {
		}

		void sendMessage(String message) {
		}
	}

	void startChat(String chatId) {
		String nickName = null;
		nickName = chatId;
		Chat chat = new Chat() {
			@Override
			public void start() {
				while (true) {
					String inputData = "안녕하세요";
					// nickName은 final 특성을 가지기 때문에 startChat method에서 값을 변경할 수 없다.
//					String message = "[" + nickName + "] " + inputData; 
//					sendMessage(message);
				}
			}
		};
		chat.start();
	}

	private static void ch09no06() {
		// 9장 확인문제 6번
		Anonymous anony = new Anonymous();
		anony.field.run();
		anony.method1();
		anony.method2(new Vehicle() {
			public void run() {
				System.out.println("트럭이 달립니다.");
			}
		});
	}

	public interface Vehicle {
		public void run();
	}

	public static class Anonymous {
		Vehicle field = new Vehicle() {
			public void run() {
				System.out.println("자전거가 달립니다.");
			}
		};

		void method1() {
			Vehicle localVar = new Vehicle() {
				public void run() {
					System.out.println("승용차가 달립니다.");
				}
			};
			localVar.run();
		}

		void method2(Vehicle v) {
			v.run();
		}
	}

	private static void ch09no05() {
		// 9장 확인문제 5번
		Action action = new Action() {
			public void work() {
				System.out.println("복사를 합니다.");
			}
		};
		action.work();

	}

	public interface Action {
		public void work();
	}

	private static void ch09no04() {
		// 9장 확인문제 4번
		Car myCar = new Car();

		Car.Tire tire = myCar.new Tire();
		Car.Engine Engine = new Car.Engine();
	}

	public static class Car {
		class Tire {
		}

		static class Engine {
		}
	}

	private static void ch09no03() {
		// 9장 확인문제 3번
		// 1. 익명 객체는 클래스를 상속하거나 인터페이스를 구현해야만 생성될 수 있다. -> O
		// 2. 익명 객체는 필드, 매개변수, 로컬 변수의 초기값으로 주로 사용된다. -> O
		// 3. 익명 객체에는 생성자를 선언할 수 있다. -> X
		// 4. 익명 객체는 주로 재정의된 메소드를 멤버로 가진다. -> O

	}

	private static void ch09no02() {
		// 9장 확인문제 2번
		// 1. 로컬 클래스는 메소드 내부에 선언된 클래스를 말한다. -> O
		// 2. 로컬 클래스는 바깥 클래스의 필드와 메소드를 사용할 수 있다. -> O
		// 3. 로클 클래스는 static 키워드를 이용해서 정적 클래스로 만들 수 있다. -> X
		// 4. final 특성을 가진 매개변수나 로컬 변수만 로컬 클래스 내부에서 사용할 수 있다. -> O

	}

	private static void ch09no01() {
		// 9장 확인문제 1번
		// 1. 인스턴스 멤버 클래스는 바깥 클래스의 객체가 있어야 사용될 수 있다. -> O
		// 2. 정적 멤버 클래스는 바깥 클래스의 객체가 없어도 사용될 수 있다. -> O
		// 3. 인스턴스 멤버 클래스 내부에는 바깥 클래스의 모든 필드와 메소드를 사용할 수 있다. -> O
		// 4. 정적 멤버 클래스 내부에는 바깥 클래스의 인스턴스 필드를 사용할 수 있다. -> X

	}

}
