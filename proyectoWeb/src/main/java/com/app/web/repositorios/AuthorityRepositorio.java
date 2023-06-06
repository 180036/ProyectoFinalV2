package com.app.web.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.web.usuarioregistro.Authority;
import com.app.web.usuarioregistro.AuthorityName;

public interface AuthorityRepositorio extends JpaRepository<Authority, Long>{
	Optional<Authority> findByName(AuthorityName name);

}
