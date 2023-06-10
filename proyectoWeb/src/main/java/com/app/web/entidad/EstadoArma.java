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
 * Esta clase define el objeto que hace referencia al Estado del Arma.
 * Las cuales ya estan metidas en la base de datos de manera automatica, puesto que siempre son los mismos.
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */
@Entity
@Table(name="estadoarma")
public class EstadoArma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "estado", nullable = false)
	private String estado;

	 /**
     * Crea una nueva instancia de EstadoArma.
     */
    public EstadoArma() {}

    /**
     * Crea una nueva instancia de EstadoArma con el estado especificado.
     *
     * @param estado El estado del arma.
     */
    public EstadoArma(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el identificador del estado.
     *
     * @return El identificador del estado.
     */
    public long getId() {
        return id;
    }

    /**
     * Establece el identificador del estado.
     * No seria neceasario puesto que seria Auto-Incremental
     *
     * @param id El identificador del estado.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Obtiene el estado.
     *
     * @return El estado.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado.
     *
     * @param estado El estado.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Devuelve una representación en cadena de la instancia EstadoArma.
     *
     * @return Una representación en cadena de la instancia EstadoArma.
     */
    @Override
    public String toString() {
        return "EstadoArma [id=" + id + ", estado=" + estado + "]";
    }

	
	
}
