package com.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.ecommerce.dao.AdminDao;
import com.ecommerce.model.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/adminvalidation")
public class AdminServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		String ema = req.getParameter("email");
		String pswd = req.getParameter("password");
		
		AdminDao dao = new AdminDao();
		
		Admin admin=dao.ValidateAdmin(ema, pswd);
		
		
		
		if(admin!=null)
		{
//			writer.println("Login Successfully");
			req.getRequestDispatcher("adminhome.html").forward(req, resp);
		}
		else
		{
			writer.println("Invalid Details");
		}
	}
	
}
