package pe.edu.fico.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.fico.spring.model.Asesor;
import pe.edu.fico.spring.repository.IAsesorRepository;
import pe.edu.fico.spring.service.IAsesorService;

@Service
public class AsesorServiceImpl implements IAsesorService{
	
	@Autowired
	private IAsesorRepository dAsesor;

	@Override
	@Transactional
	public boolean insertar(Asesor asesor) {
		// TODO Auto-generated method stub
		Asesor objAsesor = dAsesor.save(asesor);
		if(objAsesor == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Asesor asesor) {
		boolean flag = false;
		try {
			dAsesor.save(asesor);
			flag = true;
		}catch(Exception ex){
			System.out.println("Sucedio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int CAsesor) {
		// TODO Auto-generated method stub
		dAsesor.deleteById(CAsesor);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Asesor> listarId(int CAsesor) {
		// TODO Auto-generated method stub
		return dAsesor.findById(CAsesor);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asesor> listar() {
		// TODO Auto-generated method stub
		return dAsesor.findAll();
	}

	@Override
	@Transactional
	public List<Asesor> findByNnombre(String Nnombre) {
		// TODO Auto-generated method stub
		return dAsesor.findByNnombre(Nnombre);
	}
	
}