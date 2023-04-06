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

@WebServlet("/uupdate")
public class UserUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String name=req.getParameter("fullName");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        int id= Integer.parseInt(req.getParameter("id"));
        
        User user=new User(id,name,email,password);
        
        UserDAO dao = new UserDAO(DBConnect.getConn());
        HttpSession session=req.getSession();
        
        boolean f = dao.updateUser(user);
        
        if(f)
        {
           session.setAttribute("succMsg","User Details Updated succesfully.");
           resp.sendRedirect("user.jsp");
           //System.out.println("Student Details submit succesfully.");
        }else {
             session.setAttribute("errorMsg","Something wrong on server.");
             resp.sendRedirect("user.jsp");
            //System.out.println("Something wrong on server.");
        }
    }
    
    
}

