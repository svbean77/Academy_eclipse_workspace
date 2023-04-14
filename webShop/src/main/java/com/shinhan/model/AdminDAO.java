package com.shinhan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.util.OracleUtil;
import com.shinhan.vo.AdminVO;


public class AdminDAO {
	Connection conn; 
	Statement st;
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
	
	// day038
	public List<AdminVO> adminsPicture() {
		String result = "";
		String sql = """
				select * from (
				select * from admins order by manager_name desc)
				where rownum <= 3
				""";
		List<AdminVO> adminList = new ArrayList<>();
		
		conn = OracleUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				AdminVO admin = new AdminVO();
				admin.setEmail(rs.getString("Email"));
				admin.setManager_name(rs.getString("Manager_name"));
				admin.setPass(rs.getString("Pass"));
				admin.setPic(rs.getString("Pic"));
				
				adminList.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
		return adminList;
	}
}
