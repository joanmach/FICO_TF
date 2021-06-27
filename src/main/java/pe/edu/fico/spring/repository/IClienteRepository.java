package pe.edu.fico.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.fico.spring.model.Cliente;
@Repository
public interface IClienteRepository extends JpaRepository<Cliente,Integer>{
	
	List<Cliente> findByNNombre(String NNombre);
	
	
}
