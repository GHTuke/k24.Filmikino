package k24.Filmikino.web;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import k24.Filmikino.model.MoviesRepository;
import k24.Filmikino.model.ScreensRepository;
import k24.Filmikino.model.Showings;
import k24.Filmikino.model.ShowingsKey;
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
		model.addAttribute("movies", moviesrepo.findAll());
		model.addAttribute("screens", screensrepo.findAll());
		
		model.addAttribute("showing", new Showings());
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
		Showings showing1 = new Showings(showing.getMovie(), showing.getScreen(), showing.getShowingtime());
		log.info("Saving in repo");
		showingsrepo.save(showing1);
		log.info("Saved in repo");
		return "redirect:showinglist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("deleteshowing/{movieId}/{screenId}/{showingtime}")
	public String deleteShowing(@PathVariable("movieId") Long movieId, @PathVariable("screenId") Long screenId, @PathVariable("showingtime") LocalDateTime showingtime, Model model) {
			log.info("Deleting showing");
			ShowingsKey Id = new ShowingsKey(movieId, screenId, showingtime);
		showingsrepo.deleteById(Id);
		return "redirect:/showinglist";
	}

}
