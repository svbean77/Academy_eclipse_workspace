// 08
package com.shinhan.day07;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 정규표현식 연습!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class ObjectTest5 {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		f1();
		f2();
		f3();
		f4();
		f5();
		f6();
		f7();
	}

	private static void f7() throws IOException {
//		리소스 경로 얻기 - 리소스 얻기 ver
		System.out.println("** 함수 f7 실행 **");
//		.class를 읽기 때문에 경로가 bin으로 떠!! .java는 없어!!
//		src 경로는 개발자 환경 - 실행할 때는 .class이기 때문에 bin 경로로 가야 함!
		URL url = ObjectTest5.class.getResource("CellPhone.class");
		System.out.println(url.getPath());

		URL url2 = ObjectTest5.class.getResource("fox.jpg");
		System.out.println(url2.getPath());
//		AsStream이기 때문에 1byte씩 읽음 -> 한글 깨져..
		InputStream is = ObjectTest5.class.getResourceAsStream("CellPhone.class");
		InputStreamReader ir = new InputStreamReader(is);
		int i;
		while ((i = is.read()) != -1) {
			System.out.print((char) i);
		}

		while ((i = ir.read()) != -1) {
			System.out.print((char) i);
		}
		is.close();
		ir.close();
	}

	private static void f6() throws IOException {
//		리소스 경로 얻기 - 그냥 경로 적기 ver
		System.out.println("** 함수 f6 실행 **");

//		Stream은 1byte이기 때문에 한글 깨짐, Reader는 2byte이기 때문에 한글 정상
//		이거 경로 쓰는게 너무 귀찮아! ("src/com/shinhan/day07/CellPhone.java") -> 경로 얻기! f7()
//		javaProject를 기준으로 파일 읽기 -> 소스파일이기 때문에 src로
		FileReader fr = new FileReader("src/com/shinhan/day07/CellPhone.java");
		int i;
		while ((i = fr.read()) != -1) {
			System.out.print((char) i);
		}

		fr.close();
	}

	private static void f5() throws ClassNotFoundException {
//		리플렉션: 일반적이지는 않음.. low level의 프로그램을 짤 때 사용
		System.out.println("** 함수 f5 실행 **");

//		클래스를 얻어오는 3가지 방법!
		Class cls1 = CellPhone.class;
		Class cls2 = Class.forName("com.shinhan.day07.CellPhone");
		CellPhone phone = new CellPhone("AA");
		Class cls3 = phone.getClass();

//		생성자 정보 가져옴
		Constructor[] constructors = cls1.getDeclaredConstructors();
		for (Constructor c : constructors) {
			System.out.println(c.getModifiers()); // modifier가 생략되었기 때문에 0(개)
		}

//		필드 정보 가져옴
		Field[] fs = cls1.getDeclaredFields();
		for (Field f : fs) {
			System.out.print(f.getName() + ": ");
			System.out.println(f.getType().getSimpleName());
		}

//		메소드 정보 가져옴
		Method[] ms = cls1.getDeclaredMethods();
		for (Method m : ms) {
			System.out.print(m.getName() + ": ");
			System.out.println(m.getParameterCount() + "개의 매개변수 존재");
		}
	}

	private static void f4() {
//		이메일 정규 표현식 - 원하는 형식들 추출
		System.out.println("** 함수 f4 실행 **");

		String p1 = "([a-zA-Z0-9]+)@(\\w+)\\.\\w+"; // 아이디가 무조건 와야하니까 +(한 자 이상)
		String data = "wed0409@daum.net 제 이메일입니다. asdfg@naver.vd or dswq34r@google.sdc 연락 주세요!";

		Pattern pattern = Pattern.compile(p1);
		Matcher matcher = pattern.matcher(data);
		while (matcher.find()) {
			System.out.print(matcher.group(1) + " 아이디의 "); // 괄호로 감싼 첫 번째 그룹 (아이디)
			System.out.print(matcher.group(2) + ": "); // 괄호로 감싼 두 번째 그룹 (도메인)
			System.out.println(matcher.group()); // 모든 형식 출력

		}
	}

	private static void f3() {
//		휴대폰번호 정규 표현식 - 원하는 형식들 추출
		System.out.println("** 함수 f3 실행 **");

		String p1 = "010-([0-9]{3,4})-\\d{4}";
		String data = "010-1234-5678 이 연락처로 연락 바람! 010-9876-4321 혹은 010-2357-5673";

		Pattern pattern = Pattern.compile(p1); // 패턴을 생성: 이 패턴에 매칭되는 것을 찾겠다!
		Matcher matcher = pattern.matcher(data); // 매칭되는 것을 찾아줌
		while (matcher.find()) { // 매칭되는 내용이 있니?
			System.out.print(matcher.group(1) + "님: ");
			System.out.println(matcher.group());
		}
	}

	private static void f2() {
//		이메일 정규 표현식
		System.out.println("** 함수 f2 실행 **");

		String p1 = "[a-zA-Z0-9]+@\\w+\\.\\w+"; // 아이디가 무조건 와야하니까 +(한 자 이상)
		String data = "wed0409@daum.net";
		boolean result = Pattern.matches(p1, data);
		System.out.println(result ? "올바른 형식!" : "형식 안맞아..");
	}

	private static void f1() {
//		휴대폰번호 정규 표현식
		System.out.println("** 함수 f1 실행 **");
		String p1 = "010-[0-9]{3,4}-\\d{4}"; // 명확하게 010, -로 구분, 3~4자리씩
//		[0-9]를 쓰기 싫어서 숫자라고 할거야! -> 제어문자(\)를 그대로 사용하기 위해 \\d (\를 두 번) 사용!
		String data = "010-1234-5678";

		boolean result = Pattern.matches(p1, data); // 조건, 데이터
		System.out.println(result ? "올바른 형식!" : "형식 안맞아..");
	}

}
