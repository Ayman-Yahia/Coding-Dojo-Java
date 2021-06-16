package com.codingdojo.Counter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
@Controller
public class HomeControler {
	int count=0;
	@RequestMapping("/your_server")
	public String index1(HttpSession session) {
		session.setAttribute("count", count);
		count++;
		session.setAttribute("count", count);
		return "index.jsp";		
	}
	@RequestMapping("/your_server/counter")
	public String counter(Model model,HttpSession session) {
		Integer counter = (Integer) session.getAttribute("count");
		String str1 = Integer.toString(counter);
		model.addAttribute("str1", str1);
		return "counter.jsp";
	}

}
