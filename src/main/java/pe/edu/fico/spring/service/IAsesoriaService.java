package pe.edu.fico.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.fico.spring.model.Asesoria;

public interface IAsesoriaService {
	
	public boolean insertar(Asesoria asesoria);
	public boolean modificar(Asesoria asesoria);
	public void eliminar(int CAsesoria);
	public Optional<Asesoria> listarId(int CAsesoria);
	List<Asesoria> listar();
	List<Asesoria> findByNAsesoria(String NAsesoria);
}