package com.app.web.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.web.entidad.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{

}
