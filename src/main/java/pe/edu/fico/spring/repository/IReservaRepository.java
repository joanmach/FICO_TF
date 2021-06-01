package pe.edu.fico.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.fico.spring.model.Reserva;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Integer> {

}
