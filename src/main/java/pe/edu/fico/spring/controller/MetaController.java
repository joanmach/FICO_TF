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

import pe.edu.fico.spring.model.Cliente;
import pe.edu.fico.spring.model.Meta;
import pe.edu.fico.spring.service.IClienteService;
import pe.edu.fico.spring.service.IMetaService;

@Controller
@RequestMapping("/meta")
public class MetaController {

	@Autowired
	private IMetaService mService;
	
	@Autowired
	private IClienteService cService;

	@RequestMapping("/")
	public String irMeta(Map<String, Object> model) {
		model.put("listaMetas", mService.listar());
		return "listMeta";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("listaClientes", cService.listar());
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("meta", new Meta());
		return "meta";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Meta meta, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			return "meta";
		} else {
			boolean flag = mService.insertar(meta);
			if (flag) {
				return "redirect:/meta/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/meta/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Meta> objMeta = mService.listarId(id);
		if (objMeta == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/meta/listar";
		} else {
			model.addAttribute("listaClientes", cService.listar());
			if (objMeta.isPresent())
				objMeta.ifPresent(o -> model.addAttribute("meta", o));
			return "meta";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				mService.eliminar(id);
				model.put("listaMetas", mService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Sucedio un error");
			model.put("listaMetas", mService.listar());
		}
		return "listMeta";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaMetas", mService.listar());
		return "listMeta";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute Meta meta) throws ParseException {
		mService.listarId(meta.getCMeta());
		return "listMeta";
	}
	
	@RequestMapping("/find")
	public String findByNMeta(Map<String, Object> model, @ModelAttribute Meta meta) throws ParseException {
		List<Meta> listaMeta;
		meta.setNMeta(meta.getNMeta());
		listaMeta = mService.findByNMeta(meta.getNMeta());

		if (listaMeta.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaMetas", listaMeta );
		return "listMeta";
	}
	
	@ModelAttribute("especialidad")
	public Meta createModel() {
	    return new Meta();
	}
}