package pe.edu.fico.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.fico.spring.model.Horario;
import pe.edu.fico.spring.repository.IHorarioRepository;
import pe.edu.fico.spring.service.IHorarioService;

@Service
public class HorarioServiceImpl implements IHorarioService{
	
	@Autowired
	private IHorarioRepository dHorario;

	@Override
	@Transactional
	public boolean insertar(Horario horario) {
		
		Horario objHorario = dHorario.save(horario);
		if(objHorario == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Horario horario) {
		boolean flag = false;
		try {
			dHorario.save(horario);
			flag = true;
		}catch(Exception ex){
			System.out.println("Sucedio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int CHorario) {
		
		dHorario.deleteById(CHorario);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Horario> listarId(int CHorario) {
		
		return dHorario.findById(CHorario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Horario> listar() {
	
		return dHorario.findAll();
	}
	
}