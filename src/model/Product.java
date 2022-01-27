/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Product {
    int id;
    String title,price,categoryName,description,thumbnail;
    String created_at, updated_at;
    
    int idCat;

    public Product() {
    }

    public Product(int id, String title, String price, String categoryName, String description, String thumbnail, String created_at, String updated_at, int idCat) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.categoryName = categoryName;
        this.description = description;
        this.thumbnail = thumbnail;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.idCat = idCat;
    }

    public Product(String title, String price, String description, String thumbnail, String created_at, String updated_at, int idCat) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.thumbnail = thumbnail;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.idCat = idCat;
    }

    public Product(String title,String categoryName,String price, String description, String thumbnail,int idCat) {
        this.title = title;
        this.categoryName = categoryName;
        this.price = price;
        this.description = description;
        this.thumbnail = thumbnail;
        this.idCat = idCat;
    }

    public Product(int id, int idCat, String title, String price, String description, String thumbnail, String updated_at) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.thumbnail = thumbnail;
        this.updated_at = updated_at;
        this.idCat = idCat;
    }

    public Product(int id, String title, String categoryName, String price, String description, String thumbnail, String created_at, String updated_at) {
        this.id = id;
        this.title = title;
        this.categoryName = categoryName;
        this.price = price;
        this.description = description;
        this.thumbnail = thumbnail;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Product(int id, String title, String price, String categoryName, String description, String thumbnail, String updated_at) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.categoryName = categoryName;
        this.description = description;
        this.thumbnail = thumbnail;
        this.updated_at = updated_at;
    }

    public Product(int id, String title, String categoryName, String price, String description, String thumbnail, String updated_at, int idCat) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.categoryName = categoryName;
        this.description = description;
        this.thumbnail = thumbnail;
        this.updated_at = updated_at;
        this.idCat = idCat;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

}
