/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Dao;


import com.mycompany.Pojo.User;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author seeminvasaikar
 */
public class UserDAO extends DAO {

    public UserDAO() {
    }

    public User getUser(String username){
        try {
            beginTransaction();
            Query q = getSession().createQuery("from User where username = :username");
            q.setParameter("username", username);
            User user = (User) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new HibernateException("Could not get user " + username, e);
        }
    }

    
}
