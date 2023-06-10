package com.app.web.entidad;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Esta clase define el objeto que hace referencia al ModeloArma.
 * Las cuales ya estan metidas en la base de datos de manera automatica, puesto que siempre son los mismos.
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */
@Entity
@Table(name="tipomodeloarma")
public class ModeloArma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	@Column(name = "nombre", nullable = false)
	private String nombre;

	/**
     * Crea una nueva instancia de ModeloArma con el nombre especificado.
     *
     * @param nombre El nombre del modelo.
     */
    public ModeloArma(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Crea una nueva instancia de ModeloArma.
     */
    public ModeloArma() {}

    /**
     * Obtiene el identificador del modelo.
     *
     * @return El identificador del modelo.
     */
    public long getId() {
        return id;
    }

    /**
     * Establece el identificador del modelo.
     *
     * @param id El identificador del modelo.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del modelo.
     *
     * @return El nombre del modelo.
     */
    public String getModelo() {
        return nombre;
    }

    /**
     * Establece el nombre del modelo.
     *
     * @param nombre El nombre del modelo.
     */
    public void setModelo(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Devuelve una representación en cadena de la instancia ModeloArma.
     *
     * @return Una representación en cadena de la instancia ModeloArma.
     */
    @Override
	public String toString() {
		return "ModeloArma [id=" + id + ", nombre=" + nombre + "]";
	}



	
}
