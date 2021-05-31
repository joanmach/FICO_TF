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

import pe.edu.fico.spring.model.Ciudad;
import pe.edu.fico.spring.service.ICiudadService;
import pe.edu.fico.spring.model.Pais;
import pe.edu.fico.spring.service.IPaisService;


@Controller
@RequestMapping("/ciudad")
public class CiudadController {

	@Autowired
	private IPaisService pService;
	
	@Autowired
	private ICiudadService cService;

	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irEntidad(Map<String, Object> model) {
		model.put("listaCiudades", cService.listar());
		return "listCiudad";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("listaPaises", pService.listar());
		
		model.addAttribute("pais", new Pais());
		model.addAttribute("ciudad", new Ciudad());
		return "ciudad";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Ciudad objCiudad, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listaPaises", pService.listar());
			return "ciudad";
		} else {
			boolean flag = cService.insertar(objCiudad);
			if (flag) {
				return "redirect:/ciudad/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/ciudad/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Ciudad> objCiudad = cService.listarId(id);
		if (objCiudad == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/ciudad/listar";
		} else {
			   model.addAttribute("listaPaises", pService.listar());
			    if(objCiudad.isPresent())
			    	objCiudad.ifPresent(o -> model.addAttribute("ciudad",o));
				return "ciudad";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id>0) {
				cService.eliminar(id);
				model.put("listaCiudades", cService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaCiudades", cService.listar());
		}
		return "listCiudad";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaCiudades", cService.listar());
		return "listCiudad";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute Ciudad ciudad) throws ParseException {
		cService.listarId(ciudad.getCCiudad());
		return "listCiudad";
	}
	
	@RequestMapping("/find")
	public String findByNEntidad(Map<String, Object> model, @ModelAttribute Ciudad ciudad) throws ParseException {
		List<Ciudad> listaCiudad;
		ciudad.setNCiudad(ciudad.getNCiudad());
		listaCiudad = cService.findByNCiudad(ciudad.getNCiudad());

		if (listaCiudad.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaCiudades", listaCiudad );
		return "listCiudad";
	}
}
