package com.joctopus.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.joctopus.entity.UserEntity;
import com.joctopus.service.UserService;
import com.joctopus.service.UserServiceImpl;
@Controller
public class UsersController {
	@Autowired
	UserService userservice;
	public UserService getUserservice() {
		return userservice;
	}
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	@RequestMapping(value = "/welcome",method=RequestMethod.GET)
	public ModelAndView userlogin(HttpServletRequest req,HttpServletResponse res) {
		
		 ModelAndView model = new ModelAndView("welcome");
	        UserEntity user = new UserEntity();
	        model.addObject("user", user);
	        return model;
				
	}
	 @RequestMapping(value="/login",method=RequestMethod.POST)
	    public ModelAndView executeLogin(HttpServletRequest req, HttpServletResponse res, @ModelAttribute("user")UserEntity user)
	    {
	        ModelAndView model= null;
	        try {
	        boolean us = userservice.isValieduser(user.getUsername(),user.getPassword());

	        if (us) {
	        
	        req.setAttribute("username", user.getUsername());
	        model = new ModelAndView("login");
	        } else {
	        model = new ModelAndView("welcome");
	        model.addObject("user",user);
	        req.setAttribute("message","user invalied");
	        	}
	        }
	    
     catch(Exception e)
     {
         e.printStackTrace();
     }

	        return model;
	    }
	        

}