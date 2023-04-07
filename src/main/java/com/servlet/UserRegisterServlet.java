package com.servlet;

import com.conn.DBConnect;
import com.dao.UserDAO;
import com.entity.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/uregister")
public class UserRegisterServlet extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // Get input parameters from form
        String fullName = req.getParameter("fullName");
        String dateOfBirth = req.getParameter("dateOfBirth");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Check if any input parameter is null or empty
        if(fullName == null || fullName.isEmpty() || dateOfBirth == null || dateOfBirth.isEmpty() || email == null || email.isEmpty() || password == null || password.isEmpty()) {
            HttpSession session = req.getSession();
            session.setAttribute("errorMsg", "All fields are required.");
            session.removeAttribute("succMsg");
            resp.sendRedirect("UserRegistation.jsp");
            return;
        }

        // Check if user already exists with same email
        UserDAO dao = new UserDAO(DBConnect.getConn());
        if (dao.isUserExist(email)) {
            HttpSession session = req.getSession();
            session.setAttribute("errorMsg", "This email address is already registered.");
            session.removeAttribute("succMsg");
            resp.sendRedirect("UserRegistation.jsp");
            return;
        }

        // Create user object and set the input parameters
        User user = new User();
        user.setFullName(fullName);
        user.setDateOfBirth(dateOfBirth);
        user.setEmail(email);
        user.setPassword(password);

        // Add user to database
        boolean f = dao.addUser(user);

        // Redirect user to appropriate page based on success or failure
        if(f) {
            HttpSession session = req.getSession();
            session.setAttribute("succMsg", "User Details submitted successfully.");
             session.removeAttribute("errorMsg");
            resp.sendRedirect("UserRegistation.jsp");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("errorMsg", "Something went wrong on the server.");
             session.removeAttribute("succMsg");
            resp.sendRedirect("UserRegistation.jsp");
        }
   }
}