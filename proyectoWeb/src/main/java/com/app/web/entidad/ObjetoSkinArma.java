package com.app.web.entidad;

import com.app.web.usuarioregistro.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="objetoskinarma")
public class ObjetoSkinArma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "precio", nullable = false)
	private int precio;
	
	@ManyToOne
	@JoinColumn(name = "idSkin")
	private Skin skin;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private User usuario;
	
	@ManyToOne
	@JoinColumn(name = "estado", nullable = false)
	private EstadoArma estado;

	public ObjetoSkinArma() {}

	public ObjetoSkinArma(String nombre, int precio, Skin skin, User usuario, EstadoArma estado) {
		this.nombre = nombre;
		this.precio = precio;
		this.skin = skin;
		this.usuario = usuario;
		this.estado = estado;
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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Skin getSkin() {
		return skin;
	}

	public void setSkin(Skin skin) {
		this.skin = skin;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public EstadoArma getEstado() {
		return estado;
	}

	public void setEstado(EstadoArma estado) {
		this.estado = estado;
	}



	@Override
	public String toString() {
		return "ObjetoSkinArma [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", skin=" + skin
				+ ", usuario=" + usuario + ", estado=" + estado + "]";
	}

	

	
	
	
}

