package com.codingdojo.Lookify.Controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.Lookify.models.Song;
import com.codingdojo.Lookify.services.SongService;
@Controller
public class HomeController {
	private final SongService songService;
	public HomeController(SongService songService) {
		this.songService = songService;
	}
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/songs/new")
	public String index1(@ModelAttribute("song") Song song) {
		System.out.println("hi");
		return "new.jsp";
	}
	@RequestMapping(value="/songs/new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "redirect:/songs/new";
		}else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	@RequestMapping("/dashboard")
	public String dashboard(Model model,@ModelAttribute("song")Song song) {
		model.addAttribute("songs", songService.allSongs());
		return "dashboard.jsp";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search(@RequestParam("search") String search,HttpSession session) {
		session.setAttribute("searchWord", search);
		return "redirect:/search/"+search;
	}
	@RequestMapping(value="/search/{searchWord}", method=RequestMethod.GET)
	public String search(HttpSession session,Model model) {
		String ar=(String) session.getAttribute("searchWord");
		List<Song> artistsongs=songService.searchSong(ar);
		model.addAttribute("artistsongs",artistsongs);
		model.addAttribute("artist",ar);
		return "search.jsp";
	}
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "show.jsp";
	}
	@RequestMapping("/songs/{id}/delete")
	public String destory(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}

}
