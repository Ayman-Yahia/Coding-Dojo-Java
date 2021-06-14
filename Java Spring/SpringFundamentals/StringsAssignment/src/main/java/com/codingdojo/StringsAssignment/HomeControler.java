package com.codingdojo.StringsAssignment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeControler {
	@RequestMapping("/")
	public String hello() {
		return "Hello Client! How are you doing?";
	}
    @RequestMapping("/random")
    public String mapclass() { 
    	return "Spring Boot  is great! So easy to just respond with strings";
    }

}
