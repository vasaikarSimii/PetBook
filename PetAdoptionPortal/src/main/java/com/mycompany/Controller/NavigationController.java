/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Controller;


import com.mycompany.Pojo.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author seeminvasaikar
 */

@Controller
public class NavigationController {
    
    @RequestMapping("/user-home.htm")
    public ModelAndView getUserHomePage(HttpServletRequest request, User user) throws Exception {
       ModelAndView mv =null;
        mv =  new ModelAndView("login");
        return mv;
    }
    @RequestMapping("/homepage-redirect.htm")
    public ModelAndView getHomePage(HttpServletRequest request, User user) throws Exception {
       ModelAndView mv =null;
        mv =  new ModelAndView("homepage");
        return mv;
    }
    @RequestMapping("/view-ads.htm")
    public ModelAndView getViewAds(HttpServletRequest request, User user) throws Exception {
       ModelAndView mv =null;
        mv =  new ModelAndView("view-ads");
        return mv;
    }
    
    @RequestMapping("/logout.htm")
    public ModelAndView logoutUser(HttpServletRequest request) throws Exception {
       ModelAndView mv =null;
       request.getSession().invalidate();
        mv =  new ModelAndView("login");
        return mv;
        
    }
    
    
    
    
}
