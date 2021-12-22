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
import model.Order;

/**
 *
 * @author Admin
 */
public class OrderModify {
    public static List<Order> findAll() {
        List<Order> orderList = new ArrayList<>();
        
        Connection conn = null;
        Statement statement = null;
        
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webbanhang", "root", "");
            
            //query
            String sql = "select orders.*, user.fullname userFullname from orders join user on user.id = orders.user_id";
            statement = (Statement) conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                Order order = new Order( resultSet.getInt("orders.id"),
                    resultSet.getInt("orders.user_id"),  
                    resultSet.getString("userFullname"),
                    resultSet.getString("email"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("address"),
                    resultSet.getString("note"),
                    resultSet.getString("total"),
                    resultSet.getString("create_time")
                );
                orderList.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return orderList;
    }
    public static void update(Order order) {
        Connection conn = null;
        java.sql.PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webbanhang", "root", "");
            
            //query
            String sql = "update orders set fullname=?, email = ?, phone_number = ?, address = ?, note = ?, create_time = ? where id = ?";
            statement = conn.prepareCall(sql);
            
            statement.setString(1, order.getFullname());
            statement.setString(2, order.getEmail());
            statement.setString(3, order.getPhoneNumber());
            statement.setString(4, order.getAddress());
            statement.setString(5, order.getNote());
            statement.setString(6, order.getCreateTime());
            statement.setInt(7, order.getId());
            
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(OrderModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void delete(int id) {
        Connection conn = null;
        java.sql.PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webbanhang", "root", "");
            
            //query
            
            String sql = "delete from orders where id = ?";
            statement = conn.prepareCall(sql);
            
            statement.setInt(1, id);
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static List<Order> findByFullnameOrder(String fullname) {
        List<Order> orderList = new ArrayList<>();
        
        Connection conn = null;
        java.sql.PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webbanhang", "root", "");
            
            //query
            String sql = "select orders.*, user.fullname userFullname from user, orders where orders.fullname like ? and user.id = orders.user_id";
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + fullname + "%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Order order = new Order( resultSet.getInt("orders.id"),
                    resultSet.getInt("orders.user_id"),  
                    resultSet.getString("userFullname"),
                    resultSet.getString("email"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("address"),
                    resultSet.getString("note"),
                    resultSet.getString("total"),
                    resultSet.getString("create_time")
                );
                orderList.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return orderList;
    }
    
    public static void update_total(int user_id) {
        Connection conn = null;
        java.sql.PreparedStatement statement = null;
        int total = 0;
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webbanhang", "root", "");
            
            //query
            
            String sql = "select order_user.*, product.price product_price "
                    + "from order_user join product "
                    + "on order_user.product_id = product.id "
                    + "where order_user.user_id = ?";
            statement = conn.prepareCall(sql);
            statement.setInt(1, user_id);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                total += resultSet.getInt("product_price") * resultSet.getInt("order_user.count");
            }
            
            
            
            sql = "update orders set total = ? where user_id = ?";
            statement = conn.prepareCall(sql);
            
            statement.setInt(1, total);
            statement.setInt(2, user_id);
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
