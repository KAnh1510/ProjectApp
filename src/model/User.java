package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class User {
    int id;
    String fullname, email, phoneNumber, address, password, roleName;
    String created_at, updated_at;
    int idRole;
    
    public User() {
    }

    public User(int id, String fullname, String email, String phoneNumber, String address, String password, String roleName, String created_at, String updated_at,int idRole) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.roleName = roleName;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.idRole = idRole;
    }

    public User(String fullname, String email, String phoneNumber, String address, String password, String created_at, String updated_at,int idRole) {
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.idRole = idRole;
    }

    public User(String fullname, String email, String phoneNumber, String address, String password, String roleName,int idRole) {
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.roleName = roleName;
        this.idRole = idRole;
    }

    public User(String fullname, String email, String phoneNumber, String address, String password, int idRole) {
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.idRole = idRole;
    }

    public User(String fullname, String email, String phoneNumber, String address, String roleName, String created_at, String updated_at) {
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.roleName = roleName;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public User(int id, String fullname, String email, String phoneNumber, String address, String password, String roleName, String updated_at, int idRole) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.roleName = roleName;
        this.updated_at = updated_at;
        this.idRole = idRole;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }
    
    
}
