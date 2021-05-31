package pe.edu.fico.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.fico.spring.model.EntidadBancaria;

@Repository
public interface IEntidadBancariaRepository extends JpaRepository<EntidadBancaria,Integer>{
	
	List<EntidadBancaria> findByNEntidad(String NEntidad);
}
