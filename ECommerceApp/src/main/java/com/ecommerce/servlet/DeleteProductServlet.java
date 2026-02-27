package com.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.ecommerce.dao.AdminDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/DeleteProduct")
public class DeleteProductServlet extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		
		AdminDao dao = new AdminDao();
		boolean delete = dao.deleteProduct(id);
		
		if(delete)
		{
			resp.sendRedirect("dashboard");
		}
		else
		{
			writer.println("The Product is Not Deleted!!!!");
		}
		
		
		
	}
	
	
}
