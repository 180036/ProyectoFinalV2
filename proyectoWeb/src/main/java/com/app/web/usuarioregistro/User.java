package com.app.web.usuarioregistro;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String passord;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_authority",
			  joinColumns = @JoinColumn(
					  	name = "user_id", referencedColumnName = "id"),
			  inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id")
					  )
	private List<Authority> authorities;

	
	
	
	public User(String name, String passord, List<Authority> authorities) {
		super();
		this.name = name;
		this.passord = passord;
		this.authorities = authorities;
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
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	
	

}
