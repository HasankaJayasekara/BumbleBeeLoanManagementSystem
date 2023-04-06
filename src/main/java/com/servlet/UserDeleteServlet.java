
package com.servlet;

import com.conn.DBConnect;
import com.dao.UserDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/udelete")
public class UserDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int id =Integer.parseInt(req.getParameter("id"));
        
        UserDAO dao= new UserDAO(DBConnect.getConn());
        boolean f = dao.deleteUser(id);
        HttpSession session=req.getSession();
        
        if(f)
        {
           session.setAttribute("succMsg","User Details Delete succesfully.");
           resp.sendRedirect("user.jsp");
           //System.out.println("Student Details submit succesfully.");
        }else {
             session.setAttribute("errorMsg","Something wrong on server.");
             resp.sendRedirect("user.jsp");
            //System.out.println("Something wrong on server.");
        }
    }
}