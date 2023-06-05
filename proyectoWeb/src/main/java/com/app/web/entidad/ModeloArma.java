package com.app.web.entidad;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tipomodeloarma")
public class ModeloArma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	@Column(name = "nombre", nullable = false)
	private String nombre;

	public ModeloArma(String nombre) {
		this.nombre = nombre;
	}
	public ModeloArma() {}


	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}


	public String getModelo() {
		return nombre;
	}


	public void setModelo(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "ModeloArma [id=" + id + ", nombre=" + nombre + "]";
	}



	
}
