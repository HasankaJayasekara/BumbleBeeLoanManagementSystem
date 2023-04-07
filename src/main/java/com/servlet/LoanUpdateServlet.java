
package com.servlet;

import com.conn.DBConnect;
import com.dao.LoanDAO;
import com.entity.Loan;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/update")
public class LoanUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String name=req.getParameter("name");
        String dob=req.getParameter("dob");
        String address=req.getParameter("address");
        String phonenumber=req.getParameter("phonenumber");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        double loanAmount = Double.parseDouble(req.getParameter("loanAmount"));
        int repaymentPeriod = Integer.parseInt(req.getParameter("repaymentPeriod"));
        int id= Integer.parseInt(req.getParameter("id"));
        
        Loan loan=new Loan(id,name,dob,address,phonenumber,email,password,loanAmount,repaymentPeriod);
        
        LoanDAO dao = new LoanDAO(DBConnect.getConn());
        HttpSession session=req.getSession();
        
        boolean f = dao.updateLoan(loan);
        
        if(f)
        {
           session.setAttribute("succMsg","Loan Details Updated succesfully.");
           resp.sendRedirect("loan.jsp");
           //System.out.println("Student Details submit succesfully.");
        }else {
             session.setAttribute("errorMsg","Something wrong on server.");
             resp.sendRedirect("loan.jsp");
            //System.out.println("Something wrong on server.");
        }
    }
    
    
}

