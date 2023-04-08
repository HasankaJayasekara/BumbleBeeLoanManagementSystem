package com.servlet;

import com.conn.DBConnect;
import com.dao.ProductDAO;
import com.entity.Product;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/pupdate")
public class ProductUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String name=req.getParameter("name");
        String category=req.getParameter("category");
        double price=Double.parseDouble(req.getParameter("price"));
        String image=req.getParameter("image");
        int id= Integer.parseInt(req.getParameter("id"));
        
        Product product = new Product(id ,name,category,price, image);
        
        ProductDAO dao = new ProductDAO(DBConnect.getConn());
        HttpSession session=req.getSession();
        
        boolean f = dao.updateProduct(product);
        
        if(f)
        {
           session.setAttribute("succMsg","Product Details Updated succesfully.");
           resp.sendRedirect("product.jsp");
           //System.out.println("Student Details submit succesfully.");
        }else {
             session.setAttribute("errorMsg","Something wrong on server.");
             resp.sendRedirect("product.jsp");
            //System.out.println("Something wrong on server.");
        }
    }
    
    
}

