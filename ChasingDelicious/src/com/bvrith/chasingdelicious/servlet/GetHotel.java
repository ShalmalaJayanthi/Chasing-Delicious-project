package com.bvrith.chasingdelicious.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bvrith.chasingdelicious.dao.HotelDAO;
import com.bvrith.chasingdelicious.dto.Hotel;


@WebServlet("/GetHotel")
public class GetHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB private HotelDAO hoteldao;
    public GetHotel() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	try {
    	System.out.println("In hotels info");
    	PrintWriter out=response.getWriter();
    	String id = request.getParameter("hotel_Id");
    	String operation = request.getParameter("operation");
		Hotel hotel = hoteldao.getHotel(id);
		request.setAttribute("hotel", hotel);
		if(operation.equalsIgnoreCase("Add")){
			System.out.println("I'm in ADD operation");
			hoteldao.add(hotel);
		} else if(operation.equalsIgnoreCase("Edit")) {
			try {
				hoteldao.update(hotel, id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Hotel searchedHotel = hoteldao.getHotel(id);
			request.setAttribute("hotel", searchedHotel);	
		} else if(operation.equalsIgnoreCase("Delete")){
			try {
				hoteldao.delete(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else { 
		out.println("I'm in GetHotel servelet");
		}
		
		request.getRequestDispatcher("hotelInfo.jsp").forward(request, response);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
