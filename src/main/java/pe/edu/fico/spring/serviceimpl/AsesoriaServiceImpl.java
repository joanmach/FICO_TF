package pe.edu.fico.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.fico.spring.model.Asesoria;
import pe.edu.fico.spring.repository.IAsesoriaRepository;
import pe.edu.fico.spring.service.IAsesoriaService;

@Service
public class AsesoriaServiceImpl implements IAsesoriaService{

	@Autowired
	private IAsesoriaRepository dAsesoria; 
	
	@Override
	@Transactional
	public boolean insertar(Asesoria asesoria) {
		if(asesoria.getMPrecio()>0) {
		Asesoria objAsesoria = dAsesoria.save(asesoria);
		if(objAsesoria == null)
			return false;
		else
			return true;
		}
		else
			System.out.println("Invalid Value");
			return false;
	}

	@Override
	@Transactional
	public boolean modificar(Asesoria asesoria) {
		boolean flag= false;
		try {
			dAsesoria.save(asesoria);
			flag = true;
			
		} catch(Exception ex){
			System.out.println("Sucedio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int CAsesoria) {
		dAsesoria.deleteById(CAsesoria);		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Asesoria> listarId(int CAsesoria) {
		return dAsesoria.findById(CAsesoria);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asesoria> listar() {
		return dAsesoria.findAll();
	}

	@Override
	@Transactional
	public List<Asesoria> findByNAsesoria(String NAsesoria) {		
		return dAsesoria.findByNAsesoria(NAsesoria);
	}
}