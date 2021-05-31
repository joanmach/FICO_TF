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

import pe.edu.fico.spring.model.Asesor;
import pe.edu.fico.spring.model.Especialidad;
import pe.edu.fico.spring.service.IAsesorService;
import pe.edu.fico.spring.service.IEspecialidadService;

@Controller
@RequestMapping("/asesor")
public class AsesorController {

	@Autowired
	private IAsesorService tService;

	@Autowired
	private IEspecialidadService cService;


	@RequestMapping("/")
	public String irUsuario(Map<String, Object> model) {
		model.put("listaAsesores", tService.listar());
		return "listAsesor";
	}
	
	@RequestMapping("/bienvenido")
	public String irAsesorBienvenido() {
		return "bienvenido";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("listaEspecialidades", cService.listar());
		model.addAttribute("asesor", new Asesor());
		model.addAttribute("especialidad", new Especialidad());
		return "asesor";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Asesor asesor, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listaEspecialidades", cService.listar());
			return "asesor";
		} else {
			boolean flag = tService.insertar(asesor);
			if (flag) {
				return "redirect:/asesor/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/asesor/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Asesor> objAsesor = tService.listarId(id);
		if (objAsesor == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/asesor/listar";
		} else {
			model.addAttribute("listaEspecialidades", cService.listar());
			if (objAsesor.isPresent())
				objAsesor.ifPresent(t -> model.addAttribute("asesor", t));
			return "asesor";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				tService.eliminar(id);
				model.put("listaAsesores", tService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Sucedio un error");
			model.put("listaAsesores", tService.listar());
		}
		return "listAsesor";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaAsesores", tService.listar());
		return "listAsesor";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute Asesor asesor) throws ParseException {
		tService.listarId(asesor.getCAsesor());
		return "listAsesor";
	}

	@RequestMapping("/find")
	public String findByNnombre(Map<String, Object> model, @ModelAttribute Asesor asesor) throws ParseException {
		List<Asesor> listaAsesor;
		asesor.setNnombre(asesor.getNnombre());
		listaAsesor = tService.findByNnombre(asesor.getNnombre());

		if (listaAsesor.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaAsesores", listaAsesor );
		return "listAsesor";
	}
	
	@ModelAttribute("asesoria")
	public Asesor createModel() {
	    return new Asesor();
	}
}
