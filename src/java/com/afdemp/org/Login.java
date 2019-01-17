/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afdemp.org;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author George.Pasparakis
 */
public class Login extends AbstractController {
    private StaticClass sc;
    
    public Login() {
        
    }
    
    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        //throw new UnsupportedOperationException("Not yet implemented");
        System.out.println(request.getParameter("name"));
        if(request.getParameter("name") != null) {
            System.out.println("logged in"); 
            sc = new StaticClass();
            sc.setUserId(1);
            ModelAndView mv = new ModelAndView("admin");
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("login");
            return mv;
        }
    }
}
