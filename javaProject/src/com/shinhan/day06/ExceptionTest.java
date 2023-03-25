// 07
package com.shinhan.day06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.spi.FileSystemProvider;

// Exception(예외): 프로그래머의 노력으로 프로그램이 중단되지 않고 계속 진행하도록 할 수 있음
// 조건문으로 오류가 없는 코드를 수행하지 않고 try-catch로 처리한 이유: 업무 로직, 오류처리 로직을 분리하기 위함
// = try 부분만 읽으면 코드를 알 수 있음
// printStackTrace: 에러 이유를 알려줌 -> 예외처리를 할 때 왜 오류인지 알기 위해 보이는 게 좋다
public class ExceptionTest {

	public static void main(String[] args) throws IOException {
		// main에서 throws를 하면 JVM이 처리하고 프로그램이 중단됨 (main의 끝까지 실행되지는 않아)
		System.out.println("*** main이 시작합니다 ***");
		// RuntimeException
		f1();
		f2();
		f3();
		f4();
		f5();
		f6();
		f7();

		// 일반 예외 + 떠넘기기(throws)
		f8();
		f9();
		f10();
		try {
			f11();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("*** main이 종료됩니다 ***");
	}

	private static void f11() throws ClassNotFoundException {
		// 클래스를 메모리에 올려 정보를 읽는 예외처리 예제
		System.out.println("** 함수 f10 실행 **");

		Class cls = Class.forName("com.shinhan.day06.Book");
		System.out.println(cls.getSimpleName());

	}

	private static void f10() throws IOException {
		// 방법 2. 떠넘긴다: 이 함수를 호출한 곳에 떠넘긴다.
		System.out.println("** 함수 f10 실행 **");
		FileReader fr = new FileReader("src/com/shinhan/day06/Book.java");

		int i;
		while ((i = fr.read()) != -1) { // IO가 옆에 생기지 않고 FileNotFound를 덮어씀? -> IO가 더 상위 예외구나!
			System.out.print((char) i);
		}

	}

	private static void f9() {
		// finally에서의 자원 반납이 너무 귀찮아! -> 자동으로 반납해줌!
		System.out.println("** 함수 f9 실행 **");

		try (FileReader fr = new FileReader("src/com/shinhan/day06/Book.java")) {
			// try 종료 후 자동으로 자원 반납!!! (try에 괄호 넣기)

			System.out.println("존재하는 파일이다.. 파일이 열림!");

			int i;
			while ((i = fr.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (FileNotFoundException e) {
			// 존재하지 않는 파일이라면?!
			System.out.println("그런 파일은 존재하지 않아!");
			e.printStackTrace();
		} catch (IOException e) {
			// 입출력 예외라면?!
			e.printStackTrace();
		} finally {

		}
	}

	private static void f8() {
		// 일반 Exception: 컴파일시 반드시 해결해야 함
		// 방법1. 내가 한다. 2. 떠넘긴다
		// 1. 내가 한다 도전!
		System.out.println("** 함수 f8 실행 **");

		FileReader fr = null; // fr이 지역변수면 finally에서 못 씀 -> try 밖에서 선언
		try {
			/*
			 * 
			 * 
			 * 실제 업무 로직의 길이는 이렇게 짦음 -> 업무 로직, 예외 처리 로직을 분리한 이유!
			 * 
			 * 
			 */
			// 폴더 위치는 javaProject임 -> 그 이후 경로부터 작성하면 됨!
			fr = new FileReader("src/com/shinhan/day06/Book.java"); // InputStream은 한 byte씩 받기 때문에 한글이 깨짐..
			System.out.println("존재하는 파일이다.. 파일이 열림!");

			int i;
			// fr.read: 2byte씩 읽음 -> 한글이 깨지지 않아!
			while ((i = fr.read()) != -1) { // 파일의 맨 끝 부분이 -1임!
				System.out.print((char) i);
			}
			/*
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 */
		} catch (FileNotFoundException e) {
			// 존재하지 않는 파일이라면?!
			System.out.println("그런 파일은 존재하지 않아!");
			e.printStackTrace();
		} catch (IOException e) {
			// 입출력 예외라면?!
			e.printStackTrace();
		} finally {
			System.out.println("파일을 닫습니다..");
			try {
				fr.close(); // fr까지 가지 않았는데 예외 발생이면 초기화되지 않은거니까 선언시 초기화 해야 함
			} catch (IOException e) {
				// 입출력 예외라면?!
				e.printStackTrace();
			} catch (NullPointerException e) {
				// 파일을 열지 못했으면 null인데 null을 어떻게 닫아!!
				e.printStackTrace();
			}
		}
	}

	private static void f7() {
		// 오류 처리가 여러 개인 경우
		System.out.println("** 함수 f7 실행 **");

		// 상위 오류는 뒤쪽에 작성 (~~~를 제외한 나머지 오류는 어쩌고)
		try {
			String s = null;
			System.out.println(s.length());
		} catch (NumberFormatException | ClassCastException ex) {
			// | (or) 연산을 사용해 여러 개 묶기도 가능
			System.out.println("예외: " + ex.getMessage());
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("예외: " + ex.getMessage());
		} catch (Exception ex) {
			System.out.println("처리하지 않은 다른 상위 예외다");
			System.out.println("예외: " + ex.getMessage());

		} finally {
			System.out.println("이 부분은 반드시 처리됨");
			System.out.println("자원 반납 코드를 작성 (ex. dbDisconnect, fileClose"); // 자원 반납이 아주 중요해
		}

	}

	private static void f6() {
		// 오류가 없는 경우
		System.out.println("** 함수 f6 실행 **");
		try {
			// 이 문장을 시도해볼게
			String num = "100";
			int total = Integer.parseInt(num) + 200;
			System.out.println(total);
			System.out.println("오류 없이 계산 잘 했다!");

		} catch (NumberFormatException ex) {
			// 예외가 발생하면 여기로
//			ex.printStackTrace(); // 오류 과정 출력
			System.out.println("예외: " + ex.getMessage());
		}
	}

	private static void f5() {
		// NumberFormatException
		System.out.println("** 함수 f5 실행 **");
		try {
			// 이 문장을 시도해볼게
			String num = "100점";
			int total = Integer.parseInt(num) + 200;
			System.out.println(total);
			System.out.println("계산 잘 했다!");

		} catch (NumberFormatException ex) {
			// 예외가 발생하면 여기로
//			ex.printStackTrace(); // 오류 과정 출력
			System.out.println("예외: " + ex.getMessage());
		}
	}

	private static void f4() {
		// ClassCastException
		System.out.println("** 함수 f2 실행 **");
		try {
			// 이 문장을 시도해볼게
			Object obj = new String("4바");
			System.out.println(obj.toString());
			String s = (String) obj;
			System.out.println(s.length());

			Object obj2 = new Object();
			String s2 = (String) obj2;
			System.out.println("계산 잘 했다!");

		} catch (ClassCastException ex) {
			// 예외가 발생하면 여기로
//			ex.printStackTrace(); // 오류 과정 출력
			System.out.println("예외: " + ex.getMessage());
		}
	}

	private static void f3() {
		// ArrayIndexOutOfBoundsException
		System.out.println("** 함수 f3 실행 **");
		try {
			// 이 문장을 시도해볼게
			int[] arr = new int[5];
			System.out.println(arr[0]);
			System.out.println(arr[5]);
			System.out.println("계산 잘 했다!");

		} catch (ArrayIndexOutOfBoundsException ex) {
			// 예외가 발생하면 여기로
//			ex.printStackTrace(); // 오류 과정 출력
			System.out.println("예외: " + ex.getMessage());
		}
	}

	private static void f2() {
		// ArithmeticException
		System.out.println("** 함수 f2 실행 **");

		try {
			// 이 문장을 시도해볼게
			int a = 10;
			int b = 0;

			System.out.println(a / b);
			System.out.println("계산 잘 했다!");

		} catch (ArithmeticException ex) {
			// 예외가 발생하면 여기로
//			ex.printStackTrace(); // 오류 과정 출력
			System.out.println("예외: " + ex.getMessage());
		}

	}

	private static void f1() {
		// 실행 예외: 컴파일시 정상, 실행시 오류 발생
		// 기타 예외: 컴파일시 오류 발생 -> 컴파일시 반드시 처리해야 함
		System.out.println("** 함수 f1 실행 **");

		int a = 10;
		int b = 0;

		// 1. ArithmeticException: 0으로 나눌 수 없어..
//		System.out.println(a / b);

		// 2. ArrayIndexOutOfBoundsException: 배열의 index 범위 벗어남..
		int[] arr = new int[5];
		System.out.println(arr[0]);
//		System.out.println(arr[5]);

		// 3. ClassCastException: 캐스팅 잘못했어..
		Object obj = new String("자바");
		System.out.println(obj.toString());
		String s = (String) obj;
		System.out.println(s.length());

		Object obj2 = new Object();
//		String s2 = (String) obj2;

		// 4. NumberFormatException: 숫자 타입이 아니야..
		String num = "100점";
//		int total = Integer.parseInt(num) + 200;

	}

}
