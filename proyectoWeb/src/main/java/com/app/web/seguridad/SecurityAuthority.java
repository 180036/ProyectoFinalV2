package com.app.web.seguridad;

import org.springframework.security.core.GrantedAuthority;

import com.app.web.usuarioregistro.Authority;

public class SecurityAuthority implements GrantedAuthority{

	private final Authority auth;
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return auth.getName().toString();
	}
	public SecurityAuthority(Authority auth) {
		super();
		this.auth = auth;
	}

	
}
