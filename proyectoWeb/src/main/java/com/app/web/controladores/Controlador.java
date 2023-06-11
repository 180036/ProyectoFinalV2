package com.app.web.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.web.entidad.Caja;
import com.app.web.entidad.EstadoArma;
import com.app.web.entidad.ObjetoSkinArma;
import com.app.web.entidad.Pregunta;
import com.app.web.entidad.Skin;
import com.app.web.repositorios.AuthorityRepositorio;
import com.app.web.repositorios.EstadoarmaRepositorio;
import com.app.web.repositorios.ObjetoskinarmaRepositorio;
import com.app.web.repositorios.PreguntaRepositorio;
import com.app.web.servicios.CajaServicio;
import com.app.web.servicios.UserServicio;
import com.app.web.usuarioregistro.AuthorityName;
import com.app.web.usuarioregistro.User;

import jakarta.servlet.http.HttpSession;
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
	@Autowired(required=true)
	private AuthorityRepositorio authRepo;
	@Autowired
	private PreguntaRepositorio preguntaRepo;
	@Autowired
	private ObjetoskinarmaRepositorio repoO;
	@Autowired
	private EstadoarmaRepositorio repoEa;

	/*@GetMapping("/cajas")
	public String listarEstudiantes(Model modelo) {
		User u = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		     u = servicioUser.obtenerUsuarioPorNombre(currentUserName);
		    System.out.println(u);
		}
		modelo.addAttribute("user", u);
		modelo.addAttribute("cajas", servicioCaja.listarTodasCajas());
		return "cajas";
	}*/
	//Home links
	@GetMapping("/")
	public String paginaWebHome(Model model) {
		User u = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		     u = servicioUser.obtenerUsuarioPorNombre(currentUserName);
		    System.out.println(u);
		}
		model.addAttribute("user", u);
		return "home";
	}
	//Index links
	@GetMapping("/index")
	public String paginaWebIndex(Model model) {
		User u = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		     u = servicioUser.obtenerUsuarioPorNombre(currentUserName);
		    System.out.println(u);
		}
		model.addAttribute("user", u);
		return "index";
	}
	//FAQ links
	@GetMapping("/FAQ")
	public String paginaWebFAQ(Model model) {
		User u = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		     u = servicioUser.obtenerUsuarioPorNombre(currentUserName);
		    System.out.println(u);
		}
		model.addAttribute("user", u);
		return "FAQ";
	}
	//Profile links
	@GetMapping("/profile")
	public String paginaWebProfile(Model model) {
		
		User u = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		     u = servicioUser.obtenerUsuarioPorNombre(currentUserName);
		    System.out.println(u);
		}
		List<ObjetoSkinArma> listaSkins = null;
		if(u != null) {
			listaSkins = u.getInventario();
			
		}
		
		model.addAttribute("listaNames", servicioUser.listarTodosUsuarios());
		model.addAttribute("listaSkins", listaSkins);
		model.addAttribute("user", u);
		
		return "profile";
	}
	@GetMapping({"/profileSubmit"})
	public String paginaWebProfileSumit(@RequestParam("result") String result, Model model) {
		User u = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		     u = servicioUser.obtenerUsuarioPorNombre(currentUserName);
		    System.out.println(u);
		}
		List<ObjetoSkinArma> listaSkins = null;
		if(u != null) {
			listaSkins = u.getInventario();
			
		}
		
		model.addAttribute("listaNames", servicioUser.listarTodosUsuarios());
		model.addAttribute("listaSkins", listaSkins);

		model.addAttribute("user", u);
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
		User u = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		     u = servicioUser.obtenerUsuarioPorNombre(currentUserName);
		    System.out.println(u);
		}
		
		String texto = url_event_chest;
		String textoCaja = url_chest_img;
		String numero = texto.replaceAll("[^0-9]", ""); //Numero de fila de cajas
		String numeroCaja =textoCaja.replaceAll("[^0-9]", ""); //Numero de fila de cajas
		
		String subcadena = "colaborator";

		int indice = texto.indexOf(subcadena);

		if (indice != -1) {
		    System.out.println("La subcadena '" + subcadena + "' se encontró en la cadena principal.");
		} else {
		    System.out.println("La subcadena '" + subcadena + "' no se encontró en la cadena principal.");
		}

		if(numero.equals("2")) {
			if(numeroCaja.equals("1"))
				numeroCaja="5";
			else if(numeroCaja.equals("2"))
				numeroCaja="6";
			else if(numeroCaja.equals("3"))
				numeroCaja="7";
			else 
				numeroCaja="8";
		}
		if(numero.equals("3")) {
			if(numeroCaja.equals("1"))
				numeroCaja="9";
			else if(numeroCaja.equals("2"))
				numeroCaja="10";
			else if(numeroCaja.equals("3"))
				numeroCaja="11";
			else 
				numeroCaja="12";
		}
		if(indice != -1) {
			if(numeroCaja.equals("1"))
				numeroCaja="13";
			else if(numeroCaja.equals("2"))
				numeroCaja="14";
			else if(numeroCaja.equals("3"))
				numeroCaja="15";
			else 
				numeroCaja="16";
		}
		
		Caja c = servicioCaja.obtenerCajaPorId(Long.parseLong(numeroCaja));
		
		model.addAttribute("listaSkins", c.getSkins());
		model.addAttribute("idcaja",numeroCaja);
		model.addAttribute("user", u);
		model.addAttribute("url_event_chest", url_event_chest);
		model.addAttribute("url_chest_img", url_chest_img);
	    return "cajas";

	}
	
	@GetMapping("/admin")
	public ModelAndView rolePage(@AuthenticationPrincipal UserDetails user) {
		ModelAndView nextPage = new ModelAndView("admin");
		nextPage.addObject("user", user);
		return nextPage;
	}

	
	
	@GetMapping("/login")
	public String muestraLogin() {
		return "login";
	}
	@GetMapping("/guardarUsuario")
	public String mostrarFormGuardarUsuario() {
		return "guardarUsuario";
	}
	@PostMapping("/eliminarUsuario")
	public String eliminarUsuario(HttpSession session) {
		User u = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		     u = servicioUser.obtenerUsuarioPorNombre(currentUserName);
		    System.out.println(u);
		}
		
		if(u!= null) {
			servicioUser.eliminarUsuario(u.getId());
			session.invalidate();	
		}
					
		 
		return "redirect:/login?logout";
	}
	
	@PostMapping("/guardarUser")
	public String guardarUser(@RequestParam("nombre") String nombre, @RequestParam("email") String email, @RequestParam("contrasena") String contrasena) {
		//User u = new User(nombre, new BCryptPasswordEncoder().encode(contrasena), email, List.of(this.authRepo.findByName(AuthorityName.USER).get()));
		//System.out.println(List.of(this.authRepo.findByName(AuthorityName.USER).get()));
	
		if(servicioUser.obtenerUsuarioPorNombre(nombre)== null && servicioUser.obtenerUsuarioPorEmail(email) == null)
		{
			User u = new User(nombre, new BCryptPasswordEncoder().encode(contrasena), email, List.of(this.authRepo.findByName(AuthorityName.USER).get()));
			
			servicioUser.guardarUsuario(u);
			return "redirect:/login";
		}
		return "redirect:/";						
		
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
		//ObjetoSkinArma osa = new ObjetoSkinArma();
		//Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();


		//User user = (User) principal;
		int rol = CompruebaRol.compruebaRol(u.getAuthorities()); 
		
		Caja c = servicioCaja.obtenerCajaPorId(id);

		Skin s = AleatorioSkins.skinAleatoria(c.getSkins(), rol); // Skin premiada
		int idE = AleatorioEstadoArma.estadoArmaAleatorio(); // EstadoArma aleatorio
		EstadoArma ea = repoEa.findById((long)idE).get();
		
		boolean tieneST = StatTrak.tieneStatTrak();
		int precio = PrecioFinalOSA.precioFinal(ea, s.getPrecioBase(), tieneST);
		
		ObjetoSkinArma osa = new ObjetoSkinArma(s.getNombre(), precio, s, u, ea);

		if (tieneST)
			osa.setStattrak(true);
		if(u != null)
			u.sumarCajaAbierta();
		
		ObjetoSkinArma osaFinal = repoO.save(osa);
		modelo.addAttribute("estado", ea);
		modelo.addAttribute("stattrak",tieneST);
		modelo.addAttribute("caja", c);
		modelo.addAttribute("skin", s);
		modelo.addAttribute("objetoskinarma", osaFinal);
		return "caja";
	}
	@GetMapping("/pregunta")
	public String guardarPregunta(@RequestParam("pregunta") String pregunta) {
		if(!pregunta.isBlank()) {
			preguntaRepo.save(new Pregunta(pregunta));
			return "redirect:/FAQ";
		}
		return "redirect:/FAQ?pregunta";
	}


}
