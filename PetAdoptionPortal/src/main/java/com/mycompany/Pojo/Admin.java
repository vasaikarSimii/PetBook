/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author seeminvasaikar
 */

@Entity
@Table(name = "admin")
public class Admin{
    @Id
    @Column(name = "admin_id")
    private long admin_id;
    @Column(name = "username", length = 50)
    private String username;
    @Column(name = "password", length = 50)
    private String password;

    public long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(long admin_id) {
        this.admin_id = admin_id;
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
    
    public String toString(){
        return "Username: "+this.username+", Password: "+this.password;
    }
    
}
