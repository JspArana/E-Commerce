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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
    	PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDao dao = new UserDao();

        // ✅ Check if email already exists
        if (dao.isEmailExists(email)) {

            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>User Exists</title>");
            writer.println("<style>");
            writer.println("body { font-family: Arial; text-align: center; margin-top: 100px; }");
            writer.println(".msg { color: red; font-size: 20px; margin-bottom: 20px; }");
            writer.println(".btn { padding: 10px 20px; background-color: #4CAF50; color: white; border: none; cursor: pointer; font-size: 16px; }");
            writer.println(".btn:hover { background-color: #45a049; }");
            writer.println("</style>");
            writer.println("</head>");
            writer.println("<body>");

            writer.println("<div class='msg'>User Already Exists! Please Login using your details.</div>");

            writer.println("<form action='login.html' method='get'>");
            writer.println("<button class='btn' type='submit'>Go to Login</button>");
            writer.println("</form>");

            writer.println("</body>");
            writer.println("</html>");

            return;
        }

        // ✅ Save new user
        User user = new User(name, email, password, "Customer");

        boolean status = dao.saveUser(user);

        if (status) {

            req.setAttribute("successMessage", "Registration Successful! Please Login.");
            req.getRequestDispatcher("login.html")
               .forward(req, resp);

        } else {

            req.setAttribute("errorMessage", "Registration Failed! Try Again.");
            req.getRequestDispatcher("register.html")
               .forward(req, resp);
        }
    }
}