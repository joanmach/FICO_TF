package pe.edu.fico.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.fico.spring.model.Meta;
import pe.edu.fico.spring.repository.IMetaRepository;
import pe.edu.fico.spring.service.IMetaService;

@Service
public class MetaServiceImpl implements IMetaService{
	
	@Autowired
	private IMetaRepository dMeta;

	@Override
	@Transactional
	public boolean insertar(Meta meta) {
		// TODO Auto-generated method stub
		Meta objMeta = dMeta.save(meta);
		if(objMeta == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Meta meta) {
		boolean flag = false;
		try {
			dMeta.save(meta);
			flag = true;
		}catch(Exception ex){
			System.out.println("Sucedio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int CMeta) {
		// TODO Auto-generated method stub
		dMeta.deleteById(CMeta);
	}

	@Override
	@Transactional
	public Optional<Meta> listarId(int CMeta) {
		// TODO Auto-generated method stub
		return dMeta.findById(CMeta);
	}

	@Override
	@Transactional
	public List<Meta> listar() {
		// TODO Auto-generated method stub
		return dMeta.findAll();
	}

	@Override
	@Transactional
	public List<Meta> findByNMeta(String NMeta) {
		// TODO Auto-generated method stub
		return dMeta.findByNMeta(NMeta);
	}
	
}