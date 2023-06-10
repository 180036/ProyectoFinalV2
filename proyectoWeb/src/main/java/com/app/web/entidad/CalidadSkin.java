package com.app.web.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Esta clase define el objeto que hace referencia a la Calidad de las Skins.
 * Estas ya estan metidas en la base de datos de manera automatica, puesto que siempre son las mismas.
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */

@Entity
@Table(name = "calidadskins")
public class CalidadSkin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;

	
	/**
     * Constructor vacío por defecto de la clase Arma.
     */
    public CalidadSkin() {}

    /**
     * Crea una nueva instancia de CalidadSkin con el nombre especificado.
     *
     * @param nombre El nombre de la calidad de skin.
     */
    public CalidadSkin(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador de la calidad de skin.
     *
     * @return El identificador de la calidad de skin.
     */
    public long getId() {
        return id;
    }

    /**
     * Establece el identificador de la calidad de skin.
     * No seria neceasario puesto que seria Auto-Incremental
     *
     * @param id El identificador de la calidad de skin.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la calidad de skin.
     *
     * @return El nombre de la calidad de skin.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la calidad de skin.
     *
     * @param nombre El nombre de la calidad de skin.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Devuelve una representación en cadena de la instancia CalidadSkin.
     *
     * @return Una representación en cadena de la instancia Arma.
     */
    @Override
    public String toString() {
        return "CalidadSkin [id=" + id + ", nombre=" + nombre + "]";
    }
	
	
	
	
}
