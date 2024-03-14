package k24.Filmikino.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MoviesRepository extends CrudRepository<Movies, Long>{
	
	List<Movies> findByMovieName(String movieName);

}
