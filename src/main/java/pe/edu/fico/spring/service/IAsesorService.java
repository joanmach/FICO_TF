package pe.edu.fico.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.fico.spring.model.Asesor;

public interface IAsesorService {
	
	public boolean insertar(Asesor asesor);
	public boolean modificar(Asesor asesor);
	public void eliminar(int CAsesor);
	public Optional<Asesor> listarId(int CAsesor);
	List<Asesor> listar();
	List<Asesor> findByNnombre(String Nnombre);
}