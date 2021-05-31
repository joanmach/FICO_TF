package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.spring.model.Pet;
import pe.edu.upc.spring.repository.IPetRepository;
import pe.edu.upc.spring.service.IPetService;

@Service
public class PerServiceImpl implements IPetService{

	@Autowired
	private IPetRepository dPet;
	
	@Override
	@Transactional
	public boolean insertar(Pet pet) {
		
		Pet objPet = dPet.save(pet);
		if(objPet!=null)
			return true;
			else
				return false;
		
		
		
	}

	@Override
	@Transactional
	public boolean modificar(Pet pet) {
		boolean flag=false;
		try {
			dPet.save(pet);
			flag=true;			
		}
		catch(Exception ex) {
			System.out.println("Sucedio un roche...");
		}
		return flag;
	}

	@Override
	public void eliminar(int idPet) {
		// TODO Auto-generated method stub
		dPet.deleteById(idPet);
	}

	@Override
	public Optional<Pet> buscarId(int idPet) {
		// TODO Auto-generated method stub
		return dPet.findById(idPet);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pet> listarId(int idPet) {
		// TODO Auto-generated method stub
		return dPet.findById(idPet);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pet> listar() {
		// TODO Auto-generated method stub
		return dPet.findAll();
	}

	@Override
	@Transactional
	public List<Pet> buscarNombre(String namePet) {
		// TODO Auto-generated method stub
		return dPet.buscarNombre(namePet);
	}

	@Override
	@Transactional
	public List<Pet> buscarRaza(String nameRace) {
		// TODO Auto-generated method stub
		return dPet.buscarRaza(nameRace);
	}

	@Override
	@Transactional
	public List<Pet> buscarPropietario(String nameDueno) {
		// TODO Auto-generated method stub
		return dPet.buscarPropietario(nameDueno);
	}

}
