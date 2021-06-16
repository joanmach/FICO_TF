package pe.edu.fico.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.fico.spring.model.Users;

@Repository
public interface iUsuarioRepository extends JpaRepository<Users, Long>{
	public Users findByUsername(String username);
}
