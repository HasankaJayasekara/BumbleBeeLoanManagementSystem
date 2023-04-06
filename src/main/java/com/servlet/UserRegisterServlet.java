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
        
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(password);
        
        UserDAO dao = new UserDAO(DBConnect.getConn());
        HttpSession session = req.getSession();
        
        boolean f = dao.addUser(user);
        
        if(f)
        {
            session.setAttribute("succMsg","User Details submitted successfully.");
            resp.sendRedirect("user.jsp");
        } 
        else 
        {
            session.setAttribute("errorMsg","Something went wrong on the server.");
            resp.sendRedirect("user.jsp");
        }
    }
}