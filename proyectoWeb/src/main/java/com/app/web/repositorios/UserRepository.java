package com.app.web.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.web.usuarioregistro.Authority;
import com.app.web.usuarioregistro.AuthorityName;
import com.app.web.usuarioregistro.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByName(String username);
}
