// 05 - 스레드 양보 p.607, p.606 (f1, f2)
// 06 - 동기화 (f3)
// 07 - 동기화 p.611 (f4)
// 08 - 공유 (f5)
// 09 - wait, notify p.615 (f6)
// 10 - safe thread,interrupt  p.619 (f7, f8, f9)
// 11 - 데몬 (f10)
package com.shinhan.day09;

public class ThreadTest4 {

	public static void main(String[] args) throws InterruptedException {

//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
//		f8();
//		f9();
		f10();
	}

	private static void f10() {
//		데몬
		AutoSaveThread t1 = new AutoSaveThread();
		t1.setDaemon(true); // 데몬으로 설정 -> main thread 종료시 데몬도 종료
		t1.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
//			e.printStackTrace();
		}
		System.out.println("main 종료");
	}

	private static void f9() {
//		safe - interrupt 사용 (interrupted())
		SafeThread t1 = new SafeThread();
		t1.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
//			e.printStackTrace();
		}

		t1.interrupt(); // interrupt 걸기
	}

	private static void f8() {
//		safe - interrupt 사용 (sleep())
		SafeThread t1 = new SafeThread();
		t1.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
//			e.printStackTrace();
		}

		t1.interrupt(); // interrupt 걸기
	}

	private static void f7() {
//		safe - while문 사용
		SafeThread t1 = new SafeThread();
		t1.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		t1.stop(): 안전하지 않으니 사용하지 말자!
		t1.setStop(true);

	}

	private static void f6() {
//		wait, notify
//		Thread에서 다른 Thread에 신호 보내기: notify, wait
		WorkObject obj = new WorkObject();

		ThreadA t1 = new ThreadA(obj);
		ThreadB t2 = new ThreadB(obj);

		t1.start();
		t2.start(); // 번갈아 실행됨!

	}

	private static void f5() {
//		08 - 공유 영역 잠그기
		ShareArea share = new ShareArea(new Account("12345", "성춘향", 1000), new Account("67890", "이몽룡", 2000));

		TransferThread t1 = new TransferThread(share);
		PrintThread t2 = new PrintThread(share);

		t1.start();
		t2.start();
	}

	private static void f4() {
//		 07 - 동기화 p.611

		User1Thread t1 = new User1Thread();
		Thread tmp = new User2Thread();
		Calculator cal = new Calculator(); // 공유 영역

//		Thread 타입이기 때문에 calculator 등 함수가 없어 -> 형변환 필요
		User2Thread t2 = (User2Thread) tmp;

//		그냥 실행하면 공유 영역의 메모리가 같은 값이 되어버림! (가~끔 정상적) -> 내가 setMemory를 할 때 다른 스레드가 바꾸면 안돼!!
		t1.setCalculator(cal);
		t2.setCalculator(cal);

		t1.start();
		t2.start();

	}

	private static void f3() {
//		동기화: 공유 영역을 하나의 스레드가 사용중일 때 다른 스레드의 접근 금지
		BathRoom bathroom = new BathRoom(); // 공유 영역
		BathThread t1 = new BathThread(bathroom, "김씨");
		BathThread t2 = new BathThread(bathroom, "이씨");
		BathThread t3 = new BathThread(bathroom, "박씨");
		BathThread t4 = new BathThread(bathroom, "최씨");

//		동기화하지 않은 경우 -> 화장실을 사용중인데 다른 사람들이 막 들어와!!!!
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	private static void f2() {
//		join
		SumThread t1 = new SumThread();
		t1.start();

		System.out.println(t1.getSum()); // 계산 다 안했는데 출력해버리면 안돼 (비동기니까) -> 끝날 때까지 기다렸다 만나서 내려가라!

		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t1.getSum());

		SumThread t2 = new SumThread(1, 50);
		SumThread t3 = new SumThread(51, 100);
		t2.start();
		t3.start();

		System.out.println("두 스레드의 합 = " + (t2.getSum() + t3.getSum()));

//		만약 다른 스레드가 오래 걸리는 작업이면 main이 너무 일찍 가버려서 결과가 이상하게 나오잖아
//		-> join을 사용해 이 스래드와 만나야 다음 코드를 실행할 수 있도록!
		try {
			Thread.sleep(3000);

			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("두 스레드의 합 = " + (t2.getSum() + t3.getSum()));

		System.out.println("** main 종료 **");

	}

	private static void f1() throws InterruptedException {
//		yield
		WorkThread t1 = new WorkThread("Thread-A");
		WorkThread t2 = new WorkThread("Thread-B");

		t1.start();
		t2.start();

//		5초간 일시정지 후 t1의 work를 false -> t1 thread가 다른 thread에게 양보함 (t1은 일 안해)
//		10초 후 t1의 work를 true
		Thread.sleep(5000);
		t1.work = false;

		Thread.sleep(10000);
		t1.work = true;
	}

}
