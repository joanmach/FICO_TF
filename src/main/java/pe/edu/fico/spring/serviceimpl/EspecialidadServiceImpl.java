package pe.edu.fico.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.fico.spring.model.Especialidad;
import pe.edu.fico.spring.repository.IEspecialidadRepository;
import pe.edu.fico.spring.service.IEspecialidadService;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService{
	
	@Autowired
	private IEspecialidadRepository dEspecialidad;

	@Override
	@Transactional
	public boolean insertar(Especialidad especialidad) {
		// TODO Auto-generated method stub
		Especialidad objEspecialidad = dEspecialidad.save(especialidad);
		if(objEspecialidad == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Especialidad especialidad) {
		boolean flag = false;
		try {
			dEspecialidad.save(especialidad);
			flag = true;
		}catch(Exception ex){
			System.out.println("Sucedio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int CEspecialidad) {
		// TODO Auto-generated method stub
		dEspecialidad.deleteById(CEspecialidad);
	}

	@Override
	@Transactional
	public Optional<Especialidad> listarId(int CEspecialidad) {
		// TODO Auto-generated method stub
		return dEspecialidad.findById(CEspecialidad);
	}

	@Override
	@Transactional
	public List<Especialidad> listar() {
		// TODO Auto-generated method stub
		return dEspecialidad.findAll();
	}

	@Override
	@Transactional
	public List<Especialidad> findByNEspecialidad(String NEspecialidad) {
		// TODO Auto-generated method stub
		return dEspecialidad.findByNEspecialidad(NEspecialidad);
	}
	
}