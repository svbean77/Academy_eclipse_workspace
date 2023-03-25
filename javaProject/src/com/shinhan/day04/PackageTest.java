// 07
package com.shinhan.day04;

import java.util.Date;
import java.sql.*;

import com.shinhan.day03.Car;

public class PackageTest {

	public static void main(String[] args) {
		// 자바의 패키지 공부
		// 패키지를 만든 이유: 같은 이름의 class를 구분하기 위함
		// 같은 이름의 클래스를 사용하고 싶다면 package 이름을 명시해야 함
		java.util.Date d1 = new java.util.Date();
		System.out.println(d1); // Date라는 class가 이미 toString을 override 했기 때문에 주소가 아님

		java.sql.Date d2 = new java.sql.Date(d1.getTime());
		System.out.println(d2);

		
		BookVO b1 = new BookVO("day04", 12345) ;
		com.shinhan.day05.BookVO b5 = new com.shinhan.day05.BookVO("day05", 54321) ;
	}

}
