/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class OrderProduct {
    int id, user_id, product_id, category_id, count, status;
    String user_name, product_name, category_name, price;

    public OrderProduct() {
    }

    public OrderProduct(int id, int user_id, int product_id, int category_id, int count, int status, String user_name, String product_name, String category_name, String price) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.category_id = category_id;
        this.count = count;
        this.status = status;
        this.user_name = user_name;
        this.product_name = product_name;
        this.category_name = category_name;
        this.price = price;
    }

    public OrderProduct(int user_id, int product_id, int count, int status) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.count = count;
        this.status = status;
    }

    public OrderProduct(int id, int product_id, int count) {
        this.id = id;
        this.product_id = product_id;
        this.count = count;
    }
    
    

    public OrderProduct(int id, int count, String price, String user_name, String product_name, String category_name) {
        this.id = id;
        this.count = count;
        this.price = price;
        this.user_name = user_name;
        this.product_name = product_name;
        this.category_name = category_name;
    }
    
    

    public OrderProduct(String user_name, int product_id, int category_id, String price, int count) {
        this.user_name = user_name;
        this.product_id = product_id;
        this.category_id = category_id;
        this.price = price;
        this.count = count;
    }
    
    public OrderProduct(int id, String user_name, String product_name, String category_name, String price, int count, int product_id, int category_id) {
        this.id = id;
        this.user_name = user_name;
        this.product_name = product_name;
        this.category_name = category_name;
        this.price = price;
        this.count = count;
        this.product_id = product_id;
        this.category_id = category_id;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
}
