/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Feedback {
    int id;
    String fullname, email, note, phoneNumber, created_at;

    public Feedback() {
    }

    public Feedback(int id, String fullname, String email, String note,  String phoneNumber, String created_at) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.note = note;
        this.created_at = created_at;
        this.phoneNumber = phoneNumber;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Feedback{" + "id=" + id + ", fullname=" + fullname + ", email=" + email + ", note=" + note + ", created_at=" + created_at + ", phoneNumber=" + phoneNumber + '}';
    }
    
}
