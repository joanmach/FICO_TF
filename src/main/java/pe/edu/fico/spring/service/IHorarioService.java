package pe.edu.fico.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.fico.spring.model.Horario;

public interface IHorarioService {
	
	public boolean insertar(Horario horario);
	public boolean modificar(Horario horario);
	public void eliminar(int CHorario);
	public Optional<Horario> listarId(int CHorario);
	List<Horario> listar();
}
