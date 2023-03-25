// day 014 - 04 (ch03_01 LAB2 6번) 다른 풀이 방법
package com.shinhan.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class OracleConnectTest3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String sql = "select first_name, hire_date, salary, trunc(months_between(sysdate, hire_date)/12)"
				+ " from employees"
				+ " where trunc(months_between(sysdate, hire_date)/12) >= 7";

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
		while (rs.next()) {
			System.out.println(rs.getString("first_name"));
			System.out.println(rs.getDate("hire_date"));
			System.out.println(rs.getInt("salary"));
			System.out.println(rs.getInt(4));
			System.out.println("---------------------");
		}

		rs.close();
		st.close();
		conn.close();
	}

}
