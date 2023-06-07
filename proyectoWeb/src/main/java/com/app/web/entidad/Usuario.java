package com.app.web.entidad;

import java.util.Collection;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name ="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
//	
//	@Column(name = "nombre", nullable = false, unique= true)
//	private String nombre;
//
//	@Column(name = "contrasena", nullable = false)
//	private String contrasena;
//	
//	@Column(name = "email", nullable = false, unique = true)
//	private String email;
//	
//	@Column(name = "urlPerfil", nullable = true)
//	private String urlPerfil;
//
//	@Column(name = "puntos", nullable =false )
//	private int puntos;
//	
//	@OneToMany(mappedBy = "usuario")
//	List<ObjetoSkinArma> inventario;
//	
//
//	public Usuario() {}
//
//	public Usuario(String nombre, String contrasena, String email, String urlPerfil) {
//		this.nombre = nombre;
//		this.contrasena = contrasena;
//		this.email = email;
//		this.urlPerfil = urlPerfil;
//		this.puntos = 100; //pts default :)
//	}
//	
//	
//
//	
//
//	public int getPuntos() {
//		return puntos;
//	}
//
//	public void setPuntos(int puntos) {
//		this.puntos = puntos;
//	}
//
//	public void sumarPuntos(int puntos) {
//		this.puntos += puntos;
//	}
//	public void restarPuntos(int puntos) {
//		this.puntos += puntos;
//	}
//	public long getId() {
//		return id;
//	}
//
//
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//
//
//	public String getNombre() {
//		return nombre;
//	}
//
//
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//
//
//	public String getContrasena() {
//		return contrasena;
//	}
//
//
//
//	public void setContrasena(String contrasena) {
//		this.contrasena = contrasena;
//	}
//
//
//
//	public String getEmail() {
//		return email;
//	}
//
//
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//
//
//	public String getUrlPerfil() {
//		return urlPerfil;
//	}
//
//
//
//	public void setUrlPerfil(String urlPerfil) {
//		this.urlPerfil = urlPerfil;
//	}
//
//
//
//	public List<ObjetoSkinArma> getListaObjetoSkinArmas() {
//		return inventario;
//	}
//
//
//
//	public void setListaObjetoSkinArmas(List<ObjetoSkinArma> listaObjetoSkinArmas) {
//		this.inventario = listaObjetoSkinArmas;
//	}
//
//
//
//	@Override
//	public String toString() {
//		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasena=" + contrasena + ", email=" + email
//				+ ", urlPerfil=" + urlPerfil + "]";
//	}
//	
	

}
