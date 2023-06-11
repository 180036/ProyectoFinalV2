package com.app.web.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

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

	@Autowired
	private CajaServicio servicioCaja;
	@Autowired
	private UserServicio servicioUser;
	

	@GetMapping("/cajas")
	public String listarEstudiantes(Model modelo) {
		User u = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		     u = servicioUser.obtenerUsuarioPorNombre(currentUserName);
		    System.out.println(u);
		}
		modelo.addAttribute("cajas", servicioCaja.listarTodasCajas());
		modelo.addAttribute("user", u);
		return "cajas";
	}
	
	
	//BORRARRRRR
	/*@GetMapping("/admin")
	public ModelAndView rolePage(@AuthenticationPrincipal UserDetails user) {
		ModelAndView nextPage = new ModelAndView("borrarAdmin");
		nextPage.addObject("user", user);
		return nextPage;
	}*/

	@GetMapping("/login")
	public String muestraLogin() {
		return "login";
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
