package com.codingdojo.DojoandNinjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.DojoandNinjas.models.Dojo;
import com.codingdojo.DojoandNinjas.models.Ninja;
import com.codingdojo.DojoandNinjas.services.DojoService;
import com.codingdojo.DojoandNinjas.services.NinjaService;

@Controller
public class HomeController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	public HomeController(NinjaService ninjaService,DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService=dojoService;
	}
	
	@RequestMapping("/dojos/new")
	public String index(Model model,@ModelAttribute("dojo")Dojo language) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "index.jsp";
	}
	@RequestMapping(value="/dojos/new", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			
			return "redirect:/dojos/new";
		}else {
			dojoService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	@RequestMapping("/ninjas/new")
	public String index(Model model,@ModelAttribute("ninja")Ninja ninja) {
		model.addAttribute("dojos", dojoService.allDojos());
		model.addAttribute("ninjas", ninjaService.allNinjas());
		return "index1.jsp";
	}
	
	@RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			
			return "redirect:/ninjas/new";
		}else {
			ninjaService.createNinja(ninja);
			return "redirect:/dojos/"+ninja.getDojo().getId();
		}
	}
	
	@RequestMapping(value="/dojos/{id}", method=RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "show.jsp";
	}

}
