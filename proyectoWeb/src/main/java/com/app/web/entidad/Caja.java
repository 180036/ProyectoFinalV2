package com.app.web.entidad;

import java.util.ArrayList;
import java.util.List;

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

	public List<Skin> getSkins(){
		List<Skin> lista = new ArrayList<>();
		lista.add(skin1);
		lista.add(skin2);
		lista.add(skin3);
		lista.add(skin4);
		lista.add(skin5);
		lista.add(skin6);
		lista.add(skin7);
		lista.add(skin8);
		lista.add(skin9);
		lista.add(skin10);
		return lista;
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


	public Skin getSkin1() {
		return skin1;
	}


	public void setSkin1(Skin skin1) {
		this.skin1 = skin1;
	}


	public Skin getSkin2() {
		return skin2;
	}


	public void setSkin2(Skin skin2) {
		this.skin2 = skin2;
	}


	public Skin getSkin3() {
		return skin3;
	}


	public void setSkin3(Skin skin3) {
		this.skin3 = skin3;
	}


	public Skin getSkin4() {
		return skin4;
	}


	public void setSkin4(Skin skin4) {
		this.skin4 = skin4;
	}


	public Skin getSkin5() {
		return skin5;
	}


	public void setSkin5(Skin skin5) {
		this.skin5 = skin5;
	}


	public Skin getSkin6() {
		return skin6;
	}


	public void setSkin6(Skin skin6) {
		this.skin6 = skin6;
	}


	public Skin getSkin7() {
		return skin7;
	}


	public void setSkin7(Skin skin7) {
		this.skin7 = skin7;
	}


	public Skin getSkin8() {
		return skin8;
	}


	public void setSkin8(Skin skin8) {
		this.skin8 = skin8;
	}


	public Skin getSkin9() {
		return skin9;
	}


	public void setSkin9(Skin skin9) {
		this.skin9 = skin9;
	}


	public Skin getSkin10() {
		return skin10;
	}


	public void setSkin10(Skin skin10) {
		this.skin10 = skin10;
	}


	@Override
	public String toString() {
		return "Caja [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", skin1=" + skin1 + ", skin2=" + skin2
				+ ", skin3=" + skin3 + ", skin4=" + skin4 + ", skin5=" + skin5 + ", skin6=" + skin6 + ", skin7=" + skin7
				+ ", skin8=" + skin8 + ", skin9=" + skin9 + ", skin10=" + skin10 + "]";
	}

	
	
}

