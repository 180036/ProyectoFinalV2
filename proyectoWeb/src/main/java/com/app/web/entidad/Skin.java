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
 * Esta clase define el objeto que hace referencia al Skin.
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */
@Entity
@Table(name = "skins")
public class Skin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "precioBase", nullable = false)
	private int precioBase;
	
	@ManyToOne
	@JoinColumn(name = "idarma")
	private Arma arma;
	
	@ManyToOne
	@JoinColumn(name = "idcalidad")
	private CalidadSkin cs;

	@OneToMany(mappedBy = "skin")
	List<ObjetoSkinArma> listaObjetoSkinArmas;
	
	/**
	 * Crea una nueva instancia de Skin con los atributos especificados.
	 *
	 * @param nombre     El nombre de la skin.
	 * @param arma       El arma asociada a la skin.
	 * @param cs         La calidad de la skin.
	 * @param precioBase El precio base de la skin.
	 */
	public Skin(String nombre, Arma arma, CalidadSkin cs, int precioBase) {
		this.nombre = nombre;
		this.arma = arma;
		this.cs = cs;
		this.precioBase = precioBase;
	}

	/**
	 * Crea una nueva instancia de Skin.
	 */
	public Skin() {}

	/**
	 * Obtiene el precio base de la skin.
	 *
	 * @return El precio base de la skin.
	 */
	public int getPrecioBase() {
		return precioBase;
	}

	/**
	 * Establece el precio base de la skin.
	 *
	 * @param precioBase El precio base de la skin.
	 */
	public void setPrecioBase(int precioBase) {
		this.precioBase = precioBase;
	}

	/**
	 * Obtiene la calidad de la skin.
	 *
	 * @return La calidad de la skin.
	 */
	public CalidadSkin getCs() {
		return cs;
	}

	/**
	 * Establece la calidad de la skin.
	 *
	 * @param cs La calidad de la skin.
	 */
	public void setCs(CalidadSkin cs) {
		this.cs = cs;
	}

	/**
	 * Obtiene el identificador de la skin.
	 *
	 * @return El identificador de la skin.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Establece el identificador de la skin.
	 *
	 * @param id El identificador de la skin.
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre de la skin.
	 *
	 * @return El nombre de la skin.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre de la skin.
	 *
	 * @param nombre El nombre de la skin.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el arma asociada a la skin.
	 *
	 * @return El arma asociada a la skin.
	 */
	public Arma getArma() {
		return arma;
	}

	/**
	 * Establece el arma asociada a la skin.
	 *
	 * @param arma El arma asociada a la skin.
	 */
	public void setArma(Arma arma) {
		this.arma = arma;
	}

	/**
	 * Obtiene la lista de objetos de skin de arma asociados a la skin.
	 *
	 * @return La lista de objetos de skin de arma asociados a la skin.
	 */
	public List<ObjetoSkinArma> getListaObjetoSkinArmas() {
		return listaObjetoSkinArmas;
	}

	/**
	 * Establece la lista de objetos de skin de arma asociados a la skin.
	 *
	 * @param listaObjetoSkinArmas La lista de objetos de skin de arma asociados a la skin.
	 */
	public void setListaObjetoSkinArmas(List<ObjetoSkinArma> listaObjetoSkinArmas) {
		this.listaObjetoSkinArmas = listaObjetoSkinArmas;
	}

	/**
     * Devuelve una representación en cadena de la instancia skins.
     *
     * @return Una representación en cadena de la instancia skins.
     */
	@Override
	public String toString() {
		return "Skin [id=" + id + ", nombre=" + nombre + ", arma=" + arma + "]";
	}

	
	
}
