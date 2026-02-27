package com.ecommerce.servlet;

import java.io.IOException;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Create Product object
            Product product = new Product();
            product.setName(request.getParameter("name"));
            product.setPrice(Double.parseDouble(request.getParameter("price")));
            String imageName = request.getParameter("image");
            product.setImage("images/" + imageName);
            product.setDescription(request.getParameter("description"));

            // Save product
            ProductDao dao = new ProductDao();
            dao.saveProduct(product);

            // Redirect to dashboard or product list page
            response.sendRedirect("dashboard");

        } catch (Exception e) {
            e.printStackTrace();
            // Forward to add-product page with error message
            request.setAttribute("errorMessage", "Failed to add product. Please try again.");
            request.getRequestDispatcher("add-product.jsp").forward(request, response);
        }
    }
}
