package com.bvrith.chasingdelicious.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bvrith.chasingdelicious.dao.HotelDAO;
import com.bvrith.chasingdelicious.dto.Hotel;

@WebServlet("AllHotels")
public class AllHotels extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HotelDAO hoteldao;
    public AllHotels() {
        super();
        
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	System.out.println("In all hotels");
    	ArrayList<Hotel> list = hoteldao.getAllHotel();
		request.setAttribute("list", list);
		request.getRequestDispatcher("displayAllHotels.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
