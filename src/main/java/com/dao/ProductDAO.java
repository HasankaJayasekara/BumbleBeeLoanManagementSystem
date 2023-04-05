package com.dao;

import java.sql.*;
import java.util.*;

import com.entity.Cart;

import com.entity.Product;

public class ProductDAO {
	private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;
    

	public ProductDAO(Connection conn) {
		super();
		this.conn = conn;
	}
        public boolean addProduct(Product product) {
            try {
                String sql = "INSERT INTO products (name, category, price, image) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ps.setString(1, product.getName());
                ps.setString(2, product.getCategory());
                ps.setDouble(3, product.getPrice());
                ps.setString(4, product.getImage());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                return false;
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (pst != null) {
                        pst.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        }
    
	
	public List<Product> getAllProducts() {
        List<Product> book = new ArrayList<>();
        try {

            String sql = "select * from products";
            pst = this.conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
            	Product row = new Product();
                row.setId(rs.getInt("id"));
                row.setName(rs.getString("name"));
                row.setCategory(rs.getString("category"));
                row.setPrice(rs.getDouble("price"));
                row.setImage(rs.getString("image"));

                book.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }
	
	
	 public Product getSingleProduct(int id) {
		 Product row = null;
	        try {
	            String sql = "select * from products where id=? ";

	            pst = this.conn.prepareStatement(sql);
	            pst.setInt(1, id);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) {
	            	row = new Product();
	                row.setId(rs.getInt("id"));
	                row.setName(rs.getString("name"));
	                row.setCategory(rs.getString("category"));
	                row.setPrice(rs.getDouble("price"));
	                row.setImage(rs.getString("image"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }

	        return row;
	    }
	
	public double getTotalCartPrice(ArrayList<Cart> cartList) {
        double sum = 0;
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    String sql = "select price from products where id=?";
                    pst = this.conn.prepareStatement(sql);
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        sum+=rs.getDouble("price")*item.getQuantity();
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sum;
    }

    
    public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
        List<Cart> book = new ArrayList<>();
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    String sql = "select * from products where id=?";
                    pst = this.conn.prepareStatement(sql);
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setId(rs.getInt("id"));
                        row.setName(rs.getString("name"));
                        row.setCategory(rs.getString("category"));
                        row.setPrice(rs.getDouble("price")*item.getQuantity());
                        row.setQuantity(item.getQuantity());
                        book.add(row);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }
            public boolean deleteProduct(int id)
                
        {
        boolean f = false;
        try{
         String sql ="delete from products where id=?";
         PreparedStatement ps=conn.prepareStatement(sql);
         ps.setInt(1, id);
         
         int i=ps.executeUpdate();
          
          if(i==1)
          {
             f=true;
          
          }
       
       }catch(Exception e){
           e.printStackTrace();
       }
    return f;
    }
}

