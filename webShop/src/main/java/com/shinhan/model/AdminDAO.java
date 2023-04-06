package com.shinhan.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.shinhan.util.OracleUtil;
import com.shinhan.vo.AdminVO;


public class AdminDAO {
	Connection conn; 
	PreparedStatement pst; 
	ResultSet rs; 
	
	// day031
	public AdminVO loginCheck(String email, String pass) {
		String sql = "select manager_name from admins where email=? and pass=?";
		AdminVO admin = null;

		try {
			conn = OracleUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, pass);
			rs = pst.executeQuery();

			while (rs.next()) {
				admin = new AdminVO(email, rs.getString(1), pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}

		return admin;
	}
	
	// day032
	public int registerAdmin(AdminVO admin) {
		int result = 0;
		String sql = "insert into admins(email, pass, manager_name) values(?, ?, ?)";
		
		try {
			conn = OracleUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, admin.getEmail());
			pst.setString(2, admin.getPass());
			pst.setString(3, admin.getManager_name());
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}
		
		return result;
	}
}
