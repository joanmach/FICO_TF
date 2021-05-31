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

import pe.edu.fico.spring.model.Especialidad;
import pe.edu.fico.spring.service.IEspecialidadService;

@Controller
@RequestMapping("/especialidad")
public class EspecialidadController {

	@Autowired
	private IEspecialidadService eService;

	@RequestMapping("/")
	public String irEspecialidad(Map<String, Object> model) {
		model.put("listaEspecialidades", eService.listar());
		return "listEspecialidad";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("especialidad", new Especialidad());
		return "especialidad";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Especialidad especialidad, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			return "especialidad";
		} else {
			boolean flag = eService.insertar(especialidad);
			if (flag) {
				return "redirect:/especialidad/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/especialidad/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Especialidad> objEspecialidad = eService.listarId(id);
		if (objEspecialidad == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/especialidad/listar";
		} else {
			model.addAttribute("especialidad", objEspecialidad);
			return "especialidad";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				eService.eliminar(id);
				model.put("listaEspecialidades", eService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Sucedio un error");
			model.put("listaEspecialidades", eService.listar());
		}
		return "listEspecialidad";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaEspecialidades", eService.listar());
		return "listEspecialidad";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute Especialidad especialidad) throws ParseException {
		eService.listarId(especialidad.getCEspecialidad());
		return "listEspecialidad";
	}
	
	@RequestMapping("/find")
	public String findByNEspecialidad(Map<String, Object> model, @ModelAttribute Especialidad especialidad) throws ParseException {
		List<Especialidad> listaEspecialidad;
		especialidad.setNEspecialidad(especialidad.getNEspecialidad());
		listaEspecialidad = eService.findByNEspecialidad(especialidad.getNEspecialidad());

		if (listaEspecialidad.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaEspecialidades", listaEspecialidad );
		return "listEspecialidad";
	}
	
	@ModelAttribute("especialidad")
	public Especialidad createModel() {
	    return new Especialidad();
	}
}