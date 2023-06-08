package com.app.web.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.web.entidad.Caja;
import com.app.web.repositorios.CajaRepositorio;

@Service
public class CajaServicioImpl implements CajaServicio{

	@Autowired
	private CajaRepositorio repo;
	
	@Override
	public List<Caja> listarTodasCajas() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Caja guardarCaja(Caja caja) {
		// TODO Auto-generated method stub
		return repo.save(caja);
	}

	@Override
	public Caja obtenerCajaPorId(Long id) {
		// TODO Auto-generated method stub
		return  repo.findById(id).get();
	}

	@Override
	public Caja actualizarCaja(Caja caja) {
		// TODO Auto-generated method stub
		return repo.save(caja);
	}

	@Override
	public void eliminarCaja(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
