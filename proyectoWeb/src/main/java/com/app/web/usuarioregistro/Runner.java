package com.app.web.usuarioregistro;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.app.web.repositorios.AuthorityRepositorio;
import com.app.web.repositorios.UserRepository;

/**
 * Componente de Spring que implementa la interfaz CommandLineRunner. Se utiliza para ejecutar
 * código adicional al iniciar la aplicación Spring Boot.
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */
@Component
public class Runner implements CommandLineRunner {

	private final UserRepository userRepo;
	private final AuthorityRepositorio authRepo;

	/**
	 * Constructor de la clase Runner.
	 *
	 * @param userRepo Repositorio de usuarios para acceder a los datos de usuario.
	 * @param authRepo Repositorio de autoridades para acceder a los datos de
	 *                 autoridad.
	 */
	public Runner(UserRepository userRepo, AuthorityRepositorio authRepo) {
		super();
		this.userRepo = userRepo;
		this.authRepo = authRepo;
	}

	/**
	 * Método que se ejecuta al iniciar la aplicación Spring Boot.
	 *
	 * @param args Argumentos de la línea de comandos.
	 * @throws Exception Excepción en caso de error durante la ejecución.
	 */
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		/*
		 * if(this.authRepo.count() == 0) { this.authRepo.saveAll(List.of( new
		 * Authority(AuthorityName.ADMIN), new Authority(AuthorityName.READ), new
		 * Authority(AuthorityName.WRITE) )); } if(this.userRepo.count() == 0) {
		 * this.userRepo.saveAll(List.of( new User("alejandro", new
		 * BCryptPasswordEncoder().encode("123"),
		 * List.of(this.authRepo.findByName(AuthorityName.ADMIN).get())), new
		 * User("oskaras", new BCryptPasswordEncoder().encode("123"),
		 * List.of(this.authRepo.findByName(AuthorityName.READ).get())), new
		 * User("pepe", new BCryptPasswordEncoder().encode("69"),
		 * List.of(this.authRepo.findByName(AuthorityName.WRITE).get())) )); }
		 */
	}

}
