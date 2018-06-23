package com.bvrith.chasingdelicious.servlet;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bvrith.chasingdelicious.dao.AdminDAO;
import com.bvrith.chasingdelicious.dao.CustomerDAO;
import com.bvrith.chasingdelicious.dto.*;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			
			String Name= request.getParameter("custName");
			String Id = request.getParameter("custId");
			Integer phoneNo = Integer.parseInt(request.getParameter("phoneNum"));
			String location = request.getParameter("location");
			String gender = request.getParameter("gender");
			String gmail = request.getParameter("gmail");
			String operation = request.getParameter("operation");
		
		/*	String sql = "insert into admin(Id, Name, password, email) values(?,?,?,?)";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/delicious","root","jaya");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, password);
			ps.setString(4, email);
			ps.executeUpdate(); */
			Customer customer= new Customer(Name, Id, phoneNo, location, gender, gmail);

			
			
			PrintWriter out = response.getWriter();
			CustomerDAO customerdao = new CustomerDAO();
			if(operation.equalsIgnoreCase("Add")){
				System.out.println("I'm in ADD operation");
				customerdao.add(customer);
			} else if(operation.equalsIgnoreCase("Edit")) {
				try {
					customerdao.update(customer, Id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Customer searchedHotel = customerdao.getCustomer(Id);
				request.setAttribute("customer", searchedHotel);	
			} else if(operation.equalsIgnoreCase("Delete")){
				try {
				customerdao.delete(Id);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else { 
			System.out.println("I'm in customer servelet");
	//		customerdao.add(customer);
			}
			
			out.println("you have successfully registered");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}