package com.app.web.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.web.entidad.Caja;
import com.app.web.entidad.EstadoArma;
import com.app.web.entidad.ObjetoSkinArma;
import com.app.web.entidad.Skin;
import com.app.web.servicios.CajaServicio;
import com.app.web.servicios.UserServicio;
import com.app.web.usuarioregistro.User;

import utilidades.AleatorioEstadoArma;
import utilidades.AleatorioSkins;
import utilidades.CompruebaRol;
import utilidades.PrecioFinalOSA;
import utilidades.StatTrak;

@Controller
public class Controlador {
	/*
	 * @Autowired private UsuarioServicio servicio;
	 * 
	 * @GetMapping("/") public String getIndex() { return "index"; }
	 * 
	 * @GetMapping("/inventario/{id}") public String mostrarFormEditar(@PathVariable
	 * Long id, Model modelo) {
	 * modelo.addAttribute("inventario",servicio.getInventario(id)); return
	 * "inventario"; }
	 */
	// serviciocaja;
	// modelo.addAttribute("estudiantes", servicio.listarTodosEstudiantes());

	@Autowired
	private CajaServicio servicioCaja;
	@Autowired
	private UserServicio servicioUser;
	
	//Home links
	@GetMapping({"/"})
	public String paginaWebHome(Model model) {
		return "home";
	}
	//Index links
	@GetMapping({"/index"})
	public String paginaWebIndex(Model model) {
		return "index";
	}
	//FAQ links
	@GetMapping({"/FAQ"})
	public String paginaWebFAQ(Model model) {
		return "FAQ";
	}
	//Profile links
	@GetMapping({"/profile"})
	public String paginaWebProfile(Model model) {
	/*	User u = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		     u = servicioUser.obtenerUsuarioPorNombre(currentUserName);
		    System.out.println(u);
		}
		List<ObjetoSkinArma> listaSkins = u.getInventario();
		for(ObjetoSkinArma osa: listaSkins) {
			System.out.println("------------------------------------------------");
			System.out.println("------------------------------------------------");
			System.out.println("------------------------------------------------");
			System.out.println("------------------------------------------------");
			System.out.println("------------------------------------------------");
			System.out.println("------------------------------------------------");
			System.out.println("------------------------------------------------"); 
			System.out.println(osa.getNombre());
		}*/
		List<String> listaNames = new ArrayList<>();
		listaNames.add("Oskar");
		listaNames.add("Alejandro");
		listaNames.add("Pepe");		
		model.addAttribute("listaNames", listaNames);
		return "profile";
	}
	@GetMapping({"/profileSubmit"})
	public String paginaWebProfileSumit(@RequestParam("result") String result, Model model) {
		model.addAttribute("result", result);
		return "profile";
	}
	@GetMapping({"/editProfile"})
	public String paginaWebEditProfile(Model model) {
		return "editProfile";
	}
	//PaymentLinks
	@GetMapping({"/payment"})
	public String paginaPayment( Model model) {
		
		return "payment";
	}
	
	@GetMapping("/cajasImagen")
	public String mostrarCaja(@RequestParam("url_event_chest") String url_event_chest, @RequestParam("url_chest_img") String url_chest_img,  Model model) {
		model.addAttribute("url_event_chest", url_event_chest);
		model.addAttribute("url_chest_img", url_chest_img);
	    return "cajas";
	}

	@GetMapping("/cajas/{id}")
	public String devolverCaja(@PathVariable Long id, Model modelo) {
		User u = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		     u = servicioUser.obtenerUsuarioPorNombre(currentUserName);
		    System.out.println(u);
		}
		ObjetoSkinArma osa = new ObjetoSkinArma();
		//Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();


		//User user = (User) principal;
		osa.setUsuario(u);
		int rol = CompruebaRol.compruebaRol(u.getAuthorities()); // NO entra¿?
		
		Caja c = servicioCaja.obtenerCajaPorId(id);

		Skin s = AleatorioSkins.skinAleatoria(c.getSkins(), rol); // Skin premiada
		EstadoArma ea = AleatorioEstadoArma.estadoArmaAleatorio(); // EstadoArma aleatorio
		boolean tieneST = StatTrak.tieneStatTrak();
		int precio = PrecioFinalOSA.precioFinal(ea, s.getPrecioBase(), tieneST);

		osa.setEstado(ea);
		osa.setSkin(s);
		osa.setPrecio(precio);
		osa.setNombre(s.getNombre()); // Nombre se le pregunta al usuario para cambiarlo
		if (tieneST)
			osa.setStattrak(true);

		modelo.addAttribute("caja", c);
		modelo.addAttribute("skin", s);
		modelo.addAttribute("objetoskinarma", osa);
		return "caja";
	}

}
