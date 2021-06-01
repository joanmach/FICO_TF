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

import pe.edu.fico.spring.model.Reserva;
import pe.edu.fico.spring.model.Asesoria;
import pe.edu.fico.spring.model.Cliente;
import pe.edu.fico.spring.model.Horario;

import pe.edu.fico.spring.service.IReservaService;
import pe.edu.fico.spring.service.IAsesoriaService;
import pe.edu.fico.spring.service.IClienteService;
import pe.edu.fico.spring.service.IHorarioService;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	private IReservaService rService;

	@Autowired
	private IAsesoriaService aService;

	@Autowired
	private IClienteService cService;

	@Autowired
	private IHorarioService hService;

	@RequestMapping("/")
	public String irReserva(Map<String, Object> model) {
		model.put("listaReservas", rService.listar());
		return "listReserva";
	}
	

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("listaAsesorias", aService.listar());
		model.addAttribute("listaClientes", cService.listar());
		model.addAttribute("listaHorarios", hService.listar());
		model.addAttribute("reserva", new Reserva());
		model.addAttribute("asesoria", new Asesoria());
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("horario", new Horario());
		return "reserva";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Reserva reserva, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listaAsesorias", aService.listar());
			model.addAttribute("listaClientes", cService.listar());
			model.addAttribute("listaHorarios", hService.listar());
			return "reserva";
		} else {
			boolean flag = rService.insertar(reserva);
			if (flag) {
				return "redirect:/reserva/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/reserva/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Reserva> objReserva = rService.listarId(id);
		if (objReserva == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/reserva/listar";
		} else {
			model.addAttribute("listaAsesorias", aService.listar());
			model.addAttribute("listaClientes", cService.listar());
			model.addAttribute("listaHorarios", hService.listar());
			if (objReserva.isPresent())
				objReserva.ifPresent(r -> model.addAttribute("reserva", r));
			return "reserva";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				rService.eliminar(id);
				model.put("listaReservas", rService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Sucedio un error");
			model.put("listaReservas", rService.listar());
		}
		return "listReserva";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaReservas", rService.listar());
		return "listReserva";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute Reserva reserva) throws ParseException {
		rService.listarId(reserva.getCReserva());
		return "listReserva";
	}

	/*@RequestMapping("/find")
	public String findByNumTarjeta(Map<String, Object> model, @ModelAttribute TarjetaCred tarjeta) throws ParseException {
		List<TarjetaCred> listaTarjeta;
		tarjeta.setNumTarjeta(tarjeta.getNumTarjeta());
		listaTarjeta = tService.findByNumTarjeta(tarjeta.getNumTarjeta());

		if (listaTarjeta.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaTarjetas", listaTarjeta );
		return "listTarjeta";
	}
	*/
	
	@ModelAttribute("reserva")
	public Reserva createModel() {
	    return new Reserva();
	}
}
