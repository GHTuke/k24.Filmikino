package k24.Filmikino.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import k24.Filmikino.model.GenresRepository;
import k24.Filmikino.model.MoviesRepository;
import k24.Filmikino.model.ScreensRepository;

/*
 * Controller for the application
 */

@Controller
public class FilmikinoController {
	
	//Adding repositories
	@Autowired
	private MoviesRepository moviesrepo;
	
	@Autowired
	private GenresRepository genresrepo;
	
	@Autowired
	private ScreensRepository screensrepo;
	
	
	@GetMapping(value = {"/", "index"})
	public String returnIndex() {
		
		return "movielist";
	}
	
	@GetMapping("movielist") 
	public String returnMovielist(Model model) {
		model.addAttribute("movies", moviesrepo.findAll());
		return "movielist";
	}

}
