package k24.Filmikino.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import k24.Filmikino.model.MoviesRepository;
import k24.Filmikino.model.ScreensRepository;
import k24.Filmikino.model.Showings;
import k24.Filmikino.model.ShowingsRepository;

@Controller
public class ShowingsController {
	
	@Autowired
	private ShowingsRepository showingsrepo;
	@Autowired
	private MoviesRepository moviesrepo;
	@Autowired
	private ScreensRepository screensrepo;
	
	@GetMapping("showinglist")
	public String returnShowingList(Model model) {
		model.addAttribute("showings", showingsrepo.findAll());
		
		model.addAttribute("showing", new Showings());
		model.addAttribute("movies", moviesrepo.findAll());
		model.addAttribute("screens", screensrepo.findAll());
		return "showinglist";
	}
	
	@PostMapping("saveshowing")
	public String saveShowing(@Valid @ModelAttribute("showing") Showings showing, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("showings", showingsrepo.findAll());
			model.addAttribute("movies", moviesrepo.findAll());
			model.addAttribute("screens", screensrepo.findAll());
			return "showinglist";
		}
		showingsrepo.save(showing);
		return "redirect:showinglist";
	}

}
