
package com.servlet;

import com.conn.DBConnect;
import com.dao.CustomerDAO;
import com.entity.Customer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/register")
public class CustomerRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String name=req.getParameter("name");
        String dob=req.getParameter("dob");
        String address=req.getParameter("address");
        String phonenumber=req.getParameter("phonenumber");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        
        
        Customer customer=new Customer(name,dob,address,phonenumber,email,password);
        
        CustomerDAO dao = new CustomerDAO(DBConnect.getConn());
        HttpSession session=req.getSession();
        
        boolean f = dao.addCustomer(customer);
        
        if(f)
        {
           session.setAttribute("succMsg","Customer Details submit succesfully.");
           resp.sendRedirect("customer.jsp");
           //System.out.println("Student Details submit succesfully.");
        }else {
             session.setAttribute("errorMsg","Something wrong on server.");
             resp.sendRedirect("customer.jsp");
            //System.out.println("Something wrong on server.");
        }
    }
    
    
}
