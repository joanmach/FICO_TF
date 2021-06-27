package pe.edu.fico.spring.repository;


import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.fico.spring.model.Horario;

@Repository
public interface IHorarioRepository extends JpaRepository<Horario, Integer> {

	@Query("select count (*) from Horario h where h.FechaInicio = :FechaInicio and h.FechaFin = :FechaFin and h.HoraInicio = :HoraInicio and h.HoraFin = :HoraFin")
	int duplicidadHorario(@Param("FechaInicio") Date FechaInicio,@Param("FechaFin") Date FechaFin,@Param("HoraInicio") Date HoraInicio,@Param("HoraFin") Date HoraFin);
}