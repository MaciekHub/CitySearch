package pr.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomepageController {

	@RequestMapping("/homepage")
	public String home() {
		System.out.print("####home###");
		return "home";
	}

}
