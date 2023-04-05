package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
        private Connection conn;
    
    public LoginDAO(Connection conn) {
        super();
        this.conn = conn;
    }
    public boolean validate(String email, String password) throws ClassNotFoundException {

        boolean isValid = false;

        // create a database connection
        try (
                
                PreparedStatement ps = conn
                        .prepareStatement("select * from customer where email = ? and password = ?")) {

            ps.setString(1, email);
            ps.setString(2, password);

            // execute the SQL query to retrieve user data
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // if a user with the given email and password exists, set isValid to true
                isValid = true;
            }

        } catch (SQLException e) {
            // handle any database errors
            System.err.println("Error executing SQL query: " + e.getMessage());
        }

        return isValid;
    }
}