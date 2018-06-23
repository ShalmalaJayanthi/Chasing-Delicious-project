package com.bvrith.chasingdelicious.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.*;
import javax.activation.DataSource;
import javax.annotation.Resource;

import com.bvrith.chasingdelicious.DBConnection.DBConnection;
import com.bvrith.chasingdelicious.dto.Customer;
import com.bvrith.chasingdelicious.dto.Hotel;

public class HotelDAO {
	@Resource(name = "jdbc/hotelDB") 
	private DataSource ds;
	
	public void add(Hotel hotel){
		System.out.println("in add fun");
		final String INSERT_QUERY="insert into hotel(hotel_Id, hotelName, phoneNum, city, street, pincode, district, flatno, status) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, hotel.getHotelId());
			pst.setString(2, hotel.getName());
			pst.setString(4, hotel.getCity());
			pst.setInt(3, hotel.getPhone());
			pst.setString(5, hotel.getStreet());
			pst.setInt(6, hotel.getPincode());
			pst.setString(7, hotel.getDistrict());
			pst.setString(8, hotel.getFlatno());
			pst.setString(9, hotel.getStatus());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}
	public void update(Hotel hotel, String hotelId) throws SQLException {
		final String UPDATE_QUERY = "UPDATE hotel SET hotelName=?, phoneNum=?, city=?, street=?, pincode=?, district=?, flatno=?, status=? WHERE hotel_Id=?";
		PreparedStatement pst = null;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(UPDATE_QUERY);
			pst.setString(1, hotel.getHotelId());
			pst.setString(1, hotel.getName());
			pst.setString(3, hotel.getCity());
			pst.setInt(2, hotel.getPhone());
			pst.setString(4, hotel.getStreet());
			pst.setInt(5, hotel.getPincode());
			pst.setString(6, hotel.getDistrict());
			pst.setString(7, hotel.getFlatno());
			pst.setString(8, hotel.getStatus());
			pst.setString(9, hotelId);
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String hotel_Id) throws SQLException {
		final String DELETE_QUERY = "DELETE FROM hotel WHERE hotel_Id=?";
		
		PreparedStatement pst = null;
		try(Connection con=DBConnection.getConnection();) {
			pst = con.prepareStatement(DELETE_QUERY);
			pst.setString(1, hotel_Id);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Hotel getHotel(String hotelId){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Hotel htl=null;
	    final String SELECT_QUERY = "select * from hotel where hotel_Id = ?";
	    try(Connection con = DBConnection.getConnection();){
		
	    	pst = con.prepareStatement(SELECT_QUERY);
	    	pst.setString(1, hotelId);
		
	    	rst = pst.executeQuery();
	    	if(rst.next()){
	    		htl=new Hotel();
	    		htl.setHotelId(rst.getString(2));
	    		htl.setName(rst.getString(3));
	    		htl.setPhone(rst.getInt(4));
	    		htl.setCity(rst.getString(5));
	    		htl.setStreet(rst.getString(6));
	    		htl.setPincode(rst.getInt(7));
	    		htl.setDistrict(rst.getString(8));
	    		htl.setFlatno(rst.getString(9));
	    		htl.setStatus(rst.getString(10));
	    		System.out.println(htl);
	    	}
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    return htl;
	}
	
	public ArrayList<Hotel> getAllHotel(){
		ArrayList<Hotel> list=new ArrayList<>();
		PreparedStatement pst = null;
		final String SELECT_QUERY = "select * from hotel";
		ResultSet rst = executeFetchQuery(SELECT_QUERY);
		
		try{
			while(rst.next()){
				Hotel hotel=new Hotel();
				hotel.setHotelId(rst.getString(2));
	    		hotel.setName(rst.getString(3));
	    		hotel.setPhone(rst.getInt(4));
	    		hotel.setCity(rst.getString(5));
	    		hotel.setStreet(rst.getString(6));
	    		hotel.setPincode(rst.getInt(7));
	    		hotel.setDistrict(rst.getString(8));
	    		hotel.setFlatno(rst.getString(9));
	    		hotel.setStatus(rst.getString(10));
				list.add(hotel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void executeModifyQuery(String sql){
		try {
			Connection con = ((Statement) ds).getConnection();
			con.createStatement().execute(sql);
			con.close();
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	public ResultSet executeFetchQuery(String sql){
		ResultSet rs = null;
		try {
			Connection con = ((Statement) ds).getConnection();
			rs = con.createStatement().executeQuery(sql);
			con.close();
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return rs;
	}
}