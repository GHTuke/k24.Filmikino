package k24.Filmikino.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		
		model.addAttribute("movie", new Movies());
		model.addAttribute("genre", genrerepo.findAll());
		
		return "movielist";
	}
	
	@RequestMapping(value="savemovie", method=RequestMethod.POST)
	public String saveMovie(@Valid @ModelAttribute("movie") Movies movie, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("movies", moviesrepo.findAll());
			model.addAttribute("genre", genrerepo.findAll());
			return "movielist";
		}
		moviesrepo.save(movie);
		return "redirect:movielist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")	
	@RequestMapping(value = "/editmovie/{id}", method = RequestMethod.GET)
	public String editMovie(@PathVariable("id") Long Id, Model model) {
		
		model.addAttribute("movie", moviesrepo.findById(Id));
		model.addAttribute("genre", genrerepo.findAll());
		
		return "editmovie";
	}
	
	@RequestMapping(value="saveEditedmovie", method=RequestMethod.POST)
	public String saveEditedMovie(@Valid @ModelAttribute("movie") Movies movie, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("movies", moviesrepo.findAll());
			model.addAttribute("genre", genrerepo.findAll());
			return "editmovie";
		}
		moviesrepo.save(movie);
		return "redirect:movielist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("deletemovie/{id}")
	public String deleteMovie(@PathVariable("id") Long Id, Model model) {
			
		moviesrepo.deleteById(Id);
		return "redirect:/movielist";
	}

}