package k24.Filmikino;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import k24.Filmikino.model.Genres;
import k24.Filmikino.model.GenresRepository;
import k24.Filmikino.model.Movies;
import k24.Filmikino.model.MoviesRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MoviesRepositoryTest {
	
	@Autowired
	MoviesRepository movierepo;
	@Autowired
	GenresRepository genrerepo;
		
	@Test
	public void findByMovieNameShouldReturnMovieName() {
		Genres genre1 = new Genres("TestGenre");
		genrerepo.save(genre1);
		Movies movie1 = new Movies("Test name", 2024, "TestFirstName", "TestLastName", "TestDescription", genre1);
		movierepo.save(movie1);
		List<Movies> movies = movierepo.findByMovieName("Test name");
		assertThat(movies.get(0).getMovieName().equalsIgnoreCase("test name"));
	}
	
	@Test
	public void addNewMovieShouldGrowRepoSizeByOne() {
		Genres genre1 = new Genres("TestGenre");
		genrerepo.save(genre1);
		Movies movie1 = new Movies("Test name", 2024, "TestFirstName", "TestLastName", "TestDescription", genre1);
		long firstcount = movierepo.count();
		movierepo.save(movie1);
		long secondcount = movierepo.count();
		
		assertEquals((firstcount+1), secondcount);
	}
	
	@Test
	public void deletingAddedMovieShouldReduceCountByOne() {
		Genres genre1 = new Genres("TestGenre");
		genrerepo.save(genre1);
		Movies movie1 = new Movies("Test name", 2024, "TestFirstName", "TestLastName", "TestDescription", genre1);
		movierepo.save(movie1);
		long firstcount = movierepo.count();
		movierepo.delete(movie1);
		long secondcount = movierepo.count();
		
		assertEquals((firstcount-1), secondcount);
		
		//Just making sure the actual object is gone
		Movies deleted = movierepo.findById(movie1.getId()).orElse(null);
		assertNull(deleted);
	}
	
}
