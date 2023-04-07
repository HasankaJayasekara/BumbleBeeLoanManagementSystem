package com.servlet;

import com.conn.DBConnect;
import com.dao.CategoryDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cdelete")
public class CategoryDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int id =Integer.parseInt(req.getParameter("id"));
        
        CategoryDAO dao= new CategoryDAO(DBConnect.getConn());
        boolean f = dao.deleteCategory(id);
        HttpSession session=req.getSession();
        
        if(f)
        {
           session.setAttribute("succMsg","Category Details Delete succesfully.");
           resp.sendRedirect("category.jsp");
        }else {
             session.setAttribute("errorMsg","Something wrong on server.");
             resp.sendRedirect("category.jsp");
            //System.out.println("Something wrong on server.");
        }
    }
}