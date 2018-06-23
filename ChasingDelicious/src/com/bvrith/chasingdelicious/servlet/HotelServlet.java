package com.bvrith.chasingdelicious.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.ejb.*;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.bvrith.chasingdelicious.dao.HotelDAO;
import com.bvrith.chasingdelicious.dto.Hotel;


@WebServlet("/HotelServlet")
public class HotelServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    
    public HotelServlet() {
        super();
        
    }
    private HotelDAO hoteldao;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I'm in hotel servelet");
		String hotel_Id = request.getParameter("id");
		String hotelName = request.getParameter("name");
		
		Integer phone = Integer.parseInt(request.getParameter("phone"));
		
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		
		Integer	pincode = Integer.parseInt(request.getParameter("pincode"));
		
		String district = request.getParameter("dist");
		String flatno = request.getParameter("flat");
		String status = request.getParameter("status");
		String operation = request.getParameter("operation");
		
		Hotel hotel = new Hotel(hotel_Id, hotelName, phone, city, street, pincode, district, flatno, status);
		PrintWriter out=response.getWriter();
		HotelDAO hoteldao = new HotelDAO();
		if(operation.equalsIgnoreCase("Add")){
			//System.out.println("I'm in ADD operation");
			hoteldao.add(hotel);
			request.getRequestDispatcher("adminHomePage.jsp").forward(request, response);
		} else if(operation.equalsIgnoreCase("Edit")) {
			try {
				hoteldao.update(hotel, hotel_Id);
				request.getRequestDispatcher("adminHomePage.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Hotel searchedHotel = hoteldao.getHotel(hotel_Id);
			request.setAttribute("hotel", searchedHotel);	
		} else if(operation.equalsIgnoreCase("Delete")){
			try {
				hoteldao.delete(hotel_Id);
				System.out.println("im in delete block");
				request.getRequestDispatcher("adminHomePage.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else { 
		out.println("I'm in hotel servelet");
		}
	//	request.getRequestDispatcher("hotelInfo.jsp").forward(request, response);
		//out.println("you have successfully registered");
	//	hoteldao.add(hotel);
	}
} 
