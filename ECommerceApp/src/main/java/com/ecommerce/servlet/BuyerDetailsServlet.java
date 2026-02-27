package com.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.ecommerce.dao.BuyDao;
import com.ecommerce.model.Buy;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/BuyerDetails")
public class BuyerDetailsServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		
		BuyDao dao = new BuyDao();
		
		List<Buy> details = dao.getDetails();
		
		req.setAttribute("details", details);
		req.getRequestDispatcher("buyer.jsp").forward(req, resp);
		
	}

}
