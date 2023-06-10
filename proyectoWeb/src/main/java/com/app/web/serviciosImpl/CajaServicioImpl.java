package com.app.web.serviciosImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.web.entidad.Caja;
import com.app.web.repositorios.CajaRepositorio;
import com.app.web.servicios.CajaServicio;

/**
 * Implementación de la interfaz CajaServicio que proporciona la lógica para realizar operaciones relacionadas con las cajas.
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */
@Service
public class CajaServicioImpl implements CajaServicio{

	@Autowired
	private CajaRepositorio repo;
	
	/**
     * Obtiene una lista de todas las cajas.
     *
     * @return Una lista de todas las cajas.
     */
    @Override
    public List<Caja> listarTodasCajas() {
        return repo.findAll();
    }

    /**
     * Guarda una caja en la base de datos.
     *
     * @param caja La caja a guardar.
     * @return La caja guardada.
     */
    @Override
    public Caja guardarCaja(Caja caja) {
        return repo.save(caja);
    }

    /**
     * Obtiene una caja por su ID.
     *
     * @param id El ID de la caja.
     * @return La caja encontrada, o null si no se encuentra.
     */
    @Override
    public Caja obtenerCajaPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Actualiza una caja en la base de datos.
     *
     * @param caja La caja a actualizar.
     * @return La caja actualizada.
     */
    @Override
    public Caja actualizarCaja(Caja caja) {
        return repo.save(caja);
    }

    /**
     * Elimina una caja por su ID.
     *
     * @param id El ID de la caja a eliminar.
     */
    @Override
    public void eliminarCaja(Long id) {
        repo.deleteById(id);
    }

}
