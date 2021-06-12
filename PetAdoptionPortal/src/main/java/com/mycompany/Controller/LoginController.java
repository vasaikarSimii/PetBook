/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Controller;

import com.mycompany.Dao.CategoryDAO;
import com.mycompany.Dao.LoginDao;
import com.mycompany.Pojo.Admin;
import com.mycompany.Pojo.Category;
import com.mycompany.Pojo.PetAdvertisement;
import com.mycompany.Pojo.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author seeminvasaikar
 */

@Controller
public class LoginController {
   
    
    
    @GetMapping("/login.htm")
    public String showForm(Model model, User user){
       
        return "login";
    }
    
    @PostMapping("/login.htm")
    public ModelAndView userLogin(HttpServletRequest request) throws Exception {
        try{
        ModelAndView mv = null;
      
        String option = request.getParameter("option") == null ? "" : request.getParameter("option");
        if (option == null || option == "") {
            mv = new ModelAndView("login");
            return mv;
        }
        else if(option.equals("login")){
            String role = request.getParameter("role") == null? "none": request.getParameter("role");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            LoginDao loginDao = new LoginDao();
            if(role.equals("admin")){
                ArrayList<Admin> admin = loginDao.getAdminLogin(username, password);
                if(admin.size() > 0){
                    request.getSession().setAttribute("user", admin.get(0));
                    request.getSession().setAttribute("role", "admin");
                    mv = new ModelAndView("admin-home", "role", admin.get(0));
                    return mv;
                }else{
                   mv = new ModelAndView("login");
                    mv.addObject("error","User or Password is Invalid. Please create a new user account!");
                    return mv;
                }
            
            }else if(role.equals("user")){
                ArrayList<User> user = loginDao.getUserLogin(username, password);
                if(user.size() > 0){
                    request.getSession().setAttribute("user", user.get(0));
                    request.getSession().setAttribute("role", "user");                  
                    mv = new ModelAndView("homepage", "role", user.get(0));
                    return mv;
                }else{
                    mv = new ModelAndView("login");
                    mv.addObject("error","User or Password is Invalid. Please create a new user account!");
                    return mv;
                }
                
            }else{
                mv = new ModelAndView("login");
                mv.addObject("error","Please specify a role!");
                return mv;
            }
        }
    
        return new ModelAndView("login");
        }
        catch(HibernateException e){
            throw new HibernateException("Could not obtain login details" + e.getMessage());
        }
}  
    
    
@RequestMapping(value = "/registeruser.htm")
    protected ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mv = null;
        String option = request.getParameter("option") == null ? "" : request.getParameter("option");
        if (option == null || option == "") {
            mv = new ModelAndView("register-user");
            return mv;
        }
        else if(option.equals("register")){
            LoginDao loginDao = new LoginDao();
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String gender = request.getParameter("gender") == null ? "" : request.getParameter("gender");
            String age = request.getParameter(String.valueOf("age"));
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            int result = loginDao.registerUser(firstname,lastname,gender, age, email, phone, username, password);
            
            if(result == 1){
                mv = new ModelAndView("login","error","User registered successfully!");
                return mv;
            }else {
                mv = new ModelAndView("register-user");
                mv.addObject("error","Please enter correct date!");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("gender",gender);
                mv.addObject("age",age);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }
        
        }
        return mv;
        
           
        }
    

}
                
        
        
        
        
        
        

   
    
    
    

