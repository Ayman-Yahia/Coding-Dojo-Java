package com.codingdojo.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.services.UserService;

@Controller
public class HomeController {
	private final UserService userService;
    public HomeController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "redirect:/registration";
    	}else {
    		User newUser=userService.registerUser(user);
    		session.setAttribute("user_id",newUser.getId());
    		return "redirect:/home";
    	}
    	
    }
    @GetMapping("/login")
    public String loginPage() {
    	return "loginPage.jsp";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session,RedirectAttributes redirectAttributes) {
        
//    	boolean authentication_result=userService.authenticateUser(email,password);
    	if(userService.authenticateUser(email,password)) {
    		session.setAttribute("user_id",userService.findByEmail(email).getId());
    		return "redirect:/home";
    	}else {
    		
    		redirectAttributes.addFlashAttribute("error","Login information didn't match our records! Please, double-check it again.");
    		return "redirect:/login";
    	}
    }
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	if(session.getAttribute("user_id")==null) {
    		return "you must be logged in";
    	}else {
    		model.addAttribute("user",userService.findUserById((Long) session.getAttribute("user_id")) );
    		return "homePage.jsp";
    	}
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/login";
    }

}
