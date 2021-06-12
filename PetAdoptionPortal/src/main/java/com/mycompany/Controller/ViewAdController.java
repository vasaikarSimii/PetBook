/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Controller;

import com.mycompany.Dao.CategoryDAO;
import com.mycompany.Dao.DAO;
import com.mycompany.Pojo.Category;
import com.mycompany.Pojo.PetAdvertisement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author seeminvasaikar
 */
@Controller
public class ViewAdController {
    
    @GetMapping("/view-ads.htm")
    public ModelAndView listAdverts(){
        CategoryDAO categories = null;
        List<Category> categoryList = null;
        List advList = new ArrayList();
         try {
            categories = new CategoryDAO();
            categoryList = categories.getCategoryList();
            Iterator categIterator = categoryList.iterator();
            while (categIterator.hasNext())
            {
                Category category = (Category) categIterator.next();
                Iterator advIterator = category.getAdverts().iterator();
                while (advIterator.hasNext())
                {
                    PetAdvertisement petadv = (PetAdvertisement) advIterator.next();
                    advList.add(petadv);
                }
            }
            DAO.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ModelAndView mv = new ModelAndView("view-ads", "petadv", advList);
//        ModelAndView mv = new ModelAndView("viewAdverts", "categories", categoryList);
        return mv;
    }
    
}
