package pe.edu.fico.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.fico.spring.model.Especialidad;

@Repository
public interface IEspecialidadRepository extends JpaRepository<Especialidad, Integer> {

	List<Especialidad> findByNEspecialidad(String NEspecialidad);
}