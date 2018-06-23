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
import com.bvrith.chasingdelicious.dto.OrderLine;
import com.bvrith.chasingdelicious.dto.FoodItem;

public class OrderLineDAO{
	
	
	public int add(OrderLine orderLine){
		final String INSERT_QUERY="insert into orderLine(qty, cost) values(?,?)";
		PreparedStatement pst = null;
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setInt(1, orderLine.getQty());
			pst.setDouble(2, orderLine.getCost());
			
			Double TotalCost = orderLine.getQty() * orderLine.getCost(); 
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	public void update(OrderLine orderline, String id) throws SQLException {
		final String UPDATE_QUERY = "UPDATE orderline SET qty=?, cost=? WHERE id=?";
		PreparedStatement pst = null;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(UPDATE_QUERY);
			pst.setInt(1, orderline.getQty());
			pst.setDouble(2, orderline.getCost());
			pst.setString(3, id);
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
		final String DELETE_QUERY = "DELETE FROM customer WHERE id=?";
		
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
	
public OrderLine OrderLineSingle(String name){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		OrderLine ol=null;
	    final String SELECT_QUERY = "select * from orderline where recipeName=?";
	    try(Connection con = DBConnection.getConnection();){
		
	    	pst = con.prepareStatement(SELECT_QUERY);
	    	pst.setString(1, name);
		
	    	rst = pst.executeQuery();
	    	if(rst.next()){
	    		ol = new OrderLine();
	    		ol.setQty(rst.getInt(1));
	    		ol.setCost(rst.getDouble(2));
	    		
	    		System.out.println(ol);
	    	}
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    return ol;
	}
	
}