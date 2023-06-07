package com.app.web.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.servicios.CajaServicio;

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
	//serviciocaja;
	//modelo.addAttribute("estudiantes", servicio.listarTodosEstudiantes());

	
	@Autowired
	private CajaServicio servicioCaja;
	
	@GetMapping({"/cajas", "/"})
	public String listarEstudiantes(Model modelo) {
		//mostrar todas las cajas
		modelo.addAttribute("cajas", servicioCaja.listarTodasCajas());
		return "cajas.html";
	}
	
	
	/*@GetMapping("/cajas")
	public String listarCajas() {
		return "cajas.html";
	 }*/
	
	
	@PostMapping("/cajas/{id}")
	public String devolverCaja(@PathVariable Long id) {
		if(id == 1) {
			return "pruebas/caja1.html";
		}else if(id == 2) {
			return "pruebas/caja2.html";
		}else if(id == 3) {
			return "pruebas/caja3.html";
		}
		return "redirect:/index";
	}
}
