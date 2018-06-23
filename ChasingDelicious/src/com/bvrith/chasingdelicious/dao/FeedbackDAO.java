package com.bvrith.chasingdelicious.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bvrith.chasingdelicious.DBConnection.DBConnection;
import com.bvrith.chasingdelicious.dto.Customer;
import com.bvrith.chasingdelicious.dto.Feedback;
import com.bvrith.chasingdelicious.dto.Hotel;
import com.bvrith.chasingdelicious.dto.Delivery;
public class FeedbackDAO{
	
	
	public int add(Feedback feedback){
		final String INSERT_QUERY="insert into feedback(feedback) values(?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, feedback.getFeedback());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public void update(Feedback feedBack, String deliveryId) throws SQLException {
		final String UPDATE_QUERY = "UPDATE feedback SET feedback=? WHERE deliveryId = ?";
		PreparedStatement pst = null;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(UPDATE_QUERY);
			pst.setString(1, feedBack.getFeedback());
			pst.setString(2, deliveryId);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int rowsUpdated = pst.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("An existing user was updated successfully!");
		}
	}
	
	public void delete(String deliveryId) throws SQLException {
		final String DELETE_QUERY = "DELETE FROM customer WHERE deliveryId=?";
		
		PreparedStatement pst = null;
		try(Connection con=DBConnection.getConnection();) {
			pst = con.prepareStatement(DELETE_QUERY);
			pst.setString(1, deliveryId);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		int rowsDeleted = pst.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("A user was deleted successfully!");
		}
	}
	
public Feedback FeedbackSingle(String transactionId){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Feedback fb=null;
	    final String SELECT_QUERY = "select * from feedback where transactionId = ?";
	    try(Connection con = DBConnection.getConnection();){
		
	    	pst = con.prepareStatement(SELECT_QUERY);
	    	pst.setString(1, transactionId);
		
	    	rst = pst.executeQuery();
	    	if(rst.next()){
	    		fb=new Feedback();
	    		fb.setFeedback(rst.getString(2));
	    		
	    		System.out.println(fb);
	    	}
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    return fb;
	}
	
	public List<Feedback> getAllHotelDetails(){
		List<Feedback> list=new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rst = null;
		final String SELECT_QUERY = "select * from feedback";
		try(Connection con = DBConnection.getConnection();){
			pst = con.prepareStatement(SELECT_QUERY);
			rst = pst.executeQuery();
			
			while(rst.next()){
				Feedback fb = new Feedback();
	    		fb.setFeedback(rst.getString(2));
				list.add(fb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}