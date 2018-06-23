package com.bvrith.chasingdelicious.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HotelLogin")
public class HotelLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HotelLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String hotelName = request.getParameter("user");
			String hotelId = request.getParameter("hotelId");
			String sql = "select * from hotel where hotelName=? and hotel_Id=?";
			String dbName = null;
			String dbId = null;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/delicious","root","jaya");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hotelName);
			ps.setString(2, hotelId);			
			
			ResultSet rs = ps.executeQuery();
			PrintWriter out=response.getWriter();
			while(rs.next()) {
				dbName = rs.getString(3);
				dbId = rs.getString(2);
				if(hotelName.equals(dbName) && hotelId.equals(dbId)){
					out.println("you have successfully Logged In");
					RequestDispatcher d = request.getRequestDispatcher("loginHomepage.jsp");
					d.forward(request,response);
					break;
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("./hotelLogin.jsp");
					rd.include(request, response);
					out.print("Invalid Credentials");
				}
			}
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
