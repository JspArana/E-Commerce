package com.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.ecommerce.dao.UserDao;
import com.ecommerce.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ForgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		
		String email = req.getParameter("email");
		
		UserDao dao = new UserDao();
		
		User user = dao.ForgotUser(email);
		
		if(user != null)
		{
			req.setAttribute("email", email);
			req.getRequestDispatcher("resetPassword.jsp").forward(req, resp);
		}
		else
		{
			writer.println("Email Not Found!!!");
			writer.println("Please Register");
		}
	}
	
}
