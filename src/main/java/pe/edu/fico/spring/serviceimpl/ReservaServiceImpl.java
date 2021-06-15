package pe.edu.fico.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.fico.spring.model.Reserva;
import pe.edu.fico.spring.repository.IReservaRepository;
import pe.edu.fico.spring.service.IReservaService;

@Service
public class ReservaServiceImpl implements IReservaService{

	@Autowired
	private IReservaRepository dRe; 
	
	@Override
	@Transactional
	public boolean insertar(Reserva re) {
		Reserva objRe = dRe.save(re);
		if(objRe == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Reserva re) {
		boolean flag= false;
		try {
			dRe.save(re);
			flag = true;
			
		} catch(Exception ex){
			System.out.println("Sucedio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int CReserva) {
		dRe.deleteById(CReserva);		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Reserva> listarId(int CReserva) {
		return dRe.findById(CReserva);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reserva> listar() {
		return dRe.findAll();
	}

}