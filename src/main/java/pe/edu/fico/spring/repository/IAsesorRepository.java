package pe.edu.fico.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.fico.spring.model.Asesor;

@Repository
public interface IAsesorRepository extends JpaRepository<Asesor,Integer>{
	
	List<Asesor> findByNnombre(String Nnombre);
}
