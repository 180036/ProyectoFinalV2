package com.app.web.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.web.entidad.ObjetoSkinArma;
import com.app.web.repositorios.ObjetoskinarmaRepositorio;
@Service
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
