package com.app.web.seguridad;

import org.springframework.security.core.GrantedAuthority;
import com.app.web.usuarioregistro.Authority;

/**
 * Clase que representa una autoridad de seguridad en el sistema.
 * Implementa la interfaz GrantedAuthority de Spring Security.
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */
public class SecurityAuthority implements GrantedAuthority{
	
	private final Authority auth;
	
	/**
	 * Crea una nueva instancia de SecurityAuthority con la autoridad especificada.
	 *
	 * @param auth La autoridad asociada a la instancia de SecurityAuthority.
	 */
	public SecurityAuthority(Authority auth) {
		super();
		this.auth = auth;
	}

	/**
	 * Obtiene el nombre de la autoridad.
	 *
	 * @return El nombre de la autoridad.
	 */
	@Override
	public String getAuthority() {
		return auth.getName().toString();
	}

	
}
