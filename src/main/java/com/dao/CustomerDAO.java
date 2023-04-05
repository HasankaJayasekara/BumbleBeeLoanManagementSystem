
package com.dao;

import com.entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hasan
 */
public class CustomerDAO {
    
    private Connection conn;
    
    public CustomerDAO(Connection conn) {
        super();
        this.conn = conn;
    }
    
    public boolean addCustomer(Customer customer)
    
    {
       boolean f =false;
       
       try {
           
          String sql="insert into customer(name,dob,address,phonenumber,email,password) values(?,?,?,?,?,?)" ;
          
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, customer.getFullName());
          ps.setString(2, customer.getDob() );
          ps.setString(3, customer.getAddress());
          ps.setString(4, customer.getPhonenumber() );
          ps.setString(5, customer.getEmail());
          ps.setString(6, customer.getPassword() );
          
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
    
    public List<Customer> getAllCustomer()
    {
        List<Customer> list =new ArrayList<Customer>();
        Customer s =null;
        try{
            String sql ="select * from customer";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
              s=new Customer();
              s.setId(rs.getInt(1));
              s.setFullName(rs.getString(2));
              s.setDob(rs.getString(3));
              s.setAddress(rs.getString(4));
              s.setPhonenumber(rs.getString(5));
              s.setEmail(rs.getString(6));
              s.setPassword(rs.getString(7));
              list.add(s);
              
            }
        }catch(Exception e){
            
        }
        return list;
        }
    
        public Customer getCustomerById(int id){
          Customer s=null;
        try{
            String sql ="select * from customer where cid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
              s=new Customer();
              s.setId(rs.getInt(1));
              s.setFullName(rs.getString(2));
              s.setDob(rs.getString(3));
              s.setAddress(rs.getString(4));
              s.setPhonenumber(rs.getString(5));
              s.setEmail(rs.getString(6));
              s.setPassword(rs.getString(7));
              
    
              
            }
        }catch(Exception e){
            
        }
          
          return s;
        
        }
    public boolean updateCustomer(Customer customer)
    
    {
       boolean f =false;
       
       try {
           
          String sql="update customer set name=?,dob=?,address=?,phonenumber=?,email=?,password=? where cid=?" ;
          
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, customer.getFullName());
          ps.setString(2, customer.getDob() );
          ps.setString(3, customer.getAddress());
          ps.setString(4, customer.getPhonenumber() );
          ps.setString(5, customer.getEmail());
          ps.setString(6, customer.getPassword());
          ps.setInt(7,customer.getId());
          
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
        public boolean deleteCustomer(int id)
                
        {
        boolean f = false;
        try{
         String sql ="delete from customer where cid=?";
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
         
         
       
    

