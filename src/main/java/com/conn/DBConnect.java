
package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hasan
 */
public class DBConnect {
    
    private static Connection conn=null;
    public static Connection getConn(){
    
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bumblebee","root","12252875@#");
            
        
        
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
        return conn;
    
    
    }
    
    
}

