package com.pizza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pizza.model.RoleEnum;
import com.pizza.model.User;
import com.pizza.services.UserService;

@Controller
@SessionAttributes("username")
public class LoginController {

	@Autowired
	UserService userService;

    @RequestMapping(value= {"/", "/login"}, method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "login";
    }

    @RequestMapping(value= {"/", "/login"}, method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String username, @RequestParam String password){

    	
        User loggedUser = userService.loadUser(username, password);
        
        if (loggedUser == null) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }
        model.put("username", username);
        model.put("password", password);
        
        if (loggedUser.getRole().name().equals(RoleEnum.ADMIN.name())) {
        	return "adminMenu";
        } 
        return "userMenu";
    }
     

}