package pe.edu.fico.spring.controller;

import java.text.ParseException;
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

import pe.edu.fico.spring.model.Horario;
import pe.edu.fico.spring.service.IHorarioService;

@Controller
@RequestMapping("/horario")
public class HorarioController {

	@Autowired
	private IHorarioService hService;

	@RequestMapping("/")
	public String irHorario(Map<String, Object> model) {
		model.put("listaHorarios", hService.listar());
		return "listHorario";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("horario", new Horario());
		return "horario";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Horario horario, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			return "horario";
		} else {
			boolean flag = hService.insertar(horario);
			if (flag) {
				return "redirect:/horario/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/horario/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Horario> objHorario = hService.listarId(id);
		if (objHorario == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/horario/listar";
		} else {
			model.addAttribute("horario", objHorario);
			return "horario";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				hService.eliminar(id);
				model.put("listaHorarios", hService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Sucedio un error");
			model.put("listaHorarios", hService.listar());
		}
		return "listEspecialidad";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaHorarios", hService.listar());
		return "listHorario";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute Horario horario) throws ParseException {
		hService.listarId(horario.getCHorario());
		return "listHorario";
	}
	
	/*@RequestMapping("/find")
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
	
	*/
	
	@ModelAttribute("horario")
	public Horario createModel() {
	    return new Horario();
	}
}