package com.codingdojo.HelloHuman;

//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
@RequestMapping("/your_server")
public class HomeControler {
	@RequestMapping("/")
	public String hello(@RequestParam(value="first_name", required=false) String searchQuery,@RequestParam(value="last_name", required=false) String search) {
		if (searchQuery=="") {
			return "<h1>Hello Human</h1>  <p>Welcome to Spring Boot!</p>";
						
		}else {
			return "Welcome "+searchQuery+" "+search+"<h6>Welcome to Spring boot!</h6>";
		}
		
	}

}
