
package com.servlet;

import com.conn.DBConnect;
import com.dao.LoanDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/delete")
public class LoanDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int id =Integer.parseInt(req.getParameter("id"));
        
        LoanDAO dao= new LoanDAO(DBConnect.getConn());
        boolean f = dao.deleteLoan(id);
        HttpSession session=req.getSession();
        
        if(f)
        {
           session.setAttribute("succMsg","Customer Details Delete succesfully.");
           resp.sendRedirect("loan.jsp");
        }else {
             session.setAttribute("errorMsg","Something wrong on server.");
             resp.sendRedirect("loan.jsp");
            //System.out.println("Something wrong on server.");
        }
    }
}