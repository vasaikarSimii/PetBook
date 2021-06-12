/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Dao;

import com.mycompany.Pojo.PetAdvertisement;
import com.mycompany.Pojo.User;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author seeminvasaikar
 */

public class PetAdDAO extends DAO {

    public PetAdvertisement createAd(String petname, String petage, String petgender, String numberofvaccines, String petvetname, String levelofactiveness, String microchip, User user, String photofilename) {
        try {
            beginTransaction();
            PetAdvertisement advert = new PetAdvertisement(petname, petage, petgender, numberofvaccines, petvetname, levelofactiveness, microchip, user, photofilename);
            //PetAdvertisement advert = new PetAdvertisement(petname, petage, petgender, numberofvaccines, petvetname, levelofactiveness, microchip, petgender, user);
            getSession().save(advert);
            commit();
            return advert; 
            
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
            
        } 
        return null;
        
       
    }
    public List listOfPetAds() {
        try {
            beginTransaction();
            Query q = getSession().createQuery("from PetAdvertisement");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new HibernateException("Could not list the categories", e);
        }
    }

    public void delete(PetAdvertisement advert) {
        try {
            beginTransaction();
            getSession().delete(advert);
            commit();
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new HibernateException("Exception while deleting category: " + e.getMessage());
        }
    }
}