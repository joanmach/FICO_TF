package pe.edu.fico.spring.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.fico.spring.model.Pais;
import pe.edu.fico.spring.repository.IPaisRepository;
import pe.edu.fico.spring.service.IPaisService;

@Service
public class PaisServiceImpl implements IPaisService{
	
	@Autowired
	private IPaisRepository dPais;

	@Override
	public boolean insertar(Pais pais) {
		Pais objPais=dPais.save(pais);
		if(objPais == null)
			return false;
		else
			return true;
	}

	@Override
	public boolean modificar(Pais pais) {
		boolean flag = false;
		try {
			dPais.save(pais);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("ERROR");
		}
		return flag;
	}

	@Override
	public void eliminar(int CPais) {
		dPais.deleteById(CPais);		
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Pais> listarId(int CPais) {
		return dPais.findById(CPais);
	}

	@Override
	public List<Pais> listar() {
		return dPais.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Pais> findByNPais(String NPais) {
		return dPais.buscarNombre(NPais);
	}


	
}
