package k24.Filmikino;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k24.Filmikino.model.Genres;
import k24.Filmikino.model.GenresRepository;
import k24.Filmikino.model.Movies;
import k24.Filmikino.model.MoviesRepository;
import k24.Filmikino.model.Screens;
import k24.Filmikino.model.ScreensRepository;

@SpringBootApplication
public class FilmikinoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmikinoApplication.class, args);
	}
	
	
	/*
	 * Adding some test data for the system to show
	 * Don't mind the movies, just needed something to take my mind off every now and then
	 */
	@Bean
	public CommandLineRunner filmikinoTester (MoviesRepository moviesrepository, ScreensRepository screensrepository, GenresRepository genresrepository) {
		return (args) -> {
			
			Screens screen1 = new Screens("Lounge", 30);
			Screens screen2 = new Screens("VIP", 50);
			Screens screen3 = new Screens("Cattle", 300);
			
			screensrepository.save(screen1);
			screensrepository.save(screen2);
			screensrepository.save(screen3);
			
			Genres genre1 = new Genres("Romance");
			Genres genre2 = new Genres("Drama");
			Genres genre3 = new Genres("Action");
			Genres genre4 = new Genres("Comedy");
			
			genresrepository.save(genre1);
			genresrepository.save(genre2);
			genresrepository.save(genre3);
			genresrepository.save(genre4);
			
			Movies movie1 = new Movies("The Great Gretzky"
					, 2013
					, "Steve", "Holt"
					, "Placeholder description"
					, genresrepository.findByGenre("Romance").get(0));
			Movies movie2 = new Movies("Jaws of the Jungle"
					, 2023
					, "Christopher", "Turkleton"
					, "Placeholder description"
					, genresrepository.findByGenre("Action").get(0));
			Movies movie3 = new Movies("Jurassic Bark"
					, 3001
					, "Phillip", "Fry"
					, "Placeholder description"
					, genresrepository.findByGenre("Drama").get(0));
			Movies movie4 = new Movies("Gone with the kiln"
					, 1939
					, "George", "Constanza"
					, "Witness the exciting story of how the famous ceramics of Arabia came to be. Experience first hand as Kaj Franck(Spede Pasanen) tutors a young new designer Laura(Marjatta Raita). See the origins of the famous quote 'Franckly, my dear, I don't give a damn'. Set in the backdrop of war torn Finland after the Finnish Civil War."
					, genresrepository.findByGenre("Comedy").get(0));
			
			moviesrepository.save(movie1);
			moviesrepository.save(movie2);
			moviesrepository.save(movie3);
			moviesrepository.save(movie4);
		};
	}

}
