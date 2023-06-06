package com.app.web.controladores;

import org.springframework.web.bind.annotation.*;

@RestController
public class ControladorRest {

	@GetMapping("/demo")
	public String showDemo() {
		return "hola desde Demo";
	}
}
