/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Dao;


import com.mycompany.Pojo.Category;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author seeminvasaikar
 */
public class CategoryDAO extends DAO {

    public Category getCategory(String category_name)  {
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Category where category_name = :category_name");
            q.setString("category_name", category_name);
            Category category = (Category) q.uniqueResult();
            commit();
            return category;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new HibernateException("Could not obtain the named category " + category_name + " " + e.getMessage());
        }
    }


        public ArrayList<Category> getCategoryList(){
        ArrayList<Category> categorylist = null;
        try {
            beginTransaction();
            org.hibernate.Query q = getSession().createQuery("from Category");
            categorylist = (ArrayList <Category>) q.list();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return categorylist;
    }

    public Category createCategory(String category_name)  {
        try {
            beginTransaction();
            Category cat = new Category(category_name);
            getSession().save(cat);
            commit();
            return null;
        } catch (HibernateException e) {
            rollbackTransaction();
            //throw new AdException("Could not create the category", e);
            throw new HibernateException("Exception while creating category: " + e.getMessage());
        }
    }

    public void saveCategory(Category category){
        try {
            beginTransaction();
            getSession().update(category);
            commit();
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new HibernateException("Could not save the category", e);
        }
    }

    public void deleteCategory(Category category)  {
        try {
            beginTransaction();
            getSession().delete(category);
            commit();
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new HibernateException("Could not delete the category", e);
        }
    }

    
}
