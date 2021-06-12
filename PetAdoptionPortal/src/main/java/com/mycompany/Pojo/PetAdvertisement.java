/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Pojo;

import java.awt.Image;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author seeminvasaikar
 */
@Entity
@Table(name = "petad")

public class PetAdvertisement {
    @Id
    @Column(name = "pet_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long pet_id;
    @Column(name = "petname", length = 50)
    private String petname; 
    @Column(name = "petage", length = 50)
    private String petage; 
    @Column(name = "petgender", length = 50)
    private String petgender; 
    @Column(name = "numberofvaccines", length = 50)
    private String numberofvaccines;
    @Column(name = "petvetname", length = 50)
    private String petvetname;
    @Column(name = "levelofactiveness", length = 50)
    private String levelofactiveness;
    @Column(name = "microchip", length = 50)
    private String microchip;
    @Column(name = "category", length = 50)
    private String category;
    @Column(name = "postedBy", length = 50)
    private String postedBy;
    @Column(name = "photofilename", length = 50)
    private String photofilename;
    @Transient
    private MultipartFile petpic;

    public MultipartFile getPetpic() {
        return petpic;
    }

    public void setPetpic(MultipartFile petpic) {
        this.petpic = petpic;
    }
    

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }
    
    @Column(name = "user", length = 50)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
   
    
    
    public PetAdvertisement(String petname, String petage, String petgender, String numberofvaccines, String petvetname, String levelofactiveness, String microchip, User user, String photofilename) {
        this.petname = petname;
        this.petage = petage;
        this.petgender = petgender;
        this.numberofvaccines = numberofvaccines;
        this.petvetname = petvetname;
        this.levelofactiveness = levelofactiveness;
        this.microchip = microchip;
        this.user = user;
        this.photofilename = photofilename;
        this.petpic = petpic;
        
    }

    public String getPhotofilename() {
        return photofilename;
    }

    public void setPhotofilename(String photofilename) {
        this.photofilename = photofilename;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public long getPet_id() {
        return pet_id;
    }

    public void setPet_id(long pet_id) {
        this.pet_id = pet_id;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getPetage() {
        return petage;
    }

    public void setPetage(String petage) {
        this.petage = petage;
    }

    public String getPetgender() {
        return petgender;
    }

    public void setPetgender(String petgender) {
        this.petgender = petgender;
    }

    public String getNumberofvaccines() {
        return numberofvaccines;
    }

    public void setNumberofvaccines(String numberofvaccines) {
        this.numberofvaccines = numberofvaccines;
    }

    public String getPetvetname() {
        return petvetname;
    }

    public void setPetvetname(String petvetname) {
        this.petvetname = petvetname;
    }

    public String getLevelofactiveness() {
        return levelofactiveness;
    }

    public void setLevelofactiveness(String levelofactiveness) {
        this.levelofactiveness = levelofactiveness;
    }

    public String getMicrochip() {
        return microchip;
    }

    public void setMicrochip(String microchip) {
        this.microchip = microchip;
    }
    
    

    
    
    public PetAdvertisement() {
    }
    
    

}