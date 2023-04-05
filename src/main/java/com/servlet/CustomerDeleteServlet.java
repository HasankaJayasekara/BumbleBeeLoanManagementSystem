
package com.servlet;

import com.conn.DBConnect;
import com.dao.CustomerDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/delete")
public class CustomerDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int id =Integer.parseInt(req.getParameter("id"));
        
        CustomerDAO dao= new CustomerDAO(DBConnect.getConn());
        boolean f = dao.deleteCustomer(id);
        HttpSession session=req.getSession();
        
        if(f)
        {
           session.setAttribute("succMsg","Customer Details Delete succesfully.");
           resp.sendRedirect("customer.jsp");
           //System.out.println("Student Details submit succesfully.");
        }else {
             session.setAttribute("errorMsg","Something wrong on server.");
             resp.sendRedirect("customer.jsp");
            //System.out.println("Something wrong on server.");
        }
    }
}