package com.codingdojo.Getting.Familiar;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DojoControler {
	@RequestMapping("/{dojoName}")
	public String dojo(@PathVariable("dojoName") String name) {
		if(name.equals("dojo")) {
			return "The Dojo is awesome!";
		}
		if(name.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California.";
		}
		if(name.equals("san-jose")) {
			return "DJ dojo is the headquarters.";
		}
		return "!!!!";
    }

}
