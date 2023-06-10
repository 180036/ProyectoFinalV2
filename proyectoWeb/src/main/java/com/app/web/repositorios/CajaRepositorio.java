package com.app.web.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.web.entidad.Caja;
/**
 * Esta clase defina la interfaz para el uso de los métodos que existen en el JPA.
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */
public interface CajaRepositorio extends JpaRepository<Caja, Long>{

}
