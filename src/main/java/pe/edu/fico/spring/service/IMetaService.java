package pe.edu.fico.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.fico.spring.model.Meta;

public interface IMetaService {
	
	public boolean insertar(Meta meta);
	public boolean modificar(Meta meta);
	public void eliminar(int CMeta);
	public Optional<Meta> listarId(int CMeta);
	List<Meta> listar();
	List<Meta> findByNMeta(String NMeta);
}
