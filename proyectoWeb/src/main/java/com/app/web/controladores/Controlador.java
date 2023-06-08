package com.app.web.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.web.entidad.Caja;
import com.app.web.entidad.EstadoArma;
import com.app.web.entidad.ObjetoSkinArma;
import com.app.web.entidad.Skin;
import com.app.web.servicios.CajaServicio;
import com.app.web.usuarioregistro.User;

import utilidades.AleatorioEstadoArma;
import utilidades.AleatorioSkins;
import utilidades.PrecioFinalOSA;
import utilidades.StatTrak;

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
	
	@GetMapping("/cajas/{id}")
	public String devolverCaja(@PathVariable Long id, Model modelo) {
		Caja c = servicioCaja.obtenerCajaPorId(id);
		Skin s = AleatorioSkins.skinAleatoria(c.getSkins()); //Skin premiada
		EstadoArma ea = AleatorioEstadoArma.estadoArmaAleatorio(); //EstadoArma aleatorio
		int precio = PrecioFinalOSA.precioFinal(ea, s.getPrecioBase(), StatTrak.tieneStatTrak());
		
		ObjetoSkinArma osa = new ObjetoSkinArma();
		osa.setEstado(ea);
		osa.setSkin(s);
		osa.setPrecio(precio);
		osa.setUsuario(new User()); //pillar usuario de sesion, por realizar
		osa.setNombre(s.getNombre()); //Nombre se le pregunta al usuario para cambiarlo
		
		
		modelo.addAttribute("caja", c);
		modelo.addAttribute("skin", s);		
		/*if(id == 1) {
			return "pruebas/caja1.html";
		}else if(id == 2) {
			return "pruebas/caja2.html";
		}else if(id == 3) {
			return "pruebas/caja3.html";
		}*/
		return "caja";
	}
	
}
