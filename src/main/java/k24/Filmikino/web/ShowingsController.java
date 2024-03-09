package k24.Filmikino.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import k24.Filmikino.model.ShowingsRepository;

@Controller
public class ShowingsController {
	
	@Autowired
	private ShowingsRepository showingsrepo;
	
	@GetMapping("showinglist")
	public String returnShowingList(Model model) {
		model.addAttribute("showings", showingsrepo.findAll());
		return "showinglist";
	}

}
