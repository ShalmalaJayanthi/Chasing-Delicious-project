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
@WebServlet("/CustomerLogin")
public class CustomerLogin extends HttpServlet {
 private static final long serialVersionUID = 1L;
      public CustomerLogin() {
        super();
        
    }
 
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  try {
   String name= request.getParameter("custName");
   String custId = request.getParameter("custId");
   String sql = "select * from customer where custName=? and custId=?";
   String dbName = null;
   String dbId = null;
   Class.forName("com.mysql.jdbc.Driver");
   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/delicious","root","jaya");
   PreparedStatement ps = con.prepareStatement(sql);
   ps.setString(1, name);
   ps.setString(2, custId);   
   
   ResultSet rs = ps.executeQuery();
   PrintWriter out=response.getWriter();
   while(rs.next()) {
    dbName = rs.getString(1);
    dbId = rs.getString(2);
    if(name.equals(dbName) && custId.equals(dbId)){
     out.println("you have successfully Logged In");
     break;
    } 
    
    }
    
     RequestDispatcher rd = request.getRequestDispatcher("./custLogin.jsp");
     rd.include(request, response);
     out.print("Invalid Credentials");
     } catch(Exception e) {
      e.printStackTrace();
     }
 }
 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
  doGet(request, response);
 }
}
