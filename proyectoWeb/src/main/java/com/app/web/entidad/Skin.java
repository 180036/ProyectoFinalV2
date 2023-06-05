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

@Entity
@Table(name = "skins")
public class Skin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "idarma")
	private Arma arma;
	
	@ManyToOne
	@JoinColumn(name = "idcalidad")
	private CalidadSkin cs;

	@OneToMany(mappedBy = "skin")
	List<ObjetoSkinArma> listaObjetoSkinArmas;
	
	public Skin() {}

	public Skin(String nombre, Arma arma, CalidadSkin cs) {
		this.nombre = nombre;
		this.arma = arma;
		this.cs = cs;
	}

	public CalidadSkin getCs() {
		return cs;
	}

	public void setCs(CalidadSkin cs) {
		this.cs = cs;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Arma getArma() {
		return arma;
	}


	public void setArma(Arma arma) {
		this.arma = arma;
	}


	
	public List<ObjetoSkinArma> getListaObjetoSkinArmas() {
		return listaObjetoSkinArmas;
	}


	public void setListaObjetoSkinArmas(List<ObjetoSkinArma> listaObjetoSkinArmas) {
		this.listaObjetoSkinArmas = listaObjetoSkinArmas;
	}


	@Override
	public String toString() {
		return "Skin [id=" + id + ", nombre=" + nombre + ", arma=" + arma + "]";
	}

	
	
}
