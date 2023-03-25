// 12 - 스레드풀 p.629(runnable), callable (f1, f2)
package com.shinhan.day09;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolTest {
	public static void main(String[] args) {
//		f1();
		f2();
	}

	private static void f2() {
//		Callable 익명객체
		String[][] mails = new String[1000][3];
		for (int i = 0; i < mails.length; i++) {
			mails[i][0] = "admin@my.com";
			mails[i][1] = "member" + i + "@my.com";
			mails[i][2] = "신상품 입고";
		}
		ExecutorService service = Executors.newFixedThreadPool(5);
		for (int i = 1; i <= 100; i++) {
			int idx = i; // 내부 클래스에서 사용하기 때문에 final 특성을 가짐 (익명 클래스니까 클래스라고 생각!!!!)

			Future<Integer> future = service.submit(new Callable<Integer>() {
//				리턴하고싶은 타입을 제네릭에 작성
				public Integer call() throws Exception {
					int sum = 0;
					for (int j = 1; j <= idx; j++) {
						sum += j;
					}
					return sum;
				}
			});

			int result;
			try {
				result = future.get();
				System.out.println(idx + "까지의 합 = " + result);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		service.shutdown(); // 스레드풀이 끝!

	}

	private static void f1() {
//		Runnable 익명객체
		String[][] mails = new String[1000][3];
		for (int i = 0; i < mails.length; i++) {
			mails[i][0] = "admin@my.com";
			mails[i][1] = "member" + i + "@my.com";
			mails[i][2] = "신상품 입고";
		}
		ExecutorService service = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 1000; i++) {
			int idx = i; // 내부 클래스에서 사용하기 때문에 final 특성을 가짐 (익명 클래스니까 클래스라고 생각!!!!)
//			따라서 다른 변수에 i값을 보냄!

			service.execute(new Runnable() {
				@Override
				public void run() {
					String tName = Thread.currentThread().getName();
//					 1000번을 돌리는데 스레드는 1~5밖에 없음 -> 개수를 5로 정했기 때문!
					System.out.println(
							tName + " from " + mails[idx][0] + " to " + mails[idx][1] + " => " + mails[idx][2]);
				}
			});
		}

	}
}
