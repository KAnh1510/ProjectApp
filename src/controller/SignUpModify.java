/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SignUp;

/**
 *
 * @author Admin
 */
public class SignUpModify {
    public static void insert(SignUp signUp) {
        
        Connection conn = null;
        java.sql.PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webbanhang", "root", "");
            
            //query
            String sql = "insert into user(fullname,email,password,role_id,created_at,updated_at) value(?,?,?,1,?,?)" ;
            statement = conn.prepareCall(sql);
            
            statement.setString(1, signUp.getFullname());
            statement.setString(2, signUp.getEmail());
            statement.setString(3, signUp.getPassword());
            statement.setString(4, signUp.getCreated_at());
            statement.setString(5, signUp.getUpdated_at());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SignUpModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SignUpModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SignUpModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
