/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Controller;

import com.mycompany.Dao.LoginDao;
import com.mycompany.Pojo.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpMethod.POST;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Seemin
 */

@Controller
public class LoginController {
    
   
    public LoginController() {
    }
    
    @PostMapping(value ="/login.htm")
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = null;
        String option = request.getParameter("option") == null ? "" : request.getParameter("option");
        if (option == null || option == "") {
            mv = new ModelAndView("login");
            return mv;
        } else if(option.equals("login")){
            String role = request.getParameter("role") == null? "none": request.getParameter("role");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            LoginDao loginDao = new LoginDao();
        
        if(role.equals("user")){
                ArrayList<User> user = loginDao.getUserLoginDetails(username, password);
                if(user.size() > 0){
                    request.getSession().setAttribute("user", user.get(0));
                    request.getSession().setAttribute("role", "user");                  
                    mv = new ModelAndView("user-homepage", "role", user.get(0));
                    return mv;
                }else{
                    mv = new ModelAndView("login");
                    mv.addObject("error","User or Password is Invalid. Kindly Register if you don't have an account!");
                    return mv;
                }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
        return mv;
    }
        return new ModelAndView ();
}
}
