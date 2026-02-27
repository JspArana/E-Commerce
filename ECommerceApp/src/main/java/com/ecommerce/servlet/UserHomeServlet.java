package com.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/UserHomeServlet")
public class UserHomeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		resp.setHeader("Pragma", "no-cache");
		resp.setDateHeader("Expires", 0);

		
		PrintWriter writer = resp.getWriter();
		
		ProductDao dao = new ProductDao();
		
		List<Product> product = dao.getAllProducts();
		req.setAttribute("Product", product);
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
}
