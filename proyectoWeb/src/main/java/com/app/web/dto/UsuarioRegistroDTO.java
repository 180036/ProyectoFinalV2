package com.app.web.dto;



public class UsuarioRegistroDTO {
 
	private long id;
	
	private String nombre;

	private String contrasena;
	
	private String email;

	  
	
	public UsuarioRegistroDTO() {
	}

	public UsuarioRegistroDTO(long id, String nombre, String contrasena, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.email = email;
	}

	
	public UsuarioRegistroDTO(String nombre, String contrasena, String email) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.email = email;
	}
	
	

	public UsuarioRegistroDTO(String email) {
		super();
		this.email = email;
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

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
