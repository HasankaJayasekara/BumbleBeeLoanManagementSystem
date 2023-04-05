package com.servlet;
import com.conn.DBConnect;
import com.dao.LoginDAO;
import com.entity.Login;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        LoginDAO dao = new LoginDAO(DBConnect.getConn());
        boolean isAdmin = "admin@gmail.com".equals(email) && "admin".equals(password);

        if (isAdmin) {
            // If the user is an admin, redirect to customer.jsp
            response.sendRedirect(request.getContextPath() + "/customer.jsp");
        } else {
            try {
                // If the user is not an admin, check their credentials and redirect to buy.jsp if they're valid
                Login login = new Login(email, password);
                boolean isValid = dao.validate(email, password);
                
                if (isValid) {
                    response.sendRedirect(request.getContextPath() + "/add_customer.jsp");
                } else {
                    // If the user's credentials are invalid, redirect back to the login page with an error message
                    request.setAttribute("error", "Invalid email or password");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}