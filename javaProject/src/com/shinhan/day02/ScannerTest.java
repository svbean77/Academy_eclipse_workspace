// 04
package com.shinhan.day02;

import java.io.IOException;
// java.lang 내부 클래스는 import 없이 사용 가능
// 나머지 패키지 내부 클래스는 import 해야 함
import java.io.InputStream;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) throws IOException { // 에러가 발생하면 상위 함수(JVM)이 책임지기
		// console 입력을 받는 scanner
		f1();
		f2();
	}

	private static void f2() {
		// 
		System.out.println("f2 함수입니당");
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 입력 >> ");
		int score = sc.nextInt();
		System.out.print("이름 입력 >> ");
		String name = sc.next();
		System.out.print("메모 >> ");
		sc.nextLine(); // 위 입력의 \n을 읽기 때문에 한 번 날려줘야 함
		String memo = sc.nextLine(); // 한 라인을 다 읽음
		System.out.println(name + " => " + score);
		System.out.println("memo => " + memo);
		
		
		
	}

	private static void f1() throws IOException { // 에러가 발생하면 상위 함수(main)이 책임지기
		// 사용자 입력(=System.in)을 받는 함수
		// Scanner는 사용자의 입력을 편하게 받기 위해 만든 클래스
		System.out.println("f1 함수입니당");
		System.out.print("정수를 입력 >> ");
		InputStream is = System.in;

		int i;
		// i = is.read(); // 한 byte만 읽음, 첫 번째 글자부터 읽기 때문에 한 글자씩 출력됨
		while ((i = is.read()) != 13) { // 13이 종료코드
			System.out.print((char) i);
		}

	}

}
