package com.bvrith.chasingdelicious.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bvrith.chasingdelicious.DBConnection.DBConnection;
import com.bvrith.chasingdelicious.dto.Customer;
import com.bvrith.chasingdelicious.dto.Hotel;

public class CustomerDAO {
	
	
	public int add(Customer customer) throws SQLException{
		final String INSERT_QUERY="insert into customer(custName, custId, phoneNo, location, gender, gmail) values(?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, customer.getName());
			pst.setString(2, customer.getId());
			pst.setInt(3, customer.getPhone());
			pst.setString(4, customer.getLocation());
			pst.setString(5, customer.getGender());
			pst.setString(6, customer.getGmail());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int rowsUpdated = pst.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("Customer is added successfully!");
		}
		return status;
	}
	
	public void update(Customer customer,String id) throws SQLException {
		final String UPDATE_QUERY = "UPDATE customer SET custName=?, phoneNo=?, location=?, gender=?, gmail=? WHERE custId=?";
		PreparedStatement pst = null;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(UPDATE_QUERY);
			pst.setString(1, customer.getName());
			pst.setInt(2, customer.getPhone());
			pst.setString(3, customer.getLocation());
			pst.setString(4, customer.getGender());
			pst.setString(5, customer.getGmail());
			pst.setString(6, id);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int rowsUpdated = pst.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("An existing user was updated successfully!");
		}
	}
	
	public void delete(String id) throws SQLException {
		final String DELETE_QUERY = "DELETE FROM customer WHERE custId=?";
		
		PreparedStatement pst = null;
		try(Connection con=DBConnection.getConnection();) {
			pst = con.prepareStatement(DELETE_QUERY);
			pst.setString(1, id);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		int rowsDeleted = pst.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("A user was deleted successfully!");
		}
	}
	
public Customer getCustomer(String Id){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Customer htl=null;
	    final String SELECT_QUERY = "select * from customer where custId = ?";
	    try(Connection con = DBConnection.getConnection();){
		
	    	pst = con.prepareStatement(SELECT_QUERY);
	    	pst.setString(1, Id);
		
	    	rst = pst.executeQuery();
	    	if(rst.next()){
	    		htl=new Customer();
	    		htl.setName(rst.getString(1));
	    		htl.setId(rst.getString(2));
	    		htl.setPhoneNo(rst.getInt(3));
	    		htl.setGender(rst.getString(4));
	    		htl.setGmail(rst.getString(5));
	    		
	    		System.out.println(htl);
	    	}
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    return htl;
	}
}