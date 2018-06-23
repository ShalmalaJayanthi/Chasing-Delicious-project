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
import com.bvrith.chasingdelicious.dto.*;

@WebServlet("/AdminServelet")
public class AdminServelet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			PrintWriter out=response.getWriter();
			String id = request.getParameter("id");
			String name = request.getParameter("user");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
		/*	String sql = "insert into admin(Id, Name, password, email) values(?,?,?,?)";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/delicious","root","jaya");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, password);
			ps.setString(4, email);
			ps.executeUpdate(); */
			Admin admin = new Admin(id, name, password, email);
			AdminDAO admindao = new AdminDAO();
			admindao.add(admin);
			
			out.println("you have successfully registered");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}