
package com.dao;

import com.entity.Loan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class LoanDAO {
    
    private Connection conn;
    
    public LoanDAO(Connection conn) {
        super();
        this.conn = conn;
    }
    
    public boolean addLoan(Loan loan)
    
    {
       boolean f =false;
       
       try {
           
            String sql="insert into loan (name,dob,address,phonenumber,email,password,loan_amount,repayment_period) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, loan.getFullName());
            ps.setString(2, loan.getDob() );
            ps.setString(3, loan.getAddress());
            ps.setString(4, loan.getPhonenumber() );
            ps.setString(5, loan.getEmail());
            ps.setString(6, loan.getPassword() );
            ps.setDouble(7, loan.getLoanAmount());
            ps.setInt(8, loan.getRepaymentPeriod());
          
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
    
    public List<Loan> getAllLoan()
    {
        List<Loan> list =new ArrayList<Loan>();
        Loan s =null;
        try{
            String sql ="select * from loan";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
              s=new Loan();
              s.setId(rs.getInt(1));
              s.setFullName(rs.getString(2));
              s.setDob(rs.getString(3));
              s.setAddress(rs.getString(4));
              s.setPhonenumber(rs.getString(5));
              s.setEmail(rs.getString(6));
              s.setPassword(rs.getString(7));
              s.setEmail(rs.getString(6));
              s.setPassword(rs.getString(7));
              s.setLoanAmount(rs.getDouble(8));
              s.setRepaymentPeriod(rs.getInt(9));
              list.add(s);
              
            }
        }catch(Exception e){
            
        }
        return list;
        }
    
        public Loan getLoanById(int id){
          Loan s=null;
        try{
            String sql ="select * from loan where cid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
              s=new Loan();
              s.setId(rs.getInt(1));
              s.setFullName(rs.getString(2));
              s.setDob(rs.getString(3));
              s.setAddress(rs.getString(4));
              s.setPhonenumber(rs.getString(5));
              s.setEmail(rs.getString(6));
              s.setPassword(rs.getString(7));
              s.setEmail(rs.getString(6));
              s.setPassword(rs.getString(7));
              s.setLoanAmount(rs.getDouble(8));
              s.setRepaymentPeriod(rs.getInt(9));
              
    
              
            }
        }catch(Exception e){
            
        }
          
          return s;
        
        }
    public boolean updateLoan(Loan loan)
    
    {
       boolean f =false;
       
       try {
           
          String sql="update loan set name=?,dob=?,address=?,phonenumber=?,email=?,password=?,loan_amount=?,repayment_period=? where cid=?" ;
          
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, loan.getFullName());
          ps.setString(2, loan.getDob() );
          ps.setString(3, loan.getAddress());
          ps.setString(4, loan.getPhonenumber() );
          ps.setString(5, loan.getEmail());
          ps.setString(6, loan.getPassword());
          ps.setDouble(7, loan.getLoanAmount());
          ps.setInt(8,loan.getRepaymentPeriod());
          ps.setInt(9,loan.getId());
          
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
        public boolean deleteLoan(int id)
                
        {
        boolean f = false;
        try{
         String sql ="delete from loan where cid=?";
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
         
         
       
    

