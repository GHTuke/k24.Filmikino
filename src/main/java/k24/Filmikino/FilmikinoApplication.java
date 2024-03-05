package k24.Filmikino;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	 */
	@Bean
	public CommandLineRunner filmikinoTester (MoviesRepository moviesrepository, ScreensRepository screensrepository) {
		return (args) -> {
			
			Screens screen1 = new Screens("Lounge", 30);
			Screens screen2 = new Screens("VIP", 50);
			Screens screen3 = new Screens("Cattle", 300);
			
			screensrepository.save(screen1);
			screensrepository.save(screen2);
			screensrepository.save(screen3);
			
			Movies movie1 = new Movies("The Great Gretzky", 2013, "Steve", "Holt", "Placeholder description");
			Movies movie2 = new Movies("Jaws of the Jungle", 2023, "Christopher", "Turkleton", "Placeholder description");
			Movies movie3 = new Movies("Jurassic Bark", 3001, "Phillip", "Fry", "Placeholder description");
			Movies movie4 = new Movies("Laura of Arabia", 1984, "Kaj", "Franck", "Placeholder description");
			
			moviesrepository.save(movie1);
			moviesrepository.save(movie2);
			moviesrepository.save(movie3);
			moviesrepository.save(movie4);
		};
	}

}
