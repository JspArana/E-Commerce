package com.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.ecommerce.dao.BuyDao;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Buy;
import com.ecommerce.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/BuyProduct")
public class BuyProductServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			PrintWriter writer = resp.getWriter();
		
			try
			{
				Buy buy = new Buy();
				
				String phone = req.getParameter("phone");
				String email = req.getParameter("email");
				String doorno = req.getParameter("doorno");
				String street = req.getParameter("street");
				String area = req.getParameter("area");
				String landmark = req.getParameter("landmark");
				String city = req.getParameter("city");
				String pincode = req.getParameter("pincode");
				String district = req.getParameter("district");
				String state = req.getParameter("state");
				String country = req.getParameter("country");
				
				buy.setPhone(phone);
	            buy.setEmail(email);
	            buy.setDoorNo(doorno);
	            buy.setStreet(street);
	            buy.setArea(area);
	            buy.setLandmark(landmark);
	            buy.setCity(city);
	            buy.setPincode(pincode);
	            buy.setDistrict(district);
	            buy.setState(state);
	            buy.setCountry(country);
	            
	            String productId = req.getParameter("id");
	            int pid = Integer.parseInt(productId);

	            ProductDao productDao = new ProductDao();
	            Product product = productDao.getProductById(pid);

	            buy.setProduct(product);   // 🔥 VERY IMPORTANT

	            BuyDao dao = new BuyDao();
	            dao.saveBuy(buy);

	            req.setAttribute("details", List.of(buy));
	            req.getRequestDispatcher("buyer.jsp").forward(req, resp);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
	            
			}
			
	}

}
