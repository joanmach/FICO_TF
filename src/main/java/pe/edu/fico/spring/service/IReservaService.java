package pe.edu.fico.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.fico.spring.model.Reserva;

public interface IReservaService {
	
	public boolean insertar(Reserva reserva);
	public boolean modificar(Reserva reserva);
	public void eliminar(int CReserva);
	public Optional<Reserva> listarId(int CReserva);
	List<Reserva> listar();
}
