package com.app.web.usuarioregistro;

import java.util.List;

import com.app.web.entidad.ObjetoSkinArma;

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

@Entity(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", nullable=false, unique= true)
	private String name;
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_authority",
			  joinColumns = @JoinColumn(
					  	name = "user_id", referencedColumnName = "id"),
			  inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id")
					  )
	private List<Authority> authorities;

	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "urlPerfil")
	private String urlPerfil;

	@Column(name = "puntos")
	private int puntos;
	
	@OneToMany(mappedBy = "usuario")
	List<ObjetoSkinArma> inventario;
	
	
	public User(String name, String passord, List<Authority> authorities) {
		super();
		this.name = name;
		this.password = passord;
		this.authorities = authorities;
	}

	public User(String name, String password, List<Authority> authorities, String email, String urlPerfil) {
		super();
		this.name = name;
		this.password = password;
		this.authorities = authorities;
		this.email = email;
		this.urlPerfil = urlPerfil;
		this.puntos = 100;
	}

	public User() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassord() {
		return password;
	}

	public void setPassord(String passord) {
		this.password = passord;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	
	

}
