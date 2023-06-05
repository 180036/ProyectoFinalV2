package com.app.web.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.web.dto.UsuarioRegistroDTO;
import com.app.web.servicios.UsuarioServicio;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {
	
	@Autowired
	private UsuarioServicio servicio;

	public RegistroUsuarioControlador(UsuarioServicio servicio) {
		super();
		this.servicio = servicio;
	}
	
	@ModelAttribute("usuario")
	public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
		return new UsuarioRegistroDTO();
	}
	
	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "registro";
	}
	@PostMapping
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
		servicio.guardarUsuarioDTO(registroDTO);
		return "redirect:/registro?exito";
	}

}
