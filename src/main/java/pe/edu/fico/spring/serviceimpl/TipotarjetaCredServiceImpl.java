package pe.edu.fico.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.fico.spring.model.TipotarjetaCred;
import pe.edu.fico.spring.repository.ITipoTarjetaCredRepository;
import pe.edu.fico.spring.service.ITipotarjetaCredService;

@Service
public class TipotarjetaCredServiceImpl implements ITipotarjetaCredService{
	
	@Autowired
	private ITipoTarjetaCredRepository dTTarjeta;

	@Override
	@Transactional
	public boolean insertar(TipotarjetaCred ttarjeta) {
		// TODO Auto-generated method stub
		TipotarjetaCred objTTarjeta = dTTarjeta.save(ttarjeta);
		if(objTTarjeta == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(TipotarjetaCred ttarjeta) {
		boolean flag = false;
		try {
			dTTarjeta.save(ttarjeta);
			flag = true;
		}catch(Exception ex){
			System.out.println("Sucedio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int CTTarjeta) {
		// TODO Auto-generated method stub
		dTTarjeta.deleteById(CTTarjeta);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TipotarjetaCred> listarId(int CTTarjeta) {
		// TODO Auto-generated method stub
		return dTTarjeta.findById(CTTarjeta);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipotarjetaCred> listar() {
		// TODO Auto-generated method stub
		return dTTarjeta.findAll();
	}

	@Override
	@Transactional
	public List<TipotarjetaCred> findByNTTarjeta(String NTTarjeta) {
		// TODO Auto-generated method stub
		return dTTarjeta.findByNTTarjeta(NTTarjeta);
	}
	
}
