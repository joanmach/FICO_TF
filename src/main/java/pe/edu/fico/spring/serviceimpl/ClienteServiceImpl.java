package pe.edu.fico.spring.serviceimpl;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.edu.fico.spring.model.Cliente;
import pe.edu.fico.spring.repository.IClienteRepository;
import pe.edu.fico.spring.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{
	

	
	@Autowired
	private IClienteRepository dCliente;
		
	@Override
	@Transactional
	public boolean insertar(Cliente cliente) {
		
		Cliente objCliente = dCliente.save(cliente);
		if(objCliente != null)
			return true;
		else
			return false;
			
	
	}

	@Override
	@Transactional
	public boolean modificar(Cliente cliente) {
		boolean flag = false;
		try {
			dCliente.save(cliente);
			flag = true;
		}catch(Exception ex){
			System.out.println("ERROR");
		}
		return flag;
	}

	@Override
	public void eliminar(int CCliente) {
		dCliente.deleteById(CCliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> listarId(int CCliente) {
		return dCliente.findById(CCliente);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> listar() {
		return dCliente.findAll();
	}

	@Override
	@Transactional
	public List<Cliente> findByNNombre(String NNombre) {
		return dCliente.findByNNombre(NNombre);
	}
	
}