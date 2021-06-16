package com.codingdojo.TheCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class HomeControler {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(value="/code", method=RequestMethod.POST)
	public String code(@RequestParam(value="code") String code) {
        // ... process information and save it to the session
		if(code.equals("bushido")) {
			return "code.jsp";
		}else {
			return "redirect:/errorMsg";
		}
  }
	@RequestMapping("/errorMsg")
	public String flashMessages(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "you must train harder");
        return "redirect:/";
	}
}
