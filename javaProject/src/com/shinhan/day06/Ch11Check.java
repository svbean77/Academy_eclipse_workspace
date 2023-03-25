package com.shinhan.day06;

import java.io.IOException;

public class Ch11Check {

	public static void main(String[] args) {
		ch11no01();
		ch11no02();
		ch11no03();
		ch11no04();
		ch11no05();
		ch11no06();
		ch11no07();
		ch11no08();

	}

	private static void ch11no08() {
		// 11장 확인문제 8번
		try (FileWriter fw = new FileWriter("file.txt")) {
			fw.write("Java");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static class FileWriter implements AutoCloseable {
		public FileWriter(String filePath) throws IOException {
			System.out.println(filePath + " 파일을 엽니다.");
		}

		public void write(String data) throws IOException {
			System.out.println(data + "를 파일에 저장합니다.");
		}

		@Override
		public void close() throws IOException {
			System.out.println("파일을 닫습니다.");
		}

	}

	private static void ch11no07() {
		// 11장 확인문제 7번
		try {
			login("white", "12345");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			login("blue", "54321");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void login(String id, String password) throws NotExistIDException, WrongPasswordException {
		// id가 blue가 아니라면 NotExistIDException을 발생시킴
		if (!id.equals("blue")) {
			throw new NotExistIDException("아이디가 존재하지 않습니다.");
		} // password가 12345가 아니라면 WrongPasswordException을 발생시킴
		if (!password.equals("12345")) {
			throw new WrongPasswordException("패스워드가 틀립니다.");
		}
	}

	public static class NotExistIDException extends Exception {
		public NotExistIDException() {
		}

		public NotExistIDException(String message) {
			super(message);
		}
	}

	public static class WrongPasswordException extends Exception {
		public WrongPasswordException() {
		}

		public WrongPasswordException(String message) {
			super(message);
		}
	}

	private static void ch11no06() {
		// 11장 확인문제 6번
		String[] strArray = { "10", "2a" };
		int value = 0;
		for (int i = 0; i <= 2; i++) {
			try {
				value = Integer.parseInt(strArray[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("인덱스를 초과했음");
			} catch (NumberFormatException e) {
				System.out.println("숫자로 변환할 수 없음");
			} finally {
				System.out.println(value);
			}
		}
		// 10
		// 숫자로 변환할 수 없음
		// 10
		// 인덱스를 초과했음
		// 10
	}

	private static void ch11no05() {
		// 11장 확인문제 5번
		try {
			method1();
		} catch (Exception e) {
		}
//		try {method1();} catch(Exception e) {} catch(ClassNotFoundException e) {} // 3번
		try {
			method1();
		} catch (ClassNotFoundException e) {
		} catch (NumberFormatException e) {
		}

	}

	void method2() throws Exception {
		method1();
	}

	public static void method1() throws NumberFormatException, ClassNotFoundException {
	}

	private static void ch11no04() {
		// 11장 확인문제 4번
		// 1. 예외를 최초로 발생시키는 코드이다. -> O
		// 2. 예외를 호출한 곳으로 떠넘기기 위해 메소드 선언부에 작성된다. -> X
		// 3. throw로 발생된 예외는 일반적으로 생성자나 메소드 선언부에 throws로 떠넘겨진다. -> O
		// 4. throw 키워드 뒤에는 예외 객체 생성 코드가 온다. -> O

	}

	private static void ch11no03() {
		// 11장 확인문제 3번
		// 1. 생성자나 메소드의 선언 끝 부분에 사용되어 내부에서 발생된 예외를 떠넘긴다. -> O
		// 2. throws 뒤에는 떠넘겨야 할 예외를 쉼표(,)로 구분해서 기술한다. -> O
		// 3. 모든 예외를 떠넘기기 위해 간단하게 throws Exception으로 작성할 수 있다. -> O
		// 4. 새로운 예외를 발생시키기 위해 사용된다. -> X

	}

	private static void ch11no02() {
		// 11장 확인문제 2번
		// 1. try{} 블록에는 예외가 발생할 수 있는 코드를 작성한다. -> O
		// 2. catch{} 블록은 try{} 블록에서 발생한 예외를 처리하는 블록이다. -> O
		// 3. try{} 블록에서 return 문ㅇ르 사용하면 finally{} 블록은 실행되지 않는다. -> X
		// 4. catch{} 블록은 예외의 종류별로 여러 개를 작성할 수 있다. -> O

	}

	private static void ch11no01() {
		// 11장 확인문제 1번
		// 1. 예외는 사용자의 잘못된 조작, 개발자의 잘못된 코딩으로 인한 프로그램 오류를 말한다. -> O
		// 2. RuntimeException의 하위 예외는 컴파일러가 예외 처리 코드를 체크하지 않는다. -> O
		// 3. 예외는 try-catch 블록을 사용해서 처리된다. -> O
		// 4. 자바 표준 예외만 프로그램에서 처리할 수 있다. -> X

	}

}
