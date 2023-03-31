// day015 - 05 -  미니 프로젝트 (개인 프로젝트 MVC2 model 연습하기)
// day016 - 02 - 추가 기능
// 2. DAO(Data Access Object) 만들기: DB에 대한 업무 (CRUD 업무: insert, select, update, delete)
package com.shinhan.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dbutil.OracleUtil;
import com.shinhan.vo.EmpVO;

public class EmpDAO {
	Connection conn; // field이기 때문에 초기화하지 않아도 됨 (저번엔 메소드의 로컬 변수로 사용했기 때문에 초기화한 것!)
	Statement st;
	PreparedStatement pst; // 바인딩변수 ?를 지원
	CallableStatement cst; // SP 지원 (프로시저)
	ResultSet rs; // select에만 존재함 (데이터 꺼내오기)
	int resultCount; // insert, update, delete된 건수

//	day017
//	SP 프로시저 호출
	public EmpVO getSalary(int empid) { // 가져오는 타입이 다르면 리턴 타입을 고민해봐 -> VO를 쓰거나 Map을 쓰거나... 등등!
		String sql = "{call sp_salary(?,?,?)}";
		conn = OracleUtil.getConnection();
		EmpVO emp = new EmpVO();

		try {
			cst = conn.prepareCall(sql);
			cst.setInt(1, empid); // in 변수 설정
			cst.registerOutParameter(2, Types.DOUBLE); // out 변수는 리턴 타입 설정
			cst.registerOutParameter(3, Types.VARCHAR);
			cst.execute(); // resultset이 있으면(select) true, 없으면 (update 등) false

			emp.setSalary(cst.getDouble(2));
			emp.setFirst_name(cst.getString(3));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return emp;
	}

//	day015
//	day016: sql문에 order by 추가
//	day017: sql 문에 f_tax 함수 추가 -> 에러사항 makeEmp 함수에 주석!
//	모든 직원의 모든 정보 출력
	public List<EmpVO> selectAll() {
		String sql = """
				select  EMPLOYEE_ID,
						FIRST_NAME,
						LAST_NAME,
						EMAIL,
						PHONE_NUMBER,
						HIRE_DATE,
						JOB_ID,
						salary,
						COMMISSION_PCT,
						MANAGER_ID,
						DEPARTMENT_ID
				from employees order by 1""";
		List<EmpVO> emplist = new ArrayList<>();

		conn = OracleUtil.getConnection();
		try {
			st = conn.createStatement();

			rs = st.executeQuery(sql);
//			if(st.execute(sql)) { // 이렇게 바꾸기도 가능!
//				rs = st.getResultSet();
//			}

//			컬럼 이름 등 메타데이터를 알고싶다면?!
			ResultSetMetaData meta = rs.getMetaData();
			int count = meta.getColumnCount();
			for (int i = 1; i <= count; i++) { // db의 인덱스는 1부터!
				System.out.println("컬럼이름: " + meta.getColumnName(i));
			}

			while (rs.next()) {
				EmpVO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}

		return emplist;
	}

//	day015
//	employee_id를 받아 특정 직원 조회
	public EmpVO selectById(int empid) {
		String sql = "select * from employees where employee_id=" + empid;
		EmpVO emp = null;

		try {
			conn = OracleUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				emp = makeEmp(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}

		return emp;
	}

//	day015
//	특정 부서의 직원 조회
	public List<EmpVO> selectByDept(int deptid) {
		String sql = "select * from employees where department_id=" + deptid;
		List<EmpVO> emplist = new ArrayList<>();

		try {
			conn = OracleUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				EmpVO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}

		return emplist;
	}

//	day015
//	부서 아이디, 직무 아이디, 연봉 이상으로 검색
	public List<EmpVO> selectByCondition(int deptid, String jobid, double salary) {
		String sql = "select * from employees " + "where department_id=? " + "and job_id=? " + "and salary>=?";
		List<EmpVO> emplist = new ArrayList<>();

		try {
			conn = OracleUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid);
			pst.setString(2, jobid);
			pst.setDouble(3, salary);
			rs = pst.executeQuery();

			while (rs.next()) {
				EmpVO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}

		return emplist;
	}

//	day016
//	자기 부서 평균 연봉 이하 받는 직원 조회
	public List<EmpVO> selectLAB() {
		String sql = """
				select employee_id, first_name, salary, employees.department_id
				from employees, (select department_id myDept, avg(salary) avgSal
				                 from employees
				                 group by department_id)
				where salary < avgSal
				and department_id=myDept
								""";
		List<EmpVO> emplist = new ArrayList<>();

		conn = OracleUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				EmpVO emp = makeEmp2(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}

		return emplist;
	}

//	day016
//	신규 직원 등록
	public int empInsert(EmpVO emp) {
		String sql = """
				insert into employees values(seq_employee.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
					""";

		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, emp.getFirst_name());
			pst.setString(2, emp.getLast_name());
			pst.setString(3, emp.getEmail());
			pst.setString(4, emp.getPhone_number());
			pst.setDate(5, emp.getHire_date());
			pst.setString(6, emp.getJob_id());
			pst.setDouble(7, emp.getSalary());
			pst.setDouble(8, emp.getCommission_pct());
			pst.setInt(9, emp.getManager_id());
			pst.setInt(10, emp.getDepartment_id());
			resultCount = pst.executeUpdate(); // DML 문장 실행, 영향 받은 건수 리턴
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(null, pst, conn);
		}
		return resultCount;
	}

//	day016
//	직원 정보 수정
	public int empUpdate(EmpVO emp) {
		String sql = """
				update employees
				set email=?, department_id=?, job_id=?, salary=?, hire_date=?, manager_id=?
				where employee_id=?
					 """;

		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, emp.getEmail());
			pst.setInt(2, emp.getDepartment_id());
			pst.setString(3, emp.getJob_id());
			pst.setDouble(4, emp.getSalary());
			pst.setDate(5, emp.getHire_date());
			pst.setInt(6, emp.getManager_id());
			pst.setInt(7, emp.getEmployee_id());
			resultCount = pst.executeUpdate(); // DML 문장 실행, 영향 받은 건수 리턴

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(null, pst, conn);
		}
		System.out.println("update 결과: " + resultCount);
		return resultCount;
	}

//	day016
//	한 건의 직원 삭제
	public int empDelete(int empid) {
		String sql = """
				delete from employees
				where employee_id=?
					 """;

		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, empid);
			resultCount = pst.executeUpdate(); // DML 문장 실행, 영향 받은 건수 리턴

		} catch (SQLException e) {
			resultCount = -1;
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(null, pst, conn);
		}
		System.out.println("delete 결과: " + resultCount);
		return resultCount;
	}

//	day015
//	모든 컬럼 사용
	private EmpVO makeEmp(ResultSet rs) throws SQLException {
		// 함수 부른 쪽에서 처리를 하고 있기 때문에 여기서는 그냥 던져버림~
		EmpVO emp = new EmpVO();
		emp.setCommission_pct(rs.getDouble("Commission_pct"));
		emp.setDepartment_id(rs.getInt("Department_id"));
		emp.setEmail(rs.getString("Email"));
		emp.setEmployee_id(rs.getInt("Employee_id"));
		emp.setFirst_name(rs.getString("First_name"));
		emp.setHire_date(rs.getDate("Hire_date"));
		emp.setJob_id(rs.getString("Job_id"));
		emp.setLast_name(rs.getString("Last_name"));
		emp.setManager_id(rs.getInt("Manager_id"));
		emp.setPhone_number(rs.getString("Phone_number"));
		emp.setSalary(rs.getDouble("Salary")); // 컬럼 이름이랑 완.전. 동일해야 함! 함수 등으로 이름이 변하면 에러 발생!!!!!

		return emp;
	}

//	day016
//	4개만 읽어오기 때문에 이렇게 불러와야 함! 컬럼을 다 불러오지 않잖아!
	private EmpVO makeEmp2(ResultSet rs) throws SQLException {
		EmpVO emp = new EmpVO();
		emp.setDepartment_id(rs.getInt("Department_id"));
		emp.setEmployee_id(rs.getInt("Employee_id"));
		emp.setFirst_name(rs.getString("First_name"));
		emp.setSalary(rs.getDouble("Salary"));

		return emp;
	}
}
