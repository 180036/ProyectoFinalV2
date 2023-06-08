package com.app.web.servicios;

import java.util.List;

import com.app.web.entidad.Caja;
import com.app.web.entidad.ObjetoSkinArma;

public interface ObjetoskinarmaServicio {
	
	public List<ObjetoSkinArma> listarOSA();
	public ObjetoSkinArma guardarOSA(ObjetoSkinArma osa);
	public ObjetoSkinArma obtenerOSAPorId(Long id);
	public ObjetoSkinArma actualizarOSA(ObjetoSkinArma osa);
	public void eliminarOSA(Long id);

}
