package k24.Filmikino.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import k24.Filmikino.model.GenresRepository;
import k24.Filmikino.model.Movies;
import k24.Filmikino.model.MoviesRepository;

/*
 * Controller for the movies
 */

@Controller
public class MoviesController {

	// Adding repositories
	@Autowired
	private MoviesRepository moviesrepo;
	@Autowired
	private GenresRepository genrerepo;

	@GetMapping("movielist")
	public String returnMovielist(Model model) {
		model.addAttribute("movies", moviesrepo.findAll());
		return "movielist";
	}
	
	@GetMapping("addmovie")
	public String addNewMovie(Model model) {
		
		model.addAttribute("movie", new Movies());
		model.addAttribute("genre", genrerepo.findAll());
		
		return "addmovie";
	}
	
	@PostMapping("savemovie")
	public String saveMovie(@Valid @ModelAttribute("movie") Movies movie, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("movie", new Movies());
			model.addAttribute("genre", genrerepo.findAll());
			return "addmovie";
		}
		moviesrepo.save(movie);
		return "addmovie";
	}

}