package com.app.web.repositorios;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.web.usuarioregistro.Authority;
import com.app.web.usuarioregistro.AuthorityName;
import com.app.web.usuarioregistro.User;
/**
 * Esta clase defina la interfaz para el uso de los métodos que existen en el JPA.
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */
public interface UserRepository extends JpaRepository<User, Long>{
	/**
	 * Busca el usuario por su nombre.
	 * 
	 * @param username
	 * @return
	 */
	Optional<User> findByName(String username);
}
