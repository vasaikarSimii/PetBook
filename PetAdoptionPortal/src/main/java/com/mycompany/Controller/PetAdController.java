/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Controller;

import com.mycompany.Dao.CategoryDAO;
import com.mycompany.Dao.DAO;
import com.mycompany.Dao.LoginDao;
import com.mycompany.Dao.PetAdDAO;
import com.mycompany.Dao.UserDAO;

import com.mycompany.Pojo.Category;
import com.mycompany.Pojo.PetAdvertisement;
import com.mycompany.Pojo.User;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static java.util.Objects.hash;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Email;
import static jdk.jfr.internal.handlers.EventHandler.timestamp;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author seeminvasaikar
 */

@Controller
public class PetAdController {
     
    @GetMapping("/add-petAd.htm")
    public ModelAndView displayAddAdvertForm(Model model, PetAdvertisement petAdvertisement) {
       CategoryDAO categoryDao = new CategoryDAO();
       List<Category> categories = categoryDao.getCategoryList();
        
        return new ModelAndView("add-petAd","categories", categories);
    }
    
    @PostMapping("/add-petAd.htm")
    public ModelAndView addAdvert(@ModelAttribute("petAdvertisement") PetAdvertisement newAdvert, BindingResult result, SessionStatus status, HttpServletRequest request) throws IOException{
        
        String category_name = newAdvert.getCategory();
        String username = newAdvert.getPostedBy(); 
        String petname = newAdvert.getPetname();   
        String petage = newAdvert.getPetage();   
        String petgender = newAdvert.getPetgender();      
        String numberofvaccines = newAdvert.getNumberofvaccines(); 
        String petvetname = newAdvert.getPetname();
        String levelofactiveness = newAdvert.getLevelofactiveness();
        String microchip = newAdvert.getMicrochip();
        
       
            UserDAO users = new UserDAO();
            CategoryDAO categories = new CategoryDAO();
            PetAdDAO adverts = new PetAdDAO();
            
            MultipartFile petpic = newAdvert.getPetpic();
            String photofilename = petpic.getOriginalFilename();
            File file = new File("/Users/seeminvasaikar/Documents/uploads", photofilename);
            newAdvert.setPetpic(petpic);
            petpic.transferTo(file);
      
            //searching from database
            User user = users.getUser(username);
             
            //searching from database
            Category category = categories.getCategory(category_name);

            //insert a new advert
            PetAdvertisement petAdvertisement = adverts.createAd(petname, petage, petgender, numberofvaccines, petvetname, levelofactiveness, microchip, user, photofilename);
            //PetAdvertisement petadverts = adverts.createAd(petname, petage, petgender, numberofvaccines, petvetname, levelofactiveness, microchip, user);

            category.addAdvert(petAdvertisement);
            categories.saveCategory(category);

            DAO.close();
            
            status.setComplete();
            //send email about AD creation to owner

            try{
SimpleEmail email = new SimpleEmail();
email.setHostName("jdbc:mysql://localhost");
email.setSmtpPort(3306);
email.setAuthenticator(new DefaultAuthenticator("username", "password"));
email.setSSLOnConnect(true);
email.setFrom("petadoptionadmin@gmail.com");
email.setSubject("New Pet Advertisement Request Created");
email.setMsg("This is a confirmation Email that your Request for a New Pet Adoption has been created on our Pet Adoption Portal");
email.addTo("seeminv18@gmail.com");
email.send();
            }
            catch (EmailException e){
                
            }
            return new ModelAndView("addAdvertSuccess","petAdvertisement",newAdvert);
       
    }
    
}
