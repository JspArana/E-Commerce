package com.ecommerce.servlet;

import java.io.IOException;

import com.ecommerce.dao.CartDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addtocart")
public class AddToCartServlet extends HttpServlet {

	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        int productId = Integer.parseInt(req.getParameter("productId"));

	        CartDao dao = new CartDao();
	        dao.addToCart(productId);
	        
	        resp.sendRedirect("UserHomeServlet");

	    }
	}

