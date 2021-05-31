package pe.edu.fico.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.fico.spring.model.Pais;


@Repository
public interface IPaisRepository extends JpaRepository<Pais, Integer>{
	@Query("from Pais p where p.NPais like %:NPais%")
	List<Pais> buscarNombre(@Param("NPais") String NPais);
}
