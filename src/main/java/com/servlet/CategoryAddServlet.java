
package com.servlet;

import com.conn.DBConnect;
import com.dao.CategoryDAO;
import com.entity.Category;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/categoryregister")
public class CategoryAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String name=req.getParameter("name");
        String description=req.getParameter("description");
      
        
        
        Category category=new Category (name,description);
        
        CategoryDAO dao = new CategoryDAO(DBConnect.getConn());
        HttpSession session=req.getSession();
        
        boolean f = dao.addCategory(category);
        
        if(f)
        {
           session.setAttribute("succMsg","Category Details submit succesfully.");
           resp.sendRedirect("category.jsp");
           //System.out.println("Student Details submit succesfully.");
        }else {
             session.setAttribute("errorMsg","Something wrong on server.");
             resp.sendRedirect("category.jsp");
            //System.out.println("Something wrong on server.");
        }
    }
    
    
}
