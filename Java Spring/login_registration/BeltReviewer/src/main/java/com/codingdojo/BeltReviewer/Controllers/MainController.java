package com.codingdojo.BeltReviewer.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.BeltReviewer.models.Event;
import com.codingdojo.BeltReviewer.models.User;
import com.codingdojo.BeltReviewer.services.MainService;
import com.codingdojo.BeltReviewer.validators.UserValidator;


@Controller
public class MainController {
	private final MainService mainService;
	private final UserValidator userValidator;
	public MainController(MainService mainService,UserValidator userValidator) {
		this.mainService=mainService;
		this.userValidator=userValidator;
	}
	ArrayList<String> states = new ArrayList<String>(Arrays.asList(" a","AL", "AK", "AZ", "AR", "CA", "CO", "CT",
			"DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN",
			"MS"));
	@GetMapping("")
	public String index(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("states", states);
		return "index.jsp";
	}
	@PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
    		return "redirect:/";
    	}else {
    		User newUser=mainService.registerUser(user);
    		session.setAttribute("user_id",newUser.getId());
    		return "redirect:/events";
    	}
    	
    }
	@PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session,RedirectAttributes redirectAttributes) {
        
//    	boolean authentication_result=userService.authenticateUser(email,password);
    	if(mainService.authenticateUser(email,password)==true) {
    		session.setAttribute("user_id",mainService.findByEmail(email).getId());
    		return "redirect:/events";
    	}else {
    		
//    		redirectAttributes.addFlashAttribute("error","Login information didn't match our records! Please, double-check it again.");
    		return "redirect:/";
    	}
    }
	@RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
	
	@GetMapping("/events")
	public String eventsPage(@ModelAttribute("event") Event event, HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		User user = mainService.findUserById((Long) session.getAttribute("user_id"));
		model.addAttribute("user", user);
		model.addAttribute("states", states);
		model.addAttribute("not_states",mainService.evenstNotInYourState(user));
		model.addAttribute("in_states",mainService.evenstInYourState(user));
		model.addAttribute("myUserId", (Long)session.getAttribute("user_id"));
		return "events.jsp";
	}
	@PostMapping("/event/add")
	public String addEvent(@Valid @ModelAttribute(value="event") Event event,BindingResult result,HttpSession session,RedirectAttributes redirectAttributes,Model model) {
		if(result.hasErrors()) {
			return "redirect:/events";
		}else {
			Event myEvent=mainService.createEvent(event);
			User myUser=mainService.findUserById((Long)session.getAttribute("user_id"));
			myEvent.setHost(myUser);
			mainService.createEvent(myEvent);
			return "redirect:/events";		
		}
		
	}
	@GetMapping("/events/delete/{id}")
	public String deleteEvent(@PathVariable(value="id")Long id,HttpSession session) {
		Event event=mainService.findEventById(id);
		User user=event.getHostUser();
		if(user.getId()==(Long)session.getAttribute("user_id")) {
			mainService.deleteEvent(id);
			return "redirect:/events";
		}else {
			return "redirect:/events";
		}
		
	}
	@GetMapping("/events/edit/{id}")
	public String editPage(@ModelAttribute(value="event") Event event,@PathVariable(value="id")Long id,HttpSession session,Model model) {
		Event mEvent=mainService.findEventById(id);
		model.addAttribute("mEvent", mEvent);
		User user=mEvent.getHostUser();
		model.addAttribute("states", states);
		if(user.getId()==(Long)session.getAttribute("user_id")) {
			return "edit.jsp";
		}else {
			return "redirect:/";
		}
	}
	@PutMapping("/events/edit/{id}")
	public String editEvent(@Valid@ModelAttribute(value="event") Event event,@PathVariable(value="id")Long id,HttpSession session,BindingResult result,@RequestParam(value="eventName") String eventName,@RequestParam(value="eventDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date eventDate,@RequestParam(value="city") String eventCity,@RequestParam(value="state") String eventState) {
		Event mEvent=mainService.findEventById(id);
		User user=mEvent.getHostUser();
		if(user.getId()==(Long)session.getAttribute("user_id")) {
			if (result.hasErrors()) {
	            return "redirect:/events/edit/"+mEvent.getId();
	        } else {
	        	mainService.updateEvent(id,eventName,eventDate,eventCity,eventState);
	        	mainService.createEvent(mEvent);
	            return "redirect:/events";
	        }
			
		}else {
			return "redirect:/";
		}

	}
	@GetMapping("/events/{id}/join")
	public String joinEvent(@PathVariable(value="id")Long id,HttpSession session) {
		Event mEvent=mainService.findEventById(id);
		User user=mainService.findUserById((Long)session.getAttribute("user_id"));
		mainService.joinUserEvent(user,mEvent);
		return "redirect:/events";
		
		
	}
	
}
