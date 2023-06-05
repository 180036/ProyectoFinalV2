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
@Table(name = "armas")
public class Arma {

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
	
	public Arma() {}

	public Arma(String nombre, ModeloArma ma) {
		this.nombre = nombre;
		this.ma = ma;
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
	
	public String getModelo() {
		return ma.getModelo();
	}

	public void setModelo(String s) {
		this.ma.setModelo(s);
	}

	@Override
	public String toString() {
		return "Arma [id=" + id + ", nombre=" + nombre + ", modelo=" + ma + "]";
	}

	

}
