// 04
package com.shinhan.day07;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;

public class ObjectTest3 {

	public static void main(String[] args) {
		f1();
//		try {
//			f2();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		f3(args);
		f4();
		f5();

		System.out.println("main 종료");
	}

	private static void f5() {
//		System 클래스 - property 얻기
		System.out.println("** 함수 f5 실행 **");

		String os = System.getProperty("os.name");
		System.out.println(os);

//		어떤 property가 있는지 어떻게 알아?! -> getProperties 사용
		Properties ps = System.getProperties();
		Set<Object> keys = ps.keySet(); // keys의 타입을 모르면 아무거나 담으라고 generic으로 Object 사용
		for (Object key : keys) {
			System.out.println("key: " + key + " --- " + System.getProperty((String) key));
		}
	}

	private static void f4() {
//		System 클래스 - 소요 시간 측정
		System.out.println("** 함수 f4 실행 **");

		long startTime = System.nanoTime();
		for (int i = 0; i < 1000000000; i++) {

		}
		long endTime = System.nanoTime();

		System.out.println("걸린시간: " + (endTime - startTime));
	}

	private static void f3(String[] arr) {
//		System 클래스 - 프로그램 종료
		System.out.println("** 함수 f3 실행 **");
//		명령행 매개변수: 실행시 들어오는 매개변수 (java ObjectTest3 args)
		if (arr.length == 0) {
//			1. 함수 빠지기
			System.out.println("명령행 매개변수가 없다..");
			return;
//			2. 프로그램을 당장 종료: 그 이후의 코드들은 실행되지 않음
//			System.exit(0); // 정상종료: 0
		}
		System.out.println("매개변수: " + Arrays.toString(arr));
	}

	private static void f2() throws IOException {
//		System 클래스 - 표준 입력
		System.out.println("** 함수 f2 실행 **");

//		1. in: 표준 입력 (default: keyboard)
		InputStream is = System.in;
		InputStreamReader ir = new InputStreamReader(is); // 2byte씩 읽을 수 있음!
		int i;
//		InputStream: 1byte씩 읽음 -> 한글은 2byte이기 때문에 깨짐..
		while ((i = is.read()) != 13) {
//			13: 엔터 (\n)
			System.out.print((char) i);
		}
		System.out.println();
		while ((i = ir.read()) != 13) {
//			13: 엔터 (\n)
			System.out.print((char) i);
		}
		System.out.println();
	}

	private static void f1() {
//		System 클래스 - 표준 출력
		System.out.println("** 함수 f1 실행 **");

//		1. out: 표준 출력(모니터 출력)
//		System.out은 상수! (static final) -> 그니까 new System을 안하지
		PrintStream ps1 = System.out;
//		모니터에 줄바꿈 하지 말고 찍어라.
		ps1.print(false);
		ps1.print(100);
//		모니터에 찍고 줄을 바꿔라.
		ps1.println();
		ps1.println("Java");
//		format대로 작성하라.
		ps1.printf("%10d\n", 100); // 기본: 오른쪽 정렬
		ps1.printf("%-10d\n", 100); // -: 왼쪽 정렬

//		2. err
		PrintStream ps2 = System.err;
		ps2.println("Java");
	}

}
