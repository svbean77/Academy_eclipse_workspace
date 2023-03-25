// day 014 - 03 (ch03_01 LAB2 1번)
package com.shinhan.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class OracleConnectTest2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.print("조회하고자 하는 직원 이름 입력 >> ");
		Scanner sc = new Scanner(System.in);
		String inputName = sc.nextLine();
		String sql = "select salary, hire_date from employees where first_name=initCap('" + inputName + "')";

//		1. driver load
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("driver load 성공!");

//		2. connection
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "hr";
		String pass = "hr";
		Connection conn = DriverManager.getConnection(url, userid, pass);
		System.out.println("db connection 성공!");

//		3. statement를 통해 sql 전송
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		System.out.println("조회한 이름: " + inputName);
		while (rs.next()) {
			System.out.println(rs.getInt("salary"));
			System.out.println(rs.getInt(1));
			System.out.println(rs.getDate("hire_date"));
			System.out.println(rs.getDate(2));
			System.out.println("---------------------");
		}

		rs.close();
		st.close();
		conn.close();
	}

}
