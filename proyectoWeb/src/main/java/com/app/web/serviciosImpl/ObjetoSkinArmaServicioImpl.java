package com.app.web.serviciosImpl;

import java.util.List;

import com.app.web.entidad.Caja;
import com.app.web.entidad.ObjetoSkinArma;
import com.app.web.repositorios.ObjetoskinarmaRepositorio;
import com.app.web.servicios.ObjetoskinarmaServicio;

public class ObjetoSkinArmaServicioImpl implements ObjetoskinarmaServicio{

	ObjetoskinarmaRepositorio repo;
	@Override
	public List<ObjetoSkinArma> listarOSA() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public ObjetoSkinArma guardarOSA(ObjetoSkinArma osa) {
		// TODO Auto-generated method stub
		return repo.save(osa);
	}

	@Override
	public ObjetoSkinArma obtenerOSAPorId(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public ObjetoSkinArma actualizarOSA(ObjetoSkinArma osa) {
		// TODO Auto-generated method stub
		return repo.save(osa);
	}

	@Override
	public void eliminarOSA(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
