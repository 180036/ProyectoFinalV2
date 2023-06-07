package com.app.web.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cajas")
public class Caja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 public long id;
	
	@Column(name = "nombre", nullable = false)
	public String nombre;
	
	@Column(name = "precio", nullable = false)
	public int precio;
	
	@ManyToOne
	@JoinColumn(name = "skin1")
	private Skin skin1;
	
	@ManyToOne
	@JoinColumn(name = "skin2")
	private Skin skin2;
	
	@ManyToOne
	@JoinColumn(name = "skin3")
	private Skin skin3;
	
	@ManyToOne
	@JoinColumn(name = "skin4")
	private Skin skin4;
	
	@ManyToOne
	@JoinColumn(name = "skin5")
	private Skin skin5;
	
	@ManyToOne
	@JoinColumn(name = "skin6")
	private Skin skin6;
	
	@ManyToOne
	@JoinColumn(name = "skin7")
	private Skin skin7;
	
	@ManyToOne
	@JoinColumn(name = "skin8")
	private Skin skin8;
	
	@ManyToOne
	@JoinColumn(name = "skin9")
	private Skin skin9;
	
	@ManyToOne
	@JoinColumn(name = "skin10")
	private Skin skin10;

	public Caja(String nombre, int precio, Skin skin1, Skin skin2, Skin skin3, Skin skin4, Skin skin5, Skin skin6,
			Skin skin7, Skin skin8, Skin skin9, Skin skin10) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.skin1 = skin1;
		this.skin2 = skin2;
		this.skin3 = skin3;
		this.skin4 = skin4;
		this.skin5 = skin5;
		this.skin6 = skin6;
		this.skin7 = skin7;
		this.skin8 = skin8;
		this.skin9 = skin9;
		this.skin10 = skin10;
	}

	
	public Caja() {
	}


	@Override
	public String toString() {
		return "Caja [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", skin1=" + skin1 + ", skin2=" + skin2
				+ ", skin3=" + skin3 + ", skin4=" + skin4 + ", skin5=" + skin5 + ", skin6=" + skin6 + ", skin7=" + skin7
				+ ", skin8=" + skin8 + ", skin9=" + skin9 + ", skin10=" + skin10 + "]";
	}

	
	
}

