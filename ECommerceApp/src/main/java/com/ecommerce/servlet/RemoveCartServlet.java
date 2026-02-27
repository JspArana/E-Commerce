package com.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.ecommerce.dao.CartDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/removecart")
public class RemoveCartServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		
		int cartId = Integer.parseInt(req.getParameter("id"));

	    CartDao dao = new CartDao();
	    dao.deleteCart(cartId);
	    
	    writer.println("The Product is removed from your cart");
	    
	    resp.sendRedirect("cartsitems");

	}
	
}
