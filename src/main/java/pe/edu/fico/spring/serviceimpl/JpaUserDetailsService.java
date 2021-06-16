package pe.edu.fico.spring.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.fico.spring.model.Role;
import pe.edu.fico.spring.model.Cliente;
import pe.edu.fico.spring.repository.IAsesorRepository;
import pe.edu.fico.spring.repository.IClienteRepository;
import pe.edu.fico.spring.model.Asesor;


@Service
public class JpaUserDetailsService implements UserDetailsService{

	@Autowired
	private IClienteRepository clienteRepository;
	
	@Autowired
	private IAsesorRepository asesorRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String TCorreo) throws UsernameNotFoundException {
		Cliente cliente = clienteRepository.findByCorreo(TCorreo);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(Role role: cliente.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		
		return new User(cliente.getTCorreo(), cliente.getTContraseña(), cliente.getEnabled(), true, true, true, authorities);
	}
	
//	@Override
//	@Transactional(readOnly = true)
//	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
//		Asesor asesor = asesorRepository.findByCorreo(correo);
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		
//		for(Role role: usuario.getRoles()) {
//			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
//		}
//		
//		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
//	}
	
	
}
