package com.ecommerce.servlet;

import java.io.IOException;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/BuySingle")
public class BuySingleServlet extends HttpServlet {
	
	@WebServlet("/BuyPage")
	public class BuyPageServlet extends HttpServlet {

	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        int id = Integer.parseInt(req.getParameter("id"));

	        ProductDao dao = new ProductDao();
	        Product product = dao.getProductById(id);

	        req.setAttribute("product", product);
	        req.getRequestDispatcher("buy.jsp").forward(req, resp);
	    }
	}
}
