package com.app.web.servicios;

import java.util.List;

import com.app.web.entidad.Caja;

/**
 * Interfaz que define los métodos para operar con la entidad Caja en el sistema.
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */
public interface CajaServicio {
	
	/**
     * Retorna una lista de todas las cajas en el sistema.
     *
     * @return Una lista de objetos Caja.
     */
    public List<Caja> listarTodasCajas();

    /**
     * Guarda una caja en el sistema.
     *
     * @param caja La caja a guardar.
     * @return La caja guardada.
     */
    public Caja guardarCaja(Caja caja);

    /**
     * Obtiene una caja por su ID.
     *
     * @param id El ID de la caja.
     * @return La caja encontrada, o null si no se encuentra ninguna caja con ese ID.
     */
    public Caja obtenerCajaPorId(Long id);

    /**
     * Actualiza una caja en el sistema.
     *
     * @param caja La caja a actualizar.
     * @return La caja actualizada.
     */
    public Caja actualizarCaja(Caja caja);

    /**
     * Elimina una caja del sistema.
     *
     * @param id El ID de la caja a eliminar.
     */
    public void eliminarCaja(Long id);

}
