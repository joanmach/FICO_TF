package pe.edu.fico.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.fico.spring.auth.handler.LoginSuccessHandler;
import pe.edu.fico.spring.serviceimpl.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginSuccessHandler successHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		try {
			http.authorizeRequests()
			.antMatchers("/cliente/**").access("hasRole('ROLE_CLIENTE') or hasRole('ROLE_ADMIN')")
			.antMatchers("/ciudad/**").access("hasRole('ROLE_CLIENTE') or hasRole('ROLE_ADMIN')")
			.antMatchers("/pais/**").access("hasRole('ROLE_CLIENTE') or hasRole('ROLE_ADMIN')")
			.antMatchers("/entidad/**").access("hasRole('ROLE_CLIENTE') or hasRole('ROLE_ADMIN')")
			.antMatchers("/ttarjeta/**").access("hasRole('ROLE_CLIENTE') or hasRole('ROLE_ADMIN')")
			.antMatchers("/tarjeta/**").access("hasRole('ROLE_CLIENTE') or hasRole('ROLE_ADMIN')")
			.antMatchers("/meta/**").access("hasRole('ROLE_CLIENTE') or hasRole('ROLE_ADMIN')")
			.antMatchers("/reserva/**").access("hasRole('ROLE_CLIENTE') or hasRole('ROLE_ADMIN')")
			.antMatchers("/asesor/**").access("hasRole('ROLE_ASESOR') or hasRole('ROLE_ADMIN')")
			.antMatchers("/asesoria/listarc").access("hasRole('ROLE_CLIENTE') or hasRole('ROLE_ADMIN')")
			.antMatchers("/asesoria/**").access("hasRole('ROLE_ASESOR') or hasRole('ROLE_ADMIN')")
			.antMatchers("/horario/**").access("hasRole('ROLE_ASESOR') or hasRole('ROLE_CLIENTE') or hasRole('ROLE_ADMIN')")
			.antMatchers("/welcome/bienvenido").permitAll()
			.antMatchers("/welcome/ingreso").permitAll()
			.antMatchers("/welcome/bienvenidoAdmin").access("hasRole('ROLE_ADMIN')").and()
			.formLogin().successHandler(successHandler).loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/welcome/bienvenido")
			.permitAll().and().logout().logoutSuccessUrl("/login").permitAll().and().exceptionHandling().accessDeniedPage("/error_403");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
}
