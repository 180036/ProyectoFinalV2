package com.app.web.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.web.servicios.UsuarioServicio;

@Controller
public class Controlador {
/*
	@Autowired
	private UsuarioServicio servicio;
	
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/inventario/{id}")
	public String mostrarFormEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("inventario",servicio.getInventario(id));
		return "inventario";
	}*/
}
