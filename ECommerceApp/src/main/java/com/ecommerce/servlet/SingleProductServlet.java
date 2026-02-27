package com.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/SingleProduct")
public class SingleProductServlet extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		ProductDao dao = new ProductDao();
		
		Product pid = dao.getProductById(id);

		
		if(pid != null)
		{
		    req.setAttribute("product", pid);   
		    req.getRequestDispatcher("singleproduct.jsp").forward(req, resp);
		}
		else
		{
		    writer.println("Product not Found!!!!");
		}
	}
	
	
	
	
}
