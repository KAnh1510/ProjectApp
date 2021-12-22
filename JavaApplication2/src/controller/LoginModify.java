/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Login;

/**
 *
 * @author Admin
 */
public class LoginModify {
    public static void login(Login login) {
        
        Connection conn = null;
        java.sql.PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webbanhang", "root", "");
            
            //query 
            String sql = "select * from user where email = ? and password = ? and role_id = 1" ;
            statement = conn.prepareCall(sql);
            
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                statement.setString(1, login.getEmail());
                statement.setString(2, login.getPassword());
            }
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(LoginModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoginModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoginModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
