package com.app.web.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.web.repositorios.AuthorityRepositorio;
import com.app.web.servicios.UserServicio;
import com.app.web.usuarioregistro.AuthorityName;
import com.app.web.usuarioregistro.User;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserServicio userServicio;
	@Autowired
	private AuthorityRepositorio authRepo;
	
	@GetMapping("/listar")
	public String listarTodosUsuarios(Model modelo) {
		modelo.addAttribute("usuarios", userServicio.listarTodosUsuarios());
		return "lista";
		
	}
	@GetMapping("/nuevo")
	public String crearUsuarioFormulario(Model modelo) {
		User u= new User();
		modelo.addAttribute("usuario",u);
		return "crearUsuarioDesdeAdmin";
	}
	
	@PostMapping("/guardarUsuario")
	public String guardarUsuario(@ModelAttribute("user") User user, @RequestParam("opcionSeleccionada") String opcionSeleccionada) {
		
		if(userServicio.obtenerUsuarioPorNombre(user.getName()) == null && userServicio.obtenerUsuarioPorEmail(user.getEmail()) == null)
		{
			if(opcionSeleccionada.equalsIgnoreCase("admin"))
				user.setAuthorities( List.of(this.authRepo.findByName(AuthorityName.ADMIN).get()));
			else if(opcionSeleccionada.equalsIgnoreCase("creator"))
				user.setAuthorities( List.of(this.authRepo.findByName(AuthorityName.CREATOR).get()));
			else{
				user.setAuthorities( List.of(this.authRepo.findByName(AuthorityName.USER).get()));
				
			}
			
			String passwordEncriptada = new BCryptPasswordEncoder().encode(user.getPassword());
			user.setPassword(passwordEncriptada);
			
			userServicio.guardarUsuario(user);
			return "redirect:/admin?creado";
		}
		return "redirect:/admin?errorUsuario";				
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("usuario", userServicio.obtenerUsuarioPorId(id));
		return "editarUsuario";
	}
	
	@PostMapping("/{id}")
	public String actualizarUsuario(@PathVariable Long id, @ModelAttribute("usuario") User user) {
		if(userServicio.obtenerUsuarioPorNombre(user.getName()) == null && userServicio.obtenerUsuarioPorEmail(user.getEmail()) == null)
		{
			
			String passwordEncriptada = new BCryptPasswordEncoder().encode(user.getPassword());
			user.setPassword(passwordEncriptada);
			
			userServicio.guardarUsuario(user);
			User e = userServicio.obtenerUsuarioPorId(id);
			e.setId(id);
			e.setName(user.getName());
			e.setEmail(user.getEmail());
			e.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			
			userServicio.actualizarUsuario(e);
			return "redirect:/admin?creado";
		}
		return "redirect:/admin?errorUsuario";				
		
	}
	

	@GetMapping("/{id}")
	public String eliminarUsuario(@PathVariable Long id) {
		userServicio.eliminarUsuario(id);
		return "redirect:/admin";
	}

}
