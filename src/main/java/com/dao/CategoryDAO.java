
package com.dao;

import com.entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hasan
 */
public class CategoryDAO {
    
    private Connection conn;
    
    public CategoryDAO(Connection conn) {
        super();
        this.conn = conn;
    }
    
    public boolean addCategory(Category category)
    
    {
       boolean f =false;
       
       try {
           
          String sql="insert into categories (category_name,description) values(?,?)" ;
          
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, category.getCategoryName());
          ps.setString(2, category.getDescription() );
          
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
    
    public List<Category> getAllCategory()
    {
        List<Category> list =new ArrayList<Category>();
        Category s =null;
        try{
            String sql ="select * from categories";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
              s=new Category();
              s.setId(rs.getInt(1));
              s.setCategoryName(rs.getString(2));
              s.setDescription(rs.getString(3));
              list.add(s);
              
            }
        }catch(Exception e){
            
        }
        return list;
        }
    
        public Category getCategoryById(int id){
          Category s=null;
        try{
            String sql ="select * from categories where category_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
              s=new Category();
              s.setId(rs.getInt(1));
              s.setCategoryName(rs.getString(2));
              s.setDescription(rs.getString(3));
    
              
            }
        }catch(Exception e){
            
        }
          
          return s;
        
        }
    public boolean updateCategory(Category category)
    
    {
       boolean f =false;
       
       try {
           
          String sql="update categories set category_name=?,description=? where category_id=?" ;
          
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, category.getCategoryName());
          ps.setString(2, category.getDescription() );
          ps.setInt(3,category.getId());
          
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
        public boolean deleteCategory(int id)
                
        {
        boolean f = false;
        try{
         String sql ="delete from categories where category_id=?";
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
         
         
       
    

