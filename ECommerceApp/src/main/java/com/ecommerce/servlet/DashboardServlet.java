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


@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		
		ProductDao dao = new ProductDao();
		
		List<Product> products = dao.getAllProducts();
		
		req.setAttribute("products", products);
		
		req.getRequestDispatcher("admin-dashboard.jsp").forward(req, resp);
	}
	
}
