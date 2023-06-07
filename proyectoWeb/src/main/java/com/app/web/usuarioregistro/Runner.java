package com.app.web.usuarioregistro;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.app.web.repositorios.AuthorityRepositorio;
import com.app.web.repositorios.UserRepository;

@Component
public class Runner implements CommandLineRunner{

	private final UserRepository userRepo;
	private final AuthorityRepositorio authRepo;
	
	
	public Runner(UserRepository userRepo, AuthorityRepositorio authRepo) {
		super();
		this.userRepo = userRepo;
		this.authRepo = authRepo;
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*if(this.authRepo.count() == 0) {
			this.authRepo.saveAll(List.of(
					new Authority(AuthorityName.ADMIN),
					new Authority(AuthorityName.READ),
					new Authority(AuthorityName.WRITE)
					));
		}
		if(this.userRepo.count() == 0) {
			this.userRepo.saveAll(List.of(
					new User("alejandro", new BCryptPasswordEncoder().encode("123"), List.of(this.authRepo.findByName(AuthorityName.ADMIN).get())),
					new User("oskaras", new BCryptPasswordEncoder().encode("123"), List.of(this.authRepo.findByName(AuthorityName.READ).get())),
					new User("pepe", new BCryptPasswordEncoder().encode("69"), List.of(this.authRepo.findByName(AuthorityName.WRITE).get()))
					));
		}*/
	}
	

}
