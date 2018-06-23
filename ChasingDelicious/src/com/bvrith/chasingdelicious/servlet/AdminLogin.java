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
import javax.servlet.http.HttpSession;
import com.bvrith.chasingdelicious.dao.*;
import com.bvrith.chasingdelicious.dto.*;
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	try {
    	/*System.out.println("hhhhh");
    	PrintWriter out=response.getWriter();
		
		String name = request.getParameter("user");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		session.setAttribute("loggedUser", name);
		
		response.setContentType("text/html");
		AdminDAO admindao = new AdminDAO();
		Admin admin = null;
		try {
			 admin = admindao.getAdmin(name, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(name.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			out.println("WELCOME....");
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminHomePage.jsp");
			dispatcher.include(request, response);
		} else if(admin != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.include(request, response);
			
		} else {
			out.print("Invalid credentials");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.include(request, response);
					
		} */
    		//System.out.println("Hello");
			String name = request.getParameter("user");
			String password = request.getParameter("password");
			String sql = "select * from admin where name=? and password=?";
			String dbName = null;
			String dbPassword = null;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/delicious","root","jaya");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);			
			
			ResultSet rs = ps.executeQuery();
			
			PrintWriter out=response.getWriter();
			while(rs.next()) {
				dbName = rs.getString(2);
				dbPassword = rs.getString(3);
				if(name.equals(dbName) && password.equals(dbPassword)){
					out.println("you have successfully Logged In");
					RequestDispatcher d = request.getRequestDispatcher("adminHomePage.jsp");
					d.include(request,response);
					break;
				} 
			}
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       
	}
}
