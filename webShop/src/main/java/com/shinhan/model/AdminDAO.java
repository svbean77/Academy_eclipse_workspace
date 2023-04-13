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
		String sql = "select * from admins where email=? and pass=?";
		AdminVO admin = null;

		try {
			conn = OracleUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, pass);
			rs = pst.executeQuery();

			while (rs.next()) {
				admin = new AdminVO(email, rs.getString("manager_name"), pass, rs.getString("pic"));
				// 순서를 확실히 모른다면 직접 주는거로
				admin.setEmail(email);
				admin.setManager_name(rs.getString("manager_name"));
				admin.setPass(pass);
				admin.setPic(rs.getString("pic"));
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
		String sql = "insert into admins(email, pass, manager_name, pic) values(?, ?, ?, ?)";
		
		try {
			conn = OracleUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, admin.getEmail());
			pst.setString(2, admin.getPass());
			pst.setString(3, admin.getManager_name());
			pst.setString(4, admin.getPic());
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}
		
		return result;
	}
	
	// day033
	public int dupCheck(String email) {
		String sql = "select count(*) from admins where email=?";  
		int count = 0;

		try {
			conn = OracleUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			rs = pst.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}

		return count;
	}
}
