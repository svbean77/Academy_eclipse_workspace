// 06 내가 해보는 MVC2
package aproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dbutil.OracleUtil;

import aproject.vo.DeptVO;

public class DeptDAO {
	Connection conn;
	Statement st;
	PreparedStatement rst;
	ResultSet rs;

	public List<DeptVO> selectAll() {
		String sql = "select * from departments";
		List<DeptVO> deptlist = new ArrayList<>();

		conn = OracleUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				DeptVO dept = makeDept(rs);
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
		return deptlist;

	}

	public DeptVO selectById(int deptid) {
		String sql = "select * from departments where department_id=" + deptid;
		DeptVO dept = null;

		conn = OracleUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				dept = makeDept(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
		return dept;

	}

	public DeptVO selectByCondition(String deptname, int managerid) {
		String sql = "select * from departments " + "where department_name=? " + "and manager_id=?";
		DeptVO dept = null;

		conn = OracleUtil.getConnection();
		try {
			rst = conn.prepareStatement(sql);
			rst.setString(1, deptname);
			rst.setInt(2, managerid);
			rs = rst.executeQuery();

			while (rs.next()) {
				dept = makeDept(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, rst, conn);
		}
		return dept;

	}

	private DeptVO makeDept(ResultSet rs) throws SQLException {
		DeptVO dept = new DeptVO();
		dept.setDepartment_id(rs.getInt("Department_id"));
		dept.setDepartment_name(rs.getString("Department_name"));
		dept.setLocation_id(rs.getInt("Location_id"));
		dept.setManager_id(rs.getInt("Manager_id"));
		return dept;
	}
}
