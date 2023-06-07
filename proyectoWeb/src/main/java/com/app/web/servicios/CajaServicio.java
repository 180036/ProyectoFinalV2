package com.app.web.servicios;

import java.util.List;

import com.app.web.entidad.Caja;

public interface CajaServicio {
	
	public List<Caja> listarTodasCajas();
	public Caja guardarEstudiante(Caja caj);
	public Caja obtenerEstudiantePorId(Long id);
	public Caja actualizarEstudiante(Caja caja);
	public void eliminarEstudiante(Long id);

}
