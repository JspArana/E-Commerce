package com.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.ecommerce.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ResetPassword")
public class ResetPasswordServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		
		String email = req.getParameter("email");
		String newpswd = req.getParameter("newPassword");
		String cfmpswd = req.getParameter("confirmPassword");
		
		System.out.println(newpswd);
		System.out.println(cfmpswd);
		
		if(!newpswd.equals(cfmpswd) )
		{
			writer.println("Password not matched");
			return;
		}
		
		UserDao dao = new UserDao();
		dao.updateUser(email, newpswd);

			writer.println("Password Updated Successfully");

	}
	
}
