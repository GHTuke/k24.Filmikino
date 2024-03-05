package k24.Filmikino.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GenresRepository extends CrudRepository<Genres, Long>{
	
	List<Genres> findByGenre(String genre);

}
