/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Role;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class RoleModify {
   public static List<Role> findAll() {
        List<Role> RoleList = new ArrayList<>();
        
        Connection conn = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webbanhang", "root", "");
            
            //query
            String sql = "select * from role";
            statement = (Statement) conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                Role role = new Role( resultSet.getInt("id"),
                    resultSet.getString("name"));
                RoleList.add(role);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RoleModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RoleModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return RoleList;
    }
}
