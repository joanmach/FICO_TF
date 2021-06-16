package pe.edu.fico.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingController {
	
	@GetMapping("/landing")
	public String landing() {
		return "Landing";
	}
	
	@GetMapping("/")
	public String irLanding() {
		return "redirect:/landing";
		
	}
}
