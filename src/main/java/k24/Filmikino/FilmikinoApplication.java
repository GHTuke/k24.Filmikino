package k24.Filmikino;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k24.Filmikino.model.AppUser;
import k24.Filmikino.model.AppUserRepository;
import k24.Filmikino.model.Genres;
import k24.Filmikino.model.GenresRepository;
import k24.Filmikino.model.Movies;
import k24.Filmikino.model.MoviesRepository;
import k24.Filmikino.model.Screens;
import k24.Filmikino.model.ScreensRepository;
import k24.Filmikino.model.Showings;
import k24.Filmikino.model.ShowingsRepository;

@SpringBootApplication
public class FilmikinoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(FilmikinoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FilmikinoApplication.class, args);
	}
	
	
	/*
	 * Adding some test data for the system to show
	 * Don't mind the movies, just needed something to take my mind off every now and then
	 */
	@Bean
	public CommandLineRunner filmikinoTester (MoviesRepository moviesrepository
			, ScreensRepository screensrepository
			, GenresRepository genresrepository
			, ShowingsRepository showingsrepository
			, AppUserRepository appuserrepository) {
		return (args) -> {
			/* COMMENTING AWAY TEST DATA FOR LOCAL DATABASE
			//Adding some screens and saving them in repository for testing
			log.info("Adding screens");
			Screens screen1 = new Screens("Lounge", 30);
			Screens screen2 = new Screens("VIP", 50);
			Screens screen3 = new Screens("Cattle", 300);
			
			log.info("saving screens to repository");
			screensrepository.save(screen1);
			screensrepository.save(screen2);
			screensrepository.save(screen3);
			
			//Adding some genres and saving them in repository for testing
			log.info("Adding genres");
			Genres genre1 = new Genres("Romance");
			Genres genre2 = new Genres("Drama");
			Genres genre3 = new Genres("Action");
			Genres genre4 = new Genres("Comedy");
			
			log.info("saving genres to repository");
			genresrepository.save(genre1);
			genresrepository.save(genre2);
			genresrepository.save(genre3);
			genresrepository.save(genre4);
			
			//Adding some movies and saving them in repository for testing
			log.info("Adding movies");
			Movies movie1 = new Movies("The Great Gretzky"
					, 2013
					, "Steve", "Holt"
					, "Placeholder description"
					, genresrepository.findByGenre("Romance").get(0));
			Movies movie2 = new Movies("Jaws of the Jungle"
					, 2023
					, "Christopher", "Turkleton"
					, "Following his Oscar worthy perfomance in the 'Whale', actor Brendan Frasier returns to reprise his most famous role as George of the Jungle, in this action filled sequel that combines the tense horror of Jaws with the comedy of George of the Jungle."
					, genresrepository.findByGenre("Action").get(0));
			Movies movie3 = new Movies("Jurassic Bark"
					, 3001
					, "Phillip", "Fry"
					, "Placeholder description"
					, genresrepository.findByGenre("Drama").get(0));
			Movies movie4 = new Movies("Gone with the kiln"
					, 1939
					, "George", "Constanza"
					, "Witness the exciting story of how the famous ceramics of Arabia came to be. Experience first hand as Kaj Franck(Spede Pasanen) tutors a young new designer, Laura, for Arabia(Marjatta Raita). See the origins of the famous quote 'Franckly, my dear, I don't give a damn'. Set in the backdrop of war torn Finland after the Finnish Civil War."
					, genresrepository.findByGenre("Comedy").get(0));
			
			log.info("saving movies to repository");
			moviesrepository.save(movie1);
			moviesrepository.save(movie2);
			moviesrepository.save(movie3);
			moviesrepository.save(movie4);
			
			//Adding some showings and saving them in repository for testing
			log.info("Adding showings");
			Showings showing1 = new Showings(movie1, screen1, LocalDateTime.of(2024, 4, 21, 14, 00));
			Showings showing2 = new Showings(movie2, screen2, LocalDateTime.of(2024, 5, 2, 18, 15));
			Showings showing3 = new Showings(movie3, screen3, LocalDateTime.of(2024, 6, 3, 10, 10));
			
			log.info("saving showings to repository");
			showingsrepository.save(showing1);
			showingsrepository.save(showing2);
			showingsrepository.save(showing3);
			
			//Adding users: user and admin
			
			AppUser user = new AppUser("user", "$2a$10$0I3D.dWMqG/08uwoXjKsx.yNG447U3tk/szToL8FtWSxKVfTqJGBm", "USER");
			AppUser admin = new AppUser("admin", "$2a$10$WmiW5apNDwm9k03E/mRkxeJ1scRyqNHhEIbhnOtV88Du5NDfw3tqO", "ADMIN");
			
			appuserrepository.save(user);
			appuserrepository.save(admin);
			*/
		};
	}

}
