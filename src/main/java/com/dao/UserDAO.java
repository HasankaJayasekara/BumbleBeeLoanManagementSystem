package com.dao;

import com.entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    
    private Connection conn;
    
    public UserDAO(Connection conn) {
        super();
        this.conn = conn;
    }
    
    public boolean addUser(User user) {
        boolean f = false;
       
        try {
           
            String sql = "INSERT INTO users (name, dob, email, password) VALUES (?, ?, ?, ?)";
          
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFullName());
            ps.setString(2,user.getDateOfBirth());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword() );
          
            int i = ps.executeUpdate();
          
            if (i == 1) {
                f = true;
            }
       
        } catch(Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    
    public List<User> getAllUser() {
        List<User> list = new ArrayList<User>();
        User u = null;
        try {
            String sql ="SELECT * FROM users";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                u = new User();
                u.setId(rs.getInt(1));
                u.setFullName(rs.getString(2));
                u.setDateOfBirth(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setPassword(rs.getString(5));
                list.add(u);
              
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public User getUserById(int id) {
        User u = null;
        try {
            String sql = "SELECT * FROM users WHERE uid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                u = new User();
                u.setId(rs.getInt(1));
                u.setFullName(rs.getString(2));
                u.setDateOfBirth(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setPassword(rs.getString(5));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
          
        return u;
    }
    
    public boolean updateUser(User user) {
        boolean f = false;
       
        try {
           
            String sql = "UPDATE users SET name=?, dob=?, email=?, password=? WHERE uid=?";
          
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFullName());
            ps.setString(2,user.getDateOfBirth());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setInt(5,user.getId());
          
            int i = ps.executeUpdate();
          
            if (i == 1) {
                f = true;
            }
       
        } catch(Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    
    public boolean deleteUser(int id) {
        boolean f = false;
        try {
            String sql = "DELETE FROM users WHERE uid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
         
            int i = ps.executeUpdate();
          
            if (i == 1) {
                f = true;
            }
       
        } catch(Exception e) {
            e.printStackTrace();
        }
        return f;
    }
        
        
      public User userLogin(String email, String password) {
		User user = null;
        try {
            String sql = "select * from users where email=? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
            	user = new User();
            	user.setId(rs.getInt("uid"));
                user.setDateOfBirth(rs.getString("dob"));
            	user.setFullName(rs.getString("fullName"));
            	user.setEmail(rs.getString("email"));
            }
        }catch(Exception e){
           e.printStackTrace();
       }
        return user;
    }
      public boolean isUserExist(String email) {
    boolean userExists = false;
    try {
        String sql = "SELECT * FROM users WHERE email = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            userExists = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return userExists;
}
}      
  

       
       
    

