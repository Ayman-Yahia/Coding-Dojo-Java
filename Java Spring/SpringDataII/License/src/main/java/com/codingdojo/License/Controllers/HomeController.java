package com.codingdojo.License.Controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.License.models.License;
import com.codingdojo.License.models.Person;
import com.codingdojo.License.services.LicenseService;
import com.codingdojo.License.services.PersonService;

@Controller
public class HomeController {
	private final PersonService personService;
	private final LicenseService licenseService;
	
	public HomeController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person, Model model) {
		model.addAttribute("persons", personService.allPeople());
		return "index.jsp";
	}
	
	@RequestMapping("/license/new")
	public String newPerson(@ModelAttribute("license") License license, Model model) {
		model.addAttribute("licenses", licenseService.allLicenses());
		model.addAttribute("peoplelist", personService.allPeople());
		return "index1.jsp";
	}
	
	@RequestMapping("/persons/{id}")
	public String viewDetails(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", personService.findPerson(id));
		return "show.jsp";
	}
	

	@RequestMapping(value="/persons/new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model) {
		if(result.hasErrors()) {
			
			return "redirect:/persons/new";
		}else {
			personService.createPerson(person);
			return "redirect:/license/new";
		}
	}
	@RequestMapping(value="/licenses/new",method=RequestMethod.POST)
	public String newLicenseProcessing(@ModelAttribute(value="license") License license,@RequestParam(value="person") Person person, @RequestParam(value="state") String state,@RequestParam(value="date") Date date) {
		int myNumber=licenseService.generateLicenseNumber();
		licenseService.createLicense(license, person, state,date,myNumber);
		return "redirect:/licenses/new";
	}

}
