package com.app.web.seguridad;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.web.usuarioregistro.User;

/**
 * Implementación de UserDetails para representar a un usuario en el sistema de seguridad..
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */
public class SecurityUser implements UserDetails {
	
	private final User user;
	/**
	 * Crea una instancia de SecurityUser con el usuario proporcionado.
	 *
	 * @param user El objeto User que representa al usuario.
	 */
	public SecurityUser(User user) {
		super();
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return user.getAuthorities().stream().map(SecurityAuthority::new).toList();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
