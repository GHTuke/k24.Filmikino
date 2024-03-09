package k24.Filmikino.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ScreensRepository extends CrudRepository<Screens, Long>{
	
	List<Genres> findByScreenName(String screenName);

}
