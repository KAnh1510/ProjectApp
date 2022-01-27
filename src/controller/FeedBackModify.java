/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Feedback;

/**
 *
 * @author Admin
 */
public class FeedBackModify {
    public static List<Feedback> findAll() {
        List<Feedback> feedbackList = new ArrayList<>();
        
        Connection conn = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webbanhang", "root", "");
            
            //query
            String sql = "select * from feedback";
            statement = (Statement) conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                Feedback feedback = new Feedback(resultSet.getInt("id"),
                    resultSet.getString("fullname"),
                    resultSet.getString("email"),
                    resultSet.getString("note"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("created_at")
                );
                feedbackList.add(feedback);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeedBackModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FeedBackModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FeedBackModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return feedbackList;
    }

    public static void delete(int id) {
        Connection conn = null;
        java.sql.PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webbanhang", "root", "");
            
            //query
            String sql = "delete from feedback where id = ?";
            statement = conn.prepareCall(sql);
            statement.setInt(1, id);
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(FeedBackModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FeedBackModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FeedBackModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
}
