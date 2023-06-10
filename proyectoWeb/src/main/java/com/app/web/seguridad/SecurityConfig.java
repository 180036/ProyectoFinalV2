package com.app.web.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Clase de configuración para la seguridad del sistema.
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */
@Configuration
@EnableWebSecurity
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
