package com.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/adminlogin")
public class AdminLoginServlet extends HttpServlet {
    
    private final String ADMIN_EMAIL = "admin@gmail.com";
    private final String ADMIN_PASSWORD = "admin";

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if(email.equals(ADMIN_EMAIL) && password.equals(ADMIN_PASSWORD)) {
            HttpSession session = request.getSession();
            session.setAttribute("adminEmail", email);
            response.sendRedirect("user.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid email or password");
            request.getRequestDispatcher("AdminLogin.jsp").forward(request, response);
        }
    }
}