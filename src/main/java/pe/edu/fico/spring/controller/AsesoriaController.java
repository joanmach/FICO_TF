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
import pe.edu.fico.spring.model.Asesoria;
import pe.edu.fico.spring.service.IAsesorService;
import pe.edu.fico.spring.service.IAsesoriaService;

@Controller
@RequestMapping("/asesoria")
public class AsesoriaController {

	@Autowired
	private IAsesoriaService tService;

	@Autowired
	private IAsesorService cService;


	@RequestMapping("/")
	public String irUsuario(Map<String, Object> model) {
		model.put("listaAsesorias", tService.listar());
		return "listAsesoria";
	}
	
	@RequestMapping("/bienvenido")
	public String irAsesoriaBienvenido() {
		return "bienvenido";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("listaAsesores", cService.listar());
		model.addAttribute("asesoria", new Asesoria());
		model.addAttribute("asesor", new Asesor());
		return "asesoria";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Asesoria asesoria, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listaAsesores", cService.listar());
			return "asesoria";
		} else {
			boolean flag = tService.insertar(asesoria);
			if (flag) {
				return "redirect:/asesoria/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/asesoria/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Asesoria> objAsesoria = tService.listarId(id);
		if (objAsesoria == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/asesoria/listar";
		} else {
			model.addAttribute("listaAsesores", cService.listar());
			if (objAsesoria.isPresent())
				objAsesoria.ifPresent(t -> model.addAttribute("asesoria", t));
			return "asesoria";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				tService.eliminar(id);
				model.put("listaAsesorias", tService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Sucedio un error");
			model.put("listaAsesorias", tService.listar());
		}
		return "listAsesoria";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaAsesorias", tService.listar());
		return "listAsesoria";
	}
	@RequestMapping("/listarc")
	public String listarC(Map<String, Object> model) {
		model.put("listaAsesorias", tService.listar());
		return "listAsesoriaC";
	}
	
	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute Asesoria asesoria) throws ParseException {
		tService.listarId(asesoria.getCAsesoria());
		return "listAsesoria";
	}

	@RequestMapping("/find")
	public String findByNAsesoria(Map<String, Object> model, @ModelAttribute Asesoria asesoria) throws ParseException {
		List<Asesoria> listaAsesoria;
		asesoria.setNAsesoria(asesoria.getNAsesoria());
		listaAsesoria = tService.findByNAsesoria(asesoria.getNAsesoria());

		if (listaAsesoria.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaAsesorias", listaAsesoria );
		return "listAsesoria";
	}
	
	@ModelAttribute("asesoria")
	public Asesoria createModel() {
	    return new Asesoria();
	}
}
