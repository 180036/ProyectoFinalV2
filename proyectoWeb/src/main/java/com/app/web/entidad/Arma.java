package com.app.web.entidad;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * Esta clase define el objeto que hace referencia al Arma, las cuales ya estan metidas en la base de datos de manera
 * automatica, puesto que siempre son las mismas.
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */
@Entity
@Table(name = "armas")
public class Arma {

	 //Campos de la clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nombre", nullable = false, unique= true)
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "modelo", nullable = false)
	private ModeloArma ma;
	
	@OneToMany(mappedBy = "arma")
	List<Skin> listaSkins;
	
	/**
     * Constructor vacío por defecto de la clase Arma. 
     */
    public Arma() {}

    /**
     * Constructor con los parametros nombre(String) y ma(ModeloArma) de la clase Arma.
     *
     * @param nombre El nombre del arma.
     * @param ma     El modelo del arma.
     */
    public Arma(String nombre, ModeloArma ma) {
        this.nombre = nombre;
        this.ma = ma;
    }

    /**
     * Obtiene el ID del arma.
     *
     * @return El ID del arma.
     */
    public long getId() {
        return id;
    }

    /**
     * Establece el ID del arma.
     * No seria neceasario puesto que seria Auto-Incremental
     *
     * @param id El ID del arma.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del arma.
     *
     * @return El nombre del arma.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del arma.
     *
     * @param nombre El nombre del arma.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el modelo del arma.
     *
     * @return El modelo del arma.
     */
    public String getModelo() {
        return ma.getModelo();
    }

    /**
     * Establece el modelo del arma.
     *
     * @param s El modelo del arma.
     */
    public void setModelo(String s) {
        this.ma.setModelo(s);
    }

    /**
     * Devuelve una representación en cadena de la instancia Arma.
     *
     * @return Una representación en cadena de la instancia Arma.
     */
    @Override
    public String toString() {
        return "Arma [id=" + id + ", nombre=" + nombre + ", modelo=" + ma + "]";
    }

	

}
