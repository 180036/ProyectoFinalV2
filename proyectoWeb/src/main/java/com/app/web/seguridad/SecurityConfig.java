package com.app.web.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatchers;

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
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		/*http.authorizeHttpRequests()
		.requestMatchers("/admin").authenticated(). //para entrar a admin => autenticado
		anyRequest().permitAll();
		
		http.formLogin().
		loginPage("/miLogin").
		loginProcessingUrl("/miLogin").
		defaultSuccessUrl("/").
		permitAll();
		
		//http.formLogin();
		http.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout") // Página a la que se redirige después del logout exitoso
        .permitAll();;*/
		
		
		/* http.authorizeRequests()
         .anyRequest().authenticated().formLogin().loginPage("/login").usernameParameter("email").permitAll();
         http.logout().permitAll();*/
		
		
		http.authorizeRequests().
		requestMatchers("/cajas").permitAll().requestMatchers("**.css","/img/**.png","/img/**.jpg","/img/chest-colaborator-1/**.jpg","/img/chest-colaborator-1/**.png",
				"/img/chest-colaborator-2/**.png","/img/chest-event-1/**.png", "/img/chest-event-2/**.png","/img/chest-event-3/**.png","/img/colaborators/**.jpg",
				"/img/eventos/**.jpg", "/img/payment/**.png","**.js","**.html").permitAll().requestMatchers("/").permitAll().requestMatchers("/FAQ").permitAll().
		requestMatchers("/guardarUsuario").permitAll().requestMatchers(HttpMethod.POST,"/guardarUser").permitAll()
            .anyRequest().authenticated() 
            .and()
        .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/index").permitAll();
            
		
        http.logout()
            .logoutUrl("/logout") 
            .logoutSuccessUrl("/login?logout") 
            .permitAll();
		http.csrf().disable();
		
		return http.build();
	}
	

}
