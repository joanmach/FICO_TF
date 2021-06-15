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
import pe.edu.fico.spring.service.IClienteService;
import pe.edu.fico.spring.model.Ciudad;
import pe.edu.fico.spring.service.ICiudadService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private IClienteService clService;

	@Autowired
	private ICiudadService cService;


	@RequestMapping("/")
	public String irUsuario(Map<String, Object> model) {
		model.put("listaClientes", clService.listar());
		return "listCliente";
	}
	
	@RequestMapping("/bienvenido")
	public String irClienteBienvenido() {
		return "bienvenido";
	}
	
	@RequestMapping("/bienvenidoc")
	public String irClienteBienvenidoc() {
		return "bienvenidoC";
	}
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("listaCiudades", cService.listar());
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("ciudad", new Ciudad());
		return "cliente";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Cliente cliente, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listaCiudades", cService.listar());
			return "cliente";
		} else {
			boolean flag = clService.insertar(cliente);
			if (flag) {
				return "redirect:/cliente/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/cliente/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Cliente> objCliente = clService.listarId(id);
		if (objCliente == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/cliente/listar";
		} else {
			model.addAttribute("listaCiudades", cService.listar());
			if (objCliente.isPresent())
				objCliente.ifPresent(o -> model.addAttribute("asesor", o));
			return "cliente";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				clService.eliminar(id);
				model.put("listaClientes", clService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Sucedio un error");
			model.put("listaClientes", clService.listar());
		}
		return "listCliente";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaClientes", clService.listar());
		return "listCliente";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute Cliente cliente) throws ParseException {
		clService.listarId(cliente.getCCliente());
		return "listCliente";
	}

	@RequestMapping("/find")
	public String findByNNombre(Map<String, Object> model, @ModelAttribute Cliente cliente) throws ParseException {
		List<Cliente> listaCliente;
		cliente.setNNombre(cliente.getNNombre());
		listaCliente = clService.findByNNombre(cliente.getNNombre());

		if (listaCliente.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaClientes", listaCliente );
		return "listCliente";
	}
}
