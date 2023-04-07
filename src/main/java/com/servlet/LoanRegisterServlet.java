package com.servlet;

import com.conn.DBConnect;
import com.dao.LoanDAO;
import com.entity.Loan;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/register")
public class LoanRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String dob = req.getParameter("dob");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phonenumber");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        double loanAmount = Double.parseDouble(req.getParameter("loanAmount"));
        int repaymentPeriod = Integer.parseInt(req.getParameter("repaymentPeriod"));

        // Check if the user is eligible for the loan
        int age = calculateAge(dob);
        if (age < 18 || loanAmount <= 15000) {
            HttpSession session = req.getSession();
            session.setAttribute("errorMsg", "You are not eligible for the loan. Please make sure you are at least 18 years old and the loan amount is not less than 15000.");
            resp.sendRedirect("add_loan.jsp");
            return;
        }

        Loan loan = new Loan(name, dob, address, phoneNumber, email, password, loanAmount, repaymentPeriod);

        LoanDAO dao = new LoanDAO(DBConnect.getConn());
        HttpSession session = req.getSession();

        boolean f = dao.addLoan(loan);

        if (f) {
            session.setAttribute("succMsg", "Loan Details submitted successfully.");
            resp.sendRedirect("add_loan.jsp");
        } else {
            session.setAttribute("errorMsg", "Something went wrong on server.");
            resp.sendRedirect("add_loan.jsp");
        }
    }

private int calculateAge(String dob) {
    int age = 0;
    try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dob);
        long currentTime = System.currentTimeMillis();
        long dobTime = date.getTime();
        long diffTime = currentTime - dobTime;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);
        age = (int) (diffDays / 365);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return age;
}
}