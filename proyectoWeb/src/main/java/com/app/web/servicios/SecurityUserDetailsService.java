package com.app.web.servicios;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.web.repositorios.UserRepository;
import com.app.web.seguridad.SecurityUser;

/**
 * Servicio que implementa la interfaz UserDetailsService de Spring Security para cargar los detalles de un usuario durante el proceso de autenticación.
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */
@Service
public class SecurityUserDetailsService implements UserDetailsService{

	private final UserRepository userRepo;

	/**
     * Constructor de la clase SecurityUserDetailsService.
     *
     * @param userRepo El repositorio de usuarios utilizado para buscar usuarios.
     */
    public SecurityUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
	
	/**
     * Carga los detalles de un usuario por su nombre de usuario.
     *
     * @param username El nombre de usuario del usuario.
     * @return Los detalles del usuario encontrado.
     * @throws UsernameNotFoundException Si no se encuentra ningún usuario con el nombre de usuario especificado.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var optUser = this.userRepo.findByName(username);
        if (optUser.isPresent()) {
            return new SecurityUser(optUser.get());
        }
        throw new UsernameNotFoundException("Usuario no encontrado: " + username);
    }
}
