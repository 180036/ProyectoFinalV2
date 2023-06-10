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
	
	@Column(name = "tieneStatTrak", nullable = false)
	private boolean stattrak;
	
	@ManyToOne
	@JoinColumn(name = "idSkin")
	private Skin skin;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private User usuario;
	
	@ManyToOne
	@JoinColumn(name = "estado", nullable = false)
	private EstadoArma estado;

	/**
     * Crea una nueva instancia de ObjetoSkinArma con los atributos especificados.
     *
     * @param nombre  El nombre del objeto de skin de arma.
     * @param precio  El precio del objeto de skin de arma.
     * @param skin    La skin asociada al objeto de skin de arma.
     * @param usuario El usuario propietario del objeto de skin de arma.
     * @param estado  El estado del arma asociado al objeto de skin de arma.
     */
    public ObjetoSkinArma(String nombre, int precio, Skin skin, User usuario, EstadoArma estado) {
        this.nombre = nombre;
        this.precio = precio;
        this.skin = skin;
        this.usuario = usuario;
        this.estado = estado;
    }

    /**
     * Crea una nueva instancia de ObjetoSkinArma.
     */
    public ObjetoSkinArma() {}

    /**
     * Obtiene el identificador del objeto de skin de arma.
     *
     * @return El identificador del objeto de skin de arma.
     */
    public long getId() {
        return id;
    }

    /**
     * Establece el identificador del objeto de skin de arma.
     *
     * @param id El identificador del objeto de skin de arma.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del objeto de skin de arma.
     *
     * @return El nombre del objeto de skin de arma.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del objeto de skin de arma.
     *
     * @param nombre El nombre del objeto de skin de arma.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del objeto de skin de arma.
     *
     * @return El precio del objeto de skin de arma.
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del objeto de skin de arma.
     *
     * @param precio El precio del objeto de skin de arma.
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la skin asociada al objeto de skin de arma.
     *
     * @return La skin asociada al objeto de skin de arma.
     */
    public Skin getSkin() {
        return skin;
    }

    /**
     * Establece la skin asociada al objeto de skin de arma.
     *
     * @param skin La skin asociada al objeto de skin de arma.
     */
    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    /**
     * Obtiene el usuario propietario del objeto de skin de arma.
     *
     * @return El usuario propietario del objeto de skin de arma.
     */
    public User getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario propietario del objeto de skin de arma.
     *
     * @param usuario El usuario propietario del objeto de skin de arma.
     */
    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el estado del arma asociado al objeto de skin de arma.
     *
     * @return El estado del arma asociado al objeto de skin de arma.
     */
    public EstadoArma getEstado() {
        return estado;
    }

	public boolean isStattrak() {
		return stattrak;
	}

	public void setStattrak(boolean stattrak) {
		this.stattrak = stattrak;
	}

    /**
     * Establece el estado del arma asociado al objeto de skin de arma.
     *
     * @param estado El estado del arma asociado al objeto de skin de arma.
     */
    public void setEstado(EstadoArma estado) {
        this.estado = estado;
    }
    
    /**
     * Devuelve una representación en cadena de la instancia ObjetoSkinArma.
     *
     * @return Una representación en cadena de la instancia ObjetoSkinArma.
     */
	@Override
	public String toString() {
		return "ObjetoSkinArma [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", skin=" + skin
				+ ", usuario=" + usuario + ", estado=" + estado + "]";
	}

	

	
	
	
}

