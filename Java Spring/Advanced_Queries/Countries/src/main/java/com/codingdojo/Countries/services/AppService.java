package com.codingdojo.Countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.Countries.repositories.CityRepository;
import com.codingdojo.Countries.repositories.CountryRepository;
import com.codingdojo.Countries.repositories.LanguageRepository;

@Service
public class AppService {
	private  CountryRepository countryRepository;
	private  CityRepository cityRepository;
	private  LanguageRepository languageRepository;
	
	public AppService(CountryRepository countryRepository,CityRepository cityRepository,LanguageRepository languageRepository) {
		this.countryRepository=countryRepository;
		this.cityRepository=cityRepository;
		this.languageRepository=languageRepository;
	}
	// QUESTION 1
		public List<Object[]> CountryByLang(String language){
			return countryRepository.findCountryByLang(language);
		}
		
		// QUESTION 2
		public List<Object[]> CitiesCount(){
			return countryRepository.findCitiesCount();
		}
		
		// QUESTION 3
		public List<Object[]> CitiesByCountryName(String name){
			return countryRepository.findCitiesByCountryName(name);
		}
		
		// QUESTION 4
		public List<Object[]> LanguagesInEachCountry(){
			return languageRepository.findLanguagesInEachCountry();
		}
		
		// QUESTION 5
		public List<Object[]> CountryByAreaAndPopulation(double surface_area, int population){
			return countryRepository.findCountryByAreaAndPopulation(surface_area, population);
		}
		
		// QUESTION 6
		public List<Object[]> CountryByGovernmentalAndAreaAndLife(){
			return countryRepository.findCountryByGovernmentalAndAreaAndLife();
		}
		
		// QUESTION 7
		public List<Object[]> SpecificCitiesInArgentinaBuenosAires(){
			return cityRepository.findSpecificCitiesInArgentinaBuenosAires();
		}
		
		// QUESTION 8
		public List<Object[]> CountriesAndRegions(){
			return countryRepository.summarizeCountriesAndRegions();
		}

}
