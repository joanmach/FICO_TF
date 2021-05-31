package pe.edu.fico.spring.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.fico.spring.model.Pais;
import pe.edu.fico.spring.service.IPaisService;

@Controller
@RequestMapping("/pais")
public class PaisController {

	@Autowired
	private IPaisService pService;

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaPaises(Map<String, Object> model) {
		model.put("listaPaises", pService.listar());
		return "listPais";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("pais", new Pais());
		return "pais";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Pais pais, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			return "pais";
		} else {
			boolean flag = pService.insertar(pais);
			if (flag) {
				return "redirect:/pais/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/pais/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Pais> objPais = pService.listarId(id);
		if (objPais == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/pais/listar";
		} else {
			model.addAttribute("pais", objPais);
			return "pais";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if(id!=null && id>0) {
			pService.eliminar(id);
			model.put("listaPaises", pService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje","Ocurrio un error");
			model.put("listaPaises", pService.listar());
		}
		
		return "listPais";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaPaises", pService.listar());
		return "listPais";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute Pais pais) throws ParseException {
		pService.listarId(pais.getCPais());
		return "listPais";
	}
	
	@RequestMapping("/find")
	public String findByNPais(Map<String, Object> model, @ModelAttribute Pais pais) throws ParseException {
		List<Pais> listaPais;
		pais.setNPais(pais.getNPais());
		listaPais = pService.findByNPais(pais.getNPais());

		if (listaPais.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaPaises", listaPais );
		return "listPais";
	}
}
