// 04 - f1()
package com.shinhan.day05;

public class OracleDB extends Object implements JDBCInterface {
	// interface를 받을 때는 implements 예약어 사용

	@Override
	public void dbConnect(String dbName) {
		// 상수 접근
		System.out.println("OracleDB.. 상수 접근: " + JDBC);
		System.out.println("OracleDB.. 상수 접근: " + JDBC2);

		// default method 호출
		select();

		JDBCInterface.update(); // static method는 인터페이스 거: 인터페이스 이름으로 접근
//		JDBCInterface.insert() // private는 호출 불가능
	}

	@Override
	public void dbConnect2(String dbName) {
		System.out.println(dbName + " Oracle DB db2Connect2");

	}

	public void select() {
		// overriding (재정의) 가능
		System.out.println("OracleDB 함수 select 재정의");
	}

}
