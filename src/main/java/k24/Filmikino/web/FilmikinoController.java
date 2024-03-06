package k24.Filmikino.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/*
 * Controller for the application
 */

@Controller
public class FilmikinoController {
	
	
	@GetMapping(value = {"/", "index", "main"})
	public String returnIndex() {
		
		return "main";
	}


}
