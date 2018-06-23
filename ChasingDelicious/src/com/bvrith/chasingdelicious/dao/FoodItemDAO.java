package com.bvrith.chasingdelicious.dao;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bvrith.chasingdelicious.DBConnection.DBConnection;
import com.bvrith.chasingdelicious.dto.Admin;
import com.bvrith.chasingdelicious.dto.Category;
import com.bvrith.chasingdelicious.dto.FoodItem;
import com.bvrith.chasingdelicious.dto.Hotel;

public class FoodItemDAO {
	public int add(FoodItem foodItem){
		final String INSERT_QUERY="insert into foodItem(name, cost, status, pic) values(?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, foodItem.getName());
			pst.setDouble(2, foodItem.getCost());
			pst.setString(3, foodItem.getStatus());
			pst.setString(4, foodItem.getPic());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	public void update(FoodItem foodItem,String name) throws SQLException {
		final String UPDATE_QUERY = "UPDATE foodItem SET cost=?, status=?, pic=? WHERE name=?";
		PreparedStatement pst = null;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(UPDATE_QUERY);
			pst.setDouble(1, foodItem.getCost());
			pst.setString(2, foodItem.getStatus());
			pst.setString(3, foodItem.getPic());
			pst.setString(4, name);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int rowsUpdated = pst.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("An existing fooditem was updated successfully!");
		}
	}
	
	public void delete(String name) throws SQLException {
		final String DELETE_QUERY = "DELETE FROM foodItem WHERE name=?";
		
		PreparedStatement pst = null;
		try(Connection con=DBConnection.getConnection();) {
			pst = con.prepareStatement(DELETE_QUERY);
			pst.setString(1, name);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		int rowsDeleted = pst.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("Fooditem was deleted successfully!");
		}
	}
	
public FoodItem RecipeDetailsSingle(String name){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		FoodItem fi=null;
	    final String SELECT_QUERY = "select * from foodItem where recipeName = ?";
	    try(Connection con = DBConnection.getConnection();){
		
	    	pst = con.prepareStatement(SELECT_QUERY);
	    	pst.setString(1, name);
		
	    	rst = pst.executeQuery();
	    	if(rst.next()){
	    		fi =new FoodItem();
	    		fi.setCost(rst.getDouble(2));
	    		fi.setStatus(rst.getString(3));
	    		fi.setPic(rst.getString(4));
	    		
	    		System.out.println(fi);
	    	}
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    return fi;
	}
	
	public List<FoodItem> getAllRecipeDetails(){
		List<FoodItem> list=new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rst = null;
		final String SELECT_QUERY = "select * from foodItem";
		try(Connection con = DBConnection.getConnection();){
			pst = con.prepareStatement(SELECT_QUERY);
			rst = pst.executeQuery();
			while(rst.next()){
				FoodItem fi=new FoodItem();
				fi.setName(rst.getString(1));
				fi.setCost(rst.getDouble(2));
				fi.setStatus(rst.getString(3));
				fi.setPic(rst.getString(4));
	    		
				list.add(fi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<FoodItem> VEG_Details(){
		List<FoodItem> list=new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rst = null;
		final String SELECT_QUERY = "select * from foodItem where categoryId='1'";
		try(Connection con = DBConnection.getConnection();){
			pst = con.prepareStatement(SELECT_QUERY);
			rst = pst.executeQuery();
			while(rst.next()){
				FoodItem fi=new FoodItem();
				fi.setName(rst.getString(1));
				fi.setCost(rst.getDouble(2));
				fi.setStatus(rst.getString(3));
				fi.setPic(rst.getString(4));
	    		
				list.add(fi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<FoodItem> NONVEG_Details(){
		List<FoodItem> list=new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rst = null;
		final String SELECT_QUERY = "select * from foodItem where categoryId='2'";
		try(Connection con = DBConnection.getConnection();){
			pst = con.prepareStatement(SELECT_QUERY);
			rst = pst.executeQuery();
			while(rst.next()){
				FoodItem fi=new FoodItem();
				fi.setName(rst.getString(1));
				fi.setCost(rst.getDouble(2));
				fi.setStatus(rst.getString(3));
				fi.setPic(rst.getString(4));
	    		
				list.add(fi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public List<FoodItem> Both_Details(){
		List<FoodItem> list=new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rst = null;
		final String SELECT_QUERY = "select * from foodItem where categoryId=?";
		try(Connection con = DBConnection.getConnection();){
			pst = con.prepareStatement(SELECT_QUERY);
			rst = pst.executeQuery();
			while(rst.next()){
				FoodItem fi=new FoodItem();
				fi.setName(rst.getString(1));
				fi.setCost(rst.getDouble(2));
				fi.setStatus(rst.getString(3));
				fi.setPic(rst.getString(4));
	    		
				list.add(fi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}