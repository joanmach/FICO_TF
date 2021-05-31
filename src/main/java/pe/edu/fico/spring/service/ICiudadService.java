package pe.edu.fico.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.fico.spring.model.Ciudad;

public interface ICiudadService {
	
	public boolean insertar(Ciudad ciudad);
	public boolean modificar(Ciudad ciudad);
	public void eliminar(int CCiudad);
	public Optional<Ciudad> listarId(int CCiudad);
	List<Ciudad> listar();
	List<Ciudad> findByNCiudad(String NCiudad);
}
