package com.bvrith.chasingdelicious.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bvrith.chasingdelicious.dao.HotelDAO;
import com.bvrith.chasingdelicious.dto.Hotel;


@WebServlet("/AdminHomepageServlet")
public class AdminHomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminHomepageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		// TODO Auto-generated method stub
		Hotel h = null;
		System.out.println("welcome");
		String operation = request.getParameter("operation");
	/*	Hotel hotel = new Hotel();
		String id = hotel.getHotelId();
		String city =hotel.getCity();
		String dist = hotel.getDistrict();
		String flat =hotel.getFlatno();
		String name = hotel.getName();
		int phone = hotel.getPhone();
		int pin=hotel.getPincode();
		String status = hotel.getStatus();
		String street=hotel.getStreet();

		hotel.setCity(city);
		hotel.setDistrict(dist);
		hotel.setFlatno(flat);
		hotel.setHotelId(id);
		hotel.setName(name);
		hotel.setPhone(phone);
		hotel.setPincode(pin);
		hotel.setStatus(status);
		hotel.setStreet(street);   */
	
		PrintWriter out=response.getWriter();
		HotelDAO hoteldao = new HotelDAO();
		//hoteldao.add(hotel);
		
		if(operation.equalsIgnoreCase("Add")){
			RequestDispatcher d = request.getRequestDispatcher("hotelRegistration.jsp");
			d.forward(request,response);
		} else if(operation.equalsIgnoreCase("Edit")) {
				RequestDispatcher d = request.getRequestDispatcher("hotelRegistration.jsp");
				d.forward(request,response);
		} else if(operation.equalsIgnoreCase("Delete")){
			RequestDispatcher d = request.getRequestDispatcher("hotelRegistration.jsp");
			d.forward(request,response);
		} else if (operation.equalsIgnoreCase("Display Single Hotel")) {
			RequestDispatcher d = request.getRequestDispatcher("hotelInfo.jsp");
			d.forward(request,response);
		} else  {
			RequestDispatcher d = request.getRequestDispatcher("displayAllHotels.jsp");
			d.forward(request,response);
		}
  	/*	System.out.println("I'm in hotel servelet");
		request.getRequestDispatcher("hotelInfo.jsp").forward(request, response); */
		} catch(Exception e) {
			e.printStackTrace();
		}    
} 
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
