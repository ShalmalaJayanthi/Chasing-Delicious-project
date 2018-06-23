package com.bvrith.chasingdelicious.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import com.bvrith.chasingdelicious.DBConnection.DBConnection;
import com.bvrith.chasingdelicious.dto.Customer;
import com.bvrith.chasingdelicious.dto.Hotel;
import com.bvrith.chasingdelicious.dto.OrderDetails;

public class OrderDetailsDAO{
	
	
	public int add(OrderDetails orderdetails){
		final String INSERT_QUERY="insert into orderdetails(totalcost, date, transactioinId, deliveryCharges) values(?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setDouble(1, orderdetails.getTotalcost());
			pst.setString(2, orderdetails.getDate());
			pst.setString(3, orderdetails.getTransactionId());
			pst.setDouble(4, orderdetails.getDeliveryCharges());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	public void update(OrderDetails orderdetails, String transactionId) throws SQLException {
		final String UPDATE_QUERY = "UPDATE orderdetails SET totalcost=?, date=?, deliveryCharges=? WHERE transactionId=?";
		PreparedStatement pst = null;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(UPDATE_QUERY);
			pst.setDouble(1, orderdetails.getTotalcost());
			pst.setString(2, orderdetails.getDate());
			pst.setDouble(3, orderdetails.getDeliveryCharges());
			pst.setString(4, transactionId);
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int rowsUpdated = pst.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("An existing user was updated successfully!");
		}
	}
	
	public void delete(String transactionId) throws SQLException {
		final String DELETE_QUERY = "DELETE FROM orderdetails WHERE transactionId=?";
		
		PreparedStatement pst = null;
		try(Connection con=DBConnection.getConnection();) {
			pst = con.prepareStatement(DELETE_QUERY);
			pst.setString(1, transactionId);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		int rowsDeleted = pst.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("A user was deleted successfully!");
		}
	}
	
public OrderDetails OrderDetailsSingle(String transactionId){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		OrderDetails od=null;
	    final String SELECT_QUERY = "select * from orderDetails where transactionId =?";
	    try(Connection con = DBConnection.getConnection();){
		
	    	pst = con.prepareStatement(SELECT_QUERY);
	    	pst.setString(1, transactionId);
		
	    	rst = pst.executeQuery();
	    	if(rst.next()){
	    		od=new OrderDetails();
	    		od.setTotalcost(rst.getDouble(2));
	    		od.setDate(rst.getString(3));
	    		od.setTransactionId(rst.getString(4));
	    		od.setDeliveryCharges(rst.getDouble(5));
	    		
	    		System.out.println(od);
	    	}
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    return od;
	}
	public List<OrderDetails> getAllOrderlineDetails(){
		List<OrderDetails> list=new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rst = null;
		final String SELECT_QUERY = "select * from orderline where ";
		try(Connection con = DBConnection.getConnection();){
			pst = con.prepareStatement(SELECT_QUERY);
			rst = pst.executeQuery();
			while(rst.next()){
				OrderDetails od=new OrderDetails();
				od.setTotalcost(rst.getDouble(2));
	    		od.setDate(rst.getString(3));
	    		od.setTransactionId(rst.getString(4));
	    		od.setDeliveryCharges(rst.getDouble(5));
	    		
				list.add(od);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
