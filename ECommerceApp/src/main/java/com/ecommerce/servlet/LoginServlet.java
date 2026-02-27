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


@WebServlet("/loginuser")
public class LoginServlet extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
	        throws ServletException, IOException {

	    // Disable caching
	    resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	    resp.setHeader("Pragma", "no-cache");
	    resp.setDateHeader("Expires", 0);

	    String email = req.getParameter("email");
	    String password = req.getParameter("password");

	    UserDao dao = new UserDao();
	    User user = dao.validateUser(email, password);

	    if (user != null) {
	        resp.sendRedirect("UserHomeServlet");
	    } else {
	        resp.getWriter().println("Invalid login Details");
	    }
	}


}
