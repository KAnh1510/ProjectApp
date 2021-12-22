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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;
import model.OrderProduct;
import model.User;

/**
 *
 * @author Admin
 */
public class OrderProductModify {
    
    public static List<OrderProduct> findAll(int user_id) {
        List<OrderProduct> orderProductList = new ArrayList<>();
        
        Connection conn = null;
        java.sql.PreparedStatement statement = null;
        
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webbanhang", "root", "");
            
            //query
            
            System.out.println(user_id);
            
            String sql = "select order_user.*, product.title product_title, product.price product_price, "
                    + "user.fullname user_name, category.name category_name, orders.fullname orders_fullname "
                    + "from order_user join user "
                    + "on order_user.user_id = user.id "
                    + "join product "
                    + "on order_user.product_id = product.id "
                    + "join category "
                    + "on product.category_id = category.id "
                    + "join orders "
                    + "on orders.user_id = user.id "
                    + "where order_user.user_id = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setInt(1, user_id);
            
            ResultSet resultSet = statement.executeQuery();
            
            
            while (resultSet.next()) {
                OrderProduct orderProduct = new OrderProduct( resultSet.getInt("id"),
                    resultSet.getInt("order_user.count"),
                    resultSet.getString("product_price"),
                    resultSet.getString("orders_fullname"),
                    resultSet.getString("product_title"),
                    resultSet.getString("category_name")
                );
                orderProductList.add(orderProduct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderProductModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return orderProductList;
    }
    
    public static void insert(OrderProduct orderProduct) {
        Connection conn = null;
        java.sql.PreparedStatement statement = null;
        try {
            //lay tat ca danh mục
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webbanhang", "root", "");
            
            //query
            String sql = "insert into order_user(user_id, product_id, count, status) values(?, ?, ?, ?) ";
            statement = conn.prepareCall(sql);
            
            statement.setInt(1, orderProduct.getUser_id());
            statement.setInt(2, orderProduct.getProduct_id());
            statement.setInt(3, orderProduct.getCount());
            statement.setInt(4, orderProduct.getStatus());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(OrderProductModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void update(OrderProduct orderProduct) {
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webbanhang", "root", "");
            
            //query
            String sql = "update order_user set product_id = ?, count = ? where id = ?";
            statement = conn.prepareCall(sql);
            
            statement.setInt(1, orderProduct.getProduct_id());
            statement.setInt(2, orderProduct.getCount());
            statement.setInt(3, orderProduct.getId());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void delete(int id) {
        Connection conn = null;
        java.sql.PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webbanhang", "root", "");
            
            //query
            String sql = "delete from order_user where id = ?";
            statement = conn.prepareCall(sql);
            statement.setInt(1, id);
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderProductModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
}
