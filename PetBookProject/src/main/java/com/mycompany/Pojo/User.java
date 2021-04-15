/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Seemin
 */

@Entity
@Table(name = "tbl_user_details")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long user_id;
    @Column(name = "firstname", length = 50)
    private String firstname;
    @Column(name = "lastname", length = 50)
    private String lastname;
    @Column(name = "username", length = 10)
    private String username;
    @Column(name = "password", length = 50)
    private String password;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private int age;
    @Column(name = "address", length = 100)
    private String address;
    @Column(name = "email", length = 30)
    private String email;
    @Column(name = "phone_number", length = 20)
    private String phone_number;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    

}
