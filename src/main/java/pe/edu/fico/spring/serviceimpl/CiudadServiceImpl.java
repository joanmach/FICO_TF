package pe.edu.fico.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.fico.spring.model.Ciudad;
import pe.edu.fico.spring.repository.ICiudadRepository;
import pe.edu.fico.spring.service.ICiudadService;

@Service
public class CiudadServiceImpl implements ICiudadService{

	@Autowired
	private ICiudadRepository dCiudad;

	@Override
	public boolean insertar(Ciudad ciudad) {
		Ciudad objCiudad = dCiudad.save(ciudad);
		if(objCiudad != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean modificar(Ciudad ciudad) {
		boolean flag = false;
		try {
			dCiudad.save(ciudad);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	public void eliminar(int CCiudad) {
		dCiudad.deleteById(CCiudad);
		
	}

	@Override
	public Optional<Ciudad> listarId(int CCiudad) {
		return dCiudad.findById(CCiudad);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Ciudad> listar() {
		return dCiudad.findAll();
	}

	@Override
	public List<Ciudad> findByNCiudad(String NCiudad) {
		return dCiudad.buscarCiudad(NCiudad);
	} 
	
	
}