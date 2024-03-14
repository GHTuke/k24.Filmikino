package k24.Filmikino.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import k24.Filmikino.model.Movies;
import k24.Filmikino.model.MoviesRepository;
import k24.Filmikino.model.Screens;
import k24.Filmikino.model.ScreensRepository;
import k24.Filmikino.model.Showings;
import k24.Filmikino.model.ShowingsKey;
import k24.Filmikino.model.ShowingsRepository;

/*
 * Controller for the REST actions of the application
 */

@RestController
public class RestFilmikinoController {
	
	@Autowired
	private MoviesRepository movierepo;
	@Autowired
	private ShowingsRepository showingrepo;
	@Autowired
	private ScreensRepository screenrepo;
	
	//Movies REST actions
	@GetMapping("movies")
	public Iterable<Movies> getMovies() {
		return movierepo.findAll();
	}
	
	@GetMapping("movie/{id}")
	public Optional<Movies> getMovieById(@PathVariable("id") Long movieId) {
		return movierepo.findById(movieId);
	}
	
	@PostMapping("movie")
	Movies newMovie(@RequestBody Movies newMovie) {
		return movierepo.save(newMovie);
	}
	
	@PutMapping("car/{id}")
	Movies editMovie(@RequestBody Movies editMovie, @PathVariable("id") Long id) {
		editMovie.setId(id);
		return movierepo.save(editMovie);
	}
	
	//Showings REST actions
	
	@GetMapping("showings")
	public Iterable<Showings> getShowings() {
		return showingrepo.findAll();
	}
	/* This does not work without a DTO
	@GetMapping("showing/{id}")
	public Optional<Showings> getShowingById(@PathVariable("id") ShowingsKey showingId) {
		return showingrepo.findById(showingId);
	}
	*/
	//Screens REST actions
	
	@GetMapping("screens")
	public Iterable<Screens> getScreens() {
		return screenrepo.findAll();
	}
	
	@GetMapping("screen/{id}")
	public Optional<Screens> getScreenById(@PathVariable("id") Long showingId) {
		return screenrepo.findById(showingId);
	}
	
}
