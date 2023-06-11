package com.app.web.usuarioregistro;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Clase que representa una autoridad o rol que puede ser asignado a un usuario.
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */
@Entity(name = "autorities")
public class Authority implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(EnumType.STRING)
	private AuthorityName name;

	/**
     * Crea una nueva instancia de la clase Authority con el nombre especificado.
     * @param name el nombre de la autoridad
     */
    public Authority(AuthorityName name) {
        this.name = name;
    }

    /**
     * Crea una nueva instancia de la clase Authority.
     * Este constructor se utiliza en caso de que se necesite crear una instancia sin especificar el nombre de la autoridad.
     */
    public Authority() {
    }

    /**
     * Obtiene el ID de la autoridad.
     * @return el ID de la autoridad
     */
    public long getId() {
        return id;
    }

    /**
     * Establece el ID de la autoridad.
     * @param id el ID de la autoridad
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la autoridad.
     * @return el nombre de la autoridad
     */
    public AuthorityName getName() {
        return name;
    }

    /**
     * Establece el nombre de la autoridad.
     * @param name el nombre de la autoridad
     */
    public void setName(AuthorityName name) {
        this.name = name;
    }
}
