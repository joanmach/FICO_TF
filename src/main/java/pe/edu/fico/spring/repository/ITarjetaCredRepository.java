package pe.edu.fico.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.fico.spring.model.TarjetaCred;

@Repository
public interface ITarjetaCredRepository extends JpaRepository<TarjetaCred, Integer> {

	List<TarjetaCred> findByNumTarjeta(String numTarjeta);
}
