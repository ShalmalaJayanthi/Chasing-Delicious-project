	package com.bvrith.chasingdelicious.dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
	import com.bvrith.chasingdelicious.DBConnection.DBConnection;
	import com.bvrith.chasingdelicious.dto.Category;
import com.bvrith.chasingdelicious.dto.Customer;
import com.bvrith.chasingdelicious.dto.Hotel;;

	public class CategoryDAO {
		
		
		public int add(Category category){
			final String INSERT_QUERY="insert into category(id, name) values(?,?)";
			PreparedStatement pst = null;
			
			int status=0;
			
			try(Connection con=DBConnection.getConnection();) {
				pst=con.prepareStatement(INSERT_QUERY);
				pst.setString(1, category.getId());
				pst.setString(2, category.getName());
				
				status=pst.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return status;
		}
		
		public void update(Category category,String id) throws SQLException {
			final String UPDATE_QUERY = "UPDATE category SET name=? WHERE id=?";
			PreparedStatement pst = null;
			
			try(Connection con=DBConnection.getConnection();) {
				pst=con.prepareStatement(UPDATE_QUERY);
				pst.setString(1, category.getName());
				pst.setString(2, id);
				
				pst.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			int rowsUpdated = pst.executeUpdate();
			if (rowsUpdated > 0) {
			    System.out.println("An existing category was updated successfully!");
			}
		}
		
		public void delete(String id) throws SQLException {
			final String DELETE_QUERY = "DELETE FROM category WHERE id=?";
			
			PreparedStatement pst = null;
			try(Connection con=DBConnection.getConnection();) {
				pst = con.prepareStatement(DELETE_QUERY);
				pst.setString(1, id);

			} catch (SQLException e) {
				e.printStackTrace();
			}
			int rowsDeleted = pst.executeUpdate();
			if (rowsDeleted > 0) {
			    System.out.println("Category was deleted successfully!");
			}
		}
		
		public List<Category> VEG_Details(){
			List<Category> list=new ArrayList<>();
			PreparedStatement pst = null;
			ResultSet rst = null;
			final String SELECT_QUERY = "select * from category where categoryName='veg'";
			try(Connection con = DBConnection.getConnection();){
				pst = con.prepareStatement(SELECT_QUERY);
				rst = pst.executeQuery();
				while(rst.next()){
					Category category=new Category();
					category.setId(rst.getString(1));
		    		category.setName(rst.getString(2));
					list.add(category);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		
		public List<Category> NONVEG_Details(){
			List<Category> list=new ArrayList<>();
			PreparedStatement pst = null;
			ResultSet rst = null;
			final String SELECT_QUERY = "select * from category where categoryName='non_veg'";
			try(Connection con = DBConnection.getConnection();){
				pst = con.prepareStatement(SELECT_QUERY);
				rst = pst.executeQuery();
				while(rst.next()){
					Category category=new Category();
					category.setId(rst.getString(1));
		    		category.setName(rst.getString(2));
					list.add(category);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		
		public List<Category> Both_Details(){
			List<Category> list=new ArrayList<>();
			PreparedStatement pst = null;
			ResultSet rst = null;
			final String SELECT_QUERY = "select * from category where categoryName='veg' and categoryName='non_veg'";
			try(Connection con = DBConnection.getConnection();){
				pst = con.prepareStatement(SELECT_QUERY);
				rst = pst.executeQuery();
				while(rst.next()){
					Category category=new Category();
					category.setId(rst.getString(1));
		    		category.setName(rst.getString(2));
					list.add(category);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	}
