package k24.Filmikino.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger log = LoggerFactory.getLogger(ShowingsController.class);
	
	@Autowired
	private ShowingsRepository showingsrepo;
	@Autowired
	private MoviesRepository moviesrepo;
	@Autowired
	private ScreensRepository screensrepo;
	
	@GetMapping("showinglist")
	public String returnShowingList(Model model) {
		
		log.info("List different showings and add new showings as admin");
		model.addAttribute("showings", showingsrepo.findAll());
		
		model.addAttribute("showing", new Showings());
		model.addAttribute("movies", moviesrepo.findAll());
		model.addAttribute("screens", screensrepo.findAll());
		return "showinglist";
	}
	
	@PostMapping("saveshowing")
	public String saveShowing(@Valid @ModelAttribute("showing") Showings showing, BindingResult bindingResult, Model model) {
		log.info("Save new showing and check the validation" + showing.getMovie() + showing.getScreen() + showing.getShowingtime());
		if (bindingResult.hasErrors()) {
			log.info("Issues with the validation" + showing);
			model.addAttribute("showings", showingsrepo.findAll());
			model.addAttribute("movies", moviesrepo.findAll());
			model.addAttribute("screens", screensrepo.findAll());
			return "showinglist";
		}
		showingsrepo.save(showing);
		return "redirect:showinglist";
	}

}
