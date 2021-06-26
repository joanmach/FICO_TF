package pe.edu.fico.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.fico.spring.model.Cliente;
@Repository
public interface IClienteRepository extends JpaRepository<Cliente,Integer>{
	
	List<Cliente> findByNNombre(String NNombre);
	
	@Query("select count (*) from Cliente c where c.NDNI = NDNI")
	int buscarDNI(@Param("NDNI") int NDNI);
}
