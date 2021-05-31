package pe.edu.fico.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.fico.spring.model.Pais;

public interface IPaisService {
	
	public boolean insertar(Pais pais);
	public boolean modificar(Pais pais);
	public void eliminar(int CPais);
	public Optional<Pais> listarId(int CPais);
	List<Pais> listar();
	List<Pais> findByNPais(String NPais);
}
