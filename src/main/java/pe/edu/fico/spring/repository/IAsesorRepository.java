package pe.edu.fico.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.fico.spring.model.Asesor;

@Repository
public interface IAsesorRepository extends JpaRepository<Asesor,Integer>{
	@Query("from Asesor a where a.Nnombre like %:Nnombre%")
	List<Asesor> findByNnombre(@Param("Nnombre") String Nnombre);
	
	@Query("select count (*) from Asesor a where a.Ndni= :Ndni")
	int buscarDNI(@Param("Ndni") int Ndni);
	
}
