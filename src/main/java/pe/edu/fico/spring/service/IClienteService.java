package pe.edu.fico.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.fico.spring.model.Cliente;

public interface IClienteService {
	
	public boolean insertar(Cliente cliente);
	public boolean modificar(Cliente cliente);
	public void eliminar(int CCliente);
	public Optional<Cliente> listarId(int CCliente);
	List<Cliente> listar();
	List<Cliente> findByNNombre(String NNombre);
}