package com.bvrith.chasingdelicious.dao;

import java.beans.Statement;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bvrith.chasingdelicious.DBConnection.DBConnection;
import com.bvrith.chasingdelicious.dto.Admin;
import com.bvrith.chasingdelicious.dto.Customer;
import com.bvrith.chasingdelicious.dto.Hotel;

public class AdminDAO {
	public static int add(Admin admin){
		final String INSERT_QUERY="insert into admin(id, name, password, email) values(?,?,?,?)";
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, admin.getId());
			pst.setString(2, admin.getName());
			pst.setString(3, admin.getPassword());
			pst.setString(4, admin.getEmail());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	public void update(Admin admin,String id) throws SQLException {
		final String UPDATE_QUERY = "UPDATE admin SET name=?, password=?, email=? WHERE id=?";
		PreparedStatement pst = null;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(UPDATE_QUERY);
			pst.setString(1, admin.getName());
			pst.setString(2, admin.getPassword());
			pst.setString(3, admin.getEmail());
			pst.setString(4, id);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int rowsUpdated = pst.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("An existing admin was updated successfully!");
		}
	}
	
	public void delete(String id) throws SQLException {
		final String DELETE_QUERY = "DELETE FROM admin WHERE id=?";
		
		PreparedStatement pst = null;
		try(Connection con=DBConnection.getConnection();) {
			pst = con.prepareStatement(DELETE_QUERY);
			pst.setString(1, id);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		int rowsDeleted = pst.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("Admin was deleted successfully!");
		}
	}
	
	public Admin getAdmin(String name, String password) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Admin admin = null;
		final String SELECT_QUERY = "select * from admin where name = ? and password = ?";
		try(Connection con = DBConnection.getConnection();) {
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, name);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()) {
				admin = new Admin();
				admin.setId(rs.getString(1));
				admin.setName(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setEmail(rs.getString(4));
				System.out.println(admin);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}
	

	 
}