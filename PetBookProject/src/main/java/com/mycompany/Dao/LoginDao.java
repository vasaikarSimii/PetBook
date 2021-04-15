/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Dao;

import com.mycompany.Pojo.User;
import java.util.ArrayList;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Seemin
 */
public class LoginDao {
    private static final SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private Session session = null;

    private Session getSession() {
        if (session == null || !session.isOpen()) {
            session = sf.openSession();
        }
        return session;
    }

    private void beginTransaction() {
        getSession().beginTransaction();
    }

    private void commit() {
        getSession().getTransaction().commit();;
    }

    private void close() {
        getSession().close();
    }

    private void rollbackTransaction() {
        getSession().getTransaction().rollback();
    }
    
    
    public ArrayList<User> getUserLoginDetails(String username, String password) {
        ArrayList<User> role = null;
        try {
            beginTransaction();
            //Query q = getSession().createQuery("from Message where userName= :username");
            org.hibernate.Query q = getSession().createQuery("from User where username = :username and password = :password");
            q.setParameter("username", username);
            q.setParameter("password", password);
            
            commit();
        } 
        catch (Exception e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return role;
    }
    
    
}
