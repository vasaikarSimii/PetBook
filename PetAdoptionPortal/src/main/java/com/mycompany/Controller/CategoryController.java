/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Controller;

import com.mycompany.Dao.CategoryDAO;
import com.mycompany.Dao.DAO;

import com.mycompany.Pojo.Category;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author seeminvasaikar
 */

@Controller
public class CategoryController {
    
    @GetMapping("/add-category.htm")
    public String displayAdCategoryForm(Model model, Category category){
        return "add-category";
    }
   
    
  @PostMapping("/add-category.htm")
    public ModelAndView addCategoryController(@ModelAttribute("category") Category newCategory, BindingResult result, SessionStatus status){
            CategoryDAO category = new CategoryDAO();
            category.createCategory(newCategory.getCategory_name());
            DAO.close();
            status.setComplete();
            return new ModelAndView("addCategorySuccess","category",newCategory);
        
    }
    
}
