package com.app.web.servicios;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.web.repositorios.UserRepository;
import com.app.web.seguridad.SecurityUser;

@Service
public class SecurityUserDetailsService implements UserDetailsService{

	
	private final UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var optUser = this.userRepo.findByName(username);
		if(optUser.isPresent()) {
			return new SecurityUser(optUser.get());
		}
		throw new UsernameNotFoundException("Usuario no encontrado " + username);
	}
	public SecurityUserDetailsService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	
	

}
