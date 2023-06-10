package com.app.web.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Clase de configuración para la seguridad del sistema.
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */
@Configuration
public class SecurityConfig {
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		var user= User.withUsername("alejandro")
//				.password("password123")
//				.roles("read")
//				.build(); 
//		
//		
//		return new InMemoryUserDetailsManager(user);
//	}
	
	/**
	 * Configura el codificador de contraseñas a utilizar.
	 *
	 * @return El codificador de contraseñas BCryptPasswordEncoder.
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
