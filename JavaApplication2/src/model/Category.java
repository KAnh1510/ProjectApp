/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Category {
    int id;
    String name,h4content,h5content;

    public Category() {
    }

    public Category(int id,String name, String h4content, String h5content) {
        this.id = id;
        this.name = name;
        this.h4content = h4content;
        this.h5content = h5content;
    }

    public Category(String name, String h4content, String h5content) {
        this.name = name;
        this.h4content = h4content;
        this.h5content = h5content;
    }

    Category(String fullname, String email, String phone_number, String address, String roleId, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getH4content() {
        return h4content;
    }

    public void setH4content(String h4content) {
        this.h4content = h4content;
    }

    public String getH5content() {
        return h5content;
    }

    public void setH5content(String h5content) {
        this.h5content = h5content;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", h4content=" + h4content + ", h5content=" + h5content + '}';
    }
}
