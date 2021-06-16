package pe.edu.fico.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "Landing";
	}
	
	@RequestMapping("/ingreso")
	public String irPanelControl() {
		return "bienvenido";
	}
	
	@RequestMapping("/bienvenidoAdmin")
	public String irAdministradorBienvenidoAdmin() {
		return "bienvenidoAdmin";
	}
}
