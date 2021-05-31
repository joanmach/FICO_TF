package pe.edu.fico.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.fico.spring.model.Asesoria;

@Repository
public interface IAsesoriaRepository extends JpaRepository<Asesoria, Integer> {

	List<Asesoria> findByNAsesoria(String NAsesoria);
}