package com.app.web.servicios;

import java.util.List;

import com.app.web.entidad.Caja;

public interface CajaServicio {
	
	public List<Caja> listarTodasCajas();
	public Caja guardarCaja(Caja caj);
	public Caja obtenerCajaPorId(Long id);
	public Caja actualizarCaja(Caja caja);
	public void eliminarCaja(Long id);

}
