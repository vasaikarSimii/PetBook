/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Dao;

import com.mycompany.Pojo.Admin;
import com.mycompany.Pojo.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author seeminvasaikar
 */

public class LoginDao extends DAO{
    private final Session session = null;
    
  
public User getUserDetails(String username){
        try {
            beginTransaction();
            Query q = getSession().createQuery("from User where username = :username");
            q.setString("username", username);
            User user = (User) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new HibernateException("Could not get user " + username, e);
        }
    }
    public ArrayList<User> getUserLogin(String username, String password) {
        ArrayList<User> user = null;
        try {
            beginTransaction();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from User where username = :username and password = :password");
            q.setString("username", username);
            q.setString("password", password);
            user = (ArrayList<User>) q.list();
            commit();
        } 
        catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return user;
    }
  
    public ArrayList<Admin> getAdminLogin(String username, String password) {
        ArrayList<Admin> admin = null;
        try {
            beginTransaction();
            //Query q = getSession().createQuery("from Message where userName= :username");
            org.hibernate.Query q = getSession().createQuery("from Admin where username = :username and password = :password");
            q.setString("username", username);
            q.setString("password", password);
            admin = (ArrayList<Admin>) q.list();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return admin;
    }
    
    public int registerUser(String firstname, String lastname, String gender, String age, String email, String phone, String username, String password){
        int result = 0;
        try{
            beginTransaction();
            User user = new User();
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setGender(gender);
            user.setAge(age);
            user.setEmail(email);
            user.setPhone(phone);
            user.setUsername(username);
            user.setPassword(password);
            getSession().save(user);
            commit();
            result = 1;
        }catch(HibernateException e){
            e.printStackTrace();
            rollbackTransaction();
            result = 0;
        }finally {
            close();
        }
        return result;
    }
    
    public int checkUser(String email, String username){
        int result = 0;
        try{
            beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            Criterion critEmail = Restrictions.eq("email",email);
            Criterion crtiUsername = Restrictions.eq("username", username); 
            criteria.add(Restrictions.or(critEmail,crtiUsername));
            List users = criteria.list();
            if (users.size() > 0) {
                result = 1;
            }else{
                result = 2;
            }
            
        }catch(HibernateException e){
            e.printStackTrace();
            rollbackTransaction();
            result = 0;
        }finally {
            close();
        }
        return result;
    }
}
    