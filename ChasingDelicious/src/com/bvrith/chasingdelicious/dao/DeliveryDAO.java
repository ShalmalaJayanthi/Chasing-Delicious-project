package com.bvrith.chasingdelicious.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bvrith.chasingdelicious.DBConnection.DBConnection;
import com.bvrith.chasingdelicious.dto.Admin;
import com.bvrith.chasingdelicious.dto.Delivery;
import com.bvrith.chasingdelicious.dto.Hotel;
import com.bvrith.chasingdelicious.dto.OrderDetails;

public class DeliveryDAO {
	public int add(Delivery delivery){
		final String INSERT_QUERY="insert into delivery(totalAmount, date, status, deliveryId;) values(?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setDouble(1, delivery.getTotalAmount());
			pst.setString(2, delivery.getDate());
			pst.setString(3, delivery.getStatus());
			pst.setString(4, delivery.getDeliveryId());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	public void update(Delivery delivery,String deliveryId) throws SQLException {
		final String UPDATE_QUERY = "UPDATE delivery SET totalAmount=?, date=?, status=? WHERE transactionId=?";
		PreparedStatement pst = null;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(UPDATE_QUERY);
			pst.setDouble(1, delivery.getTotalAmount());
			pst.setString(2, delivery.getDate());
			pst.setString(3, delivery.getStatus());
			pst.setString(4, deliveryId);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int rowsUpdated = pst.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("An existing delivery was updated successfully!");
		}
	}
	
	public void delete(String deliveryId) throws SQLException {
		final String DELETE_QUERY = "DELETE FROM delivery WHERE deliveryId=?";
		
		PreparedStatement pst = null;
		try(Connection con=DBConnection.getConnection();) {
			pst = con.prepareStatement(DELETE_QUERY);
			pst.setString(1, deliveryId);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		int rowsDeleted = pst.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("delivery was deleted successfully!");
		}
	}
	
public Delivery DeliveryDetailsSingle(String deliveryId){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Delivery d=null;
		OrderDetails od = null;
	    final String SELECT_QUERY = "select * from delivery where deliveryId = ?";
	    try(Connection con = DBConnection.getConnection();){
		
	    	pst = con.prepareStatement(SELECT_QUERY);
	    	pst.setString(1, deliveryId);
	    	OrderDetailsDAO dao = new OrderDetailsDAO();
	    	rst = pst.executeQuery();
	    	if(rst.next()){
	    		od = new OrderDetails();
	    		d=new Delivery();
	    		d.setTotalAmount(rst.getDouble(1));
	    		d.setDate(rst.getString(2));
	    		d.setStatus(rst.getString(3));
	    		d.setDeliveryId(rst.getString(4));
	    		
	    	}
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    return d;
	}
}
