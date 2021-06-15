package com.codingdojo.Getting.Familiar;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/coding")
public class CodingControler {
	@RequestMapping("")
	public String hello() {
		return "<h1>Hello Coding Dojo!</h1>";
	}
    @RequestMapping("/python")
    public String mapPython() { 
    	return "Python/Django was awesome!";
    }
    @RequestMapping("/java")
    public String mapJava() { 
    	return "Java/Spring is better!";
    }

}
