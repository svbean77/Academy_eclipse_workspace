// day 014 - 08 MySQL로 해보기
package com.shinhan.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MysqlConnectTest4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		mysql은 trunc, initCap 등의 함수가 존재하지 않음! db가 바뀐다면 이렇게 문장을 바꿔야할 수 있어
//		따라서 바꾸지 않아도 되도록 표준을 사용하는 것이 좋아! (물론 db가 바뀌는 일은 많지 않아)
		System.out.print("조회하고자 하는 직원 이름 입력 >> ");
		Scanner sc = new Scanner(System.in);
		String inputName = sc.nextLine();
		String sql = "select first_name, last_name, salary, hire_date from employees where lower(first_name)=lower('"
				+ inputName + "')";

//		1. driver load
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("driver load 성공!");

//		2. connection
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String url = "jdbc:mysql://localhost/hr";
		String userid = "hr";
		String pass = "hr";
		Connection conn = DriverManager.getConnection(url, userid, pass);
		System.out.println("db connection 성공!");

//		3. statement를 통해 sql 전송
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		System.out.println("조회한 이름: " + inputName);
		while (rs.next()) {
			System.out.print(rs.getString("first_name") + " ");
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt("salary"));
			System.out.println(rs.getInt(3));
			System.out.println(rs.getDate("hire_date"));
			System.out.println(rs.getDate(4));
			System.out.println("---------------------");
		}

		rs.close();
		st.close();
		conn.close();
	}

}
