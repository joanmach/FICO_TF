package pe.edu.fico.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.fico.spring.model.Ciudad;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Integer> {
	@Query("from Ciudad c where c.NCiudad like %:NCiudad%")
	List<Ciudad> buscarCiudad(@Param("NCiudad") String NCiudad);
	
	@Query("from Ciudad c where c.pais.NPais like %:NPais%")
	List<Ciudad> buscarPais(@Param("NPais") String NPais);
}
