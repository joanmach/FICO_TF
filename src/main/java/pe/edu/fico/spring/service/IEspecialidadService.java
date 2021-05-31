package pe.edu.fico.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.fico.spring.model.Especialidad;

public interface IEspecialidadService {
	
	public boolean insertar(Especialidad especialidad);
	public boolean modificar(Especialidad especialidad);
	public void eliminar(int CEspecialidad);
	public Optional<Especialidad> listarId(int CEspecialidad);
	List<Especialidad> listar();
	List<Especialidad> findByNEspecialidad(String NEspecialidad);
}
