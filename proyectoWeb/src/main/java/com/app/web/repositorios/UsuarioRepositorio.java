package com.app.web.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.web.entidad.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

}
