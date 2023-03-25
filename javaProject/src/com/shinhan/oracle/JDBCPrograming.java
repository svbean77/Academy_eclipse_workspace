// day015 05 - file04의 마지막을 jdbc로
// f1: file4 p. 12 직급이 manager인 사람이 속한 부서의 부서 번호, 부서명, 지역
// f2: file4 p. 8 직속상관이 Steven king인 사원의 이름과 급여, 입사일

package com.shinhan.oracle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.shinhan.dbutil.OracleUtil;

public class JDBCPrograming {

	public static void main(String[] args) {
//		f1();
		f2();
	}

	private static void f2() {
		System.out.println("직속상관이 사용자 입력인 사원의 이름과 급여");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		System.out.print("상사의 이름 입력 >> ");
		String searchName = sc.nextLine();

		String sql = """
				select first_name, salary, hire_date
				from employees
				where manager_id =any(
				    select employee_id
				    from employees
				    where last_name=?)
					"""; // 다중 문자열에서 가변임을 나타내는 ?(바인딩 변수)를 Statement에서는 지원하지 않음 -> 바꿔(preparedStatement)!
		Connection conn = null;
		PreparedStatement st = null; // 가변 문자열을 지원, Statement의 자식이기 때문에 묶은 util class도 사용 가능!
		ResultSet rs = null;

		conn = OracleUtil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, searchName); // 첫 번째 물음표에 searchName을 넣어라!
			rs = st.executeQuery(); // preparedStatement이기 때문에 여기에 sql을 넣으면 안돼! 미리 prepared된 sql을 실행하는 것!

			System.out.println("검색 이름: " + searchName);

			while (rs.next()) {
				String name = rs.getString("first_name");
				int salary = rs.getInt("salary");
//				jdbc는 sql의 date를 import
				Date date = rs.getDate("hire_date");

				System.out.println("name: " + name);
				System.out.println("salary: " + salary);
				System.out.println("date: " + date);
				System.out.println("-----------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}

	}

	private static void f1() {
//		1. driver load
//		2. db connection
//		3. sql 보낼 통로 만들기
//		4. sql 실행
//		5. 결과 받아 실행
//		6. 자원 반납
		System.out.println("직급이 manager인 사람이 속한 부서의 부서 번호, 부서명, 지역");
		System.out.println();

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = """
				select first_name, department_id, department_name, city
				from employees join departments using(department_id)
							   join locations using(location_id)
				where job_id in (
				    select job_id
				    from jobs
				    where substr(job_title, -7)=initCap('MANAGER')
				)
								""";

		try {
//			jdvc는 순서가 driver load, connection, statement, execute이기 때문에 try에 자동 자원반납을 할 수 없어 (driver load가 먼저니까!!)
			conn = OracleUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				String name = rs.getString(1);
				int deptId = rs.getInt(2);
				String dept = rs.getString(3);
				String city = rs.getString(4);

				System.out.println("이름: " + name);
				System.out.println("부서번호: " + deptId);
				System.out.println("부서명: " + dept);
				System.out.println("근무지: " + city);
				System.out.printf("%s - %d - %10s - %s\n", name, deptId, dept, city);
				System.out.println("----------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
	}

}
