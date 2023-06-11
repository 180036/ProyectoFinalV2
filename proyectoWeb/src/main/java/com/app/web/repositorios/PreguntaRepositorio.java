package com.app.web.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.web.entidad.Pregunta;

public interface PreguntaRepositorio extends JpaRepository<Pregunta, Long>{

}
