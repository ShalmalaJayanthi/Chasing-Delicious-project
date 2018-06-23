package com.bvrith.chasingdelicious.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bvrith.chasingdelicious.dao.HotelDAO;
import com.bvrith.chasingdelicious.dto.Hotel;

@WebServlet("/LoginHomepageServlet")
public class LoginHomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginHomepageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// TODO Auto-generated method stub
			
			//System.out.println("welcome");
			String operation = request.getParameter("operation");
			PrintWriter out=response.getWriter();
			HotelDAO hoteldao = new HotelDAO();
			//hoteldao.add(hotel);
			
			if(operation.equalsIgnoreCase("Add")){
				RequestDispatcher d = request.getRequestDispatcher("foodItem.jsp");
				d.forward(request,response);
			} else if(operation.equalsIgnoreCase("Edit")) {
					RequestDispatcher d = request.getRequestDispatcher("foodItem.jsp");
					d.forward(request,response);
			} else {
				RequestDispatcher d = request.getRequestDispatcher("foodItem.jsp");
				d.forward(request,response);
			}
	  	/*	System.out.println("I'm in hotel servelet");
			request.getRequestDispatcher("hotelInfo.jsp").forward(request, response); */
			} catch(Exception e) {
				e.printStackTrace();
			}    
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
