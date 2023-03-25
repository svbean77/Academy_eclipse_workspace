// day 014 - 01
package com.shinhan.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConnectTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String sql = "select * from EMPLOYEES where employee_id = 100";
//		String sql = "select * from EMPLOYEES";

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
			System.out.println(rs.getInt(1)); // 첫 번째: 직원 아이디
			System.out.println(rs.getString(2)); // 두 번째: first name
			System.out.println(rs.getString(3)); // 세 번째: last name
//			몇 번째가 어떤 타입인지 어떻게 알아?! -> 칼럼 이름으로 주는 것이 안정적
			System.out.println(rs.getInt("salary"));
			System.out.println("---------------------");
		}

		rs.close();
		st.close();
		conn.close();
	}

}
