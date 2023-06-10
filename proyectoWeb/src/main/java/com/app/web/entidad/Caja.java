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

/**
 * Esta clase define el objeto que hace referencia a la Caja.
 * Ahora mismo se insertan de manera manual con las skins elegedias por el admin.
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */

@Entity
@Table(name = "cajas")
public class Caja {

	//Campos de la clase
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

	/**
     * Constructor de la clase Caja.
     *
     * @param nombre  El nombre de la caja.
     * @param precio  El precio de la caja.
     * @param skin1   La primera skin de la caja.
     * @param skin2   La segunda skin de la caja.
     * @param skin3   La tercera skin de la caja.
     * @param skin4   La cuarta skin de la caja.
     * @param skin5   La quinta skin de la caja.
     * @param skin6   La sexta skin de la caja.
     * @param skin7   La séptima skin de la caja.
     * @param skin8   La octava skin de la caja.
     * @param skin9   La novena skin de la caja.
     * @param skin10  La décima skin de la caja.
     */
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
	
	/**
     * Constructor por defecto de la clase Caja.
     */
	public Caja() {
	}

	/**
     * Obtiene la lista de skins de la caja.
     *
     * @return La lista de skins de la caja.
     */
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

	/**
     * Obtiene el ID de la caja.
     *
     * @return El ID de la caja.
     */
    public long getId() {
        return id;
    }

    /**
     * Establece el ID de la caja.
     * No seria neceasario puesto que seria Auto-Incremental
     *
     * @param id El ID de la caja.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la caja.
     *
     * @return El nombre de la caja.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la caja.
     *
     * @param nombre El nombre de la caja.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio de la caja.
     *
     * @return El precio de la caja.
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Establece el precio de la caja.
     *
     * @param precio El precio de la caja.
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la primera skin de la caja.
     *
     * @return La primera skin de la caja.
     */
    public Skin getSkin1() {
        return skin1;
    }

    /**
     * Establece la primera skin de la caja.
     *
     * @param skin1 La primera skin de la caja.
     */
    public void setSkin1(Skin skin1) {
        this.skin1 = skin1;
    }

    /**
     * Obtiene la segunda skin de la caja.
     *
     * @return La segunda skin de la caja.
     */
    public Skin getSkin2() {
        return skin2;
    }

    /**
     * Establece la segunda skin de la caja.
     *
     * @param skin2 La segunda skin de la caja.
     */
    public void setSkin2(Skin skin2) {
        this.skin2 = skin2;
    }

    /**
     * Obtiene la tercera skin de la caja.
     *
     * @return La tercera skin de la caja.
     */
    public Skin getSkin3() {
        return skin3;
    }

    /**
     * Establece la tercera skin de la caja.
     *
     * @param skin3 La tercera skin de la caja.
     */
    public void setSkin3(Skin skin3) {
        this.skin3 = skin3;
    }

    /**
     * Obtiene la cuarta skin de la caja.
     *
     * @return La cuarta skin de la caja.
     */
    public Skin getSkin4() {
        return skin4;
    }

    /**
     * Establece la cuarta skin de la caja.
     *
     * @param skin4 La cuarta skin de la caja.
     */
    public void setSkin4(Skin skin4) {
        this.skin4 = skin4;
    }

    /**
     * Obtiene la quinta skin de la caja.
     *
     * @return La quinta skin de la caja.
     */
    public Skin getSkin5() {
        return skin5;
    }

    /**
     * Establece la quinta skin de la caja.
     *
     * @param skin5 La quinta skin de la caja.
     */
    public void setSkin5(Skin skin5) {
        this.skin5 = skin5;
    }

    /**
     * Obtiene la sexta skin de la caja.
     *
     * @return La sexta skin de la caja.
     */
    public Skin getSkin6() {
        return skin6;
    }

    /**
     * Establece la sexta skin de la caja.
     *
     * @param skin6 La sexta skin de la caja.
     */
    public void setSkin6(Skin skin6) {
        this.skin6 = skin6;
    }

    /**
     * Obtiene la séptima skin de la caja.
     *
     * @return La séptima skin de la caja.
     */
    public Skin getSkin7() {
        return skin7;
    }

    /**
     * Establece la séptima skin de la caja.
     *
     * @param skin7 La séptima skin de la caja.
     */
    public void setSkin7(Skin skin7) {
        this.skin7 = skin7;
    }

    /**
     * Obtiene la octava skin de la caja.
     *
     * @return La octava skin de la caja.
     */
    public Skin getSkin8() {
        return skin8;
    }

    /**
     * Establece la octava skin de la caja.
     *
     * @param skin8 La octava skin de la caja.
     */
    public void setSkin8(Skin skin8) {
        this.skin8 = skin8;
    }

    /**
     * Obtiene la novena skin de la caja.
     *
     * @return La novena skin de la caja.
     */
    public Skin getSkin9() {
        return skin9;
    }

    /**
     * Establece la novena skin de la caja.
     *
     * @param skin9 La novena skin de la caja.
     */
    public void setSkin9(Skin skin9) {
        this.skin9 = skin9;
    }

    /**
     * Obtiene la décima skin de la caja.
     *
     * @return La décima skin de la caja.
     */
    public Skin getSkin10() {
        return skin10;
    }

    /**
     * Establece la décima skin de la caja.
     *
     * @param skin10 La décima skin de la caja.
     */
    public void setSkin10(Skin skin10) {
        this.skin10 = skin10;
    }

    /**
     * Devuelve una representación en cadena de la instancia Caja.
     *
     * @return Una representación en cadena de la instancia Caja.
     */
    @Override
    public String toString() {
        return "Caja [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", skin1=" + skin1 + ", skin2=" + skin2
                + ", skin3=" + skin3 + ", skin4=" + skin4 + ", skin5=" + skin5 + ", skin6=" + skin6 + ", skin7=" + skin7
                + ", skin8=" + skin8 + ", skin9=" + skin9 + ", skin10=" + skin10 + "]";
    }

	
	
}

