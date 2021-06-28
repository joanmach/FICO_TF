package pe.edu.fico.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.fico.spring.model.Reserva;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Integer> {

	@Query("select count (*) from Reserva r where r.horario.CHorario= :CHorario")
	int duplicidadCHorario(@Param("CHorario") int CHorario);
}
