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

@WebServlet("/pregister")
public class ProductAddServlet extends HttpServlet {

    @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
        String name=req.getParameter("name");
        String category=req.getParameter("category");
        double price=Double.parseDouble(req.getParameter("price"));
        String image=req.getParameter("image");
        
        Product product = new Product( name,category,price, image);
        
        ProductDAO dao = new ProductDAO(DBConnect.getConn());
        HttpSession session=req.getSession();
        
        boolean f = dao.addProduct(product);
        
        if(f)
        {
           session.setAttribute("succMsg","Product Details add successfully.");
           resp.sendRedirect("product.jsp");
        }else {
             session.setAttribute("errorMsg","Something went wrong on the server.");
             resp.sendRedirect("product.jsp");
        }
    } 
}