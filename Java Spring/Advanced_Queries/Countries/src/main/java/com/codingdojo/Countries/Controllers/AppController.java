package com.codingdojo.Countries.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.Countries.services.AppService;

@RestController
public class AppController {
	private final AppService appService;
	public AppController(AppService appService) {
		this.appService=appService;
		
	}
	@RequestMapping("/q1/{language}")
	public List<Object[]> q1(@PathVariable(value="language")String language) {
		return appService.CountryByLang(language);
	}
	
	@RequestMapping("/q2")
	public List<Object[]> q2(){
		return appService.CitiesCount();
	}
	
	@RequestMapping("/q3/{name}")
	public List<Object[]> q3(@PathVariable(value="name")String name){
		return appService.CitiesByCountryName(name);
	}
	
	@RequestMapping("/q4")
	public List<Object[]> q4(){
		return appService.LanguagesInEachCountry();
	}
	
	@RequestMapping("/q5/{surface_area}/{population}")
	public List<Object[]> q5(@PathVariable(value="surface_area") double surface_area,@PathVariable(value="population") int population){
		return appService.CountryByAreaAndPopulation(surface_area,population);
	}
	
	@RequestMapping("/q6")
	public List<Object[]> q6(){
		return appService.CountryByGovernmentalAndAreaAndLife();
	}
	
	@RequestMapping("/q7")
	public List<Object[]> q7(){
		return appService.SpecificCitiesInArgentinaBuenosAires();
	}
	
	@RequestMapping("/q8")
	public List<Object[]> q8(){
		return appService.CountriesAndRegions();
	}

}
